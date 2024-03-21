package com.infnet.ghreservation.repository;

import com.infnet.ghreservation.domain.Reservation;
import com.infnet.ghreservation.enums.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> getReservationByTenantId(Long tenantId);
    List<Reservation> getReservationByPropertyId(Long propertyId);
    List<Reservation> getReservationByStatus(ReservationStatus status);
}
