package com.infnet.ghauth.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.infnet.ghauth.builder.UsuarioBuilder;
import com.infnet.ghauth.domain.Usuario;
import com.infnet.ghauth.dto.LoginDTO;
import com.infnet.ghauth.dto.UserDTO;
import com.infnet.ghauth.repository.UsuarioRepository;
import com.infnet.ghauth.service.UsuarioServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioServiceImpl usuarioService;

    private UsuarioBuilder usuarioBuilder;

    @Before
    public void setUp() {
        usuarioBuilder = new UsuarioBuilder();
    }

    @Test
    public void testLogin() throws Exception {
        UserDTO userDTO = usuarioBuilder.createUserDTOProprietario();
        String jsonBody = "{\"email\": \"teste@teste.test\", \"senha\": \"etset\"}";

        when(usuarioService.autenticar(any(LoginDTO.class))).thenReturn(userDTO);

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(userDTO.getId()));
    }

    @Test
    public void testLoginError() throws Exception {
        String jsonBody = "{\"email\": \"teste@teste.test\", \"senha\": \"wrong\"}";

        when(usuarioService.autenticar(any(LoginDTO.class))).thenThrow(EntityNotFoundException.class);

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isNotFound());
    }

}
