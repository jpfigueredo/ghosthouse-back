package com.infnet.ghproperty.controller;

import com.infnet.ghproperty.dto.PropertyDTO;
import com.infnet.ghproperty.service.PropertyService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping
    @Transactional
    public ResponseEntity<PropertyDTO> createProperty(@RequestBody @Valid PropertyDTO propertyDTO) {
        return new ResponseEntity<>(propertyService.createProperty(propertyDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PropertyDTO>> getProperties() {
        return new ResponseEntity<>(propertyService.getPropertyList(), HttpStatus.OK);
    }

    @GetMapping("/{propertyId}")
    public ResponseEntity<PropertyDTO> getPropertyById(@PathVariable Long propertyId) {
        return new ResponseEntity<>(propertyService.getPropertyById(propertyId), HttpStatus.OK);
    }

    @PutMapping("/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@PathVariable Long propertyId, @RequestBody PropertyDTO propertyDto) {
        PropertyDTO updatedProperty = propertyService.updateProperty(propertyId, propertyDto);
        return new ResponseEntity<>(updatedProperty, HttpStatus.OK);
    }

    @DeleteMapping("/{propertyId}")
    public void deleteProperty(@PathVariable Long propertyId) {
        propertyService.deleteProperty(propertyId);
    }

    @PutMapping("/dates/{propertyId}")
    public ResponseEntity<Void> updatePropertyDates(@PathVariable Long propertyId, @RequestBody List<LocalDate> newDates) {
        propertyService.setDatasReservadas(propertyId, newDates);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/dates/{propertyId}")
    public ResponseEntity<List<LocalDate>> getPropertyDates(@PathVariable Long propertyId) {
        return new ResponseEntity<>(propertyService.getDatasReservadas(propertyId), HttpStatus.OK);
    }
}
