package br.academiaDaCerveja.receitas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.academiaDaCerveja.receitas.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}
