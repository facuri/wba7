package com.produtos.apirestwba.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.produtos.apirestwba.dto.PerfilDTO;
import com.produtos.apirestwba.model.Perfil;

 

@Mapper(componentModel = "spring")
public abstract class PerfilTransformMapper {
	
	public abstract PerfilDTO toDto(Perfil perfil);

	public abstract List<PerfilDTO> toListDTO(List<Perfil> all);

	public abstract Perfil toEntity(PerfilDTO dto);

}
