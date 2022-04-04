package com.produtos.apirestwba.controller;

//import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirestwba.dto.OperacaoDTO;
import com.produtos.apirestwba.model.Operacao;
import com.produtos.apirestwba.model.Titulo;
import com.produtos.apirestwba.repository.OperacaoRepository;
import com.produtos.apirestwba.service.OperacaoService;

@RestController
@RequestMapping(value = "/operacao")
public class OperacaoController {

	@Autowired
	private OperacaoService operacaoService;

	@GetMapping("/listaOp")
	public List<Operacao> list() {

		return operacaoService.listtAll();
	}

	@GetMapping("/listaOperId/{id}")
	public Operacao get(@PathVariable Long id) {

		return operacaoService.getOp(id);

	}

	@PostMapping("/salvarOpr2")
	public OperacaoDTO salvarOperacao(@RequestBody OperacaoDTO dto) {
		return operacaoService.salvarOperacao2(dto);
	}

	/*
	 * @PutMapping("/atualizarOpr2") public OperacaoDTO
	 * atualizarOperacao2(@RequestBody OperacaoDTO dto) {
	 * 
	 * return operacaoService.updateOp2(dto);
	 * 
	 * }
	 */

	@PatchMapping(value = "/alterar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> alterarOperacao(@RequestBody OperacaoDTO dto) {

		return new ResponseEntity<>(operacaoService.alteraOperacao(dto), HttpStatus.CREATED);

	}

	@DeleteMapping("/deletarOpr/{id}")
	public void deletar(@PathVariable Long id) {

		operacaoService.deleteOp(id);
	}

}
