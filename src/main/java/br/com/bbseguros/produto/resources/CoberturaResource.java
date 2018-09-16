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

import br.com.bbseguros.produto.domain.Cobertura;
import br.com.bbseguros.produto.dto.CoberturaDTO;
import br.com.bbseguros.produto.services.CoberturaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="cobertura")
public class CoberturaResource {
	
	
	@Autowired
	CoberturaService service ;

	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation(value="Retorna lista de coberturas")
	@ApiResponses(value = {		
			@ApiResponse(code = 404, message = "Codigo inexistente") })
	public ResponseEntity<List<CoberturaDTO>>  findAll(){
		
		List<CoberturaDTO> listDTO = service.findAll().stream().map(x -> new CoberturaDTO(x)).collect(Collectors.toList()) ;
		return ResponseEntity.ok().body(listDTO) ;
	
	}


	@RequestMapping(method=RequestMethod.POST)
	@ApiOperation(value="Retorna cobertura pelo  pelo ID")
	@ApiResponses(value = {		
			@ApiResponse(code = 404, message = "Codigo inexistente") })
	public ResponseEntity<Cobertura> findById( @RequestBody Cobertura cobertura){
		return ResponseEntity.ok().body(service.findById(cobertura.getId())) ;
	}
	
	
	@RequestMapping(method=RequestMethod.PUT)
	@ApiOperation(value="Retorna Cobertura pelo  pelo ID")
	@ApiResponses(value = {		
			@ApiResponse(code = 404, message = "Codigo inexistente") })	
	public ResponseEntity<Cobertura> addProduto(
			@RequestBody Cobertura cobertura) {
		return ResponseEntity.ok().body(service.save(cobertura) );
		
		
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
