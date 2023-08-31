package com.daniel.mapeamentomapstruct.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.mapeamentomapstruct.requests.UsuarioDTO;
import com.daniel.mapeamentomapstruct.service.UsuarioService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {
    
    private UsuarioService usuarioService;

    // (Endpoint get) método http criar usuário
    @PostMapping
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO createdUser = usuarioService.save(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
}
