package com.app.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.app.model.Clube;
import com.app.repository.ClubeRepository;

@Service
public class ClubeService {
	
	private final ClubeRepository clubeRepository;
	
	public ClubeService(ClubeRepository clubeRepository) {
		this.clubeRepository = clubeRepository;
	}
	
	public void inicial(Scanner leitor) {
		salvar(leitor);
	}
	
	private void salvar(Scanner leitor) {
		System.out.println("Nome do time");
		String nome = leitor.next();
		Clube clube = new Clube();
		clube.setNome(nome);
		clubeRepository.save(clube);
		System.out.println("Salvo");
	}
}
