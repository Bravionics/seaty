package labs.lab6;

import java.util.ArrayList;

/**
 * Airline Seating. Part II. Complete the Airplane class here
 */
public class Airplane {

	public static final int FIRST = 0;
	public static final int ECONOMY = 1;

	public static final int FIRST_CLASS_ROWS = 5;
	public static final int ECONOMY_CLASS_ROWS = 15;

	public static final int SEATS_IN_FIRST_CLASS_ROW = 4;
	public static final int SEATS_IN_ECONOMY_CLASS_ROW = 6;
	
	ArrayList<SeatRow> plane = new ArrayList<SeatRow>();

	/**
	 * Constructs an Airplane object.
	 */
	public Airplane() {
		// FILL IN
		for (int i = 0; i < FIRST_CLASS_ROWS; i++) {
			plane.add(new SeatRow(SEATS_IN_FIRST_CLASS_ROW));
		}
		for (int i = 0; i < ECONOMY_CLASS_ROWS; i++) {
			plane.add(new SeatRow(SEATS_IN_ECONOMY_CLASS_ROW));
		}
	}


	/**
	 * Adds the passengers to the plane.
	 * 
	 * @param tclass     the type of class
	 * @param npassenger the number of passengers
	 * @param where      where the passenger wants to sit
	 * @return true if the assignment succeeded.
	 */
	public boolean addPassengers(int tclass, int npassenger, int where) {
		if (tclass == FIRST) {
			for (int i = 0; i < FIRST_CLASS_ROWS; i++) {
				if (plane.get(i).addPassengers(npassenger, where) == true) {
					return true;
				}
			}
		}else if(tclass == ECONOMY) {
			for (int i = 5; i < ECONOMY_CLASS_ROWS; i++) {
				if (plane.get(i).addPassengers(npassenger, where) == true) {
					return true;
				}
			}
		}
		return false; // FIX ME
	}


	/**
	 * Gets a string displaying the seating of the airplane.
	 * 
	 * @return the seating chart
	 */
	public String toString() {
		String retString = "";
		
		for (int i = 0; i < 9; i++) {
			String rowNum = Integer.toString(i + 1);
			retString = retString + " " + rowNum + " " + plane.get(i).toString() + System.lineSeparator();
		}
		
		for (int i = 9; i < plane.size(); i++) {
			String rowNum = Integer.toString(i + 1);
			retString = retString + rowNum + " " + plane.get(i).toString() + System.lineSeparator();
		}
		return retString; // FIX ME
	}

}
