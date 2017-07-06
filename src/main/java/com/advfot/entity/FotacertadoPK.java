package com.advfot.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the fotacertados database table.
 * 
 */
@Embeddable
public class FotacertadoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String login;

	private int idFotograma;

	public FotacertadoPK() {
	}
	
	public FotacertadoPK(String login) {
		this.login = login;
	}
	
	public FotacertadoPK(String login, int idFotograma) {
		this.login = login;
		this.idFotograma = idFotograma;
	}
	
	public String getLogin() {
		return this.login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getIdFotograma() {
		return this.idFotograma;
	}
	public void setIdFotograma(int idFotograma) {
		this.idFotograma = idFotograma;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FotacertadoPK)) {
			return false;
		}
		FotacertadoPK castOther = (FotacertadoPK)other;
		return 
			this.login.equals(castOther.login);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.login.hashCode();
		hash = hash * prime + this.idFotograma;
		
		return hash;
	}
}