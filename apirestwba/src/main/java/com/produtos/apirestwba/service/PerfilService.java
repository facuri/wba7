package com.produtos.apirestwba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtos.apirestwba.dto.PerfilDTO;
import com.produtos.apirestwba.mapper.PerfilTransformMapper;
import com.produtos.apirestwba.model.Perfil;
import com.produtos.apirestwba.repository.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	private PerfilTransformMapper mapper;

	@Autowired
	private PerfilRepository perfilRepository;

	public PerfilDTO getPerfilById(Long id) {
		return mapper.toDto(perfilRepository.findById(id).get());
	}

	public List<PerfilDTO> listarPerfil() {
		return mapper.toListDTO(perfilRepository.findAll());

	}

	public PerfilDTO salvarPerfil(PerfilDTO dto) {

		Perfil perfil = mapper.toEntity(dto);

		return mapper.toDto(perfilRepository.save(perfil));

	}

	public PerfilDTO atualizarPerfil(PerfilDTO dto) {

		Perfil perfil = mapper.toEntity(dto);

		return mapper.toDto(perfilRepository.save(perfil));

	}

	public String deletarPerfil(Long id) {

		perfilRepository.deleteById(id);

		return "Excluido com sucesso!";
	}

}
