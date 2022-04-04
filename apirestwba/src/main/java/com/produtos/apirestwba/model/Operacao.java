package com.produtos.apirestwba.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "TB_OPERACAO")
public class Operacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private BigDecimal valorTotal;
	private BigDecimal listaDeTitulos;
	private BigDecimal valorMulta;
    private LocalDate dataOperacao;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    private Usuario usuario;

	@OneToMany(mappedBy = "operacao", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Titulo> titulos = new ArrayList<Titulo>();

	public List<Titulo> getTitulos() {
		return titulos;
	}

	public void setTitulos(List<Titulo> titulos) {
		this.titulos = titulos;
	}

	public void inserirOperacaoNosTitulos() {
		for (int pos = 0; pos < this.getTitulos().size(); pos++) {
			this.getTitulos().get(pos).setOperacao(this);
		}
	}

	public void calculaValorTotalDaOperacao() {
		for (int pos = 0; pos < this.getTitulos().size(); pos++) {
			this.setValorTotal(this.getTitulos().stream().map(Titulo::getValor).reduce(BigDecimal::add).get());
		}
	}

}
