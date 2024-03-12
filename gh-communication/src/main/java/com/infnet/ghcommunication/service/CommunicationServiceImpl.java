package com.infnet.ghcommunication.service;

import com.infnet.ghcommunication.domain.Communication;
import com.infnet.ghcommunication.repository.CommunicationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infnet.ghcommunication.dto.CommunicationDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommunicationServiceImpl implements CommunicationService{

    @Autowired
    CommunicationRepository communicationRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommunicationDTO sendMessage(CommunicationDTO communicationDTO) {
        Communication communication = modelMapper.map(communicationDTO, Communication.class);
        Communication savedReview = communicationRepository.save(communication);
        return modelMapper.map(savedReview, CommunicationDTO.class);
    }

    @Override
    public CommunicationDTO getMessageById(Long communicationID) throws Exception {
        Communication review = communicationExistsByID(communicationID);
        return modelMapper.map(review, CommunicationDTO.class);
    }

    @Override
    public void deleteMessage(Long communicationID) throws Exception {
        Communication communication = communicationExistsByID(communicationID);
        communicationRepository.delete(communication);
    }

    @Override
    public List<CommunicationDTO> getMessageList() {
        List<Communication> imovelList = communicationRepository.findAll();
        return imovelList.stream()
                .map(review -> modelMapper.map(review, CommunicationDTO.class))
                .collect(Collectors.toList());
    }

    private Communication communicationExistsByID(Long communicationID) throws Exception {
        if (!communicationRepository.existsById(communicationID)) {
            throw new Exception("Mensagem não encontrado com o ID: " + communicationID);
        }
        return communicationRepository.findById(communicationID).get();
    }
}
