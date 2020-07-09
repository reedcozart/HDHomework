package main.java.weather;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WeatherMunger {
	public int smallestTempSpreadDay(String filePath){
		double minSpread = Double.MAX_VALUE;
		int minSpreadDay = -1;
		List<String> lines = getAllLines(filePath);
		
		for(String line : lines){
			String[] fields = line.trim().split("\\s+");
			try{
				int day = Integer.parseInt(fields[0]);
				double maxT = Double.parseDouble(fields[1]); // this particular weather data HAPPENS to be integer, but we can use doubles for future flexibility
				double minT = Double.parseDouble(fields[2]); // hardcoding fields is, honestly, not great. This is improved in part3.
				
				double spread = Math.abs(maxT - minT);
				if(spread < minSpread){
					minSpreadDay = day;
					minSpread = spread;
				}
			}catch(NumberFormatException e){
				// some of the lines in data might not numbers, that's ok, do nothing and continue
			}
		}
		return minSpreadDay;
	}
	
	private List<String> getAllLines(String filePath) {
		try {
			List<String> allLines = Files.readAllLines(Paths.get(filePath));
			return allLines;
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
}