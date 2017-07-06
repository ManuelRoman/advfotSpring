package com.advfot.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the generos database table.
 * 
 */
@Entity
@Table(name="generos")
@NamedQuery(name="Genero.findAll", query="SELECT g FROM Genero g")
public class Genero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="genero", unique = true, nullable = false)
	private String genero;

	//bi-directional many-to-one association to Fotograma
	@OneToMany(mappedBy="generoBean", fetch=FetchType.EAGER)
	private List<Fotograma> fotogramas;

	public Genero() {
	}

	public Genero(String genero) {
		super();
		this.genero = genero;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<Fotograma> getFotogramas() {
		return this.fotogramas;
	}

	public void setFotogramas(List<Fotograma> fotogramas) {
		this.fotogramas = fotogramas;
	}

	public Fotograma addFotograma(Fotograma fotograma) {
		getFotogramas().add(fotograma);
		fotograma.setGeneroBean(this);

		return fotograma;
	}

	public Fotograma removeFotograma(Fotograma fotograma) {
		getFotogramas().remove(fotograma);
		fotograma.setGeneroBean(null);

		return fotograma;
	}

}