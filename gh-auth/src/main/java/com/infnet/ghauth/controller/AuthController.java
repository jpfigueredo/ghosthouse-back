package com.infnet.ghauth.controller;

import com.infnet.ghauth.domain.Locatario;
import com.infnet.ghauth.domain.Proprietario;
import com.infnet.ghauth.dto.LoginDTO;
import com.infnet.ghauth.dto.UsuarioRecordDTO;
import com.infnet.ghauth.service.LocatarioService;
import com.infnet.ghauth.service.ProprietarioService;
import com.infnet.ghauth.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final ProprietarioService proprietarioService;
    private final LocatarioService locatarioService;
    private final UsuarioService usuarioService;

    public AuthController(ProprietarioService proprietarioService, LocatarioService locatarioService, UsuarioService usuarioService) {
        this.proprietarioService = proprietarioService;
        this.locatarioService = locatarioService;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginDTO> login(@RequestBody @Valid LoginDTO loginDto) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.autenticar(loginDto));
    }

    @PostMapping("/proprietario")
    public ResponseEntity<Proprietario> createProprietario(@RequestBody @Valid UsuarioRecordDTO usuarioRecordDto) {
        Proprietario proprietario = new Proprietario();
        BeanUtils.copyProperties(usuarioRecordDto, proprietario);

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(proprietarioService.save(proprietario));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @PostMapping("/locatario")
    public ResponseEntity<Locatario> createLocatario(@RequestBody @Valid UsuarioRecordDTO usuarioRecordDto) {
        Locatario locatario = new Locatario();
        BeanUtils.copyProperties(usuarioRecordDto, locatario);

        return ResponseEntity.status(HttpStatus.CREATED).body(locatarioService.save(locatario));


    }
}
