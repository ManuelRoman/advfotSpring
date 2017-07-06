package com.advfot.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.advfot.constantes.ConstantesVistas;
import com.advfot.util.Log4J2PropertiesConf;

@Controller
public class LoginController {
	
	private static final Log LOG = LogFactory.getLog(LoginController.class);

	/**
	 * Captura la petición de redirectToLogin()
	 * @return la vista login
	 */
	@GetMapping("/login")
	public String MuestraFormLogin(Model model, //añadimos el model de spring, para poder darle el objeto credenciales de usuario al formulario
			@RequestParam(name="error", required=false) String error, 
			@RequestParam(name="salir", required=false) String salir){ //parametro que puede llegarle
		LOG.info("Método: MuestraFormLogin() -- Parámetros: error=" +error + ", salir=" +salir);
		model.addAttribute("error", error);
		model.addAttribute("salir", salir);
		//model.addAttribute("credencialesUsuario", new CredencialesUsuario()); //Lo eliminamos para Spring Security
		LOG.info("Regresando a la vista login");
		Log4J2PropertiesConf log4J2PropertiesConf = new Log4J2PropertiesConf();
		log4J2PropertiesConf.performSomeTask();
		return ConstantesVistas.VISTA_LOGIN;
	}
	
	
	/**
	 * Se encarga del formulario login para autentificarse con Spring Security
	 * @return la vista de contactos
	 */
	@GetMapping({"/loginsuccess", "", "/"})
	public String loginCheck(){
		LOG.info("Método loginCheck()");
		LOG.info("Regresando al juego");
		return "redirect:/preguntaController/muestrafotogramas";
	}
	
}
