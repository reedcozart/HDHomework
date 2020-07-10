package test.java.football;

import static org.junit.Assert.*;
import main.java.football.FootballMunger;

import org.junit.BeforeClass;
import org.junit.Test;

public class FootballMungerTest {

	private static FootballMunger fm;
	
	@BeforeClass
	public static void setUp(){
		fm = new FootballMunger();
	}
	
	@Test
	public void testFootballMungerGoodData() {
		String ans = fm.smallestForAndAgainst("src/test/resources/test_football_gooddata.dat");
		assertEquals("Aston_Villa", ans);
	}
	
	@Test
	public void testFootballMungerBadData() {
		String ans = fm.smallestForAndAgainst("src/test/resources/test_football_baddataa.dat");
		assertEquals("Unable to answer", ans);
	}
	
	@Test
	public void testFootballMungerNoFileSpecied(){
		String ans = fm.smallestForAndAgainst("");
		assertEquals("Unable to answer", ans);
	}
	
	@Test
	public void testFootballMungerFileDNE(){
		String ans = fm.smallestForAndAgainst("something/not/a/real/file");
		assertEquals("Unable to answer", ans);
	}

}
