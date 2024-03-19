package com.infnet.ghreservation.builder;

import com.infnet.ghreservation.domain.Reservation;
import com.infnet.ghreservation.dto.ReservationDTO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.TimeZone;

public class ReservationBuilder {

    public ReservationDTO createReservaDTO() {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(1L);
        reservationDTO.setPropertyId("1");
        reservationDTO.setTenantId("1");
     //   TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        reservationDTO.setStartDate(LocalDate.of(2024, 3, 1));
        reservationDTO.setEndDate(LocalDate.of(2024, 3, 3));
        return reservationDTO;
    }

    public Reservation createReserva() {
        Reservation reservation = new Reservation();
        reservation.setId(1L);
        reservation.setPropertyId(1L);
        reservation.setTenantId(1L);
       // TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        reservation.setStartDate(LocalDate.of(2024, 3, 1));
        reservation.setEndDate(LocalDate.of(2024, 3, 3));
        return reservation;
    }
}
