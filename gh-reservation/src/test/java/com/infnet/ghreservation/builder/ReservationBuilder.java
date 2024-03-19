package com.infnet.ghreservation.builder;

import com.infnet.ghreservation.domain.Reservation;
import com.infnet.ghreservation.dto.ReservationDTO;

import java.sql.Date;
import java.util.TimeZone;

public class ReservationBuilder {

    public ReservationDTO createReservaDTO() {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(1L);
        reservationDTO.setPropertyId("1");
        reservationDTO.setTenantId("1");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        reservationDTO.setStartDate(new Date(1710039600000L));
        reservationDTO.setEndDate(new Date(1710471600000L));
        return reservationDTO;
    }

    public Reservation createReserva() {
        Reservation reservation = new Reservation();
        reservation.setId(1L);
        reservation.setPropertyId("1");
        reservation.setTenantId("1");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        reservation.setStartDate(new Date(1710039600000L));
        reservation.setEndDate(new Date(1710471600000L));
        return reservation;
    }
}
