package com.infnet.ghreservation.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infnet.ghreservation.builder.ReservaBuilder;
import com.infnet.ghreservation.dto.ReservaDTO;
import com.infnet.ghreservation.service.ReservaServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.TimeZone;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ReservaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservaServiceImpl reservaService;

    private ReservaBuilder reservaBuilder;

    @Before
    public void setUp() {
        reservaBuilder = new ReservaBuilder();
    }



    @Test
    public void testCreateReservation() throws Exception {
        ReservaDTO reservaDTO = reservaBuilder.createReservaDTO();
        String jsonBody = new ObjectMapper().setTimeZone(TimeZone.getTimeZone("UTC")).writeValueAsString(reservaDTO);

        when(reservaService.createReserva(any(ReservaDTO.class))).thenReturn(reservaDTO);

        MvcResult mvcResult = mockMvc.perform(post("/api/reservations")
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isCreated()).andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        ReservaDTO userResponseDTO = new ObjectMapper().readValue(contentAsString, ReservaDTO.class);

        assertEquals(userResponseDTO, reservaDTO);
    }

    @Test
    public void testGetReservaById() throws Exception {
        ReservaDTO reservaDTO = reservaBuilder.createReservaDTO();
        Long reservaId = reservaDTO.getId();

        when(reservaService.getReservaById(reservaId)).thenReturn(reservaDTO);

        MvcResult mvcResult = mockMvc.perform(get("/api/reservations/{reservaId}", reservaId))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        ReservaDTO reservaResponseDTO = new ObjectMapper().readValue(contentAsString, ReservaDTO.class);

        assertEquals(reservaResponseDTO, reservaDTO);
    }

    @Test
    public void testUpdateReserva() throws Exception {
        ReservaDTO reservaDTO = reservaBuilder.createReservaDTO();
        Long reservaId = reservaDTO.getId();
        String jsonBody = new ObjectMapper().setTimeZone(TimeZone.getTimeZone("UTC")).writeValueAsString(reservaDTO);

        when(reservaService.updateReserva(eq(reservaId), any(ReservaDTO.class))).thenReturn(reservaDTO);

        MvcResult mvcResult = mockMvc.perform(put("/api/reservations/{reservaId}", reservaId)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        ReservaDTO reservaResponseDTO = new ObjectMapper().readValue(contentAsString, ReservaDTO.class);

        assertEquals(reservaResponseDTO, reservaDTO);
    }

    @Test
    public void testDeleteReserva() throws Exception {
        Long reservaId = 1L;

        mockMvc.perform(delete("/api/reservations/{reservaId}", reservaId))
                .andExpect(status().isNoContent());

        verify(reservaService, times(1)).deleteReserva(reservaId);
    }
}
