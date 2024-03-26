package com.infnet.ghproperty.service;

import com.infnet.ghproperty.client.ReservaClient;
import com.infnet.ghproperty.dto.PropertyDTO;
import com.infnet.ghproperty.domain.Property;
import com.infnet.ghproperty.exceptions.ResourceNotFoundException;
import com.infnet.ghproperty.repository.PropertyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ReservaClient reservaClient;

    @Override
    public PropertyDTO createProperty(PropertyDTO propertyDTO) {
        Property property = modelMapper.map(propertyDTO, Property.class);
        Property savedProperty = propertyRepository.save(property);
        return modelMapper.map(savedProperty, PropertyDTO.class);
    }

    @Override
    public PropertyDTO getPropertyById(Long propertyId) {
        Property property = propertyExistsByID(propertyId);
        return modelMapper.map(property, PropertyDTO.class);
    }

    @Override
    public PropertyDTO updateProperty(Long propertyId, PropertyDTO propertyDTO) {
        if (!propertyRepository.existsById(propertyId)) {
            throw new EntityNotFoundException("Imóvel não encontrado com o ID: " + propertyId);
        }
        propertyDTO.setId(propertyId);
        Property updatedProperty = propertyRepository.save(modelMapper.map(propertyDTO, Property.class));
        return modelMapper.map(updatedProperty, PropertyDTO.class);
    }

    @Override
    public void deleteProperty(Long propertyId) {
        Property property = propertyExistsByID(propertyId);
        if(!reservaClient.getReservaListByPropertyId(propertyId).getBody().isEmpty()) {
            throw new IllegalArgumentException("Não é possível deletar imóveis que possuem reservas.");
        }
        propertyRepository.delete(property);
    }

    @Override
    public void setDatasReservadas(Long propertyId, List<LocalDate> newDates) {
        Property property = propertyExistsByID(propertyId);
        List<LocalDate> reservedDates = property.getDatasReservadas();
        reservedDates.addAll(newDates);
        property.setDatasReservadas(reservedDates);
        propertyRepository.save(property);
    }

    @Override
    public List<LocalDate> getDatasReservadas(Long propertyId) {
        Property property = propertyExistsByID(propertyId);
        return property.getDatasReservadas();
    }

    @Override
    public void removeDatasReservadas(Long propertyId, List<LocalDate> datesToRemove) {
        Property property = propertyExistsByID(propertyId);
        List<LocalDate> reservedDates = property.getDatasReservadas();
        reservedDates.removeAll(datesToRemove);
        property.setDatasReservadas(reservedDates);
        propertyRepository.save(property);
    }

    @Override
    public List<PropertyDTO> getPropertyByProprietarioId(Long proprietarioId) {
        List<Property> propertyList = propertyRepository.getPropertyByProprietarioId(proprietarioId);
        return propertyList.stream()
                .map(property -> modelMapper.map(property, PropertyDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PropertyDTO> getPropertyList() {
        List<Property> propertyList = propertyRepository.findAll();
        return propertyList.stream()
                .map(property -> modelMapper.map(property, PropertyDTO.class))
                .collect(Collectors.toList());
    }

    private Property propertyExistsByID(Long propertyId) {
        if (!propertyRepository.existsById(propertyId)) {
            throw new EntityNotFoundException("Imóvel não encontrado com o ID: " + propertyId);
        }
        return propertyRepository.findById(propertyId).get();
    }
}
