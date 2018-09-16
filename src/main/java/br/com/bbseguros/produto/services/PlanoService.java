package br.com.bbseguros.produto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.bbseguros.produto.domain.Assistencia;
import br.com.bbseguros.produto.domain.Cobertura;
import br.com.bbseguros.produto.domain.Plano;
import br.com.bbseguros.produto.repositories.AssistenciaRepository;
import br.com.bbseguros.produto.repositories.CoberturaRepository;
import br.com.bbseguros.produto.repositories.PlanoRepository;
import br.com.bbseguros.produto.resources.exception.*;


@Service
public class PlanoService {
	
	@Autowired
	private PlanoRepository repo ;
	
	@Autowired
	private AssistenciaRepository assistenciaRepo ;

	
	@Autowired
	private CoberturaRepository coberturaRepo ;
	
	
	public Plano findById(Integer id) {
		
		 Optional<Plano>  obj =  repo.findById(id) ;
		 
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Nenhuma Cobertura encontrada") ) ;			
		 			
	}
	
	public List<Plano> findAll(){
		return repo.findAll() ;
		
	}
	
	public Plano save(Plano plano) {
		
		if(plano.getCoberturas() != null) {
			if(plano.getCoberturas().size()  < 1 ) {			
				throw new ObjectValidationException("Deve ser selecionada pelo menos 1 cobertura") ;					
		}else {
			//valida se cobertura existe
			List<Cobertura> cobList  = plano.getCoberturas() ;
			for (Cobertura cob : cobList) {
				if(!(coberturaRepo.existsById(cob.getId()))) {
					System.out.println("### ID pesquisado " + cob.getId()) ;
					throw new ObjectValidationException("A cobertura id " + cob.getId() + "  nao existe ") ;
				} 
			}
			
			
		}
		}else {
			throw new ObjectValidationException("Deve ser selecionada pelo menos 1 cobertura") ;
		}
		
		
		
		if(plano.getAssistencias() != null ) {
			if(plano.getAssistencias().size()  < 1 ) {			
				throw new ObjectValidationException("Deve ser selecionada pelo menos 1 Assistencia") ;
			}else {
				//valida se a assistencia existe
				List<Assistencia> obj =  plano.getAssistencias() ;
				
				
				for(Assistencia assistencia : obj ) {								
					if (!(assistenciaRepo.existsById(assistencia.getId()))) {
						
						System.out.println("### ID pesquisado " + assistencia.getId()) ;
						throw new ObjectValidationException("A assistencia id " + assistencia.getId() + "  nao existe ") ;
					}								
					
				} 
				
				
				
			}
		}else {
			
			throw new ObjectValidationException("Deve ser selecionada pelo menos 1 Assistencia") ;
		}
		return repo.save(plano) ;
		
	}
	
	public void delete(Integer id ) {
		
		findById(id) ;
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Nao é possivel a exclusao de um plano com produtos") ;
		}
		
	}

}
