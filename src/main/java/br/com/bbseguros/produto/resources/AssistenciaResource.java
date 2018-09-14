package br.com.bbseguros.produto.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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


	@RequestMapping(method=RequestMethod.POST)
	@ApiOperation(value="Retorna assistencia pelo  pelo ID")
	@ApiResponses(value = {		
			@ApiResponse(code = 404, message = "Codigo inexistente") })
	public ResponseEntity<Assistencia> findById( @RequestBody Assistencia assistencia){
		return ResponseEntity.ok().body(service.findById(assistencia.getId())) ;
	}
	
	
	@RequestMapping(method=RequestMethod.PUT)
	@ApiOperation(value="Retorna Assistencia pelo  pelo ID")
	@ApiResponses(value = {		
			@ApiResponse(code = 404, message = "Codigo inexistente") })	
	public ResponseEntity<Assistencia> addProduto(
			@RequestBody Assistencia assistencia) {
		return ResponseEntity.ok().body(service.save(assistencia) );
		
		
	}
	

}
