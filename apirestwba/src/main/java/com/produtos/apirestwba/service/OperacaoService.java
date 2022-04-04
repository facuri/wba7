package com.produtos.apirestwba.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.produtos.apirestwba.dto.OperacaoDTO;
import com.produtos.apirestwba.dto.TituloDTO;
import com.produtos.apirestwba.dto.UsuarioDTO;
import com.produtos.apirestwba.mapper.OperacaoTransformMapper;
import com.produtos.apirestwba.model.Operacao;
import com.produtos.apirestwba.model.Titulo;
import com.produtos.apirestwba.model.Usuario;
import com.produtos.apirestwba.repository.OperacaoRepository;
import com.produtos.apirestwba.repository.TituloRepository;

@Service
public class OperacaoService {

	@Autowired
	OperacaoRepository operacaoRepository;

	@Autowired
	OperacaoTransformMapper mapper;

	private BigDecimal som;

	public List<Operacao> listtAll() {

		return operacaoRepository.findAll();

	}

	public Operacao getOp(Long id) {

		return operacaoRepository.findById(id).get();
	}

	public OperacaoDTO salvarOperacao2(OperacaoDTO dto) {

		Operacao operacao = mapper.toEntity(dto);// Entrada converte DTO para Entidade
		LocalDate dataOperacao = operacao.getDataOperacao();

		long dias;

		for (int pos = 0; pos < operacao.getTitulos().size(); pos++) {
			operacao.getTitulos().get(pos).setOperacao(operacao);
			LocalDate dataVencimento = operacao.getTitulos().get(pos).getDataVencimento();

			operacao.getTitulos().get(pos).setOperacao(operacao);
			dias = (long) ChronoUnit.DAYS.between(dataOperacao, dataVencimento);
			operacao.getTitulos().get(pos).setPrazo(BigDecimal.valueOf(dias));
		}
		// SUM usando o Lambda do Java 8
		// operacao.setValorTotal(operacao.getTitulos().stream().map(Titulo::getValor).reduce(BigDecimal::add).get());
		return mapper.toDto(operacaoRepository.save(operacao));// Saída converte Entidade para DTO
	}

	   /*
	public OperacaoDTO alteraOperacao(OperacaoDTO dto) {

		 // Converte DTO para Entidade
		 Operacao operacao = mapper.toEntity(dto);
		 LocalDate dataOperacao = operacao.getDataOperacao();

		 long dias;
		 
		  for (int pos = 0; pos < operacao.getTitulos().size(); pos++) {
		   operacao.getTitulos().get(pos).setOperacao(operacao); LocalDate
		  dataVencimento = operacao.getTitulos().get(pos).getDataVencimento();
		  
		   operacao.getTitulos().get(pos).setOperacao(operacao); dias = (long)
		  ChronoUnit.DAYS.between(dataOperacao, dataVencimento);
		   operacao.getTitulos().get(pos).setPrazo(BigDecimal.valueOf(dias)); }
		 
		// SUM usando o Lambda do Java 8
		  operacao.setValorTotal(operacao.getTitulos().stream().map(Titulo::getValor).reduce(BigDecimal::add).get());
		  Operacao operacaoAlterada = mapper.merge(operacao, dto);
		 return mapper.toDto(operacaoRepository.save(operacaoAlterada));
	 }
	 
 */
	
	 
	public OperacaoDTO alteraOperacao(OperacaoDTO dto) {
		  Operacao operacao = operacaoRepository.findById(dto.getId()).get();
		  Operacao operacaoAlterada = mapper.merge(operacao, dto);
		  return mapper.toDto(operacaoRepository.save(operacaoAlterada));
	  }
	
	 
	
	public String deleteOp(Long id) {

		operacaoRepository.deleteById(id);

		return "Deletou com Sucesso";
	}

}
