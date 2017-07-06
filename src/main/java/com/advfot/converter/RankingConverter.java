package com.advfot.converter;

import org.springframework.stereotype.Component;

import com.advfot.entity.Ranking;
import com.advfot.model.RankingModel;

@Component("rankingConverter")
public class RankingConverter {
	
	public Ranking ModelToEntity(RankingModel rankingModel){
		Ranking ranking = new Ranking();
		ranking.setLogin(rankingModel.getLogin());
		ranking.setPuntos(rankingModel.getPuntos());
		return ranking;
	}

	public RankingModel EntityToModel(Ranking ranking){
		RankingModel rankingModel = new RankingModel();
		rankingModel.setLogin(ranking.getLogin());
		rankingModel.setPuntos(ranking.getPuntos());
		return rankingModel;
	}

}
