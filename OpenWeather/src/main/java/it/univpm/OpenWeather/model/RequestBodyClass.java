package it.univpm.OpenWeather.model;

/**
 * Classe utilizzata per inserire i dati e ottenere filtri, statistiche e varianze.
 * @author De Ritis Riccardo
 * @author Dellisanti Francesco
 */

public class RequestBodyClass {
	private String start;
	private String end;
	private String name;
	private String type;
	 
	public RequestBodyClass(String start, String end, String name, String type) {
		this.start = start;
		this.end = end;
		this.name = name;
		this.type = type;
	}
	
	/**
	 * Metodi Get di name,start,end e Type
	 */
	public String getName() {
		return name;
	}

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}

	public String getType() {
		return type;
	}

}
