package com.infnet.ghreservation.service;

import com.infnet.ghreservation.client.PropertyClient;
import com.infnet.ghreservation.domain.Reservation;
import com.infnet.ghreservation.dto.ReservationDTO;
import com.infnet.ghreservation.repository.ReservationRepository;
import feign.FeignException;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private PropertyClient propertyClient;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public ReservationDTO createReserva(ReservationDTO reservationDTO) {
        Reservation reservation = modelMapper.map(reservationDTO, Reservation.class);

        List<LocalDate> reservedDates = generateDatesInRange(reservation.getStartDate(), reservation.getEndDate());
        setReserveddates(reservation.getPropertyId(), reservedDates);

        Reservation savedReservation = reservationRepository.save(reservation);

        return modelMapper.map(savedReservation, ReservationDTO.class);
    }

    @Override
    public List<ReservationDTO> getReservaList() {
        List<Reservation> reservationList = reservationRepository.findAll();
        return reservationList.stream()
                .map(reservation -> modelMapper.map(reservation, ReservationDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReservationDTO getReservaById(Long reservaId) {
        Reservation reservation = existsReservaByID(reservaId);
        return modelMapper.map(reservation, ReservationDTO.class);
    }

    @Override
    public ReservationDTO updateReserva(Long reservaId, ReservationDTO reservationDTO) {
        Reservation reservation = existsReservaByID(reservaId);
        reservationDTO.setId(reservaId);
        Reservation updatedReservation = reservationRepository.save(modelMapper.map(reservationDTO, Reservation.class));
        return modelMapper.map(updatedReservation, ReservationDTO.class);
    }

    @Override
    public void deleteReserva(Long reservaId) {
        Reservation reservation = existsReservaByID(reservaId);
        reservationRepository.delete(reservation);
    }

    private Reservation existsReservaByID(Long reservaId) {
        if (!reservationRepository.existsById(reservaId)) {
            throw new EntityNotFoundException("Reserva não encontrado com o ID: " + reservaId);
        }
        return reservationRepository.findById(reservaId).get();
    }

    private List<LocalDate> generateDatesInRange(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> datesInRange = new ArrayList<>();
        LocalDate date = startDate;
        while (!date.isAfter(endDate)) {
            datesInRange.add(date);
            date = date.plusDays(1);
        }
        return datesInRange;
    }

    private void setReserveddates(Long propertyId, List<LocalDate> newDates) {
        propertyClient.setReservedDates(propertyId, newDates);
    }

}
