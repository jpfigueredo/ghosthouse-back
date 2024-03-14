package com.infnet.ghreservation.builder;

import com.infnet.ghreservation.domain.Reserva;
import com.infnet.ghreservation.dto.ReservaDTO;

import java.sql.Date;
import java.util.TimeZone;

public class ReservaBuilder {

    public ReservaDTO createReservaDTO() {
        ReservaDTO reservaDTO = new ReservaDTO();
        reservaDTO.setId(1L);
        reservaDTO.setPropertyId("1");
        reservaDTO.setTenantId("1");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        reservaDTO.setStartDate(new Date(1710039600000L));
        reservaDTO.setEndDate(new Date(1710471600000L));
        return reservaDTO;
    }

    public Reserva createReserva() {
        Reserva reserva = new Reserva();
        reserva.setId(1L);
        reserva.setPropertyId("1");
        reserva.setTenantId("1");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        reserva.setStartDate(new Date(1710039600000L));
        reserva.setEndDate(new Date(1710471600000L));
        return reserva;
    }
}
