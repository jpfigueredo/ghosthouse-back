package com.infnet.ghproperty.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@FeignClient(value = "ghpreservation", url = "http://localhost:8082/api/reservas")
public interface ReservaClient {
    @GetMapping("/property/{propertyId}")
    ResponseEntity<List> getReservaListByPropertyId(@PathVariable("propertyId") Long propertyId);
}
