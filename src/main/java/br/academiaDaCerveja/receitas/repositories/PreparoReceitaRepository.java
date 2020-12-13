package br.academiaDaCerveja.receitas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.academiaDaCerveja.receitas.entities.PreparoReceita;
import br.academiaDaCerveja.receitas.entities.Receita;

public interface PreparoReceitaRepository extends JpaRepository<PreparoReceita, Long>{
	public List<PreparoReceita> findByReceita(Receita id);
	public List<PreparoReceita> findByReceitaOrderByOrdemDesc(Receita id);
}
