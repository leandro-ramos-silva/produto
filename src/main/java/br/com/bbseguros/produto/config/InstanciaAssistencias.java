package br.com.bbseguros.produto.config;



import br.com.bbseguros.produto.domain.Assistencia;
import br.com.bbseguros.produto.repositories.AssistenciaRepository;

public class InstanciaAssistencias {
	
	
	public static void instanciaAssistencia(AssistenciaRepository assistenciaRepo) {	
		
		assistenciaRepo.save(new Assistencia(null,"ASSISTÊNCIA 24 HORAS") );
		assistenciaRepo.save(new Assistencia(null,"DESCONTO EM FARMACIA") );
		assistenciaRepo.save(new Assistencia(null,"ASSISTÊNCIA BB SEGURO VIDA MULHER") );
		assistenciaRepo.save(new Assistencia(null,"ASSISTÊNCIA BB SEGURO VIDA") );
		assistenciaRepo.save(new Assistencia(null,"SOS TOTAL - OURO RESIDENCIAL") );
		assistenciaRepo.save(new Assistencia(null,"SOS TOTAL - OURO EMPRESARIAL") );
		assistenciaRepo.save(new Assistencia(null,"ASSISTÊNCIA BANCO POPULAR - PLANO TITULAR") );
		assistenciaRepo.save(new Assistencia(null,"ASSISTÊNCIA BANCO POPULAR - PLANO FAMILIAR") );
		assistenciaRepo.save(new Assistencia(null,"HELP DESK") );
		assistenciaRepo.save(new Assistencia(null,"DESCONTO COMPRA INTERNET") );
		assistenciaRepo.save(new Assistencia(null,"VIAGEM") );
		assistenciaRepo.save(new Assistencia(null,"REDE DE CONVENIÊNCIA") );
		assistenciaRepo.save(new Assistencia(null,"VEÍCULOS") );
		assistenciaRepo.save(new Assistencia(null,"MOTORISTA AMIGO") );
		assistenciaRepo.save(new Assistencia(null,"RESIDENCIAL") );
		assistenciaRepo.save(new Assistencia(null,"FUNERAL") );
		assistenciaRepo.save(new Assistencia(null,"ESCOLAR") );
		assistenciaRepo.save(new Assistencia(null,"REDE DESCONTOS ESCOLAR") );
		assistenciaRepo.save(new Assistencia(null,"SABER 24 HORAS") );
		assistenciaRepo.save(new Assistencia(null,"SOS TOTAL - OURO RESIDENCIAL - ESTILO") );
		assistenciaRepo.save(new Assistencia(null,"PLANO COMPULSÓRIO CÔNJUGE") );
		assistenciaRepo.save(new Assistencia(null,"PLANO FACULTATIVO 1") );
		assistenciaRepo.save(new Assistencia(null,"PLANO FACULTATIVO 2") );
		assistenciaRepo.save(new Assistencia(null,"ASSISTÊNCIA EMPRESARIAL") );
		assistenciaRepo.save(new Assistencia(null,"ASSISTÊNCIA EMPRESARIAL-BNB") );
		assistenciaRepo.save(new Assistencia(null,"PLANO COMPULSÓRIO TITULAR") );
		assistenciaRepo.save(new Assistencia(null,"ASSISTÊNCIA RESIDENCIAL BÁSICA") );
		assistenciaRepo.save(new Assistencia(null,"ASSISTÊNCIA RESIDENCIAL COMPLETA") );
		assistenciaRepo.save(new Assistencia(null,"ASSISTÊNCIA RESIDENCIAL ESTILO COMPLETA") );
		assistenciaRepo.save(new Assistencia(null,"ASSISTÊNCIA RESIDENCIAL ESPECIAL CASA") );
		assistenciaRepo.save(new Assistencia(null,"ASSISTÊNCIA RESIDENCIAL ESPECIAL APTO") );
				
	}

}
