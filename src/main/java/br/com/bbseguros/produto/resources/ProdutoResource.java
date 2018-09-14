package br.com.bbseguros.produto.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bbseguros.produto.domain.Produto;
import br.com.bbseguros.produto.dto.ProdutoDTO;
import br.com.bbseguros.produto.services.ProdutoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="produto")
public class ProdutoResource {
	
	@Autowired
	ProdutoService service ;
	
	
	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation(value="Retorna lista de todos produtos")
	@ApiResponses(value = {		
			@ApiResponse(code = 404, message = "Codigo inexistente") })
	public ResponseEntity<List<ProdutoDTO>> findAll(){
		
		List<ProdutoDTO> listDTO = service.findAll().stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList()) ;
		return ResponseEntity.ok().body(listDTO) ;
		
	}	
	
	@RequestMapping(method=RequestMethod.POST)
	@ApiOperation(value="Retorna produto pelo  pelo ID")
	@ApiResponses(value = {		
			@ApiResponse(code = 404, message = "Codigo inexistente") })
	public ResponseEntity<Produto> findById( @RequestBody Produto produto){
		return ResponseEntity.ok().body(service.findById(produto.getId())) ;
	}
	
	
	@RequestMapping(method=RequestMethod.PUT)
	@ApiOperation(value="Retorna produto pelo  pelo ID")
	@ApiResponses(value = {		
			@ApiResponse(code = 404, message = "Codigo inexistente") })	
	public ResponseEntity<Produto> addProduto(
			@RequestBody Produto produto) {
		return ResponseEntity.ok().body(service.save(produto) );
		
		
	}
	
	

}
