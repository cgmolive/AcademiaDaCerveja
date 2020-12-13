package br.academiaDaCerveja.receitas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.academiaDaCerveja.receitas.entities.PreparacaoReceita;
import br.academiaDaCerveja.receitas.entities.Receita;
import br.academiaDaCerveja.receitas.entities.Usuario;

public interface ReceitaRepository extends JpaRepository<Receita, Long>{
	public Receita findByReceitaId(Long id);
	public List<Receita> findByUsuario(Usuario id);

}
