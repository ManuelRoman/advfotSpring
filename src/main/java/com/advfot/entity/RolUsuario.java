package com.advfot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

// TODO: Auto-generated Javadoc
/**
 * Clase que será usada por Spring Security.
 *
 * @author usuario
 */
@Entity
@Table(name = "roles_usuario", 
	uniqueConstraints = @UniqueConstraint(columnNames = {"rol", "login"}))
public class RolUsuario {
	
	/** The id rol usuario. */
	@Id
	@GeneratedValue
	@Column(name="id_rol_usuario", unique = true, nullable = false)
	private Integer idRolUsuario;
	
	/** The usuario. */
	//Varios roles pueden ser de un usuario
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "login", nullable = false)
	private Usuario usuario;
	
	/** The rol. */
	@Column(name="rol", nullable=false, length = 45)
	private String rol;

	/**
	 * Instantiates a new rol usuario.
	 *
	 * @param usuario the usuario
	 * @param rol the rol
	 */
	public RolUsuario(Usuario usuario, String rol) {
		super();
		this.usuario = usuario;
		this.rol = rol;
	}
	
	/**
	 * Instantiates a new rol usuario.
	 */
	public RolUsuario(){
		
	}

	/**
	 * Gets the id rol usuario.
	 *
	 * @return the id rol usuario
	 */
	public Integer getIdRolUsuario() {
		return idRolUsuario;
	}

	/**
	 * Sets the id rol usuario.
	 *
	 * @param idRolUsuario the new id rol usuario
	 */
	public void setIdRolUsuario(Integer idRolUsuario) {
		this.idRolUsuario = idRolUsuario;
	}

	/**
	 * Gets the usuario.
	 *
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Sets the usuario.
	 *
	 * @param usuario the new usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Gets the rol.
	 *
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * Sets the rol.
	 *
	 * @param rol the new rol
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
	
}
