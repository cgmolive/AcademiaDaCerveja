package br.academiaDaCerveja.receitas.dtos;

public class RespostaReceitaPreparoDTO {
	
	private Long receitaPreparoId;
	private String descricao;
	private int tempoPreparo;
	private int ordem;
	private String nomePasso;
	private String imagemPasso;
	
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
	public String getNomePasso() {
		return nomePasso;
	}
	public void setNomePasso(String nomePasso) {
		this.nomePasso = nomePasso;
	}
	public String getImagemPasso() {
		return imagemPasso;
	}
	public void setImagemPasso(String imagemPasso) {
		this.imagemPasso = imagemPasso;
	}
	
	
	
}
