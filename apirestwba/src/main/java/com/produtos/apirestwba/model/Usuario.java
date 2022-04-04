package com.produtos.apirestwba.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String login;
	private String perfil;

	@OneToOne(cascade = CascadeType.ALL)
	private ConfiguracaoUsuario configuracaoUsuario;//FK chave Estrangeira ConfiguracaoUsuario

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "usuario_perfil", joinColumns = { @JoinColumn(name = "id_usuario") }, inverseJoinColumns = {
			@JoinColumn(name = "id_perfil") })
	private List<Perfil> perfis = new ArrayList<Perfil>();
}
