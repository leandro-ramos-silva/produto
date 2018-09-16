package br.com.bbseguros.produto.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.bbseguros.produto.domain.Assistencia;
import br.com.bbseguros.produto.domain.Cobertura;
import br.com.bbseguros.produto.domain.Plano;
import br.com.bbseguros.produto.domain.Produto;
import br.com.bbseguros.produto.repositories.AssistenciaRepository;
import br.com.bbseguros.produto.repositories.CoberturaRepository;
import br.com.bbseguros.produto.repositories.PlanoRepository;
import br.com.bbseguros.produto.repositories.ProdutoRepository;

@Configuration
public class Instantiation implements CommandLineRunner  {

	//criar assitencias
	
	@Autowired
	AssistenciaRepository assistenciaRepo ;
	
	
	@Autowired
	CoberturaRepository coberturaRepo ;
	
	
	@Autowired
	PlanoRepository planoRepo ;
	
	@Autowired
	ProdutoRepository produtoRepo ;
	
	@Override
	public void run(String... args) throws Exception {
		
		assistenciaRepo.deleteAll(); 
	/*	System.out.println("####intanciando banco######");
		
		
		System.out.println("#### inicio popular Coberturas######");
		InstanciaCobertura.instanciaCobertura(coberturaRepo);
		System.out.println("#### fim popular Coberturas######");		
		
		System.out.println("####inicio  popular Assistencias######");
		InstanciaAssistencias.instanciaAssistencia(assistenciaRepo) ;
		System.out.println("#### fim  popular Assistencias######");
		
		System.out.println("####inicio  popular Plano######");
		InstanciaPlanos.instanciaPlano(planoRepo) ;
		System.out.println("#### fim  popular Plano######");
		
		
	*/
		
		Assistencia assistencia1  = new Assistencia(null,"ASSISTÊNCIA 24 HORAS") ;
		Assistencia assistencia2  = new Assistencia(null,"DESCONTO EM FARMACIA") ;
		Assistencia assistencia3  = new Assistencia(null,"ASSISTÊNCIA BB SEGURO VIDA MULHER") ;
		Assistencia assistencia4  = new Assistencia(null,"ASSISTÊNCIA BB SEGURO VIDA") ;
		Assistencia assistencia5  = new Assistencia(null,"SOS TOTAL - OURO RESIDENCIAL") ;
		assistenciaRepo.saveAll(Arrays.asList(assistencia1,assistencia2,assistencia3,
				assistencia4,assistencia5));
		
		Cobertura cob1 = new Cobertura(null,"COBERTURA GENERICA PARA SINISTRO") ;
		Cobertura cob2 = new Cobertura(null,"INDENIZAÇAO ESPECIAL POR ACIDENTE - IEA") ;
		Cobertura cob3 = new Cobertura(null,"INVALIDEZ PERMANENTE TOTAL OU PARCIAL POR ACIDENTE - IPA") ;
		
		coberturaRepo.saveAll(Arrays.asList(cob1,cob2,cob3));
		Plano plano1 = new Plano(null, "completo", 15.00) ;
		Plano plano2 = new Plano(null, "basico", 9.00) ;
		
		plano1.getAssistencias().addAll(Arrays.asList(assistencia1,assistencia5)) ;
		plano2.getAssistencias().addAll(Arrays.asList(assistencia1,assistencia2,
				assistencia3,assistencia4,assistencia5)) ;
		
		
		plano1.getCoberturas().addAll(Arrays.asList(cob1,cob2,cob3)) ;		
		plano2.getCoberturas().addAll(Arrays.asList(cob1)) ;
		
		
		planoRepo.saveAll(Arrays.asList(plano1,plano2));
		
		
		Produto prod1 = new Produto(null,"vidinha",12,"vida") ;
		
		prod1.getPlano().addAll(Arrays.asList(plano1,plano2)) ;
		
		produtoRepo.saveAll(Arrays.asList(prod1));
		
	
		//Plano plano1 = new Plano(null, listCob, listAssis, "basico", 9.90) ;
		
		//plano1.setId(planoRepo.save(plano1).getId()) ;
		
		//List<Plano> listPlan = Arrays.asList(plano1) ;
	//	Produto produto1 = new Produto(null,"nome",12,listPlan,"vida");
	//	System.out.println("### Produto criado:"+ produtoRepo.save(produto1).getId()) ;
		
		
		
		
	}
	
}
