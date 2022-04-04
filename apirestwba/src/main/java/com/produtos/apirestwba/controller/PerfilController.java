package com.produtos.apirestwba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirestwba.dto.PerfilDTO;
import com.produtos.apirestwba.service.PerfilService;

@RestController
@RequestMapping(value = "/perfil")
public class PerfilController {

	@Autowired
	private PerfilService perfilService;

	@GetMapping("/listarPerfilId/{id}")
	public PerfilDTO listarPer(@PathVariable Long id) {

		return perfilService.getPerfilById(id);

	}

	@GetMapping("/listarPerfil")
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<>(perfilService.listarPerfil(), HttpStatus.OK);
	}

	@PostMapping("/salvarPerfil")
	public PerfilDTO salvarPer(@RequestBody PerfilDTO dto) {

		return perfilService.salvarPerfil(dto);

	}

	@PutMapping("/atualizarPerfil")
	public PerfilDTO atualizarPer(@RequestBody PerfilDTO dto) {

		return perfilService.atualizarPerfil(dto);

	}

	@DeleteMapping("/deletarPerfil/{id}")
	public String deletar(@PathVariable Long id) {
		return perfilService.deletarPerfil(id);
	}

}
