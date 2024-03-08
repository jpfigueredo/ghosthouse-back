package com.infnet.ghreservation.service;

import com.infnet.ghreservation.dto.ReservationDTO;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    public ReservationDTO createReservation(ReservationDTO reservationDto) {
        // Implementar lógica para criar uma nova reserva
        // Converter ReservationDto para entidade de domínio, salvar no banco de dados e retornar o ReservationDto resultante
        return null;
    }

    public ReservationDTO getReservationById(Long reservationId) {
        // Implementar lógica para buscar uma reserva pelo ID e retornar o ReservationDto correspondente
        return null;
    }

    public ReservationDTO updateReservation(Long reservationId, ReservationDTO reservationDto) {
        // Implementar lógica para atualizar uma reserva existente com os dados fornecidos em reservationDto
        // Retornar o ReservationDto atualizado
        return null;
    }

    public void deleteReservation(Long reservationId) {
        // Implementar lógica para excluir uma reserva pelo ID
    }
}
