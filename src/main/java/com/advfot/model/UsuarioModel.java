package com.advfot.model;


public class UsuarioModel {
	
	private String login;

	private String clave;

	public UsuarioModel() {

	}

	public UsuarioModel(String login, String clave) {
		super();
		this.login = login;
		this.clave = clave;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
}
