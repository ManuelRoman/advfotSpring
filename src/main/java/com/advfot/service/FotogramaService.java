package com.advfot.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.advfot.model.FotogramaModel;


public interface FotogramaService {
	
	public abstract List<String> listaFotPregunta(HttpServletRequest request);
	
	public abstract boolean existenFotogramas(HttpServletRequest request);

}
