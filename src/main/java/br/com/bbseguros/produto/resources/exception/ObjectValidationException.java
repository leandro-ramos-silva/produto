package br.com.bbseguros.produto.resources.exception;

public class ObjectValidationException  extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ObjectValidationException(String msg) {
		
		super(msg) ;
		
	}
	

}
