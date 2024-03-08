package com.infnet.ghcommunication.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.infnet.ghcommunication.domain.Communication;
import com.infnet.ghcommunication.dto.CommunicationDTO;
import com.infnet.ghcommunication.repository.CommunicationRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CommunicationServiceImplTest {

    @Mock
    private CommunicationRepository communicationRepository;

    @InjectMocks
    private CommunicationServiceImpl communicationService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSendMessage() {
        // Simular uma nova mensagem
        Communication message = new Communication();
        message.setSenderId(1L);
        message.setReceiverId(2L);
        message.setDescription("Hello, I'm interested in your property!");

        CommunicationDTO messageDTO = new CommunicationDTO();
        message.setSenderId(1L);
        message.setReceiverId(2L);
        message.setDescription("Hello, I'm interested in your property!");

        // Simular o envio da mensagem no repositório
        when(communicationRepository.save(message)).thenReturn(message);

        // Chamar o método para enviar a mensagem
        CommunicationDTO result = communicationService.sendMessage(messageDTO);

        // Verificar se a mensagem foi enviada corretamente
        assertEquals(message, result);
    }

    // Outros testes para os métodos do CommunicationService...
}
