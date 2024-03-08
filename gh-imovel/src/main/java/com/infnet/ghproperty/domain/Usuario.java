package com.infnet.ghproperty.domain;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@MappedSuperclass
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String senha;
}
