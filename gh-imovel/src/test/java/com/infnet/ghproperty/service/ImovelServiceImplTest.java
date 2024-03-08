package com.infnet.ghproperty.service;

import com.infnet.ghproperty.builder.ImovelBuilder;
import com.infnet.ghproperty.domain.Imovel;
import com.infnet.ghproperty.dto.ImovelDTO;
import com.infnet.ghproperty.exceptions.ResourceNotFoundException;
import com.infnet.ghproperty.repository.ImovelRepository;
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
class ImovelServiceImplTest {

    @Mock
    private ImovelRepository imovelRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private ImovelBuilder imovelBuilder;

    @InjectMocks
    private ImovelServiceImpl imovelService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Order(1)
    void createImovel() throws Exception {
        ImovelDTO imovelDTO = imovelBuilder.createImovelDTO();
        Imovel imovel = imovelBuilder.createImovel();

        when(modelMapper.map(imovelDTO, Imovel.class)).thenReturn(imovel);
        when(imovelRepository.save(any(Imovel.class))).thenReturn(imovel);
        when(modelMapper.map(imovel, ImovelDTO.class)).thenReturn(imovelDTO);

        ImovelDTO savedImovelDTO = imovelService.createProperty(imovelDTO);

        assertEquals(imovelDTO, savedImovelDTO);
        verify(imovelRepository, times(1)).save(any(Imovel.class));
    }

    @Test
    @Order(2)
    void getImovelById() throws Exception {
        Long propertyId = 1L;
        ImovelDTO imovelDTO = imovelBuilder.createImovelDTO();
        Imovel imovel = imovelBuilder.createImovel();

        when(imovelRepository.findById(propertyId)).thenReturn(Optional.of(imovel));
        when(modelMapper.map(imovel, ImovelDTO.class)).thenReturn(imovelDTO);

        ImovelDTO foundImovelDTO = imovelService.getPropertyById(propertyId);

        assertEquals(imovelDTO, foundImovelDTO);
    }

    @Test
    @Order(3)
    void getImovelByIdThrowsException() {
        Long propertyId = 1L;

        when(imovelRepository.findById(propertyId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> imovelService.getPropertyById(propertyId));
    }

    @Test
    @Order(4)
    void updateImovel() throws Exception {
        Long propertyId = 1L;
        ImovelDTO imovelDTO = imovelBuilder.createImovelDTOWithId(propertyId);
        Imovel imovel = imovelBuilder.createImovelWithId(propertyId);

        when(imovelRepository.existsById(propertyId)).thenReturn(true);
        when(imovelRepository.save(any(Imovel.class))).thenReturn(imovel);
        when(modelMapper.map(imovelDTO, Imovel.class)).thenReturn(imovel);
        when(modelMapper.map(imovel, ImovelDTO.class)).thenReturn(imovelDTO);

        ImovelDTO updatedImovelDTO = imovelService.updateProperty(propertyId, imovelDTO);

        assertEquals(imovelDTO, updatedImovelDTO);
    }

    @Test
    @Order(5)
    void updateImovelThrowsException() {
        Long propertyId = 1L;
        ImovelDTO imovelDTO = imovelBuilder.createImovelDTOWithId(propertyId);

        when(imovelRepository.existsById(propertyId)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> imovelService.updateProperty(propertyId, imovelDTO));
    }

    @Test
    @Order(6)
    void deleteImovel() throws Exception {
        Long propertyId = 1L;
        when(imovelRepository.existsById(propertyId)).thenReturn(true);
        imovelService.deleteProperty(propertyId);
        verify(imovelRepository, times(1)).deleteById(propertyId);
    }

    @Test
    @Order(7)
    void deleteImovelThrowsException() {
        Long propertyId = 1L;
        when(imovelRepository.existsById(propertyId)).thenReturn(false);
        assertThrows(ResourceNotFoundException.class, () -> imovelService.deleteProperty(propertyId));
    }

    @Test
    @Order(8)
    void getImovelList() {
        List<Imovel> imovelList = imovelBuilder.createImovelList();
        List<ImovelDTO> imovelDTOList = imovelBuilder.createImovelDTOList();

        when(imovelRepository.findAll()).thenReturn(imovelList);

        List<ImovelDTO> foundImovelDTOList = imovelService.getPropertyList();
        assertEquals(imovelDTOList.size(), foundImovelDTOList.size());
        for (int i = 0; i < imovelList.size(); i++) {
            assertEquals(imovelDTOList.get(i).getIdProprietario(), imovelList.get(i).getIdProprietario().getId());
        }
    }
}
