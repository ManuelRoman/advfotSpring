package com.advfot.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.advfot.controller.RespuestaController;
import com.advfot.converter.ConcursoConverter;
import com.advfot.entity.Concurso;
import com.advfot.entity.Ranking;
import com.advfot.model.DatosJuego;
import com.advfot.repository.ConcursoRepository;
import com.advfot.repository.RankingRepository;
import com.advfot.service.RespuestaService;

@Service("respuestaServiceImpl")
public class RespuestaServiceImpl implements RespuestaService{
	
	private static final Log LOG = LogFactory.getLog(RespuestaServiceImpl.class);
	
	@Autowired
	@Qualifier("concursoRepository")
	private ConcursoRepository concursoRepository;
	
	@Autowired
	@Qualifier("concursoConverter")
	private ConcursoConverter concursoConverter;
	
	@Autowired
	@Qualifier("rankingRepository")
	private RankingRepository rankingRepository;

	private DatosJuego datosJuego;
	
	@Override
	public boolean compruebaRespuesta(String opcionSeleccionada, HttpServletRequest request) {
		String titFotSelec = (String) request.getSession().getAttribute("titFotSelec");
		datosJuego = (DatosJuego) request.getSession().getAttribute("datosJuego");
		boolean acierto = false;
		if(titFotSelec.equals(opcionSeleccionada)){
			acierto = true;
			datosJuego.setNumAciertosSesion(1);
			datosJuego.setPuntosSesion(2);
		}
		Concurso concurso = concursoConverter.ModelToEntity(datosJuego);
		concursoRepository.save(concurso);
		rankingRepository.save(new Ranking(datosJuego.getLogin(), datosJuego.getPuntosGlobales()));
		LOG.info(datosJuego);
		return acierto;
	}

}
