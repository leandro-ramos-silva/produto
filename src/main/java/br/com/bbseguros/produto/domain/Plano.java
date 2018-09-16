package br.com.bbseguros.produto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "plano")
public class Plano implements Serializable {
 		
	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer id ;
	
	
	@ManyToMany
	@JoinTable(name="plano_cobertura", 
	joinColumns = @JoinColumn(name="plano_id"), 
	inverseJoinColumns = @JoinColumn(name = "cobertura_id") 	)
	private List<Cobertura> coberturas = new ArrayList<>();
	
	
	
	@ManyToMany
	@JoinTable(name="plano_assistencia", 
	joinColumns = @JoinColumn(name="plano_id"), 
	inverseJoinColumns = @JoinColumn(name = "assistencia_id") 	)
	private List<Assistencia> assistencias  = new ArrayList<>(); ;
	
	@JsonIgnore
	@ManyToMany(mappedBy="planos")	
	private List<Produto> produtos = new ArrayList<>();
	
	
	private String nome ;
    private Double valor ;
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Cobertura> getCoberturas() {
		return coberturas;
	}
	public void setCoberturas(List<Cobertura> coberturas) {
		this.coberturas = coberturas;
	}
	public List<Assistencia> getAssistencias() {
		return assistencias;
	}
	public void setAssistencias(List<Assistencia> assistencias) {
		this.assistencias = assistencias;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public Plano(Integer id, String nome, Double valor) {
		super();
		this.id = id;		
		this.nome = nome;
		this.valor = valor;
	}
	public Plano(){
		
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plano other = (Plano) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
    
    
 
 


}
