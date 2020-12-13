package br.academiaDaCerveja.receitas.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Table
@Entity
public class PreparacaoReceita{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long preparacaoReceitaId;
	@Column
	private Date dataInicio;
	@Column
	private Date dataConclusao;
	@Column
	private String statusPreparacao;
	@Column
	private String resultadoReceita;
	@Column
	private String observacao;
	@ManyToOne
	@JoinColumn(name= "usuarioid", referencedColumnName= "usuarioid")
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name= "receitaid", referencedColumnName= "receitaid")
	private Receita receita;
	@Column
	private int etapaAtual;
	@Column
	private double notaPreparacao;
	@Transient
	private int tamanhoPassos;
	
	public double getNotaPreparacao() {
		return notaPreparacao;
	}
	public void setNotaPreparacao(double notaPreparacao) {
		this.notaPreparacao = notaPreparacao;
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Receita getReceita() {
		return receita;
	}
	public void setReceita(Receita receita) {
		this.receita = receita;
	}
	public int getEtapaAtual() {
		return etapaAtual;
	}
	public void setEtapaAtual(int etapaAtual) {
		this.etapaAtual = etapaAtual;
	}
	public void setTamanhoPassos(int ultimaOrdem) {
		this.tamanhoPassos = ultimaOrdem;
	}
	public int getTamanhoPassos() {
		return tamanhoPassos;
	}
	
	
}
