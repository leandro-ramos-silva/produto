package br.com.bbseguros.produto.resources.exception;

import java.io.Serializable;

import java.util.Date;

public class StandartError implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Integer status ;
	private String msg ;
	private Date  timeStamp ;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public StandartError(Integer status, String msg, Date data ){
		super();
		this.status = status;
		this.msg = msg;
		this.timeStamp = data ;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	

}
