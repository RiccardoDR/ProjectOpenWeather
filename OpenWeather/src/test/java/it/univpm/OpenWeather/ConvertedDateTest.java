package it.univpm.OpenWeather;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.univpm.OpenWeather.service.ConvertedDate;

class ConvertedDateTest {
	
	private ConvertedDate d = null;
	
	@BeforeEach
	void setUp() throws Exception{
		d = new ConvertedDate();
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("test conversione data")
	void test() {
		assertEquals(1609455600, d.ConvertDate("01-01-2021 00:00:00"));
	}

}
