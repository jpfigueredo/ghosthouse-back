package com.infnet.ghproperty.service;

import com.infnet.ghproperty.dto.PropertyDTO;
import com.infnet.ghproperty.domain.Property;
import com.infnet.ghproperty.exceptions.ResourceNotFoundException;
import com.infnet.ghproperty.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public PropertyDTO createProperty(PropertyDTO propertyDTO) {
        Property property = modelMapper.map(propertyDTO, Property.class);
        Property savedProperty = propertyRepository.save(property);
        return modelMapper.map(savedProperty, PropertyDTO.class);
    }

    @Override
    public PropertyDTO getPropertyById(Long propertyId) throws Exception {
        Property review = propertyExistsByID(propertyId);
        return modelMapper.map(review, PropertyDTO.class);
    }

    @Override
    public PropertyDTO updateProperty(Long propertyId, PropertyDTO propertyDTO) throws ResourceNotFoundException {
        if (!propertyRepository.existsById(propertyId)) {
            throw new ResourceNotFoundException("Imóvel não encontrado com o ID: " + propertyId);
        }
        propertyDTO.setId(propertyId);
        Property updatedProperty = propertyRepository.save(modelMapper.map(propertyDTO, Property.class));
        return modelMapper.map(updatedProperty, PropertyDTO.class);
    }

    @Override
    public void deleteProperty(Long propertyId) throws Exception {
        Property property = propertyExistsByID(propertyId);
        propertyRepository.delete(property);
    }

    @Override
    public List<PropertyDTO> getPropertyList() {
        List<Property> propertyList = propertyRepository.findAll();
        return propertyList.stream()
                .map(property -> modelMapper.map(property, PropertyDTO.class))
                .collect(Collectors.toList());
    }

    private Property propertyExistsByID(Long propertyId) throws Exception {
        if (!propertyRepository.existsById(propertyId)) {
            throw new ResourceNotFoundException("Imóvel não encontrado com o ID: " + propertyId);
        }
        return propertyRepository.findById(propertyId).get();
    }
}
