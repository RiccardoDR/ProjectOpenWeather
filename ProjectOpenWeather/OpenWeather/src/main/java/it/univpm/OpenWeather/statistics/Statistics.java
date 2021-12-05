package it.univpm.OpenWeather.statistics;

import java.util.Vector;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.OpenWeather.exception.InvalidBodyException;
import it.univpm.OpenWeather.model.City;
import it.univpm.OpenWeather.model.Orari;
import it.univpm.OpenWeather.model.RequestBodyClass;
import it.univpm.OpenWeather.service.Archive;
import it.univpm.OpenWeather.service.ConvertedDate;

/**
 * @author De Ritis Riccardo
 * @author Dellisanti Francesco
 */

@Service
public class Statistics {
	
	@Autowired
	Archive archive;
	@Autowired
	ConvertedDate data;
	
	/**
	 * Metodo che visualizza le statistiche su un periodo scelto.
	 * @param body
	 * @return Città con le statistiche su un periodo scelto
	 * @throws ParseException
	 * @throws InvalidBodyException
	 */
	
	public City ShowStats(RequestBodyClass body) throws ParseException, InvalidBodyException {
		Vector<Orari> orari = new Vector<Orari>();
		orari.addAll(archive.setArchivie(body));
		String Sunrise1 = orari.get(0).getSunrise();
		String Sunset1 = orari.get(0).getSunset();
		String Sunrise2 = orari.get(orari.size()-1).getSunrise();
		String Sunset2 = orari.get(orari.size()-1).getSunset();
		return data.calculateData(Sunrise1,Sunrise2,Sunset1,Sunset2,orari.size()-1);
	}
	
}
