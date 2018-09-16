package br.com.bbseguros.produto.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	

	
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ApiOperation(value="Retorna produto pelo  pelo ID")
	@ApiResponses(value = {		
			@ApiResponse(code = 404, message = "Codigo inexistente") })
	public ResponseEntity<Produto> find( @PathVariable Integer id){
		return ResponseEntity.ok().body(service.findById(id)) ;
		
	}
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ApiOperation(value="Deleta produto pelo  pelo ID")
	@ApiResponses(value = {		
			@ApiResponse(code = 404, message = "Codigo inexistente") })
	public ResponseEntity<Void>  delete( @PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build() ;
		
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	@ApiOperation(value="Retorna produto pelo  pelo ID")
	@ApiResponses(value = {		
			@ApiResponse(code = 404, message = "Codigo inexistente") })	
	public ResponseEntity<Produto> insert(@Valid
			@RequestBody ProdutoDTO produto) {
		
		System.out.println("###############" +produto.toString()) ;
		Produto prod = service.fromDTO(produto);
		return ResponseEntity.ok().body(service.save(prod) );
		
		
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	@ApiOperation(value="Retorna produto pelo  pelo ID")
	@ApiResponses(value = {		
			@ApiResponse(code = 404, message = "Codigo inexistente") })	
	public ResponseEntity<Produto> addProduto(@Valid
			@RequestBody ProdutoDTO produto) {
		
		System.out.println("###############" +produto.toString()) ;
		Produto prod = service.fromDTO(produto);
		return ResponseEntity.ok().body(service.save(prod) );
		
		
	}
	
	

}
