package com.daniel.mapeamentomapstruct.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.daniel.mapeamentomapstruct.exception.ResourceNotFoundException;
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
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {

        Usuario usuario = UsuarioMapper.INSTANCE.toEntity(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return UsuarioMapper.INSTANCE.toDTO(usuario);
    }

    // Método buscar todos os usuário
    public List<UsuarioDTO> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioMapper.INSTANCE::toDTO).collect(Collectors.toList());

        // Para didática -> Isso aqui: .map(UsuarioMapper.INSTANCE:: toDTO) equivale a
        // .map(usuario -> UsuarioMapper.INSTANCE.toDTO(usuario)
    }

    // Método para buscar usuário por id
    public UsuarioDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Usuário not found!"));
        return UsuarioMapper.INSTANCE.toDTO(usuario);
    }

    // Método para editar usuário - busca por id
    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO){
        
        if(!usuarioRepository.existsById(id)){
            throw new ResourceNotFoundException("Não existe usuário com esse id!");
        }
        
        Usuario usuario = UsuarioMapper.INSTANCE.toEntity(usuarioDTO);
        usuario.setId(id);

        return UsuarioMapper.INSTANCE.toDTO(usuarioRepository.save(usuario));
    }

}
