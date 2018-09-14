package br.com.bbseguros.produto.dto;

import java.io.Serializable;

import br.com.bbseguros.produto.domain.Cobertura;

public class CoberturaDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Integer id ;	
	private String descricao ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public CoberturaDTO(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	
	
	public CoberturaDTO(Cobertura cobertura) {
		
		this.descricao = cobertura.getDescricao();
		this.id = cobertura.getId() ;
		
		
	}
	
	

}
