package com.produtos.apirestwba.mapper;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import com.produtos.apirestwba.dto.OperacaoDTO;
import com.produtos.apirestwba.model.Operacao;
import com.produtos.apirestwba.model.Titulo;

@Mapper(componentModel = "spring")
public abstract class OperacaoTransformMapper {

	
	@Mapping(source = "valorMulta", target = "multa")
	public abstract OperacaoDTO toDto(Operacao operacao);// Converte Entidade para DTO saída

	 //@Mapping(target = "valorMulta", source = "multa")
	@Mapping(source = "multa", target = "valorMulta", qualifiedByName = "formataValor")
	public abstract Operacao toEntity(OperacaoDTO dto);// Converte DTO para Entidade entrada

	 
	@Mapping(target = "id", ignore = true)
	 @Mapping(target = "valorTotal", ignore = true)
	@Mapping(target = "titulos", ignore = true)
	@Mapping(target = "usuario", ignore = true)
	public abstract Operacao merge(@MappingTarget Operacao operacao, OperacaoDTO dto);
	
	
	
	@Named("formataValor")
	public String setFormata(BigDecimal valoresOp) {

		String strFormated = "";

		DecimalFormat formatter = new DecimalFormat("'R$ ' 0.##");

		strFormated = formatter.format(valoresOp);

		return strFormated;

	}

	@AfterMapping
	protected void runAfterMapping(@MappingTarget Operacao operacao) {

		operacao.inserirOperacaoNosTitulos();
		operacao.calculaValorTotalDaOperacao();

	}

}
