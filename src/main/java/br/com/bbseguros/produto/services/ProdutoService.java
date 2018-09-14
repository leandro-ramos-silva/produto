package br.com.bbseguros.produto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bbseguros.produto.domain.Plano;
import br.com.bbseguros.produto.domain.Produto;
import br.com.bbseguros.produto.repositories.PlanoRepository;
import br.com.bbseguros.produto.repositories.ProdutoRepository;
import br.com.bbseguros.produto.services.exception.ObjectNotFoundExecption;
import br.com.bbseguros.produto.services.exception.ObjectValidationExecption;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repo ;
	
	@Autowired
	PlanoRepository planoRepo ;
	
	public Produto findById(Integer id) {
		
	 Optional<Produto>  obj =  repo.findById(id) ;
	 
	 return obj.orElseThrow(() -> new ObjectNotFoundExecption("Nenhuma Produto encontrado") ) ;		
	 
		
	}

	public Produto save(Produto produto) {
		
		if(produto.getPlano() != null) {
			if(produto.getPlano().size()  < 1 ) {			
				throw new ObjectValidationExecption("Deve ser selecionada pelo menos 1 plano") ;					
		}else {
			//valida se cobertura existe
			List<Plano> planoList  = produto.getPlano() ;
			for (Plano plano : planoList) {
				if(!(planoRepo.existsById(plano.getId()))) {
					System.out.println("### ID pesquisado " + plano.getId()) ;
					throw new ObjectValidationExecption("O plano id " + plano.getId() + "  nao existe ") ;
				} 
			}
			
			
		}
		}else {
			throw new ObjectValidationExecption("Deve ser selecionada pelo menos 1 Plano") ;
		}
		
		
		return repo.save(produto) ;
		
	}	
	
	public List<Produto> findAll(){
		
		return repo.findAll() ;
	}
	
	
	

}
