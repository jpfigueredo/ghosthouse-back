package com.infnet.ghreservation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.infnet.ghreservation.enums.ReservationStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Data
public class ReservationDTO {
    private Long id;
    @NotBlank
    private String propertyId;
    @NotBlank
    private String tenantId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private ReservationStatus status;
}
