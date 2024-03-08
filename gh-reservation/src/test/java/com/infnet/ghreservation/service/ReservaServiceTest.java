package com.infnet.ghreservation.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.infnet.ghreservation.dto.ReservationDTO;
import com.infnet.ghreservation.repository.ReservationRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ReservaServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindReservationById() {
        long reservationId = 1L;
        ReservationDTO mockReservation = new ReservationDTO();
        mockReservation.setId(reservationId);
        mockReservation.setGuestName("John Doe");

        when(reservationRepository.findById(reservationId)).thenReturn(Optional.of(mockReservation));

        Optional<ReservationDTO> result = reservationService.findReservationById(reservationId);

        assertEquals(mockReservation, result.orElse(null));
    }

    // Outros testes para os métodos do ReservationService...
}
