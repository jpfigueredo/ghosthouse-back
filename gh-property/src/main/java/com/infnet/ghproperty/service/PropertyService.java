package com.infnet.ghproperty.service;

import com.infnet.ghproperty.dto.PropertyDTO;
import com.infnet.ghproperty.exceptions.ResourceNotFoundException;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PropertyService {
    PropertyDTO createProperty(PropertyDTO propertyDto);
    PropertyDTO getPropertyById(Long propertyId);
    List<PropertyDTO> getPropertyList();
    PropertyDTO updateProperty(Long propertyId, PropertyDTO propertyDto);
    void deleteProperty(Long propertyId);
    void setDatasReservadas(Long propertyId, List<LocalDate> newDates);
    List<LocalDate> getDatasReservadas(Long propertyId);
    void removeDatasReservadas(Long propertyId, List<LocalDate> datesToRemove);
    List<PropertyDTO> getPropertyByProprietarioId(Long proprietarioId);
}
