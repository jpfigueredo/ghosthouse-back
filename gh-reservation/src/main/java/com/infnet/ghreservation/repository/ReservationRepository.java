package com.infnet.ghreservation.repository;

import com.infnet.ghreservation.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reserva, Long> {
}
