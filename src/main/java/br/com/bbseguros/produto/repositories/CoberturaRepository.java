package br.com.bbseguros.produto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bbseguros.produto.domain.Cobertura;

public interface CoberturaRepository extends JpaRepository< Cobertura, Integer> {

	
}
