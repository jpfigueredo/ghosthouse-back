package com.infnet.ghproperty.builder;

import com.infnet.ghproperty.domain.Property;
import com.infnet.ghproperty.domain.Proprietario;
import com.infnet.ghproperty.dto.PropertyDTO;
import com.infnet.ghproperty.enums.TipoCategoria;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class ImovelBuilder {

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
        property.setProprietario(createProprietario());
        property.setDatasReservadas(createDateList());
        property.setQuantidadeQuartos(1);
        property.setArea(1);
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
            property.setProprietario(createProprietario());
            property.setDatasReservadas(createDateList());
            property.setQuantidadeQuartos(1);
            property.setArea(1);
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
        property.setProprietario(createProprietario());
        property.setDatasReservadas(createDateList());
        property.setQuantidadeQuartos(1);
        property.setArea(1);
        return property;
    }

    private Proprietario createProprietario(){
        Proprietario proprietario = new Proprietario();
        proprietario.setId(1L);
        proprietario.setNome("teste");
        proprietario.setEmail("teste@teste.test");
        proprietario.setSenha("etset");
        proprietario.setTelefone("+55 12345-6789");
        return proprietario;
    }

    private List<Date> createDateList(){
        List<Date> dateList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Date date = new Date();
            date.setTime(i);
            dateList.add(date);
        }
        return dateList;
    }


}
