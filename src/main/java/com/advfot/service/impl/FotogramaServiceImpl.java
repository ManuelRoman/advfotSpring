package com.advfot.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.advfot.controller.PreguntaController;
import com.advfot.converter.ConcursoConverter;
import com.advfot.converter.FotogramaConverter;
import com.advfot.entity.Concurso;
import com.advfot.entity.Fotograma;
import com.advfot.model.DatosJuego;
import com.advfot.model.FotogramaModel;
import com.advfot.repository.ConcursoRepository;
import com.advfot.repository.FotogramaRepository;
import com.advfot.repository.RankingRepository;
import com.advfot.service.FotogramaService;

@Service("fotogramaServiceImpl")
public class FotogramaServiceImpl implements FotogramaService{
	
	private static final Log LOG = LogFactory.getLog(FotogramaServiceImpl.class);
	
	//private HttpServletRequest request;
	
	//private DatosJuego datosJuego;

	@Autowired
	@Qualifier("fotogramaRepository")
	private FotogramaRepository fotogramaRepository;
	
	@Autowired
	@Qualifier("fotogramaConverter")
	private FotogramaConverter fotogramaConverter;
	
	@Autowired
	@Qualifier("concursoRepository")
	private ConcursoRepository concursoRepository;
	
	@Autowired
	@Qualifier("concursoConverter")
	private ConcursoConverter concursoConverter;
	
	@Autowired
	@Qualifier("rankingRepository")
	private RankingRepository rankingRepository;
	
	@Override
	public List<String> listaFotPregunta(HttpServletRequest request) {
		//this.request = request;
		DatosJuego datosJuego = (DatosJuego) request.getSession().getAttribute("datosJuego");
		List<Integer> listaIdFotTotales = (List<Integer>) request.getSession().getAttribute("listaIdFoTotales");
		List<Integer> listaIdFotPreguntar = (List<Integer>) request.getSession().getAttribute("listaIdFotPreguntar");
		List<String> listaFot = new ArrayList<String>();
		Random random = new Random();
		if (listaIdFotTotales == null){
			LOG.info("Accediendo a bbdd para obtener todos los id");
			listaIdFotTotales = fotogramaRepository.findAllId();
			listaIdFotPreguntar = fotogramaRepository.findAllId();
			request.getSession().setAttribute("listaIdFoTotales", listaIdFotTotales);
			request.getSession().setAttribute("listaIdFotPreguntar", listaIdFotPreguntar);
			datosJuego = incializaDatosJuego();
			request.getSession().setAttribute("datosJuego", datosJuego);
		}
		Collections.shuffle(listaIdFotPreguntar);
		int idFotSelec = (listaIdFotPreguntar.get(0));
		LOG.info("Id del fotograma seleccionado: " + idFotSelec);
		Fotograma fotogramaSelec = fotogramaRepository.findByIdFotograma(idFotSelec);
		listaIdFotPreguntar.remove(0);
		datosJuego.setNumFotOfrecidosSesion(1);
		LOG.info("Fotogramas que quedan");
		for (int i: listaIdFotPreguntar){
			LOG.info(i);
		}
		String titFotSelec = fotogramaConverter.fotogramaToFotogramaModel(fotogramaSelec).getTitPelicula();
		request.getSession().setAttribute("titFotSelec", titFotSelec);
		listaFot.add(titFotSelec);
		int resp1;
		do {
			//int randomNum = random.nextInt((max - min) + 1) + min;
			resp1 = random.nextInt((listaIdFotTotales.size() - 1) + 1) + 1;
		} while (resp1 == idFotSelec);
		FotogramaModel fotogramaModel = fotogramaConverter.fotogramaToFotogramaModel(fotogramaRepository.findByIdFotograma(resp1));
		listaFot.add(fotogramaModel.getTitPelicula());
		int resp2;
		do {
			resp2 = random.nextInt((listaIdFotTotales.size() - 1) + 1) + 1;
		} while ( resp2 == idFotSelec || resp2 == resp1);
		FotogramaModel fotogramaModel2 = fotogramaConverter.fotogramaToFotogramaModel(fotogramaRepository.findByIdFotograma(resp2));
		listaFot.add(fotogramaModel2.getTitPelicula());
		Collections.shuffle(listaFot);
		listaFot.add(fotogramaConverter.fotogramaToFotogramaModel(fotogramaSelec).getArchivo());
		return listaFot;
	}

	@Override
	public boolean existenFotogramas(HttpServletRequest request) {
		boolean existe = true;
		List<Integer> listaIdFot = (List<Integer>) request.getSession().getAttribute("listaIdFotPreguntar");
		if(listaIdFot != null){
			if(listaIdFot.size() == 0){
				existe = false;
			}
			LOG.info("Cantidad de fotogramas: " + listaIdFot.size());
		}
		LOG.info("Existen fotogramas: " + existe);
		return existe;
	}
	
	private DatosJuego incializaDatosJuego(){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Concurso concurso = concursoRepository.findByLogin(user.getUsername());
		DatosJuego datosJuego = concursoConverter.EntityToModel(concurso);
		datosJuego.setPuntosGlobales(rankingRepository.findByLogin(user.getUsername()).getPuntos());
		return datosJuego;
	}

}
