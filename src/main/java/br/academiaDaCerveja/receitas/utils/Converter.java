package br.academiaDaCerveja.receitas.utils;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import br.academiaDaCerveja.receitas.dtos.IngredientesReceitaDTO;
import br.academiaDaCerveja.receitas.dtos.MateriaisReceitaDTO;
import br.academiaDaCerveja.receitas.dtos.RespostaHistoricoDTO;
import br.academiaDaCerveja.receitas.dtos.RespostaReceitaPreparoDTO;
import br.academiaDaCerveja.receitas.dtos.RespostaPreparacaoReceitaDTO;
import br.academiaDaCerveja.receitas.dtos.ReceitaDTO;
import br.academiaDaCerveja.receitas.entities.MateriaisReceita;
import br.academiaDaCerveja.receitas.entities.PreparacaoReceita;
import br.academiaDaCerveja.receitas.entities.PreparoReceita;
import br.academiaDaCerveja.receitas.entities.Receita;
import br.academiaDaCerveja.receitas.entities.Usuario;
import br.academiaDaCerveja.receitas.repositories.UsuarioRepository;
import br.academiaDaCerveja.receitas.entities.IngredientesReceita;

public class Converter {
	
	public List<MateriaisReceitaDTO> converteMaterialReceita(List<MateriaisReceita> materiais) {
		List<MateriaisReceitaDTO> listaDto = new ArrayList<MateriaisReceitaDTO>();
		for(MateriaisReceita material : materiais){
			MateriaisReceitaDTO dto = new MateriaisReceitaDTO();
			dto.setEquipamento(material.getEquipamento());
			dto.setReceitaMateriaisId(material.getMateriaisId());
			dto.setImagemMaterial(material.getImagemMaterial());
			listaDto.add(dto);
		}

		return listaDto;
	}
	
	public List<IngredientesReceitaDTO> converteReceitaIngredientes(List<IngredientesReceita> ingredientes) {
		List<IngredientesReceitaDTO> listaDto = new ArrayList<IngredientesReceitaDTO>();
		for(IngredientesReceita ingrediente : ingredientes){
			IngredientesReceitaDTO dto = new IngredientesReceitaDTO();

			dto.setNomeIngrediente(ingrediente.getNomeIngrediente());
			dto.setQuantidade(ingrediente.getQuantidade());
			dto.setReceitaIngredientesId(ingrediente.getReceitaIngredientesId());
			dto.setUnidadeMedida(ingrediente.getUnidadeMedida());
			dto.setImagemIngrediente(ingrediente.getImagemIngrediente());
			listaDto.add(dto);
		}

		return listaDto;
	}
	
	public List<RespostaReceitaPreparoDTO> converteReceitaPreparo(List<PreparoReceita> preparos){
		List<RespostaReceitaPreparoDTO> listaDto = new ArrayList<RespostaReceitaPreparoDTO>();
		for(PreparoReceita preparo : preparos){
			RespostaReceitaPreparoDTO dto = new RespostaReceitaPreparoDTO();

			dto.setDescricao(preparo.getDescricao());
			dto.setOrdem(preparo.getOrdem());
			dto.setReceitaPreparoId(preparo.getReceitaPreparoId());
			dto.setTempoPreparo(preparo.getTempoPreparo());
			dto.setImagemPasso(preparo.getImagemPasso());
			dto.setNomePasso(preparo.getNomePasso());
			listaDto.add(dto);
		}
		return listaDto;
	}
	
	public RespostaPreparacaoReceitaDTO converteRespostaPreparacaoReceita(PreparacaoReceita preparacao) {
		RespostaPreparacaoReceitaDTO dto = new RespostaPreparacaoReceitaDTO();
		dto.setDataInicio(preparacao.getDataInicio());
		dto.setEtapaAtual(preparacao.getEtapaAtual());
		dto.setPreparacaoReceitaId(preparacao.getPreparacaoReceitaId());
		dto.setStatusPreparacao(preparacao.getStatusPreparacao());
		dto.setObservacao(preparacao.getObservacao());
		dto.setResultadoReceita(preparacao.getResultadoReceita());
		dto.setDataConclusao(preparacao.getDataConclusao());
		dto.setReceitaId(preparacao.getReceita().getReceitaId());
		dto.setNotaPreparacao(preparacao.getNotaPreparacao());
		dto.setTamanhoPassos(preparacao.getTamanhoPassos());
		
		return dto;
	}
	
