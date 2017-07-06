package com.advfot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.advfot.converter.RankingConverter;
import com.advfot.entity.Ranking;
import com.advfot.model.RankingModel;
import com.advfot.repository.RankingRepository;
import com.advfot.service.RankingService;

@Service("rankingServiceImpl")
public class RankingServiceImpl implements RankingService{
	
	private static Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	@Qualifier("rankingRepository")
	private RankingRepository rankingRepository;
	
	@Autowired
	@Qualifier("rankingConverter")
	private RankingConverter rankingConverter;

	@Override
	public List<RankingModel> listaRanking10() {
		List<Ranking> listaRanking = new ArrayList<Ranking>();
		Pageable topTen = new PageRequest(0, 10);
		listaRanking = rankingRepository.findAllDesc(topTen);
		List<RankingModel> listaRankingModel = new ArrayList<RankingModel>();
		for(Ranking ranking : listaRanking){
			listaRankingModel.add(rankingConverter.EntityToModel(ranking));
		}
		LOGGER.info("Prueba de log4j en rankingServiceImpl");
		return listaRankingModel;
	}

}
