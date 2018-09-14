package br.com.bbseguros.produto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bbseguros.produto.domain.Cobertura;
import br.com.bbseguros.produto.repositories.CoberturaRepository;
import br.com.bbseguros.produto.services.exception.ObjectNotFoundExecption;

@Service
public class CoberturaService {
	
	@Autowired
	private CoberturaRepository repo ;
	
	public Cobertura findById(Integer id) {
		
		 Optional<Cobertura>  obj =  repo.findById(id) ;
		 
		 return obj.orElseThrow(() -> new ObjectNotFoundExecption("Nenhuma Cobertura encontrada") ) ;		 
			
	}
	
	public List<Cobertura> findAll(){
		
		return repo.findAll() ;
	}
	
	public Cobertura save(Cobertura cobertura) {
		
		return repo.save(cobertura) ;		
	}

}
