package br.com.bbseguros.produto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bbseguros.produto.domain.Assistencia;
import br.com.bbseguros.produto.repositories.AssistenciaRepository;
import br.com.bbseguros.produto.services.exception.ObjectNotFoundExecption;

@Service
public class AssistenciaService {
	
	@Autowired
	private AssistenciaRepository repo ;
	
	public Assistencia findById(Integer id) {
		
		 Optional<Assistencia>  obj =  repo.findById(id) ;
		 
		 return obj.orElseThrow(() -> new ObjectNotFoundExecption("Nenhuma assistencia encontrada") ) ;
					 
			
		}
	
	public List<Assistencia> findAll(){
		
		return repo.findAll() ;
	}
	
	public Assistencia save(Assistencia assistencia) {
		
		return repo.save(assistencia) ;
	}

}
