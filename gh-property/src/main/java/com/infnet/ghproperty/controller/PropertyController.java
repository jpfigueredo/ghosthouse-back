package com.infnet.ghproperty.controller;

import com.infnet.ghproperty.dto.PropertyDTO;
import com.infnet.ghproperty.service.PropertyService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping
    @Transactional
    public ResponseEntity createProperty(@RequestBody @Valid PropertyDTO propertyDTO)  throws Exception{
        return new ResponseEntity<>(propertyService.createProperty(propertyDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getProperties()  throws Exception{
        return new ResponseEntity(propertyService.getPropertyList(), HttpStatus.OK);
    }

    @GetMapping("/{propertyId}")
    public ResponseEntity<PropertyDTO> getPropertyById(@RequestParam Long propertyId)  throws Exception{
        return new ResponseEntity<>(propertyService.getPropertyById(propertyId), HttpStatus.OK);
    }

    @PutMapping("/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestParam Long propertyId, @RequestBody PropertyDTO propertyDto)  throws Exception{
        PropertyDTO updatedProperty = propertyService.updateProperty(propertyId, propertyDto);
        return new ResponseEntity<>(updatedProperty, HttpStatus.OK);
    }

    @DeleteMapping("/{propertyId}")
    public void deleteProperty(@RequestParam Long propertyId) throws Exception {
        propertyService.deleteProperty(propertyId);
    }
}
