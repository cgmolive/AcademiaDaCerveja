package br.academiaDaCerveja.receitas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.academiaDaCerveja.receitas.entities.PreparacaoReceita;
import br.academiaDaCerveja.receitas.entities.Receita;
import br.academiaDaCerveja.receitas.entities.Usuario;

public interface PreparacaoReceitaRepository extends JpaRepository<PreparacaoReceita, Long> {

	public PreparacaoReceita findByPreparacaoReceitaId(Long id);

	public List<PreparacaoReceita> findByUsuario(Usuario id);
	
	public List<PreparacaoReceita> findAllByReceita(Receita id);
}
