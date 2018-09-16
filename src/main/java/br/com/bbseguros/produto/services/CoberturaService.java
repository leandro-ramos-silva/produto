package br.com.bbseguros.produto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.bbseguros.produto.domain.Cobertura;
import br.com.bbseguros.produto.repositories.CoberturaRepository;
import br.com.bbseguros.produto.resources.exception.*;

@Service
public class CoberturaService {
	
	@Autowired
	private CoberturaRepository repo ;
	
	public Cobertura findById(Integer id) {
		
		 Optional<Cobertura>  obj =  repo.findById(id) ;
		 
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Nenhuma Cobertura encontrada") ) ;		 
			
	}
	
	public List<Cobertura> findAll(){
		
		return repo.findAll() ;
	}
	
	public Cobertura save(Cobertura cobertura) {
		
		return repo.save(cobertura) ;		
	}
	
	public void delete(Integer id ) {
		
		findById(id) ;
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Nao é possivel a exclusao de uma cobertura com planos") ;
		}
	}

}
