package com.app.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.app.model.Clube;
import com.app.repository.ClubeRepository;


@Service
public class ClubeService {
	private Boolean system = true;
	
	private final ClubeRepository clubeRepository;
	
	public ClubeService(ClubeRepository clubeRepository) {
		this.clubeRepository = clubeRepository;
	}

	public void inicial(Scanner leitor) {
		
			while (system) {
				System.out.println("\n===Tabela Clube===\n");
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
}
