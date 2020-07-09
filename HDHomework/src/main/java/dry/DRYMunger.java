package main.java.dry;

import java.util.List;

public class DRYMunger {
	
	/** This is a general purpose Data differential comparison method. The method performs a numerical differential comparison. 
	 * any field for comparison that is not a number will be ignored. Each entry must be on its own line. 
	 * Column titles are optional, they will be ignored by this method.
	 * @param filePath - file path to the data file.
	 * @param targetCol - The field that is the "answer" to the numerical differential comparison specified by these arguments.
	 * @param compareCol1 - The first data field for differential comparison
	 * @param compareCol2 - The second data field for differential comparison
	 * @param delimiter - Regular Expression for how the fields are delimited.
	 * @return The field specified for the entry that has the smallest differential based on the inputs.
	 */
	public String smallestDifferential(String filePath, int targetCol, int compareCol1, int compareCol2, String delimiter){
		// "differential" assumes in numerical comparison, use double for flexibility
		// return a column entry as text
		double minDifferential = Double.MAX_VALUE;
		String ans = "Unable to determine";
		
		List<String> lines = Utilities.getAllLinesFromFile(filePath);
		for(String line : lines){
			String[] fields = line.trim().split(delimiter);
			try{
				String target = fields[targetCol];
				double compare1 = Double.parseDouble(fields[compareCol1]);
				double compare2 = Double.parseDouble(fields[compareCol2]);
				
				double diff = Math.abs(compare1 - compare2);
				if(diff < minDifferential){
					minDifferential = diff;
					ans = target;
				}
			} catch(Exception e){
				// the data line could not be parsed, continue to the next line
				continue;
			}
		}
		
		return ans;
	}
}
