package com.advfot.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.advfot.entity.Fotograma;

@Repository("fotogramaRepository")
public interface FotogramaRepository extends JpaRepository<Fotograma, Serializable>{
	
	public abstract List<Integer> findAllId();
	
	public abstract Fotograma findByIdFotograma(int id);

}
