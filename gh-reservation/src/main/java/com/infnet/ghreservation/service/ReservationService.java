package com.infnet.ghreservation.service;

import com.infnet.ghreservation.dto.ReservationDTO;

import java.util.List;

public interface ReservationService {
    ReservationDTO createReserva(ReservationDTO reservationDTO);
    ReservationDTO getReservaById(Long reservaId);
    ReservationDTO updateReserva(Long reservaId, ReservationDTO reservationDTO);
    void deleteReserva(Long reservaId);
    List<ReservationDTO> getReservaList();
}
