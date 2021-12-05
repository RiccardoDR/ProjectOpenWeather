package it.univpm.OpenWeather;

//import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SelectClasses({CityTest.class, ArchiveTest.class, ConvertedDateTest.class})
public class AllTests {
}
