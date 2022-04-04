package com.produtos.apirestwba.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.produtos.apirestwba.model.Usuario;

import lombok.Data;

@Data
public class OperacaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private BigDecimal valorTotal;
	private LocalDate dataOperacao;
	private BigDecimal multa;
	private List<TituloDTO> titulos = new ArrayList<TituloDTO>();
	private UsuarioDTO usuario;

}
