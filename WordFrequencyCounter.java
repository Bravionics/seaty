package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Counts the frequencies of words in a file and generates a frequency graph
 */
public class WordFrequencyCounter {

	// ADD YOUR INSTANCE VARIABLES HERE
	Map<String, Integer> wordFrequency = new LinkedHashMap<String, Integer>();
	
	/**
	 * Constructor
	 * 
	 * @param fileName name of file from which to count word frequencies
	 */
	public WordFrequencyCounter(String fileName){
		//Put file 
		File inputFile  = new File(fileName);
		Scanner in = new Scanner("");
		try {
			in = new Scanner(inputFile);
		}catch (FileNotFoundException e){
			System.out.print("File: " + fileName + " not found");
		}
		
		
		while(in.hasNextLine()) {
			Scanner innerScan = new Scanner(in.nextLine());
			while (innerScan.hasNext()) {
				String temp = innerScan.next();
				temp = temp.toLowerCase();
				temp = temp.replaceAll("[^a-zA-Z0-9]", "");
				
				if (wordFrequency.containsKey(temp)) {
					wordFrequency.replace(temp, wordFrequency.get(temp) + 1);
				}else {
					wordFrequency.put(temp, 1);
				}
			}
		}
		
		//sort the by value, then by alphabetical order
		Comparator<Entry<String, Integer>> my_comp = Entry.<String, Integer>comparingByValue().reversed().thenComparing(Entry.comparingByKey());
		
		Map<String, Integer> tempLinkedMap = wordFrequency.entrySet().stream().sorted(my_comp).collect(Collectors.toMap(Entry::getKey, Entry::getValue, (a, b) -> a, LinkedHashMap::new));
		
		wordFrequency = tempLinkedMap;
		
		in.close();
	}


	/**
	 * Returns a word frequency graph based on the input file. Words are sorted
	 * based on frequency (more frequent words appear first) and then by name
	 * (lexicographically). 
	 * 
	 * Convert all words into lower case for the analysis and graph generation.
	 * 
	 * @return a word frequency graph based on the input file
	 */
	public String getFrequencyGraph() {
		String graph = "";
		for (Map.Entry<String, Integer> i : wordFrequency.entrySet()) {
			graph = graph + i.getKey() + ": ";
			for (int j = 0; j < i.getValue(); j++) {
				graph = graph + "*";
			}
			graph = graph + "\n";
		}
		return graph; // FIX ME
	}
}



