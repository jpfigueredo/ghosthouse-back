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
    @Column(name ="reserva_id")
    private Long id;

    @OneToOne
    private String propertyId;


    private String tenantId;

    private Date startDate;

    private Date endDate;
}
