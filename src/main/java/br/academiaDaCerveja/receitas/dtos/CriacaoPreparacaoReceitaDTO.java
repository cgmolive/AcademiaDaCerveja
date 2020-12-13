package br.academiaDaCerveja.receitas.dtos;

import javax.validation.constraints.NotNull;

public class CriacaoPreparacaoReceitaDTO {
	private Long usuarioId;
	
	@NotNull(message= "usuario é um campo obrigatório!")
	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	
}
