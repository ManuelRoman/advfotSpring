package com.advfot.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.advfot.entity.Ranking;

@Repository("rankingRepository")
public interface RankingRepository extends JpaRepository<Ranking, Serializable>{
	
	public abstract List<Ranking> findAllDesc(Pageable pageable);
	
	public abstract Ranking findByLogin(String login);
	
}
