package com.tpIntergiciel.kafka.springbootm2tnsiFi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@SpringBootApplication
public class SpringbootM2tnsiFiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootM2tnsiFiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String command;
		while(true) {
			System.out.println("Entrez une commande");
			Scanner sc = new Scanner(System.in);
			command = sc.nextLine();
			HttpURLCalls call = new HttpURLCalls();
			switch (command.toLowerCase()) {
				case "get_global_values" :
					call.sendPost(command);
					break;
				case "get_country_values":
					break;
				case "get_confirmed_avg":
					break;
				case "get_deaths_avg":
					break;
				case "get_countries_deaths_percent":
					break;
				case "help":
					System.out.println(" -- COMMANDES -- :\n" +
							"- get_global_values : retourne les valeurs globales clés Global du fichier json\n" +
							"- get_coutry_values + v_pays : retourne les valeurs du pays demandé ou v_pays est une chaine de\n" +
							"caractère du pays demandé\n" +
							"- get_confirmed_avg : retourne une moyenne des cas confirmés sum(pays)/nb(pays)\n" +
							"- get_deaths_avg : retourne une moyenne des Décès sum(pays)/nb(pays)\n" +
							"- get_countries_deaths_percent : retourne le pourcentage de Décès par rapport aux cas confirmés\n");
					break;
				default:
					System.out.println("Cette commande n'existe pas");
					break;
			}
		}

	}
}