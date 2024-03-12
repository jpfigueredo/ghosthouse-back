package com.infnet.ghauth.domain;


import com.infnet.ghauth.enums.UserType;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Inheritance
@Table(name = "tb_usuario")
@DiscriminatorColumn(name = "userType", discriminatorType = DiscriminatorType.STRING)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    @Column(insertable=false, updatable=false)
    @Enumerated(EnumType.STRING)
    private UserType userType;

}
