package com.produtos.apirestwba.mapper;

import org.mapstruct.Mapper;

import com.produtos.apirestwba.dto.OperacaoDTO;
import com.produtos.apirestwba.dto.UsuarioDTO;
import com.produtos.apirestwba.model.Operacao;
import com.produtos.apirestwba.model.Usuario;

@Mapper(componentModel = "spring")
public abstract class UsuarioTransformMapper {

	public abstract UsuarioDTO toDto(Usuario usuario);

	public abstract Usuario toEntity(UsuarioDTO dto);

}
