package br.academiaDaCerveja.receitas.entities;

import java.util.Date;

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
public class Receita{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long receitaId;
	@Column(name= "nomeReceita")
	private String nomeReceita;
	@Column(name= "datacriacao")
	private Date dataCriacao;
	@Column(name= "rendimentoemlitros")
	private double rendimentoEmLitros;
	@Column(name= "descricao")
	private String descricao;
	@Column(name= "categoria")
	private String categoria;
	@Column(name= "publico")
	private boolean publico;
	@ManyToOne
	@JoinColumn(name= "usuarioid", referencedColumnName= "usuarioid")
	private Usuario usuario;
	@Column(name="tempoPreparo")
	private int tempoPreparo;
	@Column
	private double notaReceita;


	public double getNotaReceita() {
		return notaReceita;
	}

	public void setNotaReceita(double notaReceita) {
		this.notaReceita = notaReceita;
	}

	public boolean isPublico() {
		return publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
	}



	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public int getTempoPreparo() {
		return tempoPreparo;
	}

	public void setTempoPreparo(int tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}


	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public double getRendimentoEmLitros() {
		return rendimentoEmLitros;
	}

	public void setRendimentoEmLitros(double rendimentoEmLitros) {
		this.rendimentoEmLitros = rendimentoEmLitros;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getReceitaId() {
		return receitaId;
	}

	public void setReceitaId(Long receitaId) {
		this.receitaId = receitaId;
	}
	
	public String getNomeReceita() {
		return nomeReceita;
	}

	public void setNomeReceita(String nomeReceita) {
		this.nomeReceita = nomeReceita;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	


	public Receita() {
		
	}
}
