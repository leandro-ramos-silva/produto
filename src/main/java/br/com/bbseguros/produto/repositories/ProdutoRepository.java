package br.com.bbseguros.produto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bbseguros.produto.domain.Produto;



public interface ProdutoRepository extends JpaRepository  <Produto, Integer> {

		
	
}