	public ReceitaDTO converteRespostaReceita(Receita receita) {
		ReceitaDTO dto = new ReceitaDTO();
		dto.setCategoria(receita.getCategoria());
		dto.setDataCriacao(receita.getDataCriacao());
		dto.setDescricao(receita.getDescricao());
		dto.setNomeReceita(receita.getNomeReceita());
		dto.setPublico(receita.isPublico());
		dto.setReceitaId(receita.getReceitaId());
		dto.setRendimentoEmLitros(receita.getRendimentoEmLitros());
		dto.setTempoPreparo(receita.getTempoPreparo());
		dto.setUsuarioId(receita.getUsuario().getUsuarioId());
		dto.setNotaReceita(receita.getNotaReceita());
		
		return dto;
	}

	public Receita converteRequisicaoReceita(ReceitaDTO receitaDTO, Long id, Usuario usuario) {
		Receita receita = new Receita();
		receita.setCategoria(receitaDTO.getCategoria());
		receita.setDataCriacao(receitaDTO.getDataCriacao());
		receita.setDescricao(receitaDTO.getDescricao());
		receita.setNomeReceita(receitaDTO.getNomeReceita());
		receita.setPublico(receitaDTO.isPublico());
		receita.setReceitaId(id);
		receita.setRendimentoEmLitros(receitaDTO.getRendimentoEmLitros());
		receita.setTempoPreparo(receitaDTO.getTempoPreparo());
		receita.setUsuario(usuario);
		
		return receita;
	}
	
	public List<RespostaHistoricoDTO> converteRespostaHistoricoPreparacaoReceita(List<PreparacaoReceita> preparacoes) {
		List<RespostaHistoricoDTO> historicoDTO = new ArrayList<RespostaHistoricoDTO>(); 
		for(PreparacaoReceita preparacao : preparacoes){
			RespostaHistoricoDTO dto = new RespostaHistoricoDTO();
			dto.setDataInicio(preparacao.getDataInicio());
			dto.setDataConclusao(preparacao.getDataConclusao());
			dto.setEtapaAtual(preparacao.getEtapaAtual());
			dto.setNomeReceita(preparacao.getReceita().getNomeReceita());
			dto.setObservacao(preparacao.getObservacao());
			dto.setPreparacaoReceitaId(preparacao.getPreparacaoReceitaId());
			dto.setResultadoReceita(preparacao.getResultadoReceita());
			dto.setStatusPreparacao(preparacao.getStatusPreparacao());
			dto.setReceitaId(preparacao.getPreparacaoReceitaId());
			dto.setNotaPreparacao(preparacao.getNotaPreparacao());
			historicoDTO.add(dto);
		};
		
		return historicoDTO;
	}

	public List<ReceitaDTO> converteRespostaListaReceita(List<Receita> listaDeReceitas) {
		
		List<ReceitaDTO> receitasConvertidas = new ArrayList();
		
		for (Receita receita : listaDeReceitas) {
			ReceitaDTO dto = new ReceitaDTO();
			dto.setCategoria(receita.getCategoria());
			dto.setDataCriacao(receita.getDataCriacao());
			dto.setDescricao(receita.getDescricao());
			dto.setNomeReceita(receita.getNomeReceita());
			dto.setPublico(receita.isPublico());
			dto.setReceitaId(receita.getReceitaId());
			dto.setRendimentoEmLitros(receita.getRendimentoEmLitros());
			dto.setTempoPreparo(receita.getTempoPreparo());
			dto.setUsuarioId(receita.getUsuario().getUsuarioId());
			dto.setNotaReceita(receita.getNotaReceita());
			receitasConvertidas.add(dto);
		}
		return receitasConvertidas;
	}
	
}
