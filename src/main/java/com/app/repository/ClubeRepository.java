package com.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Clube;

@Repository
public interface ClubeRepository extends CrudRepository <Clube, Long> {
	
	
}
