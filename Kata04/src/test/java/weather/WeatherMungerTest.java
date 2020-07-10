package test.java.weather;

import static org.junit.Assert.*;
import main.java.weather.WeatherMunger;

import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherMungerTest {
	private static WeatherMunger wm;
	
	@BeforeClass
	public static void setUp(){
		wm = new WeatherMunger();
	}
	
	@Test
	public void testWeatherMungerGoodData() {
		int ans = wm.smallestTempSpreadDay("src/test/resources/test_weather_gooddata.dat");
		assertEquals(2, ans);
	}
	
	@Test
	public void testWeatherMungerBadData() {
		int ans = wm.smallestTempSpreadDay("src/test/resources/test_weather_baddataa.dat");
		assertEquals(-1, ans);
	}
	
	@Test
	public void testWeatherMungerNoFileSpecied(){
		int ans = wm.smallestTempSpreadDay("");
		assertEquals(-1, ans);
	}
	
	@Test
	public void testWeatherMungerFileDNE(){
		int ans = wm.smallestTempSpreadDay("something/not/a/real/file");
		assertEquals(-1, ans);
	}
}
