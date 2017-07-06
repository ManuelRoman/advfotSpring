package com.advfot.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ranking database table.
 * 
 */
@Entity
@Table(name="ranking")
@NamedQueries({
	@NamedQuery(name="Ranking.findAllDesc", query="SELECT r FROM Ranking r order by r.puntos DESC"),
@NamedQuery(name="Ranking.findAll", query="SELECT r FROM Ranking r")})
public class Ranking implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String TODOS = "Ranking.findAll";

	@Id
	private String login;

	private int puntos;

	//bi-directional one-to-one association to Usuario
	@OneToOne
	@JoinColumn(name="login")
	private Usuario usuario;

	public Ranking() {
	}
	
	public Ranking(String login){
		this.login=login;
	}
	
	public Ranking(String login, int puntos){
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * Implementación del método equals
	 */
	@Override
	public boolean equals(Object objeto) {
		boolean iguales = false;
		if ((objeto instanceof Ranking) && (((Ranking) objeto).getLogin().equals(this.login))) {
			iguales = true;
		}
		return iguales;

	}

}