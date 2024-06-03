package labs.lab6;

/**
 * Represents a single sale.
 */
public class Sale {
	// ADD YOUR INSTANCE VARIABLES HERE
	private String name;
	private String service;
	private double amount;
	private String date;
	/**
	 * Constructs a Sale.
	 * 
	 * @param name    client name
	 * @param service service category
	 * @param amount  cost of service
	 * @param date    date of service
	 */
	public Sale(String name, String service, double amount, String date) {
		// FILL IN
		this.name = name;
		this.service = service;
		this.amount = amount;
		this.date = date;
	}

	/**
	 * Retrieve client name.
	 * 
	 * @return name
	 */
	public String getName() {
		return name; // FIX ME
	}

	/**
	 * Retrieve service category.
	 * 
	 * @return service category
	 */
	public String getServiceCategory() {
		return service; // FIX ME
	}

	/**
	 * Retrieve amount.
	 * 
	 * @return cost of service
	 */
	public double getAmount() {
		return amount; // FIX ME
	}

	/**
	 * Retrieve date.
	 * 
	 * @return date of service
	 */
	public String getDate() {
		return date; // FIX ME
	}
}
