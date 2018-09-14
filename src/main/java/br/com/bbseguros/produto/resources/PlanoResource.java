package br.com.bbseguros.produto.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bbseguros.produto.domain.Plano;
import br.com.bbseguros.produto.dto.PlanoDTO;
import br.com.bbseguros.produto.services.PlanoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="plano")
public class PlanoResource {
	
	@Autowired
	PlanoService service ;
	
	
	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation(value="Retorna lista de todos planos")
	@ApiResponses(value = {		
			@ApiResponse(code = 404, message = "Codigo inexistente") })
	public ResponseEntity<List<PlanoDTO>> findAll(){
		
		List<PlanoDTO> listDTO = service.findAll().stream().map(x -> new PlanoDTO(x)).collect(Collectors.toList()) ;
		return ResponseEntity.ok().body(listDTO) ;
		
	}	
	
	@RequestMapping(method=RequestMethod.POST)
	@ApiOperation(value="Retorna plano pelo  pelo ID")
	@ApiResponses(value = {		
			@ApiResponse(code = 404, message = "Codigo inexistente") })
	public ResponseEntity<Plano> findById( @RequestBody Plano plano){
		return ResponseEntity.ok().body(service.findById(plano.getId())) ;
	}
	
	
	@RequestMapping(method=RequestMethod.PUT)
	@ApiOperation(value="Retorna plano pelo  pelo ID")
	@ApiResponses(value = {		
			@ApiResponse(code = 404, message = "Codigo inexistente") })	
	public ResponseEntity<Plano> addPlano(
			@RequestBody Plano plano) {
		return ResponseEntity.ok().body(service.save(plano) );		
		
	}
	

}