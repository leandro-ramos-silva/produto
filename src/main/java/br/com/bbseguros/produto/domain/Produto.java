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

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id ;
	
	private String nome ;
	private Integer parcelas ;
	
	@ManyToMany
	@JoinTable(name="produto_plano", 
		joinColumns = @JoinColumn(name="produto_id"), 
		inverseJoinColumns = @JoinColumn(name = "plano_id")
	)	
	private List<Plano> planos  = new ArrayList<>() ;
	
	
	public List<Plano> getPlano() {
		return planos ;
	}
	public void setPlano(List<Plano> planos) {
		this.planos = planos;
	}


	private String ramoEmissao ;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getParcelas() {
		return parcelas;
	}
	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}
	
	public String getRamoEmissao() {
		return ramoEmissao;
	}
	public void setRamoEmissao(String ramoEmissao) {
		this.ramoEmissao = ramoEmissao;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Produto(Integer id, String nome, Integer parcelas,  String ramoEmissao) {
		super();
		this.id = id;
		this.nome = nome;
		this.parcelas = parcelas;		
		this.ramoEmissao = ramoEmissao;
	}
	
	
	public Produto() {
		
		
	}	
	
	

}
