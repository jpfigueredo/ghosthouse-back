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
    public ResponseEntity<ReservaDTO> createReserva(@RequestBody ReservaDTO reservaDTO) {
        ReservaDTO newReservation = reservaService.createReserva(reservaDTO);
        return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ReservaDTO> getReservaList() {
        return new ResponseEntity(reservaService.getReservaList(), HttpStatus.OK);
    }

    @GetMapping("/{reservaId}")
    public ResponseEntity<ReservaDTO> getReservaById(@PathVariable Long reservaId) throws Exception {
        ReservaDTO reservaDto = reservaService.getReservaById(reservaId);
        return new ResponseEntity<>(reservaDto, HttpStatus.OK);
    }

    @PutMapping("/{reservaId}")
    public ResponseEntity<ReservaDTO> updateReserva(@PathVariable Long reservaId, @RequestBody ReservaDTO reservaDTO) throws Exception {
        ReservaDTO updatedReservation = reservaService.updateReserva(reservaId, reservaDTO);
        return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Long reservationId) throws Exception {
        reservaService.deleteReserva(reservationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
