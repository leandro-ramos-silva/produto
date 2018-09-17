package br.com.bbseguros.produto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.bbseguros.produto.domain.Assistencia;
import br.com.bbseguros.produto.dto.AssistenciaDTO;
import br.com.bbseguros.produto.repositories.AssistenciaRepository;
import br.com.bbseguros.produto.resources.exception.*;

@Service
public class AssistenciaService {
	
	@Autowired
	private AssistenciaRepository repo ;
	
	public Assistencia findById(Integer id) {
		
		 Optional<Assistencia>  obj =  repo.findById(id) ;
		 
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Nenhuma assistencia encontrada") ) ;
					 
			
		}
	
	public List<Assistencia> findAll(){
		
		return repo.findAll() ;
	}
	
	
	
	public Assistencia save(AssistenciaDTO assistencia) {
		
		return repo.save(new Assistencia(assistencia)) ;
	}
	
public void delete(Integer id ) {
		
		findById(id) ;
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Nao é possivel a exclusao de uma assistencia com planos") ;
		}
	}

public Assistencia fromDTO(AssistenciaDTO assist) {
	
	return new Assistencia(assist) ;
}


}
