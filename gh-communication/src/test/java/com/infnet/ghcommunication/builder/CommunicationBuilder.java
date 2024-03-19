package com.infnet.ghcommunication.builder;

import com.infnet.ghcommunication.domain.Communication;
import com.infnet.ghcommunication.dto.CommunicationDTO;

import java.util.ArrayList;
import java.util.List;

public class CommunicationBuilder {

    public CommunicationDTO createCommunicationDTO(){
        CommunicationDTO communicationDTO = new CommunicationDTO();
        communicationDTO.setId(1L);
        communicationDTO.setDescription("testestesteste");
        communicationDTO.setReceiverId(1L);
        communicationDTO.setSenderId(1L);
        return communicationDTO;
    }

    public CommunicationDTO createCommunicationDTOWithId(Long id) {
        CommunicationDTO communicationDTO = new CommunicationDTO();
        communicationDTO.setId(id);
        communicationDTO.setDescription("testestesteste");
        communicationDTO.setReceiverId(1L);
        communicationDTO.setSenderId(1L);
        return communicationDTO;
    }

    public List<CommunicationDTO> createCommunicationDTOList(){
        List<CommunicationDTO> listcommunicationDTO = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            CommunicationDTO communicationDTO = new CommunicationDTO();
            communicationDTO.setId((long) i);
            communicationDTO.setDescription("testestesteste");
            communicationDTO.setReceiverId(1L);
            communicationDTO.setSenderId(1L);
            listcommunicationDTO.add(communicationDTO);
        }
        return listcommunicationDTO;
    }

    public Communication createCommunication(){
        Communication communication = new Communication();
        communication.setId(1L);
        return communication;
    }

    public Communication createCommunicationWithId(Long id){
        Communication communication = new Communication();
        communication.setId(id);
        communication.setDescription("testestesteste");
        communication.setReceiverId(1L);
        communication.setSenderId(1L);
        return communication;
    }

    public List<Communication> createCommunicationList(){
        List<Communication> listImovel = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Communication communication = new Communication();
            communication.setId((long) i);
            communication.setDescription("testestesteste");
            communication.setReceiverId(1L);
            communication.setSenderId(1L);
            listImovel.add(communication);
        }
        return listImovel;
    }

}

