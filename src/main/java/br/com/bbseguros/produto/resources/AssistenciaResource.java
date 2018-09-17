package br.com.bbseguros.produto.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bbseguros.produto.domain.Assistencia;
import br.com.bbseguros.produto.dto.AssistenciaDTO;
import br.com.bbseguros.produto.services.AssistenciaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="assistencia")
public class AssistenciaResource {
	
	
	@Autowired
	AssistenciaService service ;
	
	
	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation(value="Retorna lista de assistencias")
	@ApiResponses(value = {		
			@ApiResponse(code = 404, message = "Codigo inexistente") })
	public ResponseEntity<List<AssistenciaDTO>>  findAll(){
		
		List<AssistenciaDTO> listDTO = service.findAll().stream().map(x -> new AssistenciaDTO(x)).collect(Collectors.toList()) ;
		return ResponseEntity.ok().body(listDTO) ;
	
	}


	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation(value="Retorna assistencia pelo  pelo ID")
	@ApiResponses(value = {		
			@ApiResponse(code = 404, message = "Codigo inexistente") })
	public ResponseEntity<Assistencia> findById( @PathVariable Integer id ){
		return ResponseEntity.ok().body(service.findById(id)) ;
	}
	
	
	
	
	@RequestMapping(method=RequestMethod.POST)
	@ApiOperation(value="insere assistencia")
	@ApiResponses(value = {		
			@ApiResponse(code = 404, message = "Codigo inexistente") })	
	public ResponseEntity<Assistencia> insert(
			@RequestBody AssistenciaDTO assistencia) {
		return ResponseEntity.ok().body(service.save(assistencia) );
		
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ApiOperation(value="atualiza assistencia pelo  pelo ID")
	@ApiResponses(value = {		
			@ApiResponse(code = 404, message = "Codigo inexistente") })	
	public ResponseEntity<AssistenciaDTO> update(
			@RequestBody AssistenciaDTO assistencia) {
		return ResponseEntity.ok().body(new AssistenciaDTO(service.save(assistencia) ));
		
		
	}
	 
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ApiOperation(value="Deleta cobertura pelo  pelo ID")
	@ApiResponses(value = {		
			@ApiResponse(code = 404, message = "Codigo inexistente") })
	public ResponseEntity<Void>  delete( @PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build() ;
		
	}
	
	

}
