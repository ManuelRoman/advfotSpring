package com.advfot.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.advfot.constantes.ConstantesVistas;
import com.advfot.service.RegistroService;


@Controller
@PreAuthorize("permitAll()")
//@RequestMapping("/registro")
public class RegistroController {
	
	private static final Log LOG = LogFactory.getLog(RegistroController.class);
	
	private static Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	@Qualifier("registroServiceImpl")
	private RegistroService registroService;
	
	@PostMapping("/compruebalogin")
	public String compruebaLogin(@RequestParam(name="login", required=true) String login, Model model){
		LOG.info("Método compruebalogin() -- Parámetros: " + login);
		if(existeLogin(login)){
			model.addAttribute("existe", 1);
		} else {
			model.addAttribute("existe", 0);
		}
		LOGGER.info("Comprobando login: " + login);
		return ConstantesVistas.VISTA_LOGIN;
	}
	
	@PostMapping("/compruebalogin2")
	public String compruebaLogin2(@RequestParam(name="login", required=true) String login, Model model){
		LOG.info("Método compruebalogin2() -- Parámetros: " + login);
		boolean existe = false;
		existe = registroService.existeLogin(login);
		if(existe){
			model.addAttribute("existe", 1);
		} else {
			model.addAttribute("existe", 0);
		}
		return ConstantesVistas.VISTA_LOGIN;
	}
	
	@PostMapping("/addUsuario")
	public ModelAndView addUsuario(@RequestParam(name="login", required=true) String login,
			@RequestParam(name="clave", required=true) String clave){
		LOG.info("Método addUsuario() -- Parámetros: " + login + ", " + clave);
		ModelAndView mav = new ModelAndView(ConstantesVistas.VISTA_LOGIN);
		if(existeLogin(login)){
			mav.addObject("existe", 1);
		} else {
			if(registroService.addUsuario(login, clave)){
				mav.addObject("registro", 1);
			} else {
				mav.addObject("registro", 0);
			}
		}
		return mav;
		//return "redirect:/contactos/muestracontactos";
	}
	
	private boolean existeLogin(String login){
		boolean existe = false;
		existe = registroService.existeLogin(login);
		if(existe){
			existe = true;
		}
		return existe;
	}

}
