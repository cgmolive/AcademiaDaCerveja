package br.academiaDaCerveja.receitas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.academiaDaCerveja.receitas.entities.Receita;
import br.academiaDaCerveja.receitas.entities.IngredientesReceita;


public interface IngredientesReceitaRepository extends JpaRepository<IngredientesReceita, Long> {
	public List<IngredientesReceita> findByReceita(Receita id);
}


