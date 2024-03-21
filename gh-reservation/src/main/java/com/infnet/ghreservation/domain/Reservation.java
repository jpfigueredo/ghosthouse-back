package com.infnet.ghreservation.domain;

import com.infnet.ghreservation.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_reserva")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="reservation_id")
    private Long id;

   // @OneToOne
    private Long propertyId;

    private Long tenantId;

    private LocalDate startDate;

    private LocalDate endDate;

    private ReservationStatus status;
}
