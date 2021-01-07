package com.tpIntergiciel.kafka.springbootm2tnsiFi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

@SpringBootApplication
public class SpringbootM2tnsiFiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootM2tnsiFiApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		String command;
		Scanner sc = new Scanner(System.in);
		HttpURLCalls call = new HttpURLCalls();
		call.sendGet("/summary");
		while(true) {
			System.out.println("Entrez une commande");
			command = sc.nextLine();
			if (command.contains(" ")) {
				String[] commands = command.split(" ");
				call.sendPostWithParameter(commands[0], commands[1]);
			}
			else {
				call.sendPost(command);
			}
		}
	}

	@Scheduled(initialDelay = 1000, fixedDelay = 2000L)
	void someJob() throws Exception {
		//System.out.println("date :" + new Date());
		//HttpURLCalls call = new HttpURLCalls();
		//call.sendGet("/summary");
	}

	@Configuration
	@EnableScheduling
	@ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
	class SchedulingConfiguration {
	}

}