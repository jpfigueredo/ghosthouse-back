package com.infnet.ghpropertysearch.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.infnet.ghproperty.domain.Imovel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class ImovelSearchServiceTest {

    @InjectMocks
    private PropertySearchService propertySearchService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSearchPropertiesByFilter() {
        // Simular um filtro de pesquisa
        PropertyFilter filter = new PropertyFilter();
        filter.setType("haunted");
        filter.setCity("Gotham");

        // Simular uma lista de imóveis que correspondem ao filtro
        List<Imovel> mockProperties = new ArrayList<>();
        Imovel imovel1 = new Imovel();
        imovel1.setId(1L);
        imovel1.setName("Haunted Mansion");
        imovel1.setCity("Gotham");
        imovel1.setType("haunted");
        mockProperties.add(imovel1);

        when(propertyRepository.findByTypeAndCity("haunted", "Gotham")).thenReturn(mockProperties);

        List<Imovel> result = propertySearchService.searchPropertiesByFilter(filter);

        assertEquals(mockProperties, result);
    }

    // Outros testes para os métodos do PropertySearchService...
}

