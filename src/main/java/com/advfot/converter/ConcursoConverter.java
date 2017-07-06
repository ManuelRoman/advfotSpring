package com.advfot.converter;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.advfot.entity.Concurso;
import com.advfot.model.DatosJuego;


@Component("concursoConverter")
public class ConcursoConverter {
	
		
	public Concurso ModelToEntity(DatosJuego datosJuego){
		Concurso concurso = new Concurso();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		concurso.setLogin(user.getUsername());
		concurso.setNumGlobalAciertos(datosJuego.getNumGlobalAciertos());
		concurso.setNumGlobalFotOfrecidos(datosJuego.getNumGlobalFotOfrecidos());
		//concurso.setPorAciertosGlobal(datosJuego.getPorAciertosGlobal());
		return concurso;
	}

	public DatosJuego EntityToModel(Concurso concurso){
		DatosJuego datosJuego = new DatosJuego();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		datosJuego.setLogin(user.getUsername());
		datosJuego.setNumGlobalAciertos(concurso.getNumGlobalAciertos());
		datosJuego.setNumGlobalFotOfrecidos(concurso.getNumGlobalFotOfrecidos());
		//datosJuego.setPorAciertosGlobal(concurso.getPorAciertosGlobal());
		return datosJuego;
	}

}
