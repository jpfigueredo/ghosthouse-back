package com.infnet.ghcommunication.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
public class CommunicationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private CommunicationController communicationController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSendMessage() throws Exception {
        String jsonBody = "{\"senderId\": 1, \"recipientId\": 2, \"content\": \"Hello, I'm interested in your property!\"}";

        mockMvc.perform(post("/communication/messages")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.senderId").value(1))
                .andExpect(jsonPath("$.recipientId").value(2))
                .andExpect(jsonPath("$.content").value("Hello, I'm interested in your property!"));
    }

    // Outros testes para os endpoints do CommunicationController...
}
