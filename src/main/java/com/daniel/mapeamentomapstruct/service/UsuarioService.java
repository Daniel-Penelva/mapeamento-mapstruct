package com.daniel.mapeamentomapstruct.service;

import org.springframework.stereotype.Service;

import com.daniel.mapeamentomapstruct.mapper.UsuarioMapper;
import com.daniel.mapeamentomapstruct.model.Usuario;
import com.daniel.mapeamentomapstruct.repository.UsuarioRepository;
import com.daniel.mapeamentomapstruct.requests.UsuarioDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // Método salvar usuário
    public UsuarioDTO save(UsuarioDTO usuarioDTO){
        
        Usuario usuario = UsuarioMapper.INSTANCE.toEntity(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return UsuarioMapper.INSTANCE.toDTO(usuario);
    }
    
}
