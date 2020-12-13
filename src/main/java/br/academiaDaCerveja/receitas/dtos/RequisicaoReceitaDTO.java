package br.academiaDaCerveja.receitas.dtos;

import java.util.Date;

import javax.persistence.Column;

public class RequisicaoReceitaDTO {
	private Long receitaId;
	private String nomeReceita;
	private Date dataCriacao;
	private double rendimentoEmLitros;
	private String descricao;
	private String categoria;
	private boolean publico;
	private int usuarioId;
//	private Usuario usuario;

	public boolean isPublico() {
		return publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
	}
	
	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
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
	
//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}


}
