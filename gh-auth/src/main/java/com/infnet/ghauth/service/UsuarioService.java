package com.infnet.ghauth.service;

import com.infnet.ghauth.domain.Usuario;
import com.infnet.ghauth.dto.LoginDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final ProprietarioService proprietarioService;
    private final LocatarioService locatarioService;

    public UsuarioService(ProprietarioService proprietarioService, LocatarioService locatarioService) {
        this.proprietarioService = proprietarioService;
        this.locatarioService = locatarioService;
    }

    public LoginDTO autenticar(LoginDTO login) {
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
