package br.com.bbseguros.produto.dto;



import br.com.bbseguros.produto.domain.Assistencia;

public class AssistenciaDTO {
	
	private Integer id;
	private String descricao;
	
	

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

	public AssistenciaDTO(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public AssistenciaDTO(Assistencia assistencia) {
		
		this.id = assistencia.getId() ;
		this.descricao  = assistencia.getDescricao()  ;
	
	}


}
