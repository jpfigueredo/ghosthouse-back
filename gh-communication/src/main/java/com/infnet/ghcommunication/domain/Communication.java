package com.infnet.ghcommunication.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_communication")
public class Communication {
    private Long id;
    private Long senderId;
    private Long receiverId;
    private String description;
}
