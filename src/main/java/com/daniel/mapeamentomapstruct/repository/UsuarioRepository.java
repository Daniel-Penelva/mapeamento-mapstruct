package com.daniel.mapeamentomapstruct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.mapeamentomapstruct.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
