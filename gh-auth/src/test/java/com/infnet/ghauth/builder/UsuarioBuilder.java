package com.infnet.ghauth.builder;

import com.infnet.ghauth.domain.Locatario;
import com.infnet.ghauth.domain.Proprietario;
import com.infnet.ghauth.domain.Usuario;
import com.infnet.ghauth.dto.LoginDTO;
import com.infnet.ghauth.dto.UserDTO;
import com.infnet.ghauth.enums.UserType;

public class UsuarioBuilder {
    public UserDTO createUserDTOProprietario(){
        UserDTO userDto = new UserDTO();
        userDto.setId(1L);
        userDto.setNome("teste");
        userDto.setEmail("teste@teste.test");
        userDto.setSenha("etset");
        userDto.setTelefone("+55 12345-6789");
        userDto.setUserType(UserType.PROPRIETARIO);
        return userDto;
    }
    public UserDTO createUserDTOLocatario(){
        UserDTO userDto = new UserDTO();
        userDto.setId(1L);
        userDto.setNome("teste");
        userDto.setEmail("teste@teste.test");
        userDto.setSenha("etset");
        userDto.setTelefone("+55 12345-6789");
        userDto.setUserType(UserType.LOCATARIO);
        return userDto;
    }


    public Proprietario createProprietario(){
        Proprietario proprietario = new Proprietario();
        proprietario.setId(1L);
        proprietario.setNome("teste");
        proprietario.setEmail("teste@teste.test");
        proprietario.setSenha("etset");
        proprietario.setTelefone("+55 12345-6789");
        proprietario.setUserType(UserType.PROPRIETARIO);
        return proprietario;
    }

    public Locatario createLocatario(){
        Locatario locatario = new Locatario();
        locatario.setId(1L);
        locatario.setNome("teste");
        locatario.setEmail("teste@teste.test");
        locatario.setSenha("etset");
        locatario.setTelefone("+55 12345-6789");
        locatario.setUserType(UserType.LOCATARIO);
        return locatario;
    }

    public LoginDTO createLoginDTO() {
        return new LoginDTO("teste@teste.test", "etset");
    }

    public LoginDTO createLoginDTOWithWrongPassword() {
        return new LoginDTO("teste@teste.test", "wrong");
    }
}
