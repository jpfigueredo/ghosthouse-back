package com.infnet.ghcommunication.dto;

import lombok.Data;

@Data
public class CommunicationDTO {
    private Long id;
    private Long senderId;
    private Long receiverId;
    private String description;
}
