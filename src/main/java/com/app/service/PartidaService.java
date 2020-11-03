package com.app.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.app.model.Partida;
import com.app.repository.PartidaRepository;

@Service
public class PartidaService {
	private Boolean system = true;

	private final PartidaRepository partidaRepository;

	public PartidaService(PartidaRepository partidaRepository) {
		this.partidaRepository = partidaRepository;
	}

	public void inicialPartida(Scanner leitor) {
		while (system) {
			System.out.println("\n===Tabela Partida===\n");
			System.out.println("Qual acao voce quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Visualizar tabela");

			int action = leitor.nextInt();

			switch (action) {
			case 1:
				visualizarPartida();
				system = false;
				break;

			default:
				system = false;
				break;
			}
		}
	}

	// TABLE PARTIDA
	private void visualizarPartida() {
		Iterable<Partida> partidas = partidaRepository.findAll();
		partidas.forEach(partida -> System.out.println(partida));
	}

}
