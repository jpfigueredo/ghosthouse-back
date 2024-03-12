package com.infnet.ghreservation.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.infnet.ghreservation.dto.ReservaDTO;
import com.infnet.ghreservation.repository.ReservaRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ReservaServiceTest {

    @Mock
    private ReservaRepository reservaRepository;

    @InjectMocks
    private ReservaServiceImpl reservationService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindReservationById() {
        long reservationId = 1L;
        ReservaDTO mockReservation = new ReservaDTO();
        mockReservation.setId(reservationId);
        mockReservation.setGuestName("John Doe");

        when(reservaRepository.findById(reservationId)).thenReturn(Optional.of(mockReservation));

        Optional<ReservaDTO> result = reservationService.findReservationById(reservationId);

        assertEquals(mockReservation, result.orElse(null));
    }

    // Outros testes para os métodos do ReservationService...
}
