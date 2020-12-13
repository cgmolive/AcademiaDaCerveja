package br.academiaDaCerveja.receitas.controllers;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

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

import br.academiaDaCerveja.receitas.dtos.AtualizacaoPreparacaoReceitaDTO;
import br.academiaDaCerveja.receitas.dtos.CriacaoPreparacaoReceitaDTO;
import br.academiaDaCerveja.receitas.dtos.RespostaHistoricoDTO;
import br.academiaDaCerveja.receitas.dtos.RespostaPreparacaoReceitaDTO;
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
public class PreparacaoReceitaController{
	
	@Autowired
	private PreparacaoReceitaRepository preparacaoRepository;
	
	@Autowired
	private PreparoReceitaRepository preparoRepository;
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	//Tratar post com receita que não existe, ou receita sem passos cadastrados
	
	@PostMapping("/receitas/{id}/preparacoes")
	public ResponseEntity add(@PathVariable Long id, @Valid @RequestBody CriacaoPreparacaoReceitaDTO dto) {
		Receita receitaVerificacao = receitaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException
    			("Não existe receita com ID informado!"));
		List<PreparoReceita> listaPreparo = preparoRepository.findByReceita(receitaVerificacao);
		if(listaPreparo.size() > 0) {
			PreparacaoReceita preparo = new PreparacaoReceita();
			Receita receita = new Receita();
			receita.setReceitaId(id);
			Usuario usuario = new Usuario();
			usuario.setUsuarioId(dto.getUsuarioId());
			Date data = new Date();
			preparo.setReceita(receita);
			preparo.setDataInicio(data);
			preparo.setStatusPreparacao(Situacoes.INICIADO.getSituacao());
			preparo.setEtapaAtual(1);
			preparo.setUsuario(usuario);
			preparacaoRepository.save(preparo);
			Converter converter = new Converter();
			return ResponseEntity.status(HttpStatus.CREATED).body(converter.converteRespostaPreparacaoReceita(preparo)); 	
		}
	
		else {
			throw new RuntimeException("Não existe passo vinculado a receita!");
	}
		
	}
    @PutMapping("/receitas/preparacoes/{id}")
    public ResponseEntity edit(@PathVariable Long id, @Valid @RequestBody AtualizacaoPreparacaoReceitaDTO dto) {
    	PreparacaoReceita preparacao = preparacaoRepository.findByPreparacaoReceitaId(id);
    	preparacao.setObservacao(dto.getObservacao());
        String situacao = preparacao.getStatusPreparacao();
        int etapa = preparacao.getEtapaAtual();
        List<PreparoReceita> prep = preparoRepository.findByReceitaOrderByOrdemDesc(preparacao.getReceita());
    	int ultimaOrdem = prep.get(0).getOrdem();
        switch(situacao) {
        case "Iniciado":
        	preparacao.setStatusPreparacao(Situacoes.PREPARO.getSituacao());
        	preparacao.setEtapaAtual(etapa + 1);
        	break;
        case "Preparo": 
        	etapa = preparacao.getEtapaAtual();
        	if(etapa == ultimaOrdem) {
            	Date data = new Date();
            	preparacao.setDataConclusao(data);
            	preparacao.setStatusPreparacao(Situacoes.FINALIZADO.getSituacao());
        	}
        	else {
        		preparacao.setEtapaAtual(etapa + 1);
        	}
        	break;
        	
        case "Finalizado":
            preparacao.setResultadoReceita(dto.getResultadoReceita());
            preparacao.setNotaPreparacao(dto.getNotaPreparacao());
        	break;
        }
        preparacao.setTamanhoPassos(ultimaOrdem);
        preparacaoRepository.save(preparacao);
        Converter converter = new Converter();
        return ResponseEntity.status(HttpStatus.OK).body(converter.converteRespostaPreparacaoReceita(preparacao));
    }
    
    @GetMapping("/receitas/preparacoes/{id}")
	public RespostaPreparacaoReceitaDTO view(@PathVariable Long id) {
    	Converter converter = new Converter();
    	PreparacaoReceita preparacao = preparacaoRepository.findByPreparacaoReceitaId(id);
    	return converter.converteRespostaPreparacaoReceita(preparacao);
	}
    
 /*   
    @GetMapping("/receitas/{id}/preparacoes")
    public Object viewAll(@PathVariable Long id) {
    	  return preparacaoRepository.findAll();
    }
  
  */
  
    @GetMapping("/receitas/preparacoes/usuario/{id}")
    public List<RespostaHistoricoDTO> viewByUser(@PathVariable Long id) {
    	Usuario usuario = new Usuario();
    	usuario.setUsuarioId(id);
    	List<PreparacaoReceita> preparacoes = preparacaoRepository.findByUsuario(usuario);
    	Converter converter = new Converter();
    	return converter.converteRespostaHistoricoPreparacaoReceita(preparacoes);
    }
    
    @DeleteMapping("/receitas/preparacoes/{id}")
    public void delete(@PathVariable Long id) {
        preparacaoRepository.deleteById(id);
    }
}
