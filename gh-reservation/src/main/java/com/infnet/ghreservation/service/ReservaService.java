package com.infnet.ghreservation.service;

import com.infnet.ghreservation.dto.ReservaDTO;

import java.util.List;

public interface ReservaService {
    ReservaDTO createReserva(ReservaDTO reservaDTO);
    ReservaDTO getReservaById(Long reservaId) throws Exception;
    ReservaDTO updateReserva(Long reservaId, ReservaDTO reservaDTO) throws Exception;
    void deleteReserva(Long reservaId) throws Exception;
    List<ReservaDTO> getReservaList();
}
