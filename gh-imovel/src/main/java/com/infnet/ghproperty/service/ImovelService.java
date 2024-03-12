package com.infnet.ghproperty.service;

import com.infnet.ghproperty.dto.ImovelDTO;
import com.infnet.ghproperty.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ImovelService {
    ImovelDTO createProperty(ImovelDTO imovelDto);
    ImovelDTO getPropertyById(Long propertyId) throws Exception;
    List<ImovelDTO> getPropertyList();
    ImovelDTO updateProperty(Long propertyId, ImovelDTO imovelDto) throws ResourceNotFoundException;
    void deleteProperty(Long propertyId) throws Exception;

}
