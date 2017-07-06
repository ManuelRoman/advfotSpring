package com.advfot.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.advfot.constantes.ConstantesVistas;
import com.advfot.model.DatosJuego;
import com.advfot.service.RespuestaService;

@Controller
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/respuestaController")
public class RespuestaController {
	
	private static final Log LOG = LogFactory.getLog(RespuestaController.class);
	
	@Autowired
	@Qualifier("respuestaServiceImpl")
	private RespuestaService respuestaService;
	
	@PostMapping("/responder")
	public ModelAndView muestraFotogramas(@RequestParam(name="opcionSeleccionada", required=true) String opcionSeleccionada, HttpServletRequest request){
		LOG.info("Respuesta seleccionada: " + opcionSeleccionada); 
		ModelAndView mav = new ModelAndView(ConstantesVistas.VISTA_RESPUESTA);
		if(respuestaService.compruebaRespuesta(opcionSeleccionada, request)){
			mav.addObject("acierto", 1);
		} else {
			mav.addObject("acierto", 0);
		}
		return mav;
	}

}
