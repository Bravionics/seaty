package labs.lab6;

/**
 * A customer in a customer database
 */
public class Customer{

	// ADD YOUR INSTANCE VARIABLES HERE
	int id;
	String name;
	double balance;
	
	IllegalArgumentException negativeID = new IllegalArgumentException("Customer ID cannot be negative");
	IllegalArgumentException blankName = new IllegalArgumentException("Customer name cannot be blank");
	IllegalArgumentException negativeBalance = new IllegalArgumentException("Customer balance cannot be negative");
	IllegalArgumentException adjustNegative = new IllegalArgumentException("Cannot adjust balance to negative amount");

	/**
	 * Constructs a customer with the given id, name, and with a zero balance
	 * 
	 * @param id   customer id
	 * @param name customer name
	 */
	public Customer(int id, String name){
		// FILL IN
		if (id < 0) {
			throw negativeID;
		}
		if (name.strip().isEmpty()) {
			throw blankName;
		}
		this.id = id;
		this.name = name;
		balance = 0;
		
		
	}


	/**
	 * Constructs a customer with the given id, name, and balance.
	 * 
	 * Note: For info on why you don't need to include a throws clause in the method
	 * declaration, it's because it throws an un-checked (runtime) exception. Only
	 * include a throws clause if it throws a checked exception. See
	 * https://stackoverflow.com/questions/4392446/when-to-use-throws-in-a-java-method-declaration
	 * 
	 * @param id      customer id
	 * @param name    customer name
	 * @param balance customer balance
	 */
	public Customer(int id, String name, double balance) {		
		// FILL IN
		if (id < 0) {
			throw negativeID;
		}
		if (name.strip().isEmpty()) {
			throw blankName;
		}
		if (balance < 0) {
			throw negativeBalance;
		}
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	
	
	public int getID() {
		return id; // FIX ME
	}
	
	
	public String getName() {
		return name; // FIX ME
	}


	/**
	 * Gets the current customer balance
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		return balance; // FIX ME
	}
	

	/**
	 * Adjusts customer balance by the given amount
	 * 
	 * @param amount the amount by which to adjust the balance
	 */
	public void adjustBalance(double amount) {
		// FILL IN
		if ((balance + amount) < 0) {
			throw adjustNegative;
		}
		balance = balance + amount;
	}
}
