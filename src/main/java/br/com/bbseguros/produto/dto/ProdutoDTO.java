package br.com.bbseguros.produto.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.bbseguros.produto.domain.Produto;

public class ProdutoDTO implements Serializable {
		
	private static final long serialVersionUID = 1L;	
	
	private Integer id ;
	
	
	@NotEmpty(message="Insira um nome")
	@Length(min=3, max=80, message="O nome deve ter entre 3 a 80 caracteres")
	private String nome_produto ;
	
	
	
	@Override
	public String toString() {
		return "ProdutoDTO [id=" + id + ", nome_produto=" + nome_produto + ", parcelas=" + parcelas + ", planos="
				+ planos + ", ramo=" + ramo + "]";
	}
	private Integer parcelas ;
	
	@NotEmpty(message="Insira a quantidade pelo menos 1 plano valido")
	private List<PlanoDTO> planos  ;
	
	@NotEmpty(message="Insira um nome")
	@Length(min=3, max=10, message="O ramo deve ter entre 3 a 10 caracteres")
	private String ramo ;
	public String getNome_produto() {
		return nome_produto;
	}
	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}
	public Integer getParcelas() {
		return parcelas;
	}
	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}
	
	public String getRamo() {
		return ramo;
	}
	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	
	public ProdutoDTO() {
		
		
	}
	
	
	
	
	public ProdutoDTO(Integer id, String nome_produto, Integer parcelas, String ramo) {
		super();
		this.id = id;
		this.nome_produto = nome_produto;
		this.parcelas = parcelas;
		
		this.ramo = ramo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<PlanoDTO> getPlanos() {
		return planos;
	}
	public void setPlanos(List<PlanoDTO> planos) {
		this.planos = planos;
	}
	public ProdutoDTO(Produto produto) {
		
		this.id = produto.getId();
		this.nome_produto = produto.getNome() ;
		this.parcelas = produto.getParcelas() ;
		this.planos = produto.getPlano().stream().map(x -> new PlanoDTO(x)).collect(Collectors.toList()) ;		
		this.ramo = produto.getRamoEmissao() ;
		
		
	}

	
	
	
	
	

}
