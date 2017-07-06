package com.advfot.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the concurso database table.
 * 
 */
@Entity
@Table(name="concurso")
@NamedQuery(name="Concurso.findAll", query="SELECT c FROM Concurso c")
public class Concurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "login", unique = true, nullable = false, length = 45)
	private String login;

	@Column(name = "num_global_aciertos")
	private int numGlobalAciertos;

	@Column(name = "num_global_fot_ofrecidos")
	private int numGlobalFotOfrecidos;

	@Column(name = "por_aciertos_global")
	private int porAciertosGlobal;

	//bi-directional one-to-one association to Usuario
	@OneToOne
	@JoinColumn(name="login")
	private Usuario usuario;

	public Concurso() {
	}
	
	public Concurso(String login){
		this.login = login;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getNumGlobalAciertos() {
		return this.numGlobalAciertos;
	}

	public void setNumGlobalAciertos(int numGlobalAciertos) {
		this.numGlobalAciertos = numGlobalAciertos;
	}

	public int getNumGlobalFotOfrecidos() {
		return this.numGlobalFotOfrecidos;
	}

	public void setNumGlobalFotOfrecidos(int numGlobalFotOfrecidos) {
		this.numGlobalFotOfrecidos = numGlobalFotOfrecidos;
	}

	public int getPorAciertosGlobal() {
		return this.porAciertosGlobal;
	}

	public void setPorAciertosGlobal(int porAciertosGlobal) {
		this.porAciertosGlobal = porAciertosGlobal;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}