package br.com.bbseguros.produto.services.exception;

import java.io.Serializable;
import java.security.Timestamp;
import java.sql.Time;

public class StandartError implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Integer status ;
	private String msg ;
	private Timestamp timeStamp ;
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
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	public StandartError(Integer status, String msg, Timestamp timeStamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStamp = timeStamp ;
	}
	
	
	

}
