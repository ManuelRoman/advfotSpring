package com.advfot.model;


public class RankingModel {
	
	private String login;

	private int puntos;

	public RankingModel() {
	}
	
	public RankingModel(String login, int puntos){
		this.login=login;
		this.puntos=puntos;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getPuntos() {
		return this.puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
}
