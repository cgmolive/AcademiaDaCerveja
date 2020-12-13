package br.academiaDaCerveja.receitas.dtos;

import java.util.List;

import javax.persistence.Column;

public class MateriaisReceitaDTO {

	private Long receitaMateriaisId;
	private String equipamento;
	private String imagemMaterial;
	
	public Long getReceitaMateriaisId() {
		return receitaMateriaisId;
	}
	public void setReceitaMateriaisId(Long receitaMateriaisId) {
		this.receitaMateriaisId = receitaMateriaisId;
	}
	public String getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}
	public String getImagemMaterial() {
		return imagemMaterial;
	}
	public void setImagemMaterial(String imagemMaterial) {
		this.imagemMaterial = imagemMaterial;
	}
	
}
