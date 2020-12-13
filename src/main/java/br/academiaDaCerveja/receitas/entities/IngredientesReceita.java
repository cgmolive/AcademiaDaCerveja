package br.academiaDaCerveja.receitas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Table
@Entity
public class IngredientesReceita{

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long receitaIngredientesId;
	@Column
	private String nomeIngrediente;
	@Column
	private double quantidade;
	@Column
	private String unidadeMedida;
	@Column
	private String imagemIngrediente;
	@JoinColumn(name= "receitaid", referencedColumnName= "receitaid")
	@ManyToOne
	private Receita receita;
	public Long getReceitaIngredientesId() {
		return receitaIngredientesId;
	}
	public void setReceitaIngredientesId(Long receitaIngredientesId) {
		this.receitaIngredientesId = receitaIngredientesId;
	}

	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	public Receita getReceita() {
		return receita;
	}
	public void setReceita(Receita receita) {
		this.receita = receita;
	}
	public String getNomeIngrediente() {
		return nomeIngrediente;
	}
	public void setNomeIngrediente(String nomeIngrediente) {
		this.nomeIngrediente = nomeIngrediente;
	}
	public String getUnidadeMedida() {
		return unidadeMedida;
	}
	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	public String getImagemIngrediente() {
		return imagemIngrediente;
	}
	public void setImagemIngrediente(String imagemIngrediente) {
		this.imagemIngrediente = imagemIngrediente;
	}
	
	
}
