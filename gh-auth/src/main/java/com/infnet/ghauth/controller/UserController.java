package com.infnet.ghauth.controller;

import com.infnet.ghauth.dto.UserDTO;
import com.infnet.ghauth.exceptions.ResourceNotFoundException;
import com.infnet.ghauth.service.UsuarioServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UsuarioServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody @Valid UserDTO userDto) {
        UserDTO newUser = userService.saveUser(userDto);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
        UserDTO userDto = userService.getUserById(userId);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @RequestBody UserDTO userDto) {
        UserDTO updatedUser = userService.updateUser(userId, userDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
