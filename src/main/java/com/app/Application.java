package com.app;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.service.ClubeService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private final ClubeService clubeService;

	private Boolean system = true;

	public Application(ClubeService clubeService) {
		this.clubeService = clubeService;

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// Aqui salvo meu INSERT NO BANCO DE DADOS
	@Override
	public void run(String... args) throws Exception {
		Scanner leitor = new Scanner(System.in);

		while (system) {
			System.out.println("Qaul acao voce quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Nome do Time");

			int action = leitor.nextInt();
			if (action == 1) {
				clubeService.inicial(leitor);
			} else {
				system = false;
			}
		}

	}

}
