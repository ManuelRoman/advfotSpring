package com.advfot.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.advfot.entity.Concurso;

@Repository("concursoRepository")
public interface ConcursoRepository extends JpaRepository<Concurso, Serializable>{
	
	public abstract Concurso findByLogin(String login);

}
