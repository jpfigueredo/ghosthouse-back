package com.infnet.ghreservation.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Data
@Entity
@Table(name = "tb_reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="property_id")
    private Long id;
    private String propertyId;
    private String tenantId;
    private Date startDate;
    private Date endDate;
}
