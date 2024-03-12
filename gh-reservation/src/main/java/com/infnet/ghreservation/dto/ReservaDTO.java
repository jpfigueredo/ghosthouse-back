package com.infnet.ghreservation.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class ReservaDTO {
    private Long id;
    private String propertyId;
    private String tenantId;
    private Date startDate;
    private Date endDate;
}
