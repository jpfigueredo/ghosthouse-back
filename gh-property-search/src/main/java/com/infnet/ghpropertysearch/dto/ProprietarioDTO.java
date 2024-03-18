package com.infnet.ghpropertysearch.dto;

import com.infnet.ghpropertysearch.enums.UserType;
import lombok.Data;

@Data
public class ProprietarioDTO{

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private UserType userType;
}
