package test.java.dry;

import static org.junit.Assert.*;
import main.java.dry.DRYMunger;

import org.junit.BeforeClass;
import org.junit.Test;

public class DRYMungerTest {
	private static DRYMunger dm;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dm = new DRYMunger();
	}

	@Test
	public void testDRYMungerGoodData() {
		String ans = dm.smallestDifferential("src/test/resources/test_football_gooddata.dat", 1, 6, 8, "\\s+");
		assertEquals("Aston_Villa", ans);
		
		ans = dm.smallestDifferential("src/test/resources/test_weather_gooddata.dat", 0, 1, 2, "\\s+");
		assertEquals("2", ans);
	}
	
	@Test
	public void testDRYMungerBadData() {
		String ans = dm.smallestDifferential("src/test/resources/test_football_baddata.dat", 1, 6, 8, "\\s+");
		assertEquals("Unable to determine", ans);
		
		ans = dm.smallestDifferential("src/test/resources/test_weather_baddata.dat", 0, 1, 2, "\\s+");
		assertEquals("Unable to determine", ans);
	}
	
	
	@Test
	public void testWeatherMungerNoFileSpecied(){
		String ans = dm.smallestDifferential("", 4, 3, 3, " ");
		assertEquals("Unable to determine", ans);
	}
	
	@Test
	public void testWeatherMungerFileDNE(){
		String ans = dm.smallestDifferential("something/not/a/real/file", 4, 3, 3, " ");
		assertEquals("Unable to determine", ans);
	}
	
	
	
	

}
