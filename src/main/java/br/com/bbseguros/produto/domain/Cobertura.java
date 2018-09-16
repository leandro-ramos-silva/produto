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

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.bbseguros.produto.dto.CoberturaDTO;

@Entity
@Table(name = "cobertura")
public class Cobertura implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cobertura_id")
	private Integer id ;
	
	@Temporal(TemporalType.DATE)
	private Date dataInclusao;
	
	@Temporal(TemporalType.DATE)
	private Date dataAltercao;
	@JsonIgnore
	@ManyToMany(mappedBy="coberturas")
	private List<Plano> planos  = new ArrayList<>() ;
	
	
	public Cobertura(CoberturaDTO cob) {
		this.id = cob.getId() ;
		this.descricao = cob.getDescricao() ;
	}
	
	public List<Plano> getPlanos() {
		return planos;
	}
	public void setPlanos(List<Plano> planos) {
		this.planos = planos;
	}

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
	public Cobertura(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataAltercao = new Date() ;
		this.dataInclusao = new Date() ;
	}
	
	public Cobertura() {
		
	}
	
}
