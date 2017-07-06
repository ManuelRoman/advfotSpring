package com.advfot.converter;

import org.springframework.stereotype.Component;

import com.advfot.entity.Fotograma;
import com.advfot.entity.Genero;
import com.advfot.model.FotogramaModel;

@Component("fotogramaConverter")
public class FotogramaConverter {
	
	public Fotograma ModelToFotograma(FotogramaModel fotogramaModel){
		Fotograma fotograma = new Fotograma();
		fotograma.setAnyoEstreno(fotogramaModel.getAnyoEstreno());
		fotograma.setArchivo(fotogramaModel.getArchivo());
		fotograma.setDirector(fotogramaModel.getDirector());
		fotograma.setIdFotograma(fotogramaModel.getIdFotograma());
		fotograma.setTitPelicula(fotogramaModel.getTitPelicula());
		fotograma.setGeneroBean(new Genero(fotogramaModel.getGenero()));
		return fotograma;
	}

	public FotogramaModel fotogramaToFotogramaModel(Fotograma fotograma){
		FotogramaModel fotogramaModel = new FotogramaModel();
		fotogramaModel.setAnyoEstreno(fotograma.getAnyoEstreno());
		fotogramaModel.setArchivo(fotograma.getArchivo());
		fotogramaModel.setDirector(fotograma.getDirector());
		fotogramaModel.setIdFotograma(fotograma.getIdFotograma());
		fotogramaModel.setTitPelicula(fotograma.getTitPelicula());
		fotogramaModel.setGenero(fotograma.getGeneroBean().getGenero());;
		return fotogramaModel;
	}

}
