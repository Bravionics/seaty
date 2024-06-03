package labs.lab6;

import java.util.ArrayList;

/**
 * Airline seating. For Part I, complete the SeatRow class that represents a row
 * of seats. Use the following format to represent a row of seats as a string:
 * [. . . .] (first-class empty), [* * * *] (first class all full), [... ...]
 * (economy empty).
 */
public class SeatRow {

	public static final int WINDOW = 0;
	public static final int CENTER = 1;
	public static final int AISLE = 2;

	// ADD YOUR INSTANCE VARIABLES EHRE
	private int numSeats;
	ArrayList<String> row = new ArrayList<String>();
	
	/**
	 * Constructs a SeatingRow object.
	 * 
	 * @param numSeats the number of seats in this row;
	 */
	public SeatRow(int numSeats) {
		// FILL IN
		this.numSeats = numSeats;
		for (int i = 0; i < numSeats; i++) {
			row.add(".");
		}
	}


	/**
	 * Adds passenger(s)s to seat(s), based on preference.
	 * 
	 * @param numPassengers the number of passengers
	 * @param preference    where the passengers want to be seated
	 * @returns true if the passenger can be added, false otherwise
	 */
	public boolean addPassengers(int numPassengers, int preference) {
		//first class
		if (row.size() == 4) {
			if (numPassengers == 1) {
				if (preference == WINDOW) {
					if (row.get(0).equals(".")) {
						row.set(0, "*");
						return true;
					}else if(row.get(3).equals(".")) {
						row.set(3, "*");
						return true;
					}
				}else if (preference == AISLE) {
					for (int i = 0; i < row.size(); i++) {
						if (row.get(i).equals(".")) {
							row.set(i, "*");
							return true;
						}
					}
				}
			
			
			}else if (numPassengers == 2) {
				if (preference == AISLE) {
					for (int i = 0; i < row.size(); i++) {
						if (row.get(i).equals(".") && row.get(i + 1).equals(".")) {
							row.set(i, "*");
							row.set(i + 1, "*");
							return true;
						}
					}
				}else if (preference == WINDOW){
					if (row.get(0).equals(".") && row.get(1).equals(".")) {
						row.set(0, "*");
						row.set(1, "*");
						return true;
					}else if(row.get(2).equals(".") && row.get(3).equals(".")) {
						row.set(2, "*");
						row.set(3, "*");
						return true;
					}
				}
			}
		 
		//economy class
		}else if (row.size() == 6) {
			if (numPassengers == 1) {
				if (preference == AISLE) {
					if (row.get(2).equals(".")) {
						row.set(2, "*");
						return true;
					}else if (row.get(3).equals(".")) {
						row.set(3, "*");
						return true;
					}
				}else if (preference == WINDOW) {
					if (row.get(0).equals(".")) {
						row.set(0, "*");
						return true;
					}else if (row.get(5).equals(".")) {
						row.set(5, "*");
						return true;
					}
				}else if (preference == CENTER) {
					if (row.get(1).equals(".")) {
						row.set(1, "*");
						return true;
					}else if(row.get(4).equals(".")) {
						row.set(4, "*");
						return true;
					}
				}
			}else if (numPassengers == 2) {
				if (preference == WINDOW) {
					if (row.get(0).equals(".") && row.get(1).equals(".")) {
						row.set(0, "*");
						row.set(1, "*");
						return true;
					}else if (row.get(4).equals(".") && row.get(5).equals(".")) {
						row.set(4, "*");
						row.set(5, "*");
						return true;
					}
				
				}else if (preference == AISLE) {
					if (row.get(1).equals(".") && row.get(2).equals(".")) {
						row.set(1, "*");
						row.set(2, "*");
						return true;
					}else if (row.get(3).equals(".") && row.get(4).equals(".")) {
						row.set(3, "*");
						row.set(4, "*");
						return true;
					}
				}
			}else if (numPassengers == 3) {
				if (preference == WINDOW) {
					if (row.get(0).equals(".") && row.get(1).equals(".") && row.get(2).equals(".")) {
						row.set(0, "*");
						row.set(1, "*");
						row.set(2, "*");
						return true;
					}else if(row.get(5).equals(".") && row.get(4).equals(".") && row.get(3).equals(".")) {
						row.set(5, "*");
						row.set(4, "*");
						row.set(3, "*");
						return true;
					}
				}else if (preference == AISLE) {
					if (row.get(0).equals(".") && row.get(1).equals(".") && row.get(2).equals(".")) {
						row.set(0, "*");
						row.set(1, "*");
						row.set(2, "*");
						return true;
					}else if(row.get(5).equals(".") && row.get(4).equals(".") && row.get(3).equals(".")) {
						row.set(5, "*");
						row.set(4, "*");
						row.set(3, "*");
						return true;
					}
				}else if (preference == CENTER) {
					if (row.get(0).equals(".") && row.get(1).equals(".") && row.get(2).equals(".")) {
						row.set(0, "*");
						row.set(1, "*");
						row.set(2, "*");
						return true;
					}else if(row.get(5).equals(".") && row.get(4).equals(".") && row.get(3).equals(".")) {
						row.set(5, "*");
						row.set(4, "*");
						row.set(3, "*");
						return true;
					}
				}
			}
				
		}
		return false;
	}


	/**
	 * Adds (a) passenger(s) to a seat, if possible
	 * 
	 * @param from a starting seat, inclusive
	 * @param to   an ending seat, inclusive
	 * @return true if all the seat(s) in the range can be added, false otherwise
	 */
	public boolean add(int from, int to) {
		return false; // FIX ME
	}


	/**
	 * Gets a string displaying the seating of this row
	 * 
	 * @return the seating chart
	 */
	public String toString() {
		String retString = "";
		if (row.size() == 4) {
			retString = retString + "[";
			retString = retString + row.get(0) + " ";

			retString = retString + row.get(1) + " ";

			retString = retString + row.get(2) + " ";
			
			retString = retString + row.get(3);
			retString = retString + "]";
		}else if(row.size() == 6) {
			retString = retString + "[";
			retString = retString + row.get(0);
			retString = retString + row.get(1);
			retString = retString + row.get(2) + " ";
			
			retString = retString + row.get(3);
			retString = retString + row.get(4);
			retString = retString + row.get(5);
			retString = retString + "]";
		}
		return retString; // FIX ME
	}

}
