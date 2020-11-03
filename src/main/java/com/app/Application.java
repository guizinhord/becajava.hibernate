package com.app;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.service.ClubeService;
import com.app.service.PartidaService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private final ClubeService clubeService;
	private final PartidaService partidaService;
	
	public Application(ClubeService clubeService,PartidaService partidaService ) {
		this.clubeService = clubeService;
		this.partidaService = partidaService;

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner leitor = new Scanner(System.in);

		clubeService.inicial(leitor);
		partidaService.inicialPartida(leitor);
		
		System.out.println("\nFim!");

	}
}
