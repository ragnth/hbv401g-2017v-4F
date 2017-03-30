package backEnd;

import java.util.Date;

public class mockStorageFlight {
	private Flight flight1, flight2, flight3;
	//Tímabundið storage layer
	public mockStorageFlight(){
	    flight1 = new Flight("FI101", "Icelandair", (new Date(117, 5, 24, 7, 45)), (new Date(117, 5, 24, 14, 00)), "KEF", "JFK", true, 53789, 150); 
	    flight2 = new Flight("AA856", "American Airlines", (new Date(117, 7, 7, 11, 30)), (new Date(117, 7, 7, 14, 15)), "GYD", "AZN", false, 103754, 3); 
	    flight3 = new Flight("EA657", "Emirates Air", (new Date(117, 10, 3, 20, 00)), (new Date(117, 10, 4, 04, 30)), "VOI", "IGU", true, 90530, 40); 
	}
	
	
	
	
	
}
