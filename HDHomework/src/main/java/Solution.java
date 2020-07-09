package main.java;

import main.java.dry.DRYMunger;
import main.java.football.FootballMunger;
import main.java.weather.WeatherMunger;

public class Solution {

	public static void main(String[] args) {
		System.out.println("Hello HomeDepot!\nThis program is my solution for Kata04: Data Munging challenge.\n");
		WeatherMunger wm = new WeatherMunger();
		int day = wm.smallestTempSpreadDay("src/main/resources/weather.dat");
		System.out.println(String.format("The answer to Part1 is day: %d", day));
		
		FootballMunger fm = new FootballMunger();
		String teamName = fm.smallestForAndAgainst("src/main/resources/football.dat");
		System.out.println("The answer to Part2 is team: " + teamName);
		
		DRYMunger dm = new DRYMunger();
		String answer1 = dm.smallestDifferential("src/main/resources/weather.dat", 0, 1, 2, "\\s+");
		String answer2 = dm.smallestDifferential("src/main/resources/football.dat", 1, 6, 8, "\\s+");
		System.out.println("The answer to Part3 for the weather is: " + answer1);
		System.out.println("The answer to Part3 for football is: " + answer2);
				
	}

}
