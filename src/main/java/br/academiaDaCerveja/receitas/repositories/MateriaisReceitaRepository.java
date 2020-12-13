package br.academiaDaCerveja.receitas.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.academiaDaCerveja.receitas.entities.MateriaisReceita;
import br.academiaDaCerveja.receitas.entities.Receita;

public interface MateriaisReceitaRepository extends JpaRepository<MateriaisReceita, Long>{
	public List<MateriaisReceita> findByReceita(Receita id);

}
