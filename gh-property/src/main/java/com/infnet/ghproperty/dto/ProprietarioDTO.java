package com.infnet.ghproperty.dto;

import com.infnet.ghproperty.enums.UserType;
import lombok.Data;

@Data
public class ProprietarioDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private UserType userType;
}
