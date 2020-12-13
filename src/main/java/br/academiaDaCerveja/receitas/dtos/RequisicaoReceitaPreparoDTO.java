package br.academiaDaCerveja.receitas.dtos;

public class RequisicaoReceitaPreparoDTO {

	private Long receitaPreparoId;
	private String descricao;
	private int tempoPreparo;
	private String nomePasso;


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

	public String getNomePasso() {
		return nomePasso;
	}

	public void setNomePasso(String nomePasso) {
		this.nomePasso = nomePasso;
	}

	
}
