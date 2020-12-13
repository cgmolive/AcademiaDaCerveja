package br.academiaDaCerveja.receitas.dtos;

import javax.persistence.Column;

public class IngredientesReceitaDTO {
	private Long receitaIngredientesId;
	private String nomeIngrediente;
	private double quantidade;
	private String unidadeMedida;
	private String imagemIngrediente;
	public Long getReceitaIngredientesId() {
		return receitaIngredientesId;
	}
	public void setReceitaIngredientesId(Long receitaIngredientesId) {
		this.receitaIngredientesId = receitaIngredientesId;
	}
	public String getNomeIngrediente() {
		return nomeIngrediente;
	}
	public void setNomeIngrediente(String nome) {
		this.nomeIngrediente = nome;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	public String getUnidadeMedida() {
		return unidadeMedida;
	}
	public void setUnidadeMedida(String unidadeDeMedida) {
		this.unidadeMedida = unidadeDeMedida;
	}
	public String getImagemIngrediente() {
		return imagemIngrediente;
	}
	public void setImagemIngrediente(String imagemIngrediente) {
		this.imagemIngrediente = imagemIngrediente;
	}
	
}
