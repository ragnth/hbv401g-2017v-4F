package backEnd;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import backEnd.Flight;

public class FlightTest {
	private Flight flight1, flight2, flight3;

	@Before
	public void setUp() throws Exception {
	    new Flight("FI101", "Icelandair", (new Date(117, 5, 24, 7, 45)), (new Date(117, 5, 24, 14, 00)), "KEF", "JFK", true, 53789, 150); 
	    new Flight("AA856", "American Airlines", (new Date(117, 7, 7, 11, 30)), (new Date(117, 7, 7, 14, 15)), "GYD", "AZN", false, 103754, 3); 
	    new Flight("EA657", "Emirates Air", (new Date(117, 10, 3, 20, 00)), (new Date(117, 10, 4, 04, 30)), "VOI", "IGU", true, 90530, 40); 
	}

	@After
	public void tearDown() throws Exception {
		   flight1 = null; 
		   flight2 = null; 
		   flight3 = null; 	
	}

	@Test
	public void test() {
		 assertEquals("Icelandair", flight1.getAirline());
		 assertEquals(103754, flight2.getPrice());
		 assertEquals(true, flight3.getBags());
	}

}
