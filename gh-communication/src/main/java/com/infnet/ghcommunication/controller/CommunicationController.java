package com.infnet.ghcommunication.controller;

import com.infnet.ghcommunication.dto.CommunicationDTO;
import com.infnet.ghcommunication.service.CommunicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/communications")
public class CommunicationController {

    @Autowired
    private CommunicationServiceImpl communicationService;

    @PostMapping("/send")
    public ResponseEntity<CommunicationDTO> sendMessage(@RequestBody CommunicationDTO messageDto) {
        CommunicationDTO sentMessage = communicationService.sendMessage(messageDto);
        return new ResponseEntity<>(sentMessage, HttpStatus.CREATED);
    }

    @GetMapping("/{messageId}")
    public ResponseEntity<CommunicationDTO> getMessageById(@PathVariable Long messageId) throws Exception {
        CommunicationDTO messageDto = communicationService.getMessageById(messageId);
        return new ResponseEntity<>(messageDto, HttpStatus.OK);
    }

    @DeleteMapping("/{messageId}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long messageId) throws Exception {
        communicationService.deleteMessage(messageId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
