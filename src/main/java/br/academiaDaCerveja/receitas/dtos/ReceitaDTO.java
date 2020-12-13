package br.academiaDaCerveja.receitas.dtos;

import java.util.Date;

import br.academiaDaCerveja.receitas.entities.Usuario;

public class ReceitaDTO {

		private Long receitaId;
		private String nomeReceita;
		private Date dataCriacao;
		private double rendimentoEmLitros;
		private String descricao;
		private String categoria;
		private boolean publico;
		private Long usuarioId;
		private int tempoPreparo;
		private double notaReceita;
		
		public double getNotaReceita() {
			return notaReceita;
		}

		public void setNotaReceita(double notaReceita) {
			this.notaReceita = notaReceita;
		}

		public Long getUsuarioId() {
			return usuarioId;
		}

		public void setUsuarioId(Long usuarioId) {
			this.usuarioId = usuarioId;
		}




		public boolean isPublico() {
			return publico;
		}

		public void setPublico(boolean publico) {
			this.publico = publico;
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

		public int getTempoPreparo() {
			return tempoPreparo;
		}

		public void setTempoPreparo(int tempoPreparo) {
			this.tempoPreparo = tempoPreparo;
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
		


}


