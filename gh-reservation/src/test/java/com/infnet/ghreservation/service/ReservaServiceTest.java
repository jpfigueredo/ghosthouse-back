package com.infnet.ghreservation.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.infnet.ghreservation.builder.ReservaBuilder;
import com.infnet.ghreservation.domain.Reserva;
import com.infnet.ghreservation.dto.ReservaDTO;
import com.infnet.ghreservation.repository.ReservaRepository;
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
public class ReservaServiceTest {

    @Mock
    private ReservaRepository reservaRepository;
    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private ReservaServiceImpl reservaService;
    private ReservaBuilder reservaBuilder;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        reservaBuilder = new ReservaBuilder();
    }


    @Test
    public void testSaveUserProprietario() {
        ReservaDTO reservaDto = reservaBuilder.createReservaDTO();
        Reserva reserva = reservaBuilder.createReserva();

        when(modelMapper.map(reservaDto, Reserva.class)).thenReturn(reserva);
        when(reservaRepository.save(any(Reserva.class))).thenReturn(reserva);
        when(modelMapper.map(reserva, ReservaDTO.class)).thenReturn(reservaDto);

        ReservaDTO savedReservaDto = reservaService.createReserva(reservaDto);

        Assertions.assertEquals(reservaDto, savedReservaDto);
        verify(reservaRepository, times(1)).save(any(Reserva.class));
    }

    @Test
    public void testGetReservaById() {
        Long reservaId = 1L;
        ReservaDTO reservaDTO = reservaBuilder.createReservaDTO();
        Reserva reserva = reservaBuilder.createReserva();

        when(reservaRepository.findById(reservaId)).thenReturn(Optional.of(reserva));
        when(reservaRepository.existsById(reservaId)).thenReturn(true);
        when(modelMapper.map(reserva, ReservaDTO.class)).thenReturn(reservaDTO);

        ReservaDTO foundReservaDTO = reservaService.getReservaById(reservaId);

        Assertions.assertEquals(reservaDTO, foundReservaDTO);
    }

    @Test
    public void testGetReservaByIdThrowsException() {
        Long reservaId = 1L;

        when(reservaRepository.findById(reservaId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> reservaService.getReservaById(reservaId));
    }

    @Test
    public void testUpdateReserva() {
        Long reservaId = 1L;
        ReservaDTO reservaDTO = reservaBuilder.createReservaDTO();
        Reserva reserva = reservaBuilder.createReserva();

        when(reservaRepository.existsById(reservaId)).thenReturn(true);
        when(reservaRepository.findById(reservaId)).thenReturn(Optional.of(reserva));
        when(reservaRepository.save(any(Reserva.class))).thenReturn(reserva);
        when(modelMapper.map(reservaDTO, Reserva.class)).thenReturn(reserva);
        when(modelMapper.map(reserva, ReservaDTO.class)).thenReturn(reservaDTO);

        ReservaDTO updatedReservaDTO = reservaService.updateReserva(reservaId, reservaDTO);

        Assertions.assertEquals(reservaDTO, updatedReservaDTO);
    }

    @Test
    public void testUpdateReservaThrowsException() {
        Long reservaId = 1L;
        ReservaDTO reservaDTO = reservaBuilder.createReservaDTO();

        when(reservaRepository.existsById(reservaId)).thenReturn(false);

        assertThrows(EntityNotFoundException.class, () -> reservaService.updateReserva(reservaId, reservaDTO));
    }

    @Test
    public void testDeleteReserva() {
        Long reservaId = 1L;
        Reserva reserva = reservaBuilder.createReserva();

        when(reservaRepository.existsById(reservaId)).thenReturn(true);
        when(reservaRepository.findById(reservaId)).thenReturn(Optional.of(reserva));

        reservaService.deleteReserva(reservaId);
        verify(reservaRepository, times(1)).delete(reserva);
    }

    @Test
    public void testDeleteReservaThrowsException() {
        Long reservaId = 1L;
        when(reservaRepository.existsById(reservaId)).thenReturn(false);
        when(reservaRepository.findById(reservaId)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> reservaService.deleteReserva(reservaId));
    }
}
