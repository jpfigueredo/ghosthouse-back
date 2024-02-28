package com.infnet.ghcommunication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/communication")
public class CommunicationController {

//    private final ProprietarioService proprietarioService;
//    private final LocatarioService locatarioService;
//    private final UsuarioService usuarioService;

//    public CommunicationController(ProprietarioService proprietarioService, LocatarioService locatarioService, UsuarioService usuarioService) {
//        this.proprietarioService = proprietarioService;
//        this.locatarioService = locatarioService;
//        this.usuarioService = usuarioService;
//    }

//    @PostMapping("/login")
//    public ResponseEntity<LoginDto> login(@RequestBody @Valid LoginDto loginDto) {
//        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.autenticar(loginDto));
//    }

//    @PostMapping("/proprietario")
//    public ResponseEntity<Proprietario> createProprietario(@RequestBody @Valid UsuarioRecordDto usuarioRecordDto) {
//        Proprietario proprietario = new Proprietario();
//        BeanUtils.copyProperties(usuarioRecordDto, proprietario);
//
//        try {
//            return ResponseEntity.status(HttpStatus.CREATED).body(proprietarioService.save(proprietario));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @PostMapping("/locatario")
//    public ResponseEntity<Locatario> createLocatario(@RequestBody @Valid UsuarioRecordDto usuarioRecordDto) {
//        Locatario locatario = new Locatario();
//        BeanUtils.copyProperties(usuarioRecordDto, locatario);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(locatarioService.save(locatario));
//    }
}
