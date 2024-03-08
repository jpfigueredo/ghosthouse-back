package com.infnet.ghpropertysearch.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ImovelSearchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private PropertySearchController propertySearchController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSearchProperties() throws Exception {
        mockMvc.perform(get("/properties/search")
                        .param("location", "Haunted City")
                        .param("minPrice", "100")
                        .param("maxPrice", "500")
                        .param("minRating", "4"))
                .andExpect(status().isOk());
        // Adicione mais asserções conforme necessário
    }

    // Outros testes para os endpoints do PropertySearchController...
}
