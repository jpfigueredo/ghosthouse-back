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
import com.infnet.ghreservation.builder.ReservationBuilder;
import com.infnet.ghreservation.dto.ReservationDTO;
import com.infnet.ghreservation.service.ReservationServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class ReservationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservationServiceImpl reservaService;

    private ReservationBuilder reservationBuilder;

    @Before
    public void setUp() {
        reservationBuilder = new ReservationBuilder();
    }



    @Test
    public void testCreateReservation() throws Exception {
        ReservationDTO reservationDTO = reservationBuilder.createReservaDTO();
        String jsonBody = new ObjectMapper().setTimeZone(TimeZone.getTimeZone("UTC")).writeValueAsString(reservationDTO);

        when(reservaService.createReserva(any(ReservationDTO.class))).thenReturn(reservationDTO);

        MvcResult mvcResult = mockMvc.perform(post("/api/reservations")
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isCreated()).andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        ReservationDTO userResponseDTO = new ObjectMapper().readValue(contentAsString, ReservationDTO.class);

        assertEquals(userResponseDTO, reservationDTO);
    }

    @Test
    public void testGetReservaById() throws Exception {
        ReservationDTO reservationDTO = reservationBuilder.createReservaDTO();
        Long reservaId = reservationDTO.getId();

        when(reservaService.getReservaById(reservaId)).thenReturn(reservationDTO);

        MvcResult mvcResult = mockMvc.perform(get("/api/reservations/{reservaId}", reservaId))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        ReservationDTO reservaResponseDTO = new ObjectMapper().readValue(contentAsString, ReservationDTO.class);

        assertEquals(reservaResponseDTO, reservationDTO);
    }

    @Test
    public void testUpdateReserva() throws Exception {
        ReservationDTO reservationDTO = reservationBuilder.createReservaDTO();
        Long reservaId = reservationDTO.getId();
        String jsonBody = new ObjectMapper().setTimeZone(TimeZone.getTimeZone("UTC")).writeValueAsString(reservationDTO);

        when(reservaService.updateReserva(eq(reservaId), any(ReservationDTO.class))).thenReturn(reservationDTO);

        MvcResult mvcResult = mockMvc.perform(put("/api/reservations/{reservaId}", reservaId)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        ReservationDTO reservaResponseDTO = new ObjectMapper().readValue(contentAsString, ReservationDTO.class);

        assertEquals(reservaResponseDTO, reservationDTO);
    }

    @Test
    public void testDeleteReserva() throws Exception {
        Long reservaId = 1L;

        mockMvc.perform(delete("/api/reservations/{reservaId}", reservaId))
                .andExpect(status().isNoContent());

        verify(reservaService, times(1)).deleteReserva(reservaId);
    }
}
