package it.univpm.OpenWeather.service;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import it.univpm.OpenWeather.model.City;

/**
 * @author De Ritis Riccardo
 * @author Dellisanti Francesco
 */

@Service
public class Parse {
	
	@Autowired
	City city;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	
	/**
	 * Metodo che salva in una città i valori degli orari presi dall'API.
	 * @param data
	 * @param paese
	 * @return città con nome e orari della città
	 */
	
	public City Parsing(String data, String paese) {
		JSONObject obj = null;
		try {
			obj = (JSONObject)JSONValue.parseWithException(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JSONObject SRiseSSet= (JSONObject) obj.get("sys");
		city.setName(paese);
		long sunrise = (Long)SRiseSSet.get("sunrise");
		String dateSunrise = sdf.format(new java.util.Date(sunrise*1000));
		city.setSunrise(dateSunrise);
		long sunset = (Long)SRiseSSet.get("sunset");
		String dateSunset = sdf.format(new java.util.Date(sunset*1000));
		city.setSunset(dateSunset);
		return city;
	}
	
	/**
	 * Metodo che salva su file gli orari della città richiesta
	 * @param city
	 */
	
	@SuppressWarnings("unchecked") //Avvisa che il codice sia sicuro e non genere un'eccezione
	public void Save(City city) {
		try {
			JSONObject obj = new JSONObject();
			FileWriter fileW = new FileWriter("doc/"+"Storico.txt",true);
			obj.put("name", city.getName());
			obj.put("sunrise", city.getSunrise());
			obj.put("sunset", city.getSunset());
			fileW.write(obj.toJSONString()+"\n");
			fileW.close(); 
		}catch(IOException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"File non trovato");
		}
	}
	
}
