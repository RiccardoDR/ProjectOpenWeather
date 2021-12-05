package it.univpm.OpenWeather.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author De Ritis Riccardo
 * @author Dellisanti Francesco
 */

@Service
public class Utils {
	
	/**
	 * Metodo per ottenere i dati dall'API.
	 * @param url
	 * @return Stringa contenente tutta la risposta dell'API
	 */
		
	public String ApiData (String url) {
		String data = "";
		String line = "";
		try {
			URLConnection openConnection = new URL(url).openConnection();
			InputStream in = openConnection.getInputStream();
			try {
				BufferedReader buf = new BufferedReader(new InputStreamReader(in));
				while((line=buf.readLine())!=null)
					data+=line;
			}finally {
				in.close();
			}
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Città non trovata");
		}
		return data;
	}
	
	/**
	 *Metodo che leggi l'APIkey da un file
	 */
	
	public String readApiKey() {
		String ApiKey;
		try {
			BufferedReader fileR = new BufferedReader(new FileReader("doc/"+"ApiKey.txt"));
			ApiKey = fileR.readLine();
			if(ApiKey==null) {
				fileR.close();
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Inserire prima l'ApiKey nel file..");
			}
			fileR.close();
		}catch(IOException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"File non trovato..");
		}
		return ApiKey;
	}
	
}
