package test.java.dry;

import static org.junit.Assert.*;

import java.util.List;

import main.java.dry.Utilities;

import org.junit.Test;

public class UtilitiesTest {

	@Test
	public void testGetAllLinesFromFile() {
		List<String> ans = Utilities.getAllLinesFromFile("src/test/resources/test_football_baddata.dat");
		assertTrue(ans != null);
		assertEquals(7, ans.size());
	}
	
	@Test
	public void testGetAllLinesFromFile_NoFilepath(){
		List<String> ans = Utilities.getAllLinesFromFile("");
		assertTrue(ans != null);
		assertEquals(0, ans.size());
	}
	
	@Test
	public void testGetAllLinesFromFile_NullFilepath(){
		List<String> ans = Utilities.getAllLinesFromFile(null);
		assertTrue(ans != null);
		assertEquals(0, ans.size());
	}
	
	@Test
	public void testGetAllLinesFromFile_BadFilepath(){
		List<String> ans = Utilities.getAllLinesFromFile("something/not/a/real/file.txt");
		assertTrue(ans != null);
		assertEquals(0, ans.size());
	}

}
