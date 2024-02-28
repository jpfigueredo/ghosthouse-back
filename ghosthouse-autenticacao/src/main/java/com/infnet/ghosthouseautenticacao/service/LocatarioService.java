package com.infnet.ghosthouseautenticacao.service;

import com.infnet.ghosthouseautenticacao.domain.Locatario;
import com.infnet.ghosthouseautenticacao.repository.LocatarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocatarioService {
    private final LocatarioRepository locatarioRepository;

    public LocatarioService(LocatarioRepository locatarioRepository) {
        this.locatarioRepository = locatarioRepository;
    }

    public Locatario save(Locatario locatario) {
        boolean emailEmUso = locatarioRepository.findByEmail(locatario.getEmail())
                .stream()
                .anyMatch(usuarioExistente -> !usuarioExistente.equals(locatario));

        if (emailEmUso) {
            throw new RuntimeException("Já existe um usuário cadastrado com este e-mail.");
        }

        return locatarioRepository.save(locatario);
    }

    public Locatario findLocatario(Long id) {
        Optional<Locatario> locatario = locatarioRepository.findById(id);

        return locatario.orElse(null);
    }

    public Locatario findLocatarioByEmail(String email) {
        Optional<Locatario> locatario = locatarioRepository.findByEmail(email);

        return locatario.orElse(null);
    }
}
