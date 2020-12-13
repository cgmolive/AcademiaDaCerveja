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
@Entity
@Table
public class MateriaisReceita  {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long receitaMateriaisId;
	
	@ManyToOne
	@JoinColumn(name= "receitaid",referencedColumnName= "receitaid")
	private Receita receita;
	@Column
	private String equipamento;
	@Column
	private String imagemMaterial;
	
	public Receita getReceita() {
		return receita;
	}
	public void setReceita(Receita receita) {
		this.receita = receita;
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
	public Long getMateriaisId() {
		return receitaMateriaisId;
	}
	public void setMateriaisId(Long materiaisId) {
		this.receitaMateriaisId = materiaisId;
	}
}
