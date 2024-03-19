package com.infnet.ghpropertysearch.controller;

import com.infnet.ghpropertysearch.dto.PropertySearchDTO;
import com.infnet.ghpropertysearch.service.PropertySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/properties")
public class PropertySearchController {

    @Autowired
    private PropertySearchService propertySearchService;

    @PostMapping
    public ResponseEntity<PropertySearchDTO> createProperty(@RequestBody PropertySearchDTO propertySearchDTO) {
        PropertySearchDTO newProperty = propertySearchService.createProperty(propertySearchDTO);
        return new ResponseEntity<>(newProperty, HttpStatus.CREATED);
    }

    @GetMapping("/{propertyId}")
    public ResponseEntity<PropertySearchDTO> getPropertyById(@PathVariable Long propertyId) {
        PropertySearchDTO propertySearchDTO = propertySearchService.getPropertyById(propertyId);
        return new ResponseEntity<>(propertySearchDTO, HttpStatus.OK);
    }

    @PutMapping("/{propertyId}")
    public ResponseEntity<PropertySearchDTO> updateProperty(@PathVariable Long propertyId, @RequestBody PropertySearchDTO propertySearchDTO) {
        PropertySearchDTO updatedProperty = propertySearchService.updateProperty(propertyId, propertySearchDTO);
        return new ResponseEntity<>(updatedProperty, HttpStatus.OK);
    }

    @DeleteMapping("/{propertyId}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long propertyId) {
        propertySearchService.deleteProperty(propertyId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
