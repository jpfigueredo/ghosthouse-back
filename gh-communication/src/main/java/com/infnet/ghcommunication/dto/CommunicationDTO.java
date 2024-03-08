package com.infnet.ghcommunication.dto;

import lombok.Data;

@Data
public class CommunicationDTO {
    private Integer senderId;
    private Integer receiverId;
    private String description;
}
