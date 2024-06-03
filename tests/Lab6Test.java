package labs.lab6.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import labs.lab6.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lab6Test {

	private final double EPSILON = 1e-3;

	@Test
	public void problems1And2() {

		// words1.txt:
		WordFrequencyCounter counter1 = new WordFrequencyCounter("res/words1.txt");
		String expected1 = "robert: ******\n" + "java: ***\n" + "fun: **\n" + "is: **\n" + "agrees: *\n" + "so: *\n"
				+ "that: *\n";
		assertEquals(expected1, counter1.getFrequencyGraph());

		// words2.txt:
		WordFrequencyCounter counter2 = new WordFrequencyCounter("res/words2.txt");
		String expected2 = "of: ************\n" + "it: **********\n" + "the: **********\n" + "was: **********\n"
				+ "a: **\n" + "age: **\n" + "charles: **\n" + "dickens: **\n" + "epoch: **\n" + "i: **\n" + "read: **\n"
				+ "season: **\n" + "times: **\n" + "two: **\n" + "and: *\n" + "before: *\n" + "belief: *\n"
				+ "best: *\n" + "book: *\n" + "books: *\n" + "but: *\n" + "carol: *\n" + "christmas: *\n"
				+ "cities: *\n" + "darkness: *\n" + "despair: *\n" + "foolishness: *\n" + "have: *\n" + "havent: *\n"
				+ "hope: *\n" + "incredulity: *\n" + "its: *\n" + "light: *\n" + "list: *\n" + "my: *\n" + "oliver: *\n"
				+ "on: *\n" + "reading: *\n" + "spring: *\n" + "tale: *\n" + "this: *\n" + "twist: *\n" + "winter: *\n"
				+ "wisdom: *\n" + "worst: *\n";
		assertEquals(expected2, counter2.getFrequencyGraph());

		// words3.txt:
		WordFrequencyCounter counter3 = new WordFrequencyCounter("res/words3.txt");
		String expected3 = "the: **********\n" + "i: *********\n" + "and: *******\n" + "a: *****\n" + "it: *****\n"
				+ "me: *****\n" + "to: *****\n" + "in: ****\n" + "is: ****\n" + "my: ****\n" + "of: ****\n"
				+ "whenever: ****\n" + "about: **\n" + "as: **\n" + "find: **\n" + "get: **\n" + "little: **\n"
				+ "myself: **\n" + "nothing: **\n" + "off: **\n" + "or: **\n" + "some: **\n" + "this: **\n"
				+ "time: **\n" + "with: **\n" + "account: *\n" + "ago: *\n" + "all: *\n" + "almost: *\n" + "an: *\n"
				+ "ball: *\n" + "before: *\n" + "bringing: *\n" + "but: *\n" + "call: *\n" + "can: *\n" + "cato: *\n"
				+ "cherish: *\n" + "circulation: *\n" + "coffin: *\n" + "damp: *\n" + "degree: *\n"
				+ "deliberately: *\n" + "driving: *\n" + "drizzly: *\n" + "especially: *\n" + "every: *\n"
				+ "feelings: *\n" + "flourish: *\n" + "for: *\n" + "from: *\n" + "funeral: *\n" + "grim: *\n"
				+ "growing: *\n" + "hand: *\n" + "hats: *\n" + "have: *\n" + "having: *\n" + "high: *\n"
				+ "himself: *\n" + "his: *\n" + "how: *\n" + "hypos: *\n" + "if: *\n" + "interest: *\n" + "into: *\n"
				+ "involuntarily: *\n" + "ishmael: *\n" + "knew: *\n" + "knocking: *\n" + "long: *\n" + "meet: *\n"
				+ "men: *\n" + "methodically: *\n" + "mind: *\n" + "money: *\n" + "moral: *\n" + "mouth: *\n"
				+ "nearly: *\n" + "never: *\n" + "no: *\n" + "november: *\n" + "ocean: *\n" + "on: *\n" + "other: *\n"
				+ "part: *\n" + "particular: *\n" + "pausing: *\n" + "peoples: *\n" + "philosophical: *\n"
				+ "pistol: *\n" + "precisely: *\n" + "prevent: *\n" + "principle: *\n" + "purse: *\n" + "quietly: *\n"
				+ "rear: *\n" + "regulating: *\n" + "requires: *\n" + "sail: *\n" + "same: *\n" + "sea: *\n"
				+ "see: *\n" + "ship: *\n" + "shore: *\n" + "soon: *\n" + "soul: *\n" + "spleen: *\n" + "stepping: *\n"
				+ "street: *\n" + "strong: *\n" + "substitute: *\n" + "such: *\n" + "surprising: *\n" + "sword: *\n"
				+ "take: *\n" + "that: *\n" + "their: *\n" + "then: *\n" + "there: *\n" + "they: *\n" + "thought: *\n"
				+ "throws: *\n" + "towards: *\n" + "up: *\n" + "upon: *\n" + "upper: *\n" + "very: *\n" + "watery: *\n"
				+ "way: *\n" + "world: *\n" + "would: *\n" + "years: *\n";
		assertEquals(expected3, counter3.getFrequencyGraph());

		// blank.txt:
		WordFrequencyCounter counter4 = new WordFrequencyCounter("res/blank.txt");
		assertEquals("", counter4.getFrequencyGraph());

		// test exception message is printed out:
		String nonExistentFileName = "res/nothing.txt";
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		WordFrequencyCounter counter5 = new WordFrequencyCounter(nonExistentFileName);
		String result = output.toString();
		assertEquals("File: " + nonExistentFileName + " not found", result);
	}

	
	@Test
	public void problem3() {

		// success operations:
		Customer robert = new Customer(1, "Robert Navarro", 1);
		assertEquals(1, robert.getBalance(), EPSILON);

		robert.adjustBalance(300);
		assertEquals(301, robert.getBalance(), EPSILON);

		robert.adjustBalance(-100);
		assertEquals(201, robert.getBalance(), EPSILON);

		robert.adjustBalance(-201);
		assertEquals(0, robert.getBalance(), EPSILON);

		robert.adjustBalance(201);
		assertEquals(201, robert.getBalance(), EPSILON);

		// exception operations:

		// adjusting balance to negative amount:
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			robert.adjustBalance(-300);
		});
		String expectedMessage = "Cannot adjust balance to negative amount";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
		assertEquals(201, robert.getBalance(), EPSILON);

		// constructing new customer with negative ID:
		exception = assertThrows(IllegalArgumentException.class, () -> {
			Customer george = new Customer(-1, "George Glass", 30);
		});
		expectedMessage = "Customer ID cannot be negative";
		actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));

		// constructing new customer with blank name:
		exception = assertThrows(IllegalArgumentException.class, () -> {
			Customer blank = new Customer(2, "", 30000);
		});
		expectedMessage = "Customer name cannot be blank";
		actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));

		exception = assertThrows(IllegalArgumentException.class, () -> {
			Customer blank = new Customer(2, "  ", 30000);
		});
		expectedMessage = "Customer name cannot be blank";
		actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));

		// constructing new customer with negative balance:
		exception = assertThrows(IllegalArgumentException.class, () -> {
			Customer george = new Customer(2, "George Glass", -30);
		});
		expectedMessage = "Customer balance cannot be negative";
		actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	
	@Test
	public void problem4() {
		// sales.txt:
		SalesTally st = new SalesTally("res/sales.txt");
		assertEquals(53.4, st.getCategoryTotal("Dinner"), EPSILON);
		assertEquals(499.0, st.getCategoryTotal("Conference"), EPSILON);
		assertEquals(0.0, st.getCategoryTotal("Lodging"), EPSILON);

		// blank file:
		SalesTally stBlank = new SalesTally("res/blank.txt");
		assertEquals(0, stBlank.getCategoryTotal("Dinner"), EPSILON);
		assertEquals(0, stBlank.getCategoryTotal("Conference"), EPSILON);
		assertEquals(0, stBlank.getCategoryTotal("Lodging"), EPSILON);

		// test exception message is printed out:
		String nonExistentFileName = "res/nothing.txt";
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		SalesTally st2 = new SalesTally(nonExistentFileName);
		String result = output.toString();
		assertEquals("File: " + nonExistentFileName + " not found", result);
	}

	
	@Test
	public void problem5() {

		// babynames1.txt (10 records):
		BabyNameData data = new BabyNameData("res/babynames1.txt");

		// boy names:
		List<String> boyNames = data.getAllBoyNames();

		List<String> expectedList = Arrays.asList("Michael", "Christopher", "Matthew", "Joshua", "Nicholas", "Jacob",
				"Daniel", "Andrew", "Tyler", "Joseph");

		assertTrue(expectedList.size() == boyNames.size() && expectedList.containsAll(boyNames)
				&& boyNames.containsAll(expectedList));

		// girl names:
		List<String> girlNames = data.getAllGirlNames();

		expectedList = Arrays.asList("Megan", "Ashley", "Samantha", "Sarah", "Emily", "Amanda", "Brittany", "Elizabeth",
				"Taylor", "Jessica");

		assertTrue(expectedList.size() == girlNames.size() && expectedList.containsAll(girlNames)
				&& girlNames.containsAll(expectedList));

		// non-gender specific names:
		List<String> nonGenderSpecificNames = data.getAllNonGenderSpecificNames();

		expectedList = new ArrayList<>();

		assertTrue(
				expectedList.size() == nonGenderSpecificNames.size() && expectedList.containsAll(nonGenderSpecificNames)
						&& nonGenderSpecificNames.containsAll(expectedList));

		// rank:
		int rank = 3;
		assertEquals("Emily", data.getGirlNameAtRank(rank));
		assertEquals("Matthew", data.getBoyNameAtRank(rank));

		rank = 10;
		assertEquals("Megan", data.getGirlNameAtRank(rank));
		assertEquals("Joseph", data.getBoyNameAtRank(rank));

		rank = 1;
		assertEquals("Jessica", data.getGirlNameAtRank(rank));
		assertEquals("Michael", data.getBoyNameAtRank(rank));

		// babynames2.txt (70 records):
		data = new BabyNameData("res/babynames2.txt");
		assertEquals(70, data.getAllBoyNames().size());
		assertEquals(70, data.getAllGirlNames().size());

		expectedList = Arrays.asList("Taylor", "Jordan");

		nonGenderSpecificNames = data.getAllNonGenderSpecificNames();

		assertTrue(
				expectedList.size() == nonGenderSpecificNames.size() && expectedList.containsAll(nonGenderSpecificNames)
						&& nonGenderSpecificNames.containsAll(expectedList));

		// exception for out of range rank:
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			BabyNameData data2 = new BabyNameData("res/babynames2.txt");
			data2.getBoyNameAtRank(-1);
		});

		String expectedMessage = "Rank -1 out of range of data";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));

		exception = assertThrows(IllegalArgumentException.class, () -> {
			BabyNameData data2 = new BabyNameData("res/babynames1.txt");
			data2.getBoyNameAtRank(100);
		});

		expectedMessage = "Rank 100 out of range of data";
		actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));

		// exception for file not found:
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		String nonExistentFileName = "nobabynames.txt";
		new BabyNameData(nonExistentFileName);

		String result = output.toString();
		assertEquals("File: " + nonExistentFileName + " not found", result);
	}
	
	
	@Test
	public void problems6Through10() {
		Airplane plane = new Airplane();
		assertTrue(plane.addPassengers(Airplane.FIRST, 2, SeatRow.AISLE));
		assertTrue(plane.addPassengers(Airplane.FIRST, 1, SeatRow.WINDOW));
		assertTrue(plane.addPassengers(Airplane.ECONOMY, 3, SeatRow.AISLE));
		assertTrue(plane.addPassengers(Airplane.ECONOMY, 2, SeatRow.WINDOW));
		String exp = " 1 [* * . *]" + System.lineSeparator()
				+ " 2 [. . . .]" + System.lineSeparator()
				+ " 3 [. . . .]" + System.lineSeparator()
				+ " 4 [. . . .]" + System.lineSeparator()
				+ " 5 [. . . .]" + System.lineSeparator()
				+ " 6 [*** .**]" + System.lineSeparator()
				+ " 7 [... ...]" + System.lineSeparator()
				+ " 8 [... ...]" + System.lineSeparator()
				+ " 9 [... ...]" + System.lineSeparator()
				+ "10 [... ...]" + System.lineSeparator()
				+ "11 [... ...]" + System.lineSeparator()
				+ "12 [... ...]" + System.lineSeparator()
				+ "13 [... ...]" + System.lineSeparator()
				+ "14 [... ...]" + System.lineSeparator()
				+ "15 [... ...]" + System.lineSeparator()
				+ "16 [... ...]" + System.lineSeparator()
				+ "17 [... ...]" + System.lineSeparator()
				+ "18 [... ...]" + System.lineSeparator()
				+ "19 [... ...]" + System.lineSeparator()
				+ "20 [... ...]" + System.lineSeparator();
		assertEquals(exp, plane.toString());
	}
	

}
