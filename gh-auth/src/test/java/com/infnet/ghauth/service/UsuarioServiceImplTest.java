package com.infnet.ghauth.service;

import com.infnet.ghauth.builder.UsuarioBuilder;
import com.infnet.ghauth.domain.Locatario;
import com.infnet.ghauth.domain.Proprietario;
import com.infnet.ghauth.domain.Usuario;
import com.infnet.ghauth.dto.LoginDTO;
import com.infnet.ghauth.dto.UserDTO;
import com.infnet.ghauth.repository.LocatarioRepository;
import com.infnet.ghauth.repository.ProprietarioRepository;
import com.infnet.ghauth.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class UsuarioServiceImplTest {
    @Mock
    private UsuarioRepository userRepository;
    @Mock
    private LocatarioRepository locatarioRepository;
    @Mock
    private ProprietarioRepository proprietarioRepository;
    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private UsuarioServiceImpl usuarioService;
    private UsuarioBuilder usuarioBuilder;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        usuarioBuilder = new UsuarioBuilder();
    }

    @Test
    public void testSaveUserProprietario() {
        UserDTO userDto = usuarioBuilder.createUserDTOProprietario();
        Proprietario usuario = usuarioBuilder.createProprietario();

        when(modelMapper.map(userDto, Usuario.class)).thenReturn(usuario);
        when(proprietarioRepository.save(any(Proprietario.class))).thenReturn(usuario);
        when(modelMapper.map(usuario, UserDTO.class)).thenReturn(userDto);

        UserDTO savedUserDto = usuarioService.saveUser(userDto);

        assertEquals(userDto, savedUserDto);
        verify(proprietarioRepository, times(1)).save(any(Proprietario.class));
    }

    @Test
    public void testSaveUserLocatario() {
        UserDTO userDto = usuarioBuilder.createUserDTOLocatario();
        Locatario usuario = usuarioBuilder.createLocatario();

        when(modelMapper.map(userDto, Usuario.class)).thenReturn(usuario);
        when(locatarioRepository.save(any(Locatario.class))).thenReturn(usuario);
        when(modelMapper.map(usuario, UserDTO.class)).thenReturn(userDto);

        UserDTO savedUserDto = usuarioService.saveUser(userDto);

        assertEquals(userDto, savedUserDto);
        verify(locatarioRepository, times(1)).save(any(Locatario.class));
    }

    @Test
    public void testGetUserById() {
        Long userId = 1L;
        UserDTO userDTO = usuarioBuilder.createUserDTOProprietario();
        Usuario usuario = usuarioBuilder.createProprietario();

        when(userRepository.findById(userId)).thenReturn(Optional.of(usuario));
        when(modelMapper.map(usuario, UserDTO.class)).thenReturn(userDTO);

        UserDTO foundUserDTO = usuarioService.getUserById(userId);

        assertEquals(userDTO, foundUserDTO);
    }

    @Test
    public void testGetUserByIdThrowsException() {
        Long userId = 1L;

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> usuarioService.getUserById(userId));
    }

    @Test
    public void testUpdateUser() {
        Long userId = 1L;
        UserDTO userDTO = usuarioBuilder.createUserDTOProprietario();
        Proprietario usuario = usuarioBuilder.createProprietario();

        when(userRepository.existsById(userId)).thenReturn(true);
        when(proprietarioRepository.save(any(Proprietario.class))).thenReturn(usuario);
        when(modelMapper.map(userDTO, Usuario.class)).thenReturn(usuario);
        when(modelMapper.map(usuario, UserDTO.class)).thenReturn(userDTO);

        UserDTO updatedUserDTO = usuarioService.updateUser(userId, userDTO);

        assertEquals(userDTO, updatedUserDTO);
    }

    @Test
    public void testUpdateUserThrowsException() {
        Long userId = 1L;
        UserDTO userDTO = usuarioBuilder.createUserDTOProprietario();

        when(userRepository.existsById(userId)).thenReturn(false);

        assertThrows(EntityNotFoundException.class, () -> usuarioService.updateUser(userId, userDTO));
    }

    @Test
    public void testDeleteUser() {
        Long userId = 1L;
        when(userRepository.existsById(userId)).thenReturn(true);
        usuarioService.deleteUser(userId);
        verify(userRepository, times(1)).deleteById(userId);
    }

    @Test
    public void testDeleteUserThrowsException() {
        Long userId = 1L;
        when(userRepository.existsById(userId)).thenReturn(false);
        assertThrows(EntityNotFoundException.class, () -> usuarioService.deleteUser(userId));
    }

    @Test
    public void testAutenticar() {
        LoginDTO loginDTO = usuarioBuilder.createLoginDTO();
        UserDTO userDTO = usuarioBuilder.createUserDTOProprietario();
        Usuario usuario = usuarioBuilder.createProprietario();

        when(userRepository.findByEmail(usuario.getEmail())).thenReturn(Optional.of(usuario));

        UserDTO result = usuarioService.autenticar(loginDTO);

        assertEquals(userDTO, result);
    }

    @Test
    public void testAutenticarUserNotFound() {
        LoginDTO loginDTO = usuarioBuilder.createLoginDTO();
        String email = "test@test.com";
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> usuarioService.autenticar(loginDTO));
    }

    @Test
    public void testAutenticarIncorrectPassword() {
        LoginDTO loginDTO = usuarioBuilder.createLoginDTOWithWrongPassword();
        Usuario usuario = usuarioBuilder.createProprietario();
        when(userRepository.findByEmail(usuario.getEmail())).thenReturn(Optional.of(usuario));
        assertThrows(EntityNotFoundException.class, () -> usuarioService.autenticar(loginDTO));
    }
}
