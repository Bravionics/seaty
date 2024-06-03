package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * A set of baby name data ranking the most popular baby names in the U.S. in a
 * particular year
 */
public class BabyNameData {

	// ADD YOUR INSTANCE VARIABLES HERE
	List<BabyName> boyBabies = new ArrayList<BabyName>();
	List<BabyName> girlBabies = new ArrayList<BabyName>();
	/**
	 * Constructor that creates this object with data from a file
	 * 
	 * @param babyNamesFileName name of input file
	 */
	public BabyNameData(String babyNamesFileName) {
		// FILL IN
		File inputFile  = new File(babyNamesFileName);
		Scanner in = new Scanner("");
		try {
			in = new Scanner(inputFile);
		}catch (FileNotFoundException e){
			System.out.print("File: " + babyNamesFileName + " not found");
		}
		
		while(in.hasNextLine()) {
			List<String> tempAList = new ArrayList<String>();
			Collections.addAll(tempAList, in.nextLine().split(" "));
			tempAList.removeAll(Arrays.asList("", " "));
			
			boyBabies.add(new BabyName(tempAList.get(1), Integer.parseInt(tempAList.get(0)), Integer.parseInt(tempAList.get(2)), Double.parseDouble(tempAList.get(3))));
			girlBabies.add(new BabyName(tempAList.get(4), Integer.parseInt(tempAList.get(0)), Integer.parseInt(tempAList.get(5)), Double.parseDouble(tempAList.get(6))));
		}
		
		in.close();
	}


	/**
	 * 
	 * @return all girl names (in a non-specific order)
	 */
	public List<String> getAllGirlNames() {
		List<String> names = new ArrayList<String>();
		for (BabyName baby : girlBabies) {
			names.add(baby.getName());
		}
		return names; // FIX ME
	}


	/**
	 * 
	 * @return all boy names (in a non-specific order)
	 */
	public List<String> getAllBoyNames() {
		List<String> names = new ArrayList<String>();
		for (BabyName baby : boyBabies) {
			names.add(baby.getName());
		}
		return names; // FIX ME
	}


	/**
	 * 
	 * @return all names that appear in the data for both boys and girls (in a
	 *         non-specific order)
	 */
	public List<String> getAllNonGenderSpecificNames() {
		List<String> names = new ArrayList<String>();
		for (BabyName boyBaby: boyBabies) {
			for (BabyName girlBaby: girlBabies) {
				if (boyBaby.getName().equals(girlBaby.getName())) {
					names.add(boyBaby.getName());
				}
			}
		}
		return names; // FIX ME
	}


	/**
	 * 
	 * @param rank
	 * @return the girl name at the rank specified
	 * 
	 *         If rank is out of the range of data, throw an
	 *         IllegalArgumentException with the message "Rank [rank] out of range
	 *         of data"
	 */
	public String getGirlNameAtRank(int rank) throws IllegalArgumentException {
		IllegalArgumentException invalidRank = new IllegalArgumentException("Rank " + rank + " out of range of data");
		String nameAtRank = "";
		for (BabyName baby: girlBabies) {
			if (baby.getRank() == rank) {
				nameAtRank = baby.getName();
			}
		}
		
		if (nameAtRank.equals("")) {
			throw invalidRank;
		}
		return nameAtRank; // FIX ME
	}


	/**
	 * 
	 * @param rank
	 * @return the boy name at the rank specified
	 * 
	 *         If rank is out of the range of data, throw an
	 *         IllegalArgumentException with the message "Rank [rank] out of range
	 *         of data"
	 */
	public String getBoyNameAtRank(int rank) {
		IllegalArgumentException invalidRank = new IllegalArgumentException("Rank " + rank + " out of range of data");
		String nameAtRank = "";
		for (BabyName baby: boyBabies) {
			if (baby.getRank() == rank) {
				nameAtRank = baby.getName();
			}
		}
		
		if (nameAtRank.equals("")) {
			throw invalidRank;
		}
		return nameAtRank; // FIX ME
	}
}
