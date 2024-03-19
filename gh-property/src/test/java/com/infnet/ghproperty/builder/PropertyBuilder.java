package com.infnet.ghproperty.builder;

import com.infnet.ghproperty.domain.Property;
import com.infnet.ghproperty.dto.PropertyDTO;
import com.infnet.ghproperty.dto.ProprietarioDTO;
import com.infnet.ghproperty.enums.TipoCategoria;

import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class PropertyBuilder {

    public PropertyDTO createImovelDTO(){
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(1L);
        propertyDTO.setNome("teste");
        propertyDTO.setDescricao("testestestestestestestesteste");
        propertyDTO.setCategoria(TipoCategoria.CASA);
        propertyDTO.setIdProprietario(1L);
        propertyDTO.setDatasReservadas(createDateList());
        propertyDTO.setQuantidadeQuartos(1);
        propertyDTO.setArea(1);
        propertyDTO.setEndereco("Al. Teste, 123");
        propertyDTO.setValorDiaria(200.0);
        return propertyDTO;
    }

    public PropertyDTO createImovelDTOWithId(Long id) {
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(id);
        propertyDTO.setNome("teste");
        propertyDTO.setDescricao("testestestestestestestesteste");
        propertyDTO.setCategoria(TipoCategoria.CASA);
        propertyDTO.setIdProprietario(1L);
        propertyDTO.setDatasReservadas(createDateList());
        propertyDTO.setQuantidadeQuartos(1);
        propertyDTO.setArea(1);
        propertyDTO.setEndereco("Al. Teste, 123");
        propertyDTO.setValorDiaria(200.0);
        return propertyDTO;
    }

    public List<PropertyDTO> createImovelDTOList(){
        List<PropertyDTO> listPropertyDTO = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            PropertyDTO propertyDTO = new PropertyDTO();
            propertyDTO.setId((long) i);
            propertyDTO.setNome("teste");
            propertyDTO.setDescricao("testestestestestestestesteste");
            propertyDTO.setCategoria(TipoCategoria.CASA);
            propertyDTO.setIdProprietario(1L);
            propertyDTO.setDatasReservadas(createDateList());
            propertyDTO.setQuantidadeQuartos(1);
            propertyDTO.setArea(50);
            propertyDTO.setEndereco("Al. Teste, 123");
            propertyDTO.setValorDiaria(200.0);
            listPropertyDTO.add(propertyDTO);
        }
        return listPropertyDTO;
    }

    public Property createImovel(){
        Property property = new Property();
        property.setId(1L);
        property.setNome("teste");
        property.setDescricao("testestestestestestestesteste");
        property.setCategoria(TipoCategoria.CASA);
        property.setProprietarioId(1L);
        property.setDatasReservadas(createDateList());
        property.setQuantidadeQuartos(1);
        property.setArea(1);
        property.setEndereco("Al. Teste, 123");
        property.setValorDiaria(200.0);
        return property;
    }

    public List<Property> createImovelList(){
        List<Property> listProperty = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Property property = new Property();
            property.setId((long) i);
            property.setNome("teste");
            property.setDescricao("testestestestestestestesteste");
            property.setCategoria(TipoCategoria.CASA);
            property.setProprietarioId(1L);
            property.setDatasReservadas(createDateList());
            property.setQuantidadeQuartos(1);
            property.setArea(1);
            property.setEndereco("Al. Teste, 123");
            property.setValorDiaria(200.0);
            listProperty.add(property);
        }
        return listProperty;
    }

    public Property createImovelWithId(Long id){
        Property property = new Property();
        property.setId(id);
        property.setNome("teste");
        property.setDescricao("testestestestestestestesteste");
        property.setCategoria(TipoCategoria.CASA);
        property.setProprietarioId(1L);
        property.setDatasReservadas(createDateList());
        property.setQuantidadeQuartos(1);
        property.setArea(1);
        property.setEndereco("Al. Teste, 123");
        property.setValorDiaria(200.0);
        return property;
    }


    private List<LocalDate> createDateList(){
        List<LocalDate> dateList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            LocalDate date = LocalDate.of(2024, 3, i);
            dateList.add(date);
        }
        return dateList;
    }


}
