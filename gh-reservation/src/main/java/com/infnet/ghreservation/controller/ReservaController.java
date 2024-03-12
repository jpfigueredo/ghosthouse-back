package com.infnet.ghreservation.controller;

import com.infnet.ghreservation.dto.ReservaDTO;
import com.infnet.ghreservation.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<ReservaDTO> createReservation(@RequestBody ReservaDTO reservaDto) {
        ReservaDTO newReservation = reservaService.createReservation(reservaDto);
        return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ReservaDTO> getReservationList() {
        return new ResponseEntity(reservaService.getReservationList(), HttpStatus.OK);
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<ReservaDTO> getReservationById(@PathVariable Long reservationId) {
        ReservaDTO reservaDto = reservaService.getReservationById(reservationId);
        return new ResponseEntity<>(reservaDto, HttpStatus.OK);
    }

    @PutMapping("/{reservationId}")
    public ResponseEntity<ReservaDTO> updateReservation(@PathVariable Long reservationId, @RequestBody ReservaDTO reservaDto) {
        ReservaDTO updatedReservation = reservaService.updateReservation(reservationId, reservaDto);
        return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long reservationId) {
        reservaService.deleteReservation(reservationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
