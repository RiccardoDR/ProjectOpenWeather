package it.univpm.OpenWeather.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * Classe per visualizzare quali sono le città monitorate
 * @author De Ritis Riccardo
 * @author Dellisanti Francesco
 */

@Service
public class WeatherClass {
	
	private String description;
	private Vector<String> names = new Vector<String>();
	
	public WeatherClass() {
		this.setDescription("Città monitorate dal 18/12/2020 al 20/01/2021 : ");
	}
	
	/**
	 * @return vettore di stringhe che contiente i nomi delle città monitorate
	 */
	public Vector<String> getNames() {
		String next;
	    try {
	    	BufferedReader fileR = new BufferedReader(new FileReader("doc/"+"Archive.txt"));
	    	do {
	    		next = fileR.readLine();
	    		if(next!=null) {
	    			names.add(next);
	    		}
	    	}while(next!=null);
	    	fileR.close();
	    }catch(IOException e) {
	    	throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Errore lettura file..");
	    }
		return names;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
