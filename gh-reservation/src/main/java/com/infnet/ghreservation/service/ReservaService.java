package com.infnet.ghreservation.service;

import com.infnet.ghreservation.dto.ReservaDTO;

import java.util.List;

public interface ReservaService {
    ReservaDTO createReservation(ReservaDTO reservaDTO);
    ReservaDTO getReservationById(Long reservationId) throws Exception;
    ReservaDTO updateReservation(Long reservationId, ReservaDTO reservaDTO) throws Exception;
    void deleteReservation(Long reservationId) throws Exception;
    List<ReservaDTO> getReservationList();
}
