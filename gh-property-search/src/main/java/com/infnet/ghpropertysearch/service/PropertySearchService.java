package com.infnet.ghpropertysearch.service;

import com.infnet.ghpropertysearch.dto.PropertySearchDTO;
import org.springframework.stereotype.Service;

@Service
public class PropertySearchService {

    public PropertySearchDTO createProperty(PropertySearchDTO propertySearchDTO) {
        // Implementar lógica para criar um novo imóvel
        // Converter PropertyDto para entidade de domínio, salvar no banco de dados e retornar o PropertyDto resultante
        return null;
    }

    public PropertySearchDTO getPropertyById(Long propertyId) {
        // Implementar lógica para buscar um imóvel pelo ID e retornar o PropertyDto correspondente
        return null;
    }

    public PropertySearchDTO updateProperty(Long propertyId, PropertySearchDTO propertySearchDTO) {
        // Implementar lógica para atualizar um imóvel existente com os dados fornecidos em propertyDto
        // Retornar o PropertyDto atualizado
        return null;
    }

    public void deleteProperty(Long propertyId) {
        // Implementar lógica para excluir um imóvel pelo ID
    }
}
