package com.infnet.ghreservation.service;

import com.infnet.ghreservation.dto.ReservaDTO;

import java.util.List;

public interface ReservaService {
    ReservaDTO createReserva(ReservaDTO reservaDTO);
    ReservaDTO getReservaById(Long reservaId);
    ReservaDTO updateReserva(Long reservaId, ReservaDTO reservaDTO);
    void deleteReserva(Long reservaId);
    List<ReservaDTO> getReservaList();
}
