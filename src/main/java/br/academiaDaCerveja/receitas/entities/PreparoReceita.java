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
public class PreparoReceita {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long receitaPreparoId;
	@Column(name= "nomepasso")
	private String nomePasso;
	@Column
	private String descricao;
	@Column
	private int tempoPreparo;
	@Column
	private int ordem;
	@ManyToOne
	@JoinColumn(name= "receitaid",referencedColumnName= "receitaid")
	private Receita receita;
	@Column
	private String imagemPasso;
	
	
	
	public String getNomePasso() {
		return nomePasso;
	}
	public void setNomePasso(String nomePasso) {
		this.nomePasso = nomePasso;
	}
	public String getImagemPasso() {
		return imagemPasso;
	}
	public void setImagem(String imagemPasso) {
		this.imagemPasso = imagemPasso;
	}
	public Long getReceitaPreparoId() {
		return receitaPreparoId;
	}
	public void setReceitaPreparoId(Long receitaPreparoId) {
		this.receitaPreparoId = receitaPreparoId;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getTempoPreparo() {
		return tempoPreparo;
	}
	public void setTempoPreparo(int tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}
	public int getOrdem() {
		return ordem;
	}
	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	public Receita getReceita() {
		return receita;
	}
	public void setReceita(Receita receita) {
		this.receita = receita;
	}
	
	
}
