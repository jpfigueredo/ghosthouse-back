package com.infnet.ghreservation.service;

import com.infnet.ghreservation.domain.Reserva;
import com.infnet.ghreservation.dto.ReservaDTO;
import com.infnet.ghreservation.repository.ReservaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public ReservaDTO createReserva(ReservaDTO reservaDTO) {
        Reserva reserva = modelMapper.map(reservaDTO, Reserva.class);
        Reserva savedReserva = reservaRepository.save(reserva);
        return modelMapper.map(savedReserva, ReservaDTO.class);
    }

    @Override
    public List<ReservaDTO> getReservaList() {
        List<Reserva> reservaList = reservaRepository.findAll();
        return reservaList.stream()
                .map(reserva -> modelMapper.map(reserva, ReservaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReservaDTO getReservaById(Long reservationId) throws Exception {
        Reserva review = existsReservaByID(reservationId);
        return modelMapper.map(review, ReservaDTO.class);
    }

    @Override
    public ReservaDTO updateReserva(Long reservaId, ReservaDTO reservaDTO) throws Exception {
        Reserva reserva = existsReservaByID(reservaId);
        reserva.setId(reservaId);
        Reserva updatedReserva = reservaRepository.save(modelMapper.map(reserva, Reserva.class));
        return modelMapper.map(updatedReserva, ReservaDTO.class);
    }

    @Override
    public void deleteReserva(Long reservaId) throws Exception {
        Reserva reserva = existsReservaByID(reservaId);
        reservaRepository.delete(reserva);
    }

    private Reserva existsReservaByID(Long reservationId) throws Exception {
        if (!reservaRepository.existsById(reservationId)) {
            throw new Exception("Reserva não encontrado com o ID: " + reservationId);
        }
        return reservaRepository.findById(reservationId).get();
    }

}
