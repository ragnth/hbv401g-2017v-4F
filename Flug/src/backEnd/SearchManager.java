package backEnd;

import java.sql.Time;

public class SearchManager {
	
	SearchInfo search;
	Flight[] flightList = new Flight[100]; 
	//breyta seinna
	Time maximumTravelTime = new Time(0);
	//veit ekki alveg hvernig vid stofnum Time
	Boolean maxOneStop = false;
	Boolean directFlight = false;
	Boolean excludeOvernightFlights = false;
	
	public static void searchForFlights(){
		
	}
	
	public static void increasingPriceOrder(){
		//quicksort a flightList[i].getPrice()
	}
	

	public static void main(String[] args){
		//search = new SearchInfo()
	}
	
	
	
	
	
	
}
