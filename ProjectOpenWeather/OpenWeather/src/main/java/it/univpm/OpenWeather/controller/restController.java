package it.univpm.OpenWeather.controller;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import it.univpm.OpenWeather.exception.InvalidBodyException;
import it.univpm.OpenWeather.filters.Filters;
import it.univpm.OpenWeather.model.RequestBodyClass;
import it.univpm.OpenWeather.model.WeatherClass;
import it.univpm.OpenWeather.service.OpenWeather;
import it.univpm.OpenWeather.statistics.Statistics;
import it.univpm.OpenWeather.variances.Variances;

/**
 * Rappresenta la classe che gestisce tutte le chiamate al server
 * @author De Ritis Riccardo
 * @author Dellisanti Francesco
 */

@RestController
public class restController {
	
	@Autowired
	OpenWeather weather;
	@Autowired
	Variances variance;
	@Autowired
	Filters filters;
	@Autowired
	Statistics stats;
	@Autowired
	WeatherClass names;
	
	/**
	 * Rotta di tipo GET che ricava i dati di orario per alba e tramonto 
	 * di un certo paese passato dall'utente.
	 * @param paese Tipo parametro che dichiara di quale paese si intende conoscere i dati.
	 * @return Ritornano i dati di alba e tramonto del paese scelto dall'utente.
	 * @throws ParseException 
	 */
	
	@GetMapping(value="/Weather/{paese}")
	public ResponseEntity<Object> ShowWeather(@PathVariable("paese") String paese) {
		return new ResponseEntity<>(weather.getWeather(paese), HttpStatus.OK);
	}
	
	/**
	 * Rotta di tipo GET che mostra le città monitorate
	 * @return Ritornano le città presenti nell'archivio.
	 */
	
	@GetMapping(value="/CityMonitor")
	public WeatherClass ShowArchive() {
		return new WeatherClass();
	}
	
	/**
	 * Rotta di tipo POST che effettua il filtraggio dei dati in base al periodo scelto dall'utente.
	 * @param paese Tipo parametro che dichiara di quale paese si intende conoscere i dati.
	 * @param periodo Tipo parametro che dichiara di quale periodo si intende filtrare lo storico.
	 * @return Ritornano i dati filtrati dallo storico per il periodo indicato
	 * @throws ParseException 
	 * @throws InvalidBodyException 
	 */
	
	@PostMapping(value="/History")
	public ResponseEntity<Object> ShowHistory(@RequestBody RequestBodyClass body) throws ParseException, InvalidBodyException{
		return new ResponseEntity<>(filters.ShowFilters(body),HttpStatus.OK);
	}
	
	/**
	 * Rotta di tipo POST che mostra le statistiche dei dati in base al periodo scelto dall'utente.
	 * @param paese Tipo parametro che dichiara di quale paese si intende conoscere i dati.
	 * @param periodo Tipo parametro che dichiara di quale periodo si intende fare statistiche.
	 * @return Ritornano le statistiche in base al periodo richiesto.
	 * @throws ParseException 
	 * @throws java.text.ParseException 
	 * @throws InvalidBodyException 
	 */
	
	@PostMapping(value="/Stats")
	public ResponseEntity<Object> ShowStatistics(@RequestBody RequestBodyClass body) throws ParseException, InvalidBodyException {
		return new ResponseEntity<>(stats.ShowStats(body),HttpStatus.OK);
	}
	
	/**
	 * Rotta di tipo POST che mostra le varianze in base al periodo scelto dall'utente
	 * @param body
	 * @return Ritornano le varianze in base al periodo richiesto
	 * @throws ParseException
	 * @throws InvalidBodyException
	 */
	
	@PostMapping(value="/Variances")
	public ResponseEntity<Object> ShowVariances(@RequestBody RequestBodyClass body) throws ParseException, InvalidBodyException {
		return new ResponseEntity<>(variance.ShowVariances(body),HttpStatus.OK);
	}
	
}
