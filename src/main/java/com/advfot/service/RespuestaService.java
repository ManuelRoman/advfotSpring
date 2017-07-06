package com.advfot.service;

import javax.servlet.http.HttpServletRequest;

public interface RespuestaService {
	
	public abstract boolean compruebaRespuesta(String opcionSeleccionada, HttpServletRequest request);

}
