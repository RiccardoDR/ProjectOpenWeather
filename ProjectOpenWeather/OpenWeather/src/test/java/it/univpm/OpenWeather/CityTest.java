package it.univpm.OpenWeather;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.univpm.OpenWeather.model.City;

class CityTest {
	
	private City c = null;
	
	@BeforeEach
	void setUp() throws Exception{
		c = new City("roma", "2021-01-01 07:30:00", "2021-01-01 16:30:00");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("test city")
	void test() {
		assertEquals(c.getName(), "roma");
		assertEquals(c.getSunrise(), "2021-01-01 07:30:00");
		assertEquals(c.getSunset(), "2021-01-01 16:30:00");
	}
	
	@Test
	@DisplayName("tet 2 city")
	void test1() {
		assertAll("valori", ()->assertEquals(c.getName(), "roma"),
				()->assertEquals(c.getSunrise(), "2021-01-01 07:30:00"),
				()->assertEquals(c.getSunset(), "2021-01-01 16:30:00"));
	}

}
