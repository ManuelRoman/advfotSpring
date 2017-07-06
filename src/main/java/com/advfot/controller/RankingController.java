package com.advfot.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.advfot.constantes.ConstantesVistas;
import com.advfot.model.RankingModel;
import com.advfot.service.RankingService;

@Controller
//@RequestMapping("/ranking")
public class RankingController {
	
	private static final Log LOG = LogFactory.getLog(RankingController.class);
	
	@Autowired
	@Qualifier("rankingServiceImpl") 
	private RankingService rankingService;
	
	@PreAuthorize("permitAll()")
	@GetMapping("/verranking")
	public ModelAndView muestraFotogramas(){
		ModelAndView mav = new ModelAndView(ConstantesVistas.VISTA_RANKING);
		LOG.info("Accediendo al ranking");
		List<RankingModel> listaRanking10 = rankingService.listaRanking10();
		mav.addObject("listaRanking", listaRanking10);
		return mav;
	}

}
