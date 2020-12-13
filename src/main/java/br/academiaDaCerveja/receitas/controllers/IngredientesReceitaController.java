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

import br.academiaDaCerveja.receitas.dtos.IngredientesReceitaDTO;
import br.academiaDaCerveja.receitas.entities.IngredientesReceita;
import br.academiaDaCerveja.receitas.entities.Receita;
import br.academiaDaCerveja.receitas.repositories.IngredientesReceitaRepository;
import br.academiaDaCerveja.receitas.utils.Converter;

@RestController
public class IngredientesReceitaController{
	@Autowired
	private IngredientesReceitaRepository repo;


	@PostMapping("/receitas/{id}/ingredientes")
	public long add(@PathVariable Long id, @RequestBody IngredientesReceita ingredientes) {
		repo.save(ingredientes);
		return ingredientes.getReceitaIngredientesId();
	}


	@PutMapping("/receitas/{id}/ingredientes")
	public void edit(@PathVariable Long id, @RequestBody IngredientesReceita ingredientes) {
		if (!id.equals(ingredientes.getReceitaIngredientesId())) {
			throw new RuntimeException("Ids devem ser iguais!");
		}

		repo.save(ingredientes);

	}


	@GetMapping("/receitas/{id}/ingredientes")
	public List<IngredientesReceitaDTO> view(@PathVariable Long id) {
		Receita receita = new Receita();
		receita.setReceitaId(id);
		List<IngredientesReceita>ingredientes = repo.findByReceita(receita);
		Converter converter = new Converter();
		return converter.converteReceitaIngredientes(ingredientes);
	}


	@DeleteMapping("/receitas/{id}/ingredientes")
	public void delete(@PathVariable Long id) {
		repo.deleteById(id);
	}

}
