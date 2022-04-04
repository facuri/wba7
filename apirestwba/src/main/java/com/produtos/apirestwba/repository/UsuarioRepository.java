package com.produtos.apirestwba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirestwba.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
