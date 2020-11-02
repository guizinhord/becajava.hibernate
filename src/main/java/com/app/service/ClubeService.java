package com.app.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.app.model.Clube;
import com.app.model.Partida;
import com.app.repository.ClubeRepository;
import com.app.repository.PartidaRepository;

@Service
public class ClubeService {

	private Boolean system = true;
	// Estancia dependencia interface crud
	private final ClubeRepository clubeRepository;
	private final PartidaRepository partidaRepository;

	// Construtor para Estancia dependencia interface crud
	public ClubeService(ClubeRepository clubeRepository, PartidaRepository partidaRepository) {
		this.clubeRepository = clubeRepository;
		this.partidaRepository = partidaRepository;
	}

	public void inicial(Scanner leitor) {
		System.out.println("Qual tabela: \n 1 - Clube \n 2 - Partida");
int opcao = leitor.nextInt();
		if (opcao == 1) {

			while (system) {
				System.out.println("===Tabela Clube===");
				System.out.println("0 - Sair");
				System.out.println("1 - Novo nome do Time");
				System.out.println("2 - Atualizar nome do Time");
				System.out.println("3 - Visualizar tabela");
				System.out.println("4 - Deletar registro");

				int action = leitor.nextInt();

				switch (action) {
				case 1:
					salvar(leitor);
					break;

				case 2:
					atualizar(leitor);
					break;

				case 3:
					visualizar();
					break;

				case 4:
					deletar(leitor);
					break;

				default:
					system = false;
					break;
				}
			}
			
		} else if (opcao == 2) {
			System.out.println("===Tabela Partida===");
			System.out.println("Qual acao voce quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Visualizar tabela");

			int action = leitor.nextInt();
			while (system) {
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
	}

	private void salvar(Scanner leitor) {
		System.out.println("Adicionar nome do time:");
		String nome = leitor.next();
		Clube clube = new Clube();
		clube.setNome(nome);
		clubeRepository.save(clube);
		System.out.println("Salvo! ");
	}

	private void atualizar(Scanner leitor) {
		System.out.println("Digite o Id: ");
		Long id = leitor.nextLong();
		System.out.println("Novo nome do time:");
		String nome = leitor.next();

		Clube clube = new Clube();
		clube.setId(id);
		clube.setNome(nome);
		clubeRepository.save(clube);
		System.out.println("Atualizado! ");
	}

	private void visualizar() {
		Iterable<Clube> clubes = clubeRepository.findAll();
		clubes.forEach(clube -> System.out.println(clube));
	}

	private void deletar(Scanner leitor) {
		System.out.println("Digite o Id: ");
		Long id = leitor.nextLong();
		clubeRepository.deleteById(id);
		System.out.println("Deletado! ");
	}

	// TABLE PARTIDA
	private void visualizarPartida() {
		Iterable<Partida> partidas = partidaRepository.findAll();
		partidas.forEach(partida -> System.out.println(partida));
	}
}
