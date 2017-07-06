package com.advfot.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fotogramas database table.
 * 
 */
@Entity
@Table(name="fotogramas")
@NamedQueries({
@NamedQuery(name="Fotograma.findAll", query="SELECT f FROM Fotograma f"),
@NamedQuery(name="Fotograma.CountAll", query="SELECT COUNT(f) FROM Fotograma f"),
@NamedQuery(name="Fotograma.findAllId", query="SELECT f.idFotograma FROM Fotograma f order by f.idFotograma")})
public class Fotograma implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String BUSCAR_TODAS_IDS = "Fotograma.findAllId";
	public static final String CONTAR_FOTOGRAMAS = "Fotograma.CountAll";

	@Id
	@GeneratedValue
	@Column(name="id_fotograma", unique = true, nullable = false)
	private int idFotograma;

	@Column(name = "archivo", nullable = false)
	private String archivo;
	
	@Column(name = "tit_pelicula", nullable = false)
	private String titPelicula;
	
	@Column(name = "anyo_estreno", nullable = false)
	private int anyoEstreno;

	@Column(name = "director", nullable = false)
	private String director;

	//bi-directional many-to-one association to Genero
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="genero")
	private Genero generoBean;

	public Fotograma() {
	}

	public int getIdFotograma() {
		return this.idFotograma;
	}

	public void setIdFotograma(int idFotograma) {
		this.idFotograma = idFotograma;
	}

	public int getAnyoEstreno() {
		return this.anyoEstreno;
	}

	public void setAnyoEstreno(int anyoEstreno) {
		this.anyoEstreno = anyoEstreno;
	}

	public String getArchivo() {
		return this.archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getTitPelicula() {
		return this.titPelicula;
	}

	public void setTitPelicula(String titPelicula) {
		this.titPelicula = titPelicula;
	}

	public Genero getGeneroBean() {
		return this.generoBean;
	}

	public void setGeneroBean(Genero generoBean) {
		this.generoBean = generoBean;
	}

}