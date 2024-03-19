package com.infnet.ghreservation.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@FeignClient(value = "ghproperty", url = "http://localhost:8081/api/properties")
public interface PropertyClient {
    @PutMapping("/dates/{propertyId}")
    ResponseEntity<Void> setReservedDates(@PathVariable("propertyId") Long propertyId, @RequestBody List<LocalDate> newDates);
}
