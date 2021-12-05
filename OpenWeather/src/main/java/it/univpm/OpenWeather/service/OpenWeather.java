package it.univpm.OpenWeather.service;

import java.util.Vector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.univpm.OpenWeather.model.City;
import it.univpm.OpenWeather.model.WeatherClass;

/**
 * Classe per prendere i dati dall'API e salvarli sul file se presentii nell'archivio
 * @author De Ritis Riccardo
 * @author Dellisanti Francesco
 */

@Service
public class OpenWeather {
	
	@Autowired
	Utils util;
	@Autowired
	Parse parse;
	@Autowired
	City city;
	@Autowired
	WeatherClass weather;
	
	public City getWeather(String paese) {
		String ApiKey = util.readApiKey();
		String url = "https://api.openweathermap.org/data/2.5/weather?q="+paese+"&appid="+ApiKey;
		String data = util.ApiData(url);
	    City c = parse.Parsing(data, paese);
	    Vector<String> paesi = new Vector<String>(weather.getNames());
	    for(int i=0;i<paesi.size();i++) {
	    	if(paesi.get(i).equalsIgnoreCase(paese)) {
	    		parse.Save(c);
	    		break;
	    	}
	    }
		return c;
	}
	
}
