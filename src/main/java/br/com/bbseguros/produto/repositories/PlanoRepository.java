package br.com.bbseguros.produto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bbseguros.produto.domain.Plano;

public interface PlanoRepository extends JpaRepository <Plano,Integer> {

}
