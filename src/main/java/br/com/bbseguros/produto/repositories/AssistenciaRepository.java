package br.com.bbseguros.produto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bbseguros.produto.domain.Assistencia;

public interface AssistenciaRepository extends JpaRepository <Assistencia, Integer>{

	
}
