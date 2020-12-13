package br.academiaDaCerveja.receitas.controllers;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.academiaDaCerveja.receitas.dtos.RequisicaoReceitaPreparoDTO;
import br.academiaDaCerveja.receitas.dtos.RespostaReceitaPreparoDTO;
import br.academiaDaCerveja.receitas.entities.PreparoReceita;
import br.academiaDaCerveja.receitas.entities.Receita;
import br.academiaDaCerveja.receitas.repositories.PreparoReceitaRepository;
import br.academiaDaCerveja.receitas.repositories.ReceitaRepository;
import br.academiaDaCerveja.receitas.utils.Converter;

@RestController
public class PreparoReceitaController{
	@Autowired
	private PreparoReceitaRepository preparoReceitaRepository;
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	@PostMapping("/receitas/{id}/preparo")
	public long add(@PathVariable Long id, @RequestBody RequisicaoReceitaPreparoDTO requisicaoReceitaPreparo) {
		PreparoReceita preparoReceita = new PreparoReceita();
		preparoReceita.setDescricao(requisicaoReceitaPreparo.getDescricao());
		preparoReceita.setTempoPreparo(requisicaoReceitaPreparo.getTempoPreparo());
		preparoReceita.setNomePasso(requisicaoReceitaPreparo.getNomePasso());
		Receita receita = receitaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		preparoReceita.setReceita(receita);
		List<PreparoReceita>listaDePreparos = preparoReceitaRepository.findByReceita(receita);
		int tamanhoDaLista = listaDePreparos.size();
		if(tamanhoDaLista == 0) {
			preparoReceita.setOrdem(1);
		}else {
			preparoReceita.setOrdem(tamanhoDaLista + 1);
		}
		
		preparoReceitaRepository.save(preparoReceita);
		return preparoReceita.getReceitaPreparoId();
	}
    @PutMapping("/receitas/preparo/{id}")
    public void edit(@PathVariable Long id, @RequestBody RequisicaoReceitaPreparoDTO requisicaoPreparoDTO) {
    	PreparoReceita preparoReceita = preparoReceitaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException
    			("Não existe preparo com ID informado!"));

        preparoReceita.setReceita(receitaRepository.findByReceitaId(preparoReceita.getReceita().getReceitaId()));
        preparoReceita.setDescricao(requisicaoPreparoDTO.getDescricao());
        preparoReceita.setNomePasso(requisicaoPreparoDTO.getNomePasso());
        preparoReceita.setReceitaPreparoId(id);
        preparoReceita.setTempoPreparo(requisicaoPreparoDTO.getTempoPreparo());
        preparoReceitaRepository.save(preparoReceita);
    }
    
    @GetMapping("/receitas/{id}/preparo")
	public Object view(@PathVariable Long id) {
    	Receita receita = new Receita();
    	receita.setReceitaId(id);
    	List<PreparoReceita> preparo = preparoReceitaRepository.findByReceita(receita);
    	Converter converter = new Converter();
		return converter.converteReceitaPreparo(preparo);
	}

    @DeleteMapping("/receitas/{id}/preparo")
    public void delete(@PathVariable Long id) {
        preparoReceitaRepository.deleteById(id);
    }
}
