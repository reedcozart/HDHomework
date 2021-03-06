package main.java.dry;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Utilities {
	public static List<String> getAllLinesFromFile(String filePath){
		try {
			List<String> allLines = Files.readAllLines(Paths.get(filePath));
			return allLines;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
}
