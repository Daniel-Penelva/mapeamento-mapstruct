package com.daniel.mapeamentomapstruct.service;

import java.util.List;
import java.util.stream.Collectors;

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

    // Método buscar todos os usuário
    public List<UsuarioDTO> getAllUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioMapper.INSTANCE:: toDTO).collect(Collectors.toList());

        // Para didática -> Isso aqui: .map(UsuarioMapper.INSTANCE:: toDTO) equivale a .map(usuario -> UsuarioMapper.INSTANCE.toDTO(usuario)
    }

    
    
}