package com.infnet.ghreservation.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.infnet.ghreservation.builder.ReservationBuilder;
import com.infnet.ghreservation.client.PropertyClient;
import com.infnet.ghreservation.domain.Reservation;
import com.infnet.ghreservation.dto.ReservationDTO;
import com.infnet.ghreservation.repository.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private PropertyClient propertyClient;
    @InjectMocks
    private ReservationServiceImpl reservaService;
    private ReservationBuilder reservationBuilder;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        reservationBuilder = new ReservationBuilder();
    }


    @Test
    public void testSaveUserProprietario() {
        ReservationDTO reservationDto = reservationBuilder.createReservaDTO();
        Reservation reservation = reservationBuilder.createReserva();

        when(modelMapper.map(reservationDto, Reservation.class)).thenReturn(reservation);
        when(reservationRepository.save(any(Reservation.class))).thenReturn(reservation);
        when(modelMapper.map(reservation, ReservationDTO.class)).thenReturn(reservationDto);

        ReservationDTO savedReservationDto = reservaService.createReserva(reservationDto);

        Assertions.assertEquals(reservationDto, savedReservationDto);
        verify(reservationRepository, times(1)).save(any(Reservation.class));
    }

    @Test
    public void testGetReservaById() {
        Long reservaId = 1L;
        ReservationDTO reservationDTO = reservationBuilder.createReservaDTO();
        Reservation reservation = reservationBuilder.createReserva();

        when(reservationRepository.findById(reservaId)).thenReturn(Optional.of(reservation));
        when(reservationRepository.existsById(reservaId)).thenReturn(true);
        when(modelMapper.map(reservation, ReservationDTO.class)).thenReturn(reservationDTO);

        ReservationDTO foundReservationDTO = reservaService.getReservaById(reservaId);

        Assertions.assertEquals(reservationDTO, foundReservationDTO);
    }

    @Test
    public void testGetReservaByIdThrowsException() {
        Long reservaId = 1L;

        when(reservationRepository.findById(reservaId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> reservaService.getReservaById(reservaId));
    }

    @Test
    public void testUpdateReserva() {
        Long reservaId = 1L;
        ReservationDTO reservationDTO = reservationBuilder.createReservaDTO();
        Reservation reservation = reservationBuilder.createReserva();

        when(reservationRepository.existsById(reservaId)).thenReturn(true);
        when(reservationRepository.findById(reservaId)).thenReturn(Optional.of(reservation));
        when(reservationRepository.save(any(Reservation.class))).thenReturn(reservation);
        when(modelMapper.map(reservationDTO, Reservation.class)).thenReturn(reservation);
        when(modelMapper.map(reservation, ReservationDTO.class)).thenReturn(reservationDTO);

        ReservationDTO updatedReservationDTO = reservaService.updateReserva(reservaId, reservationDTO);

        Assertions.assertEquals(reservationDTO, updatedReservationDTO);
    }

    @Test
    public void testUpdateReservaThrowsException() {
        Long reservaId = 1L;
        ReservationDTO reservationDTO = reservationBuilder.createReservaDTO();

        when(reservationRepository.existsById(reservaId)).thenReturn(false);

        assertThrows(EntityNotFoundException.class, () -> reservaService.updateReserva(reservaId, reservationDTO));
    }

    @Test
    public void testDeleteReserva() {
        Long reservaId = 1L;
        Reservation reservation = reservationBuilder.createReserva();

        when(reservationRepository.existsById(reservaId)).thenReturn(true);
        when(reservationRepository.findById(reservaId)).thenReturn(Optional.of(reservation));

        reservaService.deleteReserva(reservaId);
        verify(reservationRepository, times(1)).delete(reservation);
    }

    @Test
    public void testDeleteReservaThrowsException() {
        Long reservaId = 1L;
        when(reservationRepository.existsById(reservaId)).thenReturn(false);
        when(reservationRepository.findById(reservaId)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> reservaService.deleteReserva(reservaId));
    }
}
