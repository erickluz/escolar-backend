package com.erick.escolar.resource.exceptions;

public class StandardError {
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String msg;
	private String instante;

	public StandardError(Integer status, String msg, String instante) {
		super();
		this.status = status;
		this.msg = msg;
		this.instante = instante;
	}

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

	public String getInstante() {
		return this.instante;
	}

	public void setInstante(String instante) {
		this.instante = instante;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
