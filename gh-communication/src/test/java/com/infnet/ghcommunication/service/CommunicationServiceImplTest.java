package com.infnet.ghcommunication.service;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.infnet.ghcommunication.builder.CommunicationBuilder;
import com.infnet.ghcommunication.domain.Communication;
import com.infnet.ghcommunication.dto.CommunicationDTO;
import com.infnet.ghcommunication.repository.CommunicationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

public class CommunicationServiceImplTest {

    @Mock
    private CommunicationRepository communicationRepository;

    @InjectMocks
    private CommunicationService communicationService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private CommunicationBuilder communicationBuilder;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Order(1)
    void sendMessage() throws Exception {
        CommunicationDTO communicationDTO = communicationBuilder.createCommunicationDTO();
        Communication communication = communicationBuilder.createCommunication();

        when(modelMapper.map(communicationDTO, Communication.class)).thenReturn(communication);
        when(communicationRepository.save(any(Communication.class))).thenReturn(communication);
        when(modelMapper.map(communication, CommunicationDTO.class)).thenReturn(communicationDTO);

        CommunicationDTO savedCommunicationDTO = communicationService.sendMessage(communicationDTO);

        Assertions.assertEquals(communicationDTO, savedCommunicationDTO);
        verify(communicationRepository, times(1)).save(any(Communication.class));
    }

    @Test
    @Order(2)
    void getCommunicationById() throws Exception {
        Long communicationById = 1L;
        CommunicationDTO communicationDTO = communicationBuilder.createCommunicationDTO();
        Communication communication = communicationBuilder.createCommunication();

        when(communicationRepository.findById(communicationById)).thenReturn(Optional.of(communication));
        when(modelMapper.map(communication, CommunicationDTO.class)).thenReturn(communicationDTO);

        CommunicationDTO foundCommunicationDTO = communicationService.getMessageById(communicationById);

        Assertions.assertEquals(communicationDTO, foundCommunicationDTO);
    }

    @Test
    @Order(3)
    void getCommunicationByIdThrowsException() {
        Long communicationById = 1L;
        when(communicationRepository.findById(communicationById)).thenReturn(Optional.empty());
        assertThrows(Exception.class, () -> communicationService.getMessageById(communicationById));
    }

    @Test
    @Order(4)
    void deleteCommunication() throws Exception {
        Long communicationID = 1L;
        when(communicationRepository.existsById(communicationID)).thenReturn(true);
        communicationService.deleteMessage(communicationID);
        verify(communicationRepository, times(1)).deleteById(communicationID);
    }

    @Test
    @Order(5)
    void deleteCommunicationThrowsException() {
        Long communicationID = 1L;
        when(communicationRepository.existsById(communicationID)).thenReturn(false);
        assertThrows(Exception.class, () -> communicationService.deleteMessage(communicationID));
    }

    @Test
    @Order(6)
    void getCommunicationList() throws Exception {
        List<Communication> communicationList = communicationBuilder.createCommunicationList();
        List<CommunicationDTO> communicationDTOList = communicationBuilder.createCommunicationDTOList();

        when(communicationRepository.findAll()).thenReturn(communicationList);

        List<CommunicationDTO> foundCommunicationDTOList = communicationService.getMessageList();

        Assertions.assertEquals(communicationDTOList.size(), foundCommunicationDTOList.size());
        for (int i = 0; i < communicationList.size(); i++) {
            Assertions.assertEquals(communicationDTOList.get(i).getReceiverId(), communicationList.get(i).getReceiverId());
            Assertions.assertEquals(communicationDTOList.get(i).getSenderId(), communicationList.get(i).getSenderId());
        }
    }
}


