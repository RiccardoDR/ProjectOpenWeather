package it.univpm.OpenWeather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Classe per eccezione personalizzata, che estende Exception
 * @author De Ritis Riccardo
 * @author Dellisanti Francesco
 */

@SuppressWarnings("serial") //Avvisa la mancanza di un campo serialID.
public class InvalidBodyException extends Exception{
	
	/**
	 * @param out, messaggio di errore personalizzato. 
	 */
	public InvalidBodyException(String out) {
		super();
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,out);
	}
	
}
