package com.advfot.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.advfot.constantes.ConstantesVistas;
import com.advfot.model.DatosJuego;

@Controller
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/estadisticasController")
public class EstadisticasController {
	
	@GetMapping("/ver")
	public ModelAndView muestraFotogramas(HttpServletRequest request){
		ModelAndView mav = new ModelAndView(ConstantesVistas.VISTA_ESTADISTICAS);
		DatosJuego datosJuego = (DatosJuego) request.getSession().getAttribute("datosJuego");
		mav.addObject("datosJuego", datosJuego);
		return mav;
	}

}
