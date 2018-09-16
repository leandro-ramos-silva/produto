package br.com.bbseguros.produto.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.bbseguros.produto.domain.Plano;

public class PlanoDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private List<CoberturaDTO> coberturas ;
	private List<AssistenciaDTO> assistencias ;
	private Integer id_plano ;
	private String nome_plano ;
    private Double valor ;
    private Date dataInclusao ;
    private Date dataAlteracao ;
    
    
	public Date getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public Date getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	public List<CoberturaDTO> getCoberturas() {
		return coberturas;
	}
	public void setCoberturas(List<CoberturaDTO> coberturas) {
		this.coberturas = coberturas;
	}
	public List<AssistenciaDTO> getAssistencias() {
		return assistencias;
	}
	public void setAssistencias(List<AssistenciaDTO> assistencias) {
		this.assistencias = assistencias;
	}
	public Integer getId_plano() {
		return id_plano;
	}
	public void setId_plano(Integer id_plano) {
		this.id_plano = id_plano;
	}
	public String getNome_plano() {
		return nome_plano;
	}
	public void setNome_plano(String nome_plano) {
		this.nome_plano = nome_plano;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
    
	
	
    public PlanoDTO(List<CoberturaDTO> coberturas, List<AssistenciaDTO> assistencias, Integer id_plano,
			String nome_plano, Double valor) {
		super();
		this.coberturas = coberturas;
		this.assistencias = assistencias;
		this.id_plano = id_plano;
		this.nome_plano = nome_plano;
		this.valor = valor;
	}
	public PlanoDTO(Plano plano) {    	
   
		this.coberturas = plano.getCoberturas().stream().map(x -> new CoberturaDTO(x)).collect(Collectors.toList()) ; ;
		this.assistencias = plano.getAssistencias().stream().map(x -> new AssistenciaDTO(x)).collect(Collectors.toList()) ;;
		this.id_plano = plano.getId();
		this.nome_plano = plano.getNome();
		this.valor = plano.getValor();
    	
    }
    
	 
	
	public PlanoDTO() {
		
		
	}
    
        
	
	

}
