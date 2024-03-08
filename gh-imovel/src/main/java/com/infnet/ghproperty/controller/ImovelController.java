package com.infnet.ghproperty.controller;

import com.infnet.ghproperty.dto.ImovelDTO;
import com.infnet.ghproperty.service.ImovelService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/properties")
public class ImovelController {

    @Autowired
    private ImovelService imovelService;

    @PostMapping
    @Transactional
    public ResponseEntity createProperty(@RequestBody @Valid ImovelDTO imovelDTO)  throws Exception{
        return new ResponseEntity<>(imovelService.createProperty(imovelDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getProperties()  throws Exception{
        return new ResponseEntity(imovelService.getPropertyList(), HttpStatus.OK);
    }

    @GetMapping("/{propertyId}")
    public ResponseEntity<ImovelDTO> getPropertyById(@RequestParam Long propertyId)  throws Exception{
        return new ResponseEntity<>(imovelService.getPropertyById(propertyId), HttpStatus.OK);
    }

    @PutMapping("/{propertyId}")
    public ResponseEntity<ImovelDTO> updateProperty(@RequestParam Long propertyId, @RequestBody ImovelDTO imovelDto)  throws Exception{
        ImovelDTO updatedProperty = imovelService.updateProperty(propertyId, imovelDto);
        return new ResponseEntity<>(updatedProperty, HttpStatus.OK);
    }

    @DeleteMapping("/{propertyId}")
    public void deleteProperty(@RequestParam Long propertyId) throws Exception {
        imovelService.deleteProperty(propertyId);
    }
}
