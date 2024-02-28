package com.infnet.ghosthouseautenticacao.service;

import com.infnet.ghosthouseautenticacao.domain.Proprietario;
import com.infnet.ghosthouseautenticacao.repository.ProprietarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProprietarioService {

    private final ProprietarioRepository proprietarioRepository;

    public ProprietarioService(ProprietarioRepository proprietarioRepository) {
        this.proprietarioRepository = proprietarioRepository;
    }

    public Proprietario save(Proprietario proprietario) {
        boolean emailEmUso = proprietarioRepository.findByEmail(proprietario.getEmail())
                .stream()
                .anyMatch(usuarioExistente -> !usuarioExistente.equals(proprietario));

        if (emailEmUso) {
            throw new RuntimeException("Já existe um usuário cadastrado com este e-mail.");
        }

        return proprietarioRepository.save(proprietario);
    }

    public Proprietario findProprietario(Long id) {
        Optional<Proprietario> proprietario = proprietarioRepository.findById(id);

        return proprietario.orElse(null);
    }

    public Proprietario findProprietarioByEmail(String email) {
        Optional<Proprietario> proprietario = proprietarioRepository.findByEmail(email);

        return proprietario.orElse(null);
    }
}
