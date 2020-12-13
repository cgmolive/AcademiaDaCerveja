package br.academiaDaCerveja.receitas.dtos;

import java.util.Date;

public class RespostaPreparacaoReceitaDTO {
	private Long preparacaoReceitaId;
	private String statusPreparacao;
	private int etapaAtual;
	private Date dataInicio;
	private Date dataConclusao;
	private String observacao;
	private String resultadoReceita;
	private Long receitaId;
	private double notaPreparacao;
	private int tamanhoPassos;
	
	
	public Long getReceitaId() {
		return receitaId;
	}
	
	
	public double getNotaPreparacao() {
		return notaPreparacao;
	}


	public void setNotaPreparacao(double notaReceita) {
		this.notaPreparacao = notaReceita;
	}


	public void setReceitaId(Long receitaId) {
		this.receitaId = receitaId;
	}
	public Long getPreparacaoReceitaId() {
		return preparacaoReceitaId;
	}
	public void setPreparacaoReceitaId(Long preparacaoReceitaId) {
		this.preparacaoReceitaId = preparacaoReceitaId;
	}

	public int getEtapaAtual() {
		return etapaAtual;
	}
	public void setEtapaAtual(int etapaAtual) {
		this.etapaAtual = etapaAtual;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getStatusPreparacao() {
		return statusPreparacao;
	}
	public void setStatusPreparacao(String statusPreparacao) {
		this.statusPreparacao = statusPreparacao;
	}
	public Date getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getResultadoReceita() {
		return resultadoReceita;
	}
	public void setResultadoReceita(String resultadoReceita) {
		this.resultadoReceita = resultadoReceita;
	}
	public int getTamanhoPassos() {
		return tamanhoPassos;
	}
	public void setTamanhoPassos(int ultimaOrdem) {
		tamanhoPassos = ultimaOrdem;
	}
	
	
}
