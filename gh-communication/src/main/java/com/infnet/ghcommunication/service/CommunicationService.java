package com.infnet.ghcommunication.service;

import com.infnet.ghcommunication.dto.CommunicationDTO;

import java.util.List;

public interface CommunicationService {
    CommunicationDTO sendMessage(CommunicationDTO communicationDTO) throws Exception;
    CommunicationDTO getMessageById(Long communicationDTO) throws Exception;
    void deleteMessage(Long communicationDTO) throws Exception;
    List<CommunicationDTO> getMessageList() throws Exception;

}
