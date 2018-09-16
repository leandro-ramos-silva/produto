package br.com.bbseguros.produto.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bbseguros.produto.domain.Plano;
import br.com.bbseguros.produto.domain.Produto;
import br.com.bbseguros.produto.dto.PlanoDTO;
import br.com.bbseguros.produto.dto.ProdutoDTO;
import br.com.bbseguros.produto.repositories.PlanoRepository;
import br.com.bbseguros.produto.repositories.ProdutoRepository;

import br.com.bbseguros.produto.resources.exception.*;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repo ;
	
	@Autowired
	PlanoRepository planoRepo ;
	
	public Produto findById(Integer id) {
		
	 Optional<Produto>  obj =  repo.findById(id) ;
	 
	 return obj.orElseThrow(() -> new ObjectNotFoundException("Nenhuma Produto encontrado") ) ;		
	 
		
	}
	
	public void delete(Integer id) {
		findById(id) ;
		repo.deleteById(id) ;
		 
			
	}

	public Produto save(Produto produto) {
		
		if(produto.getPlano() != null) {
			if(produto.getPlano().size()  < 1 ) {			
				throw new ObjectValidationException("Deve ser selecionada pelo menos 1 plano") ;					
		}else {
			//valida se cobertura existe
			List<Plano> planoList  = produto.getPlano() ;
			for (Plano plano : planoList) {
				if(!(planoRepo.existsById(plano.getId()))) {
					System.out.println("### ID pesquisado " + plano.getId()) ;
					throw new ObjectValidationException("O plano id " + plano.getId() + "  nao existe ") ;
				} 
			}
			
			
		}
		}else {
			throw new ObjectValidationException("Deve ser selecionada pelo menos 1 Plano") ;
		}
		
		
		return repo.save(produto) ;
		
	}	
	
	public List<Produto> findAll(){
		
		return repo.findAll() ;
	}
	
	public Produto  fromDTO(ProdutoDTO prod) {

	Produto produto = new Produto (prod.getId(),prod.getNome_produto(),prod.getParcelas(),prod.getRamo());
	
	produto.setPlano(prod.getPlanos().stream().map(x -> new Plano(x)).collect(Collectors.toList()) ) ;
	System.out.println("#####produto " + produto.toString()) ;
	return produto;
	}
}
