package com.advfot.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.advfot.entity.RolUsuario;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "login", unique = true, nullable = false, length = 45)
	private String login;

	@Column(name = "clave", nullable = false, length = 60)
	private String clave;
	
	@Column(name = "activo", nullable = false)
	private boolean activo;
	
	// Un usuario podrá tener muchos roles 
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "usuario", cascade=CascadeType.ALL)
	private Set<RolUsuario> rolUsuario = new HashSet<RolUsuario>();

	//bi-directional one-to-one association to Concurso
	@OneToOne(mappedBy="usuario", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="login", insertable=true, updatable=true)
	private Concurso concurso;

	//bi-directional one-to-one association to Ranking
	@OneToOne(mappedBy="usuario", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="login", insertable=true, updatable=true)
	private Ranking ranking;

	public Usuario() {
	}
	
	public Usuario(String login, String clave, boolean activo) {
		super();
		this.login = login;
		this.clave = clave;
		this.activo = activo;
	}

	public Usuario(String login, String clave, boolean activo, Set<RolUsuario> rolUsuario) {
		super();
		this.login = login;
		this.clave = clave;
		this.activo = activo;
		this.rolUsuario = rolUsuario;
	}
	
	public Usuario(String login, String clave) {
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<RolUsuario> getRolUsuario() {
		return rolUsuario;
	}

	public void setRolUsuario(Set<RolUsuario> rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	public Concurso getConcurso() {
		return concurso;
	}

	public void setConcurso(Concurso concurso) {
		this.concurso = concurso;
	}

	public Ranking getRanking() {
		return ranking;
	}

	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
	}

}