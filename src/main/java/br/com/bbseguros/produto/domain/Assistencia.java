package br.com.bbseguros.produto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "assistencia")
public class Assistencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "assistencia_id")
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date dataInclusao;
	
	@Temporal(TemporalType.DATE)
	private Date dataAltercao;

	private String descricao;
	
	@ManyToMany(mappedBy="assistencias")
	private List<Plano> planos  = new ArrayList<>() ;
	
	
	public List<Plano> getPlanos() {
		return planos;
	}

	public void setPlanos(List<Plano> planos) {
		this.planos = planos;
	}

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

	public Assistencia(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Assistencia() {
		this.dataInclusao = new Date() ;
		this.dataAltercao = new Date() ;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
		
		
	}

	public Date getDataAltercao() {
		return dataAltercao;
	}

	public void setDataAltercao(Date dataAltercao) {
		this.dataAltercao = dataAltercao;
	}

	

	
	
}
