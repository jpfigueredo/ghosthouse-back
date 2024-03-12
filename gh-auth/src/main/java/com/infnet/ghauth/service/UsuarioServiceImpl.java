package com.infnet.ghauth.service;

import com.infnet.ghauth.domain.Locatario;
import com.infnet.ghauth.domain.Proprietario;
import com.infnet.ghauth.domain.Usuario;
import com.infnet.ghauth.dto.LoginDTO;
import com.infnet.ghauth.dto.UserDTO;
import com.infnet.ghauth.exceptions.ResourceNotFoundException;
import com.infnet.ghauth.repository.LocatarioRepository;
import com.infnet.ghauth.repository.ProprietarioRepository;
import com.infnet.ghauth.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository userRepository;
    @Autowired
    private LocatarioRepository locatarioRepository;
    @Autowired
    private ProprietarioRepository proprietarioRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public UserDTO saveUser(UserDTO userDto) {

        Usuario savedUser = null;
        switch (userDto.getUserType()){
            case LOCATARIO:
                Locatario loc = modelMapper.map(userDto, Locatario.class);
                savedUser = locatarioRepository.save(loc);
                break;
            case PROPRIETARIO:
                Proprietario prop = modelMapper.map(userDto, Proprietario.class);
                savedUser = proprietarioRepository.save(prop);
                break;
            default:
                throw new IllegalArgumentException("Tipo de usuário inválido: " + userDto.getUserType());
        }

        return modelMapper.map(savedUser, UserDTO.class);
    }

    public UserDTO getUserById(Long userId) {
        Usuario user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + userId));
        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO updateUser(Long userId, UserDTO userDto) {
        if(!userRepository.existsById(userId)) {
            throw new EntityNotFoundException("Usuário não encontrado com o ID: " + userId);
        }
        userDto.setId(userId);
        return this.saveUser(userDto);
    }

    public void deleteUser(Long userId) {
        if(!userRepository.existsById(userId)) {
            throw new EntityNotFoundException("Usuário não encontrado com o ID: " + userId);
        }
        userRepository.deleteById(userId);
    }

    public UserDTO autenticar(LoginDTO login) {
        Usuario user = userRepository.findByEmail(login.email()).orElse(null);
         if (user != null && user.getSenha().equals(login.senha())) {
            return modelMapper.map(user, UserDTO.class);
        } else {
            throw new EntityNotFoundException("Usuário não existente.");
        }
    }
}
