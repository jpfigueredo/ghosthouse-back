package com.infnet.ghproperty.service;

import com.infnet.ghproperty.builder.PropertyBuilder;
import com.infnet.ghproperty.domain.Property;
import com.infnet.ghproperty.dto.PropertyDTO;
import com.infnet.ghproperty.exceptions.ResourceNotFoundException;
import com.infnet.ghproperty.repository.PropertyRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PropertyServiceImplTest {

    @Mock
    private PropertyRepository propertyRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private PropertyBuilder propertyBuilder;

    @InjectMocks
    private PropertyService propertyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Order(1)
    void createImovel() throws Exception {
        PropertyDTO propertyDTO = propertyBuilder.createImovelDTO();
        Property property = propertyBuilder.createImovel();

        when(modelMapper.map(propertyDTO, Property.class)).thenReturn(property);
        when(propertyRepository.save(any(Property.class))).thenReturn(property);
        when(modelMapper.map(property, PropertyDTO.class)).thenReturn(propertyDTO);

        PropertyDTO savedPropertyDTO = propertyService.createProperty(propertyDTO);

        assertEquals(propertyDTO, savedPropertyDTO);
        verify(propertyRepository, times(1)).save(any(Property.class));
    }

    @Test
    @Order(2)
    void getImovelById() throws Exception {
        Long propertyId = 1L;
        PropertyDTO propertyDTO = propertyBuilder.createImovelDTO();
        Property property = propertyBuilder.createImovel();

        when(propertyRepository.findById(propertyId)).thenReturn(Optional.of(property));
        when(modelMapper.map(property, PropertyDTO.class)).thenReturn(propertyDTO);

        PropertyDTO foundPropertyDTO = propertyService.getPropertyById(propertyId);

        assertEquals(propertyDTO, foundPropertyDTO);
    }

    @Test
    @Order(3)
    void getImovelByIdThrowsException() {
        Long propertyId = 1L;

        when(propertyRepository.findById(propertyId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> propertyService.getPropertyById(propertyId));
    }

    @Test
    @Order(4)
    void updateImovel() throws Exception {
        Long propertyId = 1L;
        PropertyDTO propertyDTO = propertyBuilder.createImovelDTOWithId(propertyId);
        Property property = propertyBuilder.createImovelWithId(propertyId);

        when(propertyRepository.existsById(propertyId)).thenReturn(true);
        when(propertyRepository.save(any(Property.class))).thenReturn(property);
        when(modelMapper.map(propertyDTO, Property.class)).thenReturn(property);
        when(modelMapper.map(property, PropertyDTO.class)).thenReturn(propertyDTO);

        PropertyDTO updatedPropertyDTO = propertyService.updateProperty(propertyId, propertyDTO);

        assertEquals(propertyDTO, updatedPropertyDTO);
    }

    @Test
    @Order(5)
    void updateImovelThrowsException() {
        Long propertyId = 1L;
        PropertyDTO propertyDTO = propertyBuilder.createImovelDTOWithId(propertyId);

        when(propertyRepository.existsById(propertyId)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> propertyService.updateProperty(propertyId, propertyDTO));
    }

    @Test
    @Order(6)
    void deleteImovel() throws Exception {
        Long propertyId = 1L;
        when(propertyRepository.existsById(propertyId)).thenReturn(true);
        propertyService.deleteProperty(propertyId);
        verify(propertyRepository, times(1)).deleteById(propertyId);
    }

    @Test
    @Order(7)
    void deleteImovelThrowsException() {
        Long propertyId = 1L;
        when(propertyRepository.existsById(propertyId)).thenReturn(false);
        assertThrows(ResourceNotFoundException.class, () -> propertyService.deleteProperty(propertyId));
    }

    @Test
    @Order(8)
    void getImovelList() throws Exception {
        List<Property> propertyList = propertyBuilder.createImovelList();
        List<PropertyDTO> propertyDTOList = propertyBuilder.createImovelDTOList();

        when(propertyRepository.findAll()).thenReturn(propertyList);

        List<PropertyDTO> foundPropertyDTOList = propertyService.getPropertyList();
        assertEquals(propertyDTOList.size(), foundPropertyDTOList.size());
        for (int i = 0; i < propertyList.size(); i++) {
            assertEquals(propertyDTOList.get(i).getIdProprietario(), propertyList.get(i).getProprietarioDTO().getId());
        }
    }
}
