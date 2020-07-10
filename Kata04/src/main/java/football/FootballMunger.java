package main.java.football;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FootballMunger {
	public String smallestForAndAgainst(String filePath){
		
		int minDifferential = Integer.MAX_VALUE; // football points can only be integers, so we use integer math.
		String ansName = "Unable to answer";
		List<String> lines = getAllLines(filePath);
		
		for(String line : lines){
			String[] fields = line.trim().split("\\s+");
			try{
				String teamName = fields[1];
				int goalsFor = Integer.parseInt(fields[6]);
				int goalsAgainst = Integer.parseInt(fields[8]);
				int differential = Math.abs(goalsFor - goalsAgainst); // problem steatement specifies "smallest difference" so I'm taking that to mean absolute value
				if(differential < minDifferential){
					ansName = teamName;
					minDifferential = differential;
				}
			}catch(Exception e){
				// some lines are column titles or valid data, so we skip those
			}
		}
		return ansName;
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
