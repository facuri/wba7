package com.produtos.apirestwba.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.produtos.apirestwba.model.Operacao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class TituloDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private BigDecimal valor;
	private LocalDate dataVencimento;
	private BigDecimal prazo;

}
