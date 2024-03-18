package com.infnet.ghcommunication.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "tb_communication")
public class Communication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="communication_id")
    @EqualsAndHashCode.Include
    private Long id;

    private Long senderId;

    private Long receiverId;

    private String description;
}
