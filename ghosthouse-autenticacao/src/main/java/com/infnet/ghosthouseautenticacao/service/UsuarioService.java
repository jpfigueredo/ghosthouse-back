package com.infnet.ghosthouseautenticacao.service;

import com.infnet.ghosthouseautenticacao.domain.Usuario;
import com.infnet.ghosthouseautenticacao.dto.LoginDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsuarioService {
    private final ProprietarioService proprietarioService;
    private final LocatarioService locatarioService;

    public UsuarioService(ProprietarioService proprietarioService, LocatarioService locatarioService) {
        this.proprietarioService = proprietarioService;
        this.locatarioService = locatarioService;
    }

    public LoginDto autenticar(LoginDto login) {
        Usuario user = proprietarioService.findProprietarioByEmail(login.email());
        if (user==null) {
            user = locatarioService.findLocatarioByEmail(login.email());
        }

        if (user != null && user.getSenha().equals(login.senha())) {
            return login;
        } else {
            throw new EntityNotFoundException("Usuário não existente.");
        }
    }
}
