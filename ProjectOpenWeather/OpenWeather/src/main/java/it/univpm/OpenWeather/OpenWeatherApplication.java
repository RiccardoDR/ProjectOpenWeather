package it.univpm.OpenWeather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe che si occupa di gestire e avviare tutti i componenti dell'applicazione.
 * @author De Ritis Riccardo
 * @author Dellisanti Francesco
 */

@SpringBootApplication
public class OpenWeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenWeatherApplication.class, args);
	}

}
