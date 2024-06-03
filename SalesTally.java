package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads in a sales file and calculates the total amount for each service
 * category when requested
 */
public class SalesTally{

	// ADD YOUR INSTANCE VARIABLES HERE
	ArrayList<Sale> mySales= new ArrayList<Sale>();
	/**
	 * Constructor
	 * 
	 * @param salesFileName sales file name
	 */
	public SalesTally(String salesFileName) {
		File inputFile  = new File(salesFileName);
		Scanner in = new Scanner("");
		try {
			in = new Scanner(inputFile);
		}catch (FileNotFoundException e){
			System.out.print("File: " + salesFileName + " not found");
		}
		
		while(in.hasNextLine()) {
			String[] tempSplit = in.nextLine().split(";");
			mySales.add(new Sale(tempSplit[0], tempSplit[1], Double.parseDouble(tempSplit[2]), tempSplit[3]));
		}
		
		in.close();
	}


	/**
	 * Returns the total amount of sales for the given category
	 * 
	 * @param category
	 * 
	 * @return total amount of sales for the given category
	 */
	public double getCategoryTotal(String category) {
		double totalSales = 0;
		
		for (Sale sale : mySales) {
			if (sale.getServiceCategory().equals(category)) {
				totalSales += sale.getAmount();
			}
		}
		return totalSales; // FIX ME
	}

}
