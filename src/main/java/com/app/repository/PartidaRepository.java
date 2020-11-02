package com.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Partida;

@Repository
public interface PartidaRepository extends CrudRepository<Partida, Long>{

}
