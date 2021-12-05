package it.univpm.OpenWeather.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import it.univpm.OpenWeather.exception.InvalidBodyException;
import it.univpm.OpenWeather.model.City;
import it.univpm.OpenWeather.model.Orari;
import it.univpm.OpenWeather.model.RequestBodyClass;

/**
 * Classe archivio per prendere dal file i dati richiesti
 * @author De Ritis Riccardo
 * @author Dellisanti Francesco
 */

@Service
public class Archive {
	
	ConvertedDate date = new ConvertedDate();
	
	/**
	 * @param body
	 * @return Vettore di Orari che contiente tutti gli orari della città richiesta
	 * @throws InvalidBodyException
	 * @throws ParseException
	 */

	public Vector<Orari> setArchivie(RequestBodyClass body) throws InvalidBodyException, ParseException{
		if(body.getStart()!=null && body.getEnd()!=null) {
			if(date.ConvertDate(body.getStart()+" 00:00:00")>date.ConvertDate(body.getEnd()+" 00:00:00")) {
				String out ="Periodo non ammesso...";
				throw new InvalidBodyException(out);
			}
		}
		JSONObject obj = new JSONObject();
		Vector<Orari> orari = new Vector<Orari>();
		try {
			String next;
			BufferedReader fileR = new BufferedReader(new FileReader("doc/"+"Storico.txt"));
			do {
				next = fileR.readLine();
				if(next!=null) {
					obj = (JSONObject) JSONValue.parseWithException(next);
					if(body.getName().equalsIgnoreCase((String) obj.get("name"))) {
						City c = new City();
						c.setName(body.getName());
						c.setSunrise((String)obj.get("sunrise"));
						c.setSunset((String)obj.get("sunset"));
						orari.add(c);
					}
				} else if(orari.isEmpty()) {
					fileR.close();
					String out = "Città non presente nell'archivio...";
					throw new InvalidBodyException(out); 
				}
			}while(next!=null);
			fileR.close();
		}catch(IOException e) {
			String out = "File non trovato";
			throw new InvalidBodyException(out); 
		}
		if((body.getStart()==null || body.getStart() == "") && (body.getEnd()==null || body.getEnd() == ""))
			return orari;
		else {
			int start=-1,end=-1;
			for(int i=0;i<orari.size();i++) {
				if(orari.get(i).getSunrise().substring(0,10).equals(body.getStart())) 
					start = i;
				if(orari.get(i).getSunrise().substring(0,10).equals(body.getEnd()))
					end=i;
			}
			if(start < 0 || end < 0) {
				String out = "Periodo non presente nell'archivio...";
				throw new InvalidBodyException(out);
			}
			Vector<Orari> filters = new Vector<Orari>();
			for(int i=start;i<=end;i++) {
				filters.add(orari.get(i));
			}
			return filters;
		}
	}
	
}
