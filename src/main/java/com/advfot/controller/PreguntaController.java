package com.advfot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.advfot.constantes.ConstantesVistas;
import com.advfot.model.FotogramaModel;
import com.advfot.service.FotogramaService;

@Controller
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/preguntaController")
public class PreguntaController {
	
	private static final Log LOG = LogFactory.getLog(PreguntaController.class);
	
	private static Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	@Qualifier("fotogramaServiceImpl")
	private FotogramaService fotogramaService; 
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/admintest")
	public String adminTest(Model model){
		LOG.info("Método: adminTest()");
		model.addAttribute("nombre", "valor");
		return ConstantesVistas.VISTA_RANKING;
	}
	
	@GetMapping("/muestrafotogramas")
	public ModelAndView muestraFotogramas(HttpServletRequest request){
		ModelAndView mav = new ModelAndView(ConstantesVistas.VISTA_PREGUNTA);
		//Obtenemos el usuario de la sesión .getPrincipal() -> es el usuario actual de la sesión
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("loginUsuario", user.getUsername());
		if(fotogramaService.existenFotogramas(request)){
			List<String> listaFotogramas = fotogramaService.listaFotPregunta(request);
			mav.addObject("listaFotogramas", listaFotogramas);
			mav.addObject("sinFotogramas", 0);
		} else {
			mav.addObject("sinFotogramas", 1);
		}
		LOGGER.info("Preba de log4j en muestrafotogramas");
		return mav;
	}

}
