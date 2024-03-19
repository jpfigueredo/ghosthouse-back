package com.infnet.ghauth.service;

import com.infnet.ghauth.dto.LoginDTO;
import com.infnet.ghauth.dto.UserDTO;
import com.infnet.ghauth.exceptions.ResourceNotFoundException;

public interface UsuarioService {
    public UserDTO saveUser(UserDTO userDto);

    public UserDTO getUserById(Long userId);

    public UserDTO updateUser(Long userId, UserDTO userDto);

    public void deleteUser(Long userId);
    public UserDTO autenticar(LoginDTO login);
}
