package com.produtos.apirestwba.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PerfilDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String descritivo;

}
