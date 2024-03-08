package com.infnet.ghreservation.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ReservaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private ReservationController reservationController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateReservation() throws Exception {
        String jsonBody = "{\"propertyId\": \"12345\", \"userId\": \"67890\", \"startDate\": \"2024-03-01\", \"endDate\": \"2024-03-05\"}";

        mockMvc.perform(post("/reservations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.propertyId").value("12345"))
                .andExpect(jsonPath("$.userId").value("67890"))
                .andExpect(jsonPath("$.startDate").value("2024-03-01"))
                .andExpect(jsonPath("$.endDate").value("2024-03-05"));
    }

    // Outros testes para os endpoints do ReservationController...
}
