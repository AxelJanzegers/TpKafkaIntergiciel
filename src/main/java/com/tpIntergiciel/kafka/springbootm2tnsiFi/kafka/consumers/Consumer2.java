package com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.consumers;

import com.tpIntergiciel.kafka.springbootm2tnsiFi.HttpURLCalls;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.services.CountryService;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.services.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service
public class Consumer2 {

    @Autowired
    private CountryService countryService;
    @Autowired
    private GlobalService globalService;

    @KafkaListener(topics = "request_topic",groupId = "group_id")
    public void consumeMessage(String command) throws Exception {
        System.out.println(command);
        HttpURLCalls http = new HttpURLCalls();

        String commandTab[] = command.split(" ");

        switch (commandTab[0].toLowerCase()) {
            case "get_global_values" :
                http.sendGet(command);
                break;
            case "get_country_values":
                System.out.println(countryService.getCountry(commandTab[1]).toString());
                break;
            case "get_confirmed_avg":
                System.out.println("Average confirmed: "+globalService.averageConfirmed());
                break;
            case "get_deaths_avg":
                System.out.println("Average deaths: "+globalService.averageDeaths());
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
