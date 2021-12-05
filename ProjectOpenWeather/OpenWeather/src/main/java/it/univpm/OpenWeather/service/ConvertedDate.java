package it.univpm.OpenWeather.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.OpenWeather.model.City;

/**
 * @author De Ritis Riccardo
 * @author Dellisanti Francesco
 */

@Service
public class ConvertedDate {
	
	@Autowired
	City c;
	
	/**
	 * Metodo per convertire il formato Date in String
	 * @param dateString
	 * @return Data convertita in Stringa
	 */
	
	public long ConvertDate(String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date convertedDate = new Date();
		try {
			convertedDate = sdf.parse(dateString);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		long date = convertedDate.getTime()/1000; 
		return date;
	} 
	
	/**
	 * Metodo per calcolare le statistiche
	 * @param Sunrise1
	 * @param Sunrise2
	 * @param Sunset1
	 * @param Sunset2
	 * @param giorni
	 * @return città con all'interno le statistiche
	 */
	
	public City calculateData(String Sunrise1, String Sunrise2, String Sunset1, String Sunset2, int giorni) {
		String data1 = Sunrise1.substring(0, 10);
		String data2 = Sunrise2.substring(0, 10);
		long sunrise = ConvertDate(Sunrise2) - ConvertDate(Sunrise1);
		long sunset = ConvertDate(Sunset2) - ConvertDate(Sunset1);
		sunrise -= 86400*giorni;
		sunset -= 86400*giorni;
		long Minuti1=(sunrise%3600)/60;
		long Secondi1=(sunrise%3600)%60;
		long Minuti2=(sunset%3600)/60;
		long Secondi2=(sunset%3600)%60;
		c.setName("Statistiche dell'orario dal "+data1+" al "+data2+" : ");
		if(Minuti1<0 || Secondi1<0)
			c.setSunrise("L'orario dell'alba scende di "+Minuti1*-1+" minuti e "+Secondi1*-1+" secondi ");
		else
			c.setSunrise("L'orario dell'alba sale di "+Minuti1+" minuti e "+Secondi1+" secondi ");
		if(Minuti2<0 || Secondi2<0)
			c.setSunset("L'orario del tramonto scende di "+Minuti2*-1+" minuti e "+Secondi2*-1+" secondi ");
		else
			c.setSunset("L'orario del tramonto sale di "+Minuti2+" minuti e "+Secondi2+" secondi ");
		return c;
	}
	
}
