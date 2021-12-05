package it.univpm.OpenWeather.filters;

import java.util.Vector;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import it.univpm.OpenWeather.exception.InvalidBodyException;
import it.univpm.OpenWeather.model.Orari;
import it.univpm.OpenWeather.model.RequestBodyClass;
import it.univpm.OpenWeather.service.Archive;

/**
 * Classe che implementa il filtraggio dei dati dello storico in base al periodo richiesto dall'utente.
 * @author De Ritis Riccardo
 * @author Dellisanti Francesco
 */

@Service
public class Filters {

	public Vector<Orari> ShowFilters(RequestBodyClass body) throws ParseException, InvalidBodyException {
		Archive archive = new Archive();
		return archive.setArchivie(body);
	}
}