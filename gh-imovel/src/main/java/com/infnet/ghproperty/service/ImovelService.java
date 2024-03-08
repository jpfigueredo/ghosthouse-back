package com.infnet.ghproperty.service;

import com.infnet.ghproperty.dto.ImovelDTO;

import java.util.List;

public interface ImovelService {
    public ImovelDTO createProperty(ImovelDTO imovelDto) throws Exception;
    public ImovelDTO getPropertyById(Long propertyId) throws Exception;
    public List<ImovelDTO> getPropertyList() throws Exception;
    public ImovelDTO updateProperty(Long propertyId, ImovelDTO imovelDto) throws Exception;
    public void deleteProperty(Long propertyId) throws Exception;

}
