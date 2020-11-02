package com.app;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.service.ClubeService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private final ClubeService clubeService;
	// Contrutor para chamar meu service
	public Application(ClubeService clubeService) {
		this.clubeService = clubeService;

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// Aqui salvo meu INSERT NO BANCO DE DADOS "Chamando meu service"
	@Override
	public void run(String... args) throws Exception {
		Scanner leitor = new Scanner(System.in);

		clubeService.inicial(leitor);

	}
}
