package br.academiaDaCerveja.receitas.dtos;

public class AtualizacaoPreparacaoReceitaDTO {
	private String resultadoReceita;
	private String observacao;
	private Long usuarioId;
	private double notaPreparacao;
	
	
	public String getResultadoReceita() {
		return resultadoReceita;
	}
	public void setResultadoReceita(String resultadoReceita) {
		this.resultadoReceita = resultadoReceita;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	public double getNotaPreparacao() {
		return notaPreparacao;
	}
	public void setNotaPreparacao(Long notaPreparacao) {
		this.notaPreparacao = notaPreparacao;
	}
	
	
}
