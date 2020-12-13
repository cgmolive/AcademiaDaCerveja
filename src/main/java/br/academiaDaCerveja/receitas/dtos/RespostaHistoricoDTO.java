package br.academiaDaCerveja.receitas.dtos;

import java.util.Date;

public class RespostaHistoricoDTO {
	private Long preparacaoReceitaId;
	private Date dataInicio;
	private Date dataConclusao;
	private String statusPreparacao;
	private String resultadoReceita;
	private String observacao;
	private int etapaAtual;
	private String nomeReceita;
	private Long receitaId;
	private double notaPreparacao;
	
	
	public double getNotaPreparacao() {
		return notaPreparacao;
	}
	public void setNotaPreparacao(double notaReceita) {
		this.notaPreparacao = notaReceita;
	}
	public Long getReceitaId() {
		return receitaId;
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
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	public String getStatusPreparacao() {
		return statusPreparacao;
	}
	public void setStatusPreparacao(String statusPreparacao) {
		this.statusPreparacao = statusPreparacao;
	}
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
	public int getEtapaAtual() {
		return etapaAtual;
	}
	public void setEtapaAtual(int etapaAtual) {
		this.etapaAtual = etapaAtual;
	}
	public String getNomeReceita() {
		return nomeReceita;
	}
	public void setNomeReceita(String nomeReceita) {
		this.nomeReceita = nomeReceita;
	}
	
	
	
}
