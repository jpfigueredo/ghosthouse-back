package com.infnet.ghproperty.service;

import com.infnet.ghproperty.dto.PropertyDTO;
import com.infnet.ghproperty.exceptions.ResourceNotFoundException;

import java.util.List;

public interface PropertyService {
    PropertyDTO createProperty(PropertyDTO propertyDto);
    PropertyDTO getPropertyById(Long propertyId) throws Exception;
    List<PropertyDTO> getPropertyList();
    PropertyDTO updateProperty(Long propertyId, PropertyDTO propertyDto) throws ResourceNotFoundException;
    void deleteProperty(Long propertyId) throws Exception;

}
