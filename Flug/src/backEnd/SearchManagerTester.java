package backEnd;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import backEnd.Flight;

public class SearchManagerTester {
	private SearchManagerTest testObject; 
	
	@Before
	public void setUp() throws Exception {
		testObject = new SearchManagerTest("Kenya", "Argentina", (new Date(117, 10, 3)), (new Date(117, 10, 20)), 2, true);
	}
	
	@After
	public void tearDown() throws Exception {
		testObject = null;
	}
	
	@Test
	public void testSearchForFlights() {
		ArrayList<Flight> checkFlights = new ArrayList<Flight>();
	    //two possible outgoing flights
		checkFlights.add(new Flight("EA658", "American Airlines", (new Date(117, 10, 3, 7, 00)), (new Date(117, 10, 3, 13, 30)), "VOI", "IGU", true, 12341, 100));
		checkFlights.add(new Flight("EA657", "Emirates Air", (new Date(117, 10, 3, 20, 00)), (new Date(117, 10, 4, 04, 30)), "VOI", "IGU", true, 90530, 40));
		checkFlights.add(new Flight("EA613", "American Airlines", (new Date(117, 10, 20, 7, 00)), (new Date(117, 10, 20, 13, 30)), "IGU", "VOI", false, 23144, 120));
		checkFlights.add(new Flight("EA631", "Some kind of airline", (new Date(117, 10, 20, 20, 00)), (new Date(117, 10, 20, 04, 30)), "IGU", "VOI", true, 231231, 80));

	     //Could not find exact assert function for comparing two lists 
		 //assertArrayEquals(checkFlights, testObject.searchForFlights());
		
	}
	

	@Test
	public void testIncreasingPriceOrder() {
		ArrayList<Flight> checkFlights = new ArrayList<Flight>();

		checkFlights.add(new Flight("EA658", "American Airlines", (new Date(117, 10, 3, 7, 00)), (new Date(117, 10, 3, 13, 30)), "VOI", "IGU", true, 12341, 100));
		checkFlights.add(new Flight("EA613", "American Airlines", (new Date(117, 10, 20, 7, 00)), (new Date(117, 10, 20, 13, 30)), "IGU", "VOI", false, 23144, 120));
		checkFlights.add(new Flight("EA657", "Emirates Air", (new Date(117, 10, 3, 20, 00)), (new Date(117, 10, 4, 04, 30)), "VOI", "IGU", true, 90530, 40));
		checkFlights.add(new Flight("EA631", "Some kind of airline", (new Date(117, 10, 20, 20, 00)), (new Date(117, 10, 20, 04, 30)), "IGU", "VOI", true, 231231, 80))
	
	     //Could not find exact assert function for comparing two lists
		 //assertArrayEquals(checkFlights, testObject.searchForFlights());
	}
	
	
	
	//Check if IllegalArgumentException was raised
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalConstructorArgument() {
		
		//Origin and destination cannot be the same
		SearchManagerTest t1 = new SearchManagerTest("Paris", "Paris", (new Date(117, 5, 24)), (new Date(117, 6, 24)), 2, true);
		
		//Passengers cannot be less than one
		SearchManagerTest t2 = new SearchManagerTest("Paris", "Tokyo", (new Date(117, 5, 24)), (new Date(117, 6, 24)), 0, true);
		
		//Departure date cannot be in the past
		SearchManagerTest t3 = new SearchManagerTest("Paris", "Tokyo", (new Date(115, 1, 12)), (new Date(117, 6, 24)), 2, true);
		
		//Return date cannot be before Departure date
		SearchManagerTest t4 = new SearchManagerTest("Paris", "Tokyo", (new Date(117, 6, 24)), (new Date(117, 5, 24)), 2, true);
		
		//Origin and Departure strings need to be recognised
		SearchManagerTest t5 = new SearchManagerTest("Wolfster", "Ijustwannabefree", (new Date(117, 5, 24)),  (new Date(117, 5, 24)), 2, true);

	}
	
	//Check for legal parameters
	@Test
	public void testLegalConstructorArgument()
	throws IllegalArgumentException {
		SearchManagerTest t1 = new SearchManagerTest("Paris", "Tokyo", (new Date(117, 5, 24)), (new Date(117, 6, 24)), 2, true);

	}
	
	
	

	
	
	


}
