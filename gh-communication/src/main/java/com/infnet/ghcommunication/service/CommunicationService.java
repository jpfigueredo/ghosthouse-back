package com.infnet.ghcommunication.service;

import com.infnet.ghcommunication.dto.CommunicationDTO;

public interface CommunicationService {
    public CommunicationDTO sendMessage(CommunicationDTO communicationDTO);
    public CommunicationDTO getMessageById(Long communicationDTO);
    public void deleteMessage(Long communicationDTO);
}
