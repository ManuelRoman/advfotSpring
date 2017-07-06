package com.advfot.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fotacertados database table.
 * 
 */
@Entity
@Table(name="fotacertados")
@NamedQuery(name="Fotacertado.findAll", query="SELECT f FROM Fotacertado f")
public class Fotacertado implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FotacertadoPK id;

	//@Column(name="acertado", columnDefinition="byte default '1'")
	private byte acertado;

	public Fotacertado() {
	}
	
	public Fotacertado(FotacertadoPK id) {
		this.id = id;
	}
	
	public Fotacertado(FotacertadoPK id, byte acertado) {
		this.id = id;
		this.acertado = acertado;
	}

	public FotacertadoPK getId() {
		return this.id;
	}

	public void setId(FotacertadoPK id) {
		this.id = id;
	}
	
	public byte getAcertado() {
		return this.acertado;
	}

	public void setAcertado(byte acertado) {
		this.acertado = acertado;
	}

}