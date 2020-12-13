package br.academiaDaCerveja.receitas.utils;

public enum Situacoes {
	INICIADO("Iniciado"),
	PREPARO("Preparo"),
	FINALIZADO("Finalizado");
	public final String situacao;
	
	private Situacoes(String situacao) {
		this.situacao = situacao;
	}
	
	public String getSituacao() {
		return situacao;
	}
	
	
}
