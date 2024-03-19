package com.infnet.ghreservation.controller;

import com.infnet.ghreservation.dto.ReservationDTO;
import com.infnet.ghreservation.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservas")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationDTO> createReserva(@RequestBody @Valid ReservationDTO reservationDTO) {
        ReservationDTO newReservation = reservationService.createReserva(reservationDTO);
        return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ReservationDTO> getReservaList() {
        return new ResponseEntity(reservationService.getReservaList(), HttpStatus.OK);
    }

    @GetMapping("/{reservaId}")
    public ResponseEntity<ReservationDTO> getReservaById(@PathVariable Long reservaId) {
        ReservationDTO reservationDto = reservationService.getReservaById(reservaId);
        return new ResponseEntity<>(reservationDto, HttpStatus.OK);
    }

    @PutMapping("/{reservaId}")
    public ResponseEntity<ReservationDTO> updateReserva(@PathVariable Long reservaId, @RequestBody ReservationDTO reservationDTO) {
        ReservationDTO updatedReservation = reservationService.updateReserva(reservaId, reservationDTO);
        return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
    }

    @DeleteMapping("/{reservaId}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Long reservaId) {
        reservationService.deleteReserva(reservaId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
