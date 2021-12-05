package it.univpm.OpenWeather;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import it.univpm.OpenWeather.exception.InvalidBodyException;
import it.univpm.OpenWeather.model.Orari;
import it.univpm.OpenWeather.model.RequestBodyClass;
import it.univpm.OpenWeather.service.Archive;

class ArchiveTest {
	
	Archive archive = null;
	private RequestBodyClass body = null;
	private RequestBodyClass body1 = null;
	private RequestBodyClass body2 = null;
	private RequestBodyClass body3 = null;
	
	@BeforeEach
	void setUp() throws Exception{
		archive = new Archive();
		body = new RequestBodyClass("19-12-2020", "20-12-2020", "torino", "");
		body1 = new RequestBodyClass("22-12-2020", "19-12-2020", "torino", "");
		body2 = new RequestBodyClass("00-12-2020", "20-12-2020", "torino", "");
		body3 = new RequestBodyClass("19-12-2020", "20-12-2020", "fano", "");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("test archivio")
	void test() throws InvalidBodyException, ParseException {
		Vector<Orari> o = null;
		
		o = archive.setArchivie(body);
		assertEquals(o.size(), 2);
		assertEquals(body.getStart(), "19-12-2020");
		assertEquals(body.getEnd(), "20-12-2020");
		assertEquals(body.getName(), "torino");
	}
	
	@Test
	@DisplayName("test eccezioni")
	void test1() {
		ResponseStatusException e;
		
		e = assertThrows(ResponseStatusException.class, ()->{archive.setArchivie(body1);});
		assertTrue(e.getMessage().contains("Periodo non ammesso..."));
		
		e = assertThrows(ResponseStatusException.class, ()->{archive.setArchivie(body2);});
		assertTrue(e.getMessage().contains("Periodo non presente nell'archivio..."));
		
		e = assertThrows(ResponseStatusException.class, ()->{archive.setArchivie(body3);});
		assertTrue(e.getMessage().contains("Città non presente nell'archivio..."));
		
	}

}
