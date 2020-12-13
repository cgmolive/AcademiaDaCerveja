package br.academiaDaCerveja.receitas.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.academiaDaCerveja.receitas.dtos.ReceitaDTO;
import br.academiaDaCerveja.receitas.entities.PreparacaoReceita;
import br.academiaDaCerveja.receitas.entities.PreparoReceita;
import br.academiaDaCerveja.receitas.entities.Receita;
import br.academiaDaCerveja.receitas.entities.Usuario;
import br.academiaDaCerveja.receitas.repositories.PreparacaoReceitaRepository;
import br.academiaDaCerveja.receitas.repositories.PreparoReceitaRepository;
import br.academiaDaCerveja.receitas.repositories.ReceitaRepository;
import br.academiaDaCerveja.receitas.repositories.UsuarioRepository;
import br.academiaDaCerveja.receitas.utils.Converter;
import br.academiaDaCerveja.receitas.utils.Situacoes;

@RestController
public class ReceitaController{
	@Autowired
	private ReceitaRepository receitaRepository;
	@Autowired
	private PreparoReceitaRepository preparoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PreparacaoReceitaRepository preparacaoRepository;
	
	@PostMapping("/receitas")
	public long add(@RequestBody Receita receita) {
		receitaRepository.save(receita);
		return receita.getReceitaId();
	}
	//Está atualmente fazendo POST, implementar similar a casos já funcionando, implementar DTO.

	@PutMapping("/receitas/{id}")
	public ResponseEntity edit(@PathVariable Long id, @RequestBody ReceitaDTO receitaDTO) {
		receitaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException
    			("Não existe receita com ID informado!"));
		
		Usuario usuario = usuarioRepository.findById(receitaDTO.getUsuarioId()).orElseThrow(() -> new EntityNotFoundException
				("Não existe usuário com ID informado!"));
		Converter converter = new Converter();
		Receita receitaEditada = converter.converteRequisicaoReceita(receitaDTO, id, usuario);
		receitaRepository.save(receitaEditada);
		return ResponseEntity.status(HttpStatus.OK).body(converter.converteRespostaReceita(receitaEditada));
	}
	@GetMapping("/receitas/{id}")
	public Object view(@PathVariable Long id) {
		int tempoPreparo = 0;
		String situacao = Situacoes.FINALIZADO.getSituacao();
		Receita receita = receitaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		List<PreparoReceita> lista = preparoRepository.findByReceita(receita);
		for (PreparoReceita preparo : lista) {
			tempoPreparo = tempoPreparo + preparo.getTempoPreparo();
		}
		receita.setTempoPreparo(tempoPreparo);
		List<PreparacaoReceita> listaDePreparacoesFinalizadas = new ArrayList<>();
		List<PreparacaoReceita> listaPreparacoes = preparacaoRepository.findAllByReceita(receita);
		for(PreparacaoReceita preparacoes : listaPreparacoes) {
			if(preparacoes.getStatusPreparacao().equals(situacao)) {
				listaDePreparacoesFinalizadas.add(preparacoes);
			}
		}
		receita.setNotaReceita(calculaNotaMedia(listaDePreparacoesFinalizadas)); 
		Converter converter = new Converter();
		return converter.converteRespostaReceita(receita);
	}
	
	@GetMapping("/receitas/usuario/{id}")
	public List<ReceitaDTO> viewByUser(@PathVariable Long id){
		Usuario usuario = new Usuario();
		usuario.setUsuarioId(id);
		String situacao = Situacoes.FINALIZADO.getSituacao();
		List<PreparacaoReceita> listaDePreparacoesFinalizadas = new ArrayList<PreparacaoReceita>();
		List<Receita> listaDeReceitas = receitaRepository.findByUsuario(usuario);
		for(Receita receita : listaDeReceitas) {
			List<PreparacaoReceita> listaDePreparacoes = preparacaoRepository.findAllByReceita(receita);
			for(PreparacaoReceita preparacoes : listaDePreparacoes) {
				if(preparacoes.getStatusPreparacao().equals(situacao)) {
					listaDePreparacoesFinalizadas.add(preparacoes);
				}
			}
			receita.setNotaReceita(calculaNotaMedia(listaDePreparacoesFinalizadas));
		}
		Converter converter = new Converter();
		return converter.converteRespostaListaReceita(listaDeReceitas);
	}
	
	@DeleteMapping("/receitas/{id}")
	public void delete(@PathVariable Long ID) {
		receitaRepository.deleteById(ID);
		
	}
	public double calculaNotaMedia(List<PreparacaoReceita>listaDePreparacoes) {
		double notaResultante;
		double notaPreparacao = 0;
		if (listaDePreparacoes.size() == 0) {
			notaResultante = 0;
		}
		else {
			int tamanhoLista = listaDePreparacoes.size();
			for(PreparacaoReceita preparacao : listaDePreparacoes) {
				notaPreparacao += preparacao.getNotaPreparacao();
			}	
			 notaResultante = notaPreparacao / tamanhoLista;
		}	
		if (notaResultante > 0 && notaResultante < 1) {
			notaResultante = 1.0;
		}
		return notaResultante;

	}

	
}
