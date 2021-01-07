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
			if (command.contains(" ")) {
				String[] commands = command.split(" ");
				call.sendPostWithParameter(commands[0], commands[1]);
			}
			else {
				call.sendPost(command);
			}

		}

	}
}