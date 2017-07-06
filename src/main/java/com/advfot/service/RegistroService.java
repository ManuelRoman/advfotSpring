package com.advfot.service;


public interface RegistroService {
	
	public abstract boolean existeLogin(String login);
	
	public abstract boolean addUsuario(String login, String clave);

}
