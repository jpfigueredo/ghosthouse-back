package com.infnet.ghauth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infnet.ghauth.builder.UsuarioBuilder;
import com.infnet.ghauth.dto.UserDTO;
import com.infnet.ghauth.service.UsuarioServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTest {
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
    public void testRegisterUser() throws Exception {
        UserDTO userDTO = usuarioBuilder.createUserDTOProprietario();
        String jsonBody = new ObjectMapper().writeValueAsString(userDTO);

        when(usuarioService.saveUser(any(UserDTO.class))).thenReturn(userDTO);

        MvcResult mvcResult = mockMvc.perform(post("/api/users/register")
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isCreated()).andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        UserDTO userResponseDTO = new ObjectMapper().readValue(contentAsString, UserDTO.class);

        assertEquals(userResponseDTO, userDTO);
    }

    @Test
    public void testGetUserById() throws Exception {
        UserDTO userDTO = usuarioBuilder.createUserDTOProprietario();
        Long userId = userDTO.getId();

        when(usuarioService.getUserById(userId)).thenReturn(userDTO);

        MvcResult mvcResult = mockMvc.perform(get("/api/users/{userId}", userId))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        UserDTO userResponseDTO = new ObjectMapper().readValue(contentAsString, UserDTO.class);

        assertEquals(userResponseDTO, userDTO);
    }

    @Test
    public void testUpdateUser() throws Exception {
        UserDTO userDTO = usuarioBuilder.createUserDTOProprietario();
        Long userId = userDTO.getId();
        String jsonBody = new ObjectMapper().writeValueAsString(userDTO);

        when(usuarioService.updateUser(eq(userId), any(UserDTO.class))).thenReturn(userDTO);

        MvcResult mvcResult = mockMvc.perform(put("/api/users/{userId}", userId)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        UserDTO userResponseDTO = new ObjectMapper().readValue(contentAsString, UserDTO.class);

        assertEquals(userResponseDTO, userDTO);
    }

    @Test
    public void testDeleteUser() throws Exception {
        Long userId = 1L;

        mockMvc.perform(delete("/api/users/{userId}", userId))
                .andExpect(status().isNoContent());

        verify(usuarioService, times(1)).deleteUser(userId);
    }
}
