package backEnd;

import java.util.ArrayList;
import java.util.Date;

public class SearchManagerTest {
	//Þessi klassi er tímabundinn search manager sem við notuðum í verkefni 3
	private mockStorageFlight mockObject; //mock object 
	private ArrayList<Flight> flightResults;
	
	
	public SearchManagerTest(String origin, String destination, Date departureDate, Date returnDate, int passengers, Boolean roundTrip){
		//mockObject = new mockStorageFlight();
		flightResults = new ArrayList<Flight>(searchForFlights()); //make a new list with the results of the search
		
	
	}

	public ArrayList<Flight> searchForFlights(){
		ArrayList<Flight> tempList = new ArrayList<Flight>(); 
		//code
		return tempList;
	}
	
	public static void increasingPriceOrder(){
		//sorts flightResults, returns nothing
	}
	
}
