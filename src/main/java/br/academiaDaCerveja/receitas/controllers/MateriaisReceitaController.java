package br.academiaDaCerveja.receitas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.academiaDaCerveja.receitas.dtos.MateriaisReceitaDTO;
import br.academiaDaCerveja.receitas.entities.MateriaisReceita;
import br.academiaDaCerveja.receitas.entities.Receita;
import br.academiaDaCerveja.receitas.repositories.MateriaisReceitaRepository;
import br.academiaDaCerveja.receitas.utils.Converter;

@RestController
public class MateriaisReceitaController {
	
	@Autowired
	private MateriaisReceitaRepository repo;
	

	@PostMapping("/receitas/{id}/materiais")
	public long add(@PathVariable Long id, @RequestBody MateriaisReceita object) {
		repo.save(object);
		return object.getMateriaisId();
	}

    
    @PutMapping("/receitas/{id}/materiais")
    public void edit(@PathVariable Long id, @RequestBody MateriaisReceita materiais) {
        if (!id.equals(materiais.getMateriaisId())) {
            throw new RuntimeException("Ids devem ser iguais!");
        }

        repo.save(materiais);
    }
  

    @GetMapping("/receitas/{id}/materiais")
    public List<MateriaisReceitaDTO> view(@PathVariable Long id) {
    	Receita receita = new Receita();
    	receita.setReceitaId(id);
    	List<MateriaisReceita> materiais = repo.findByReceita(receita);
    	Converter converter = new Converter();
    	return converter.converteMaterialReceita(materiais);
    }

    //Implementar get por materiais baseado em usuário

    @DeleteMapping("/receitas/{id}/materiais")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
	
    
}
