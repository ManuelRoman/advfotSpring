package com.advfot.model;


public class FotogramaModel {
	
	private int idFotograma;

	private String archivo;
	
	private String titPelicula;
	
	private int anyoEstreno;

	private String director;

	private String genero;

	public FotogramaModel(int idFotograma, String archivo, String titPelicula, int anyoEstreno, String director,
			String genero) {
		super();
		this.idFotograma = idFotograma;
		this.archivo = archivo;
		this.titPelicula = titPelicula;
		this.anyoEstreno = anyoEstreno;
		this.director = director;
		this.genero = genero;
	}
	
	public FotogramaModel(){
		
	}

	public int getIdFotograma() {
		return idFotograma;
	}

	public void setIdFotograma(int idFotograma) {
		this.idFotograma = idFotograma;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getTitPelicula() {
		return titPelicula;
	}

	public void setTitPelicula(String titPelicula) {
		this.titPelicula = titPelicula;
	}

	public int getAnyoEstreno() {
		return anyoEstreno;
	}

	public void setAnyoEstreno(int anyoEstreno) {
		this.anyoEstreno = anyoEstreno;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "FotogramaModel [idFotograma=" + idFotograma + ", archivo=" + archivo + ", titPelicula=" + titPelicula
				+ ", anyoEstreno=" + anyoEstreno + ", director=" + director + ", genero=" + genero + "]";
	}

}
