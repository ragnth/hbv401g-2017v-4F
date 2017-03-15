package backEnd;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SearchManager {
	static SearchInfo search;
	static FlightStorage storage = new FlightStorage();
	static ArrayList <Flight> flightList = new ArrayList<Flight>(storage.flightList);
	//breyta seinna
	Time maximumTravelTime = new Time(0);
	//veit ekki alveg hvernig vid stofnum Time
	Boolean maxOneStop = false;
	Boolean directFlight = false;
	Boolean excludeOvernightFlights = false;
	static ArrayList<Flight> departResults;
	static ArrayList<Flight> returnResults;

	
	
	public static void searchForFlights(SearchInfo search){
		//flug ut
		departResults = new ArrayList<Flight>();
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(search.getDepartureDate()); //
		for(int i = 0; i<flightList.size(); i++){
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(flightList.get(i).getDepartureTime());
			boolean sameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
			                  cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
			if(sameDay){
				departResults.add(flightList.get(i));
			}
		}
		
		//heimflug
		returnResults = new ArrayList<Flight>();
		cal1 = Calendar.getInstance();
		cal1.setTime(search.getReturnDate()); //
		for(int i = 0; i<flightList.size(); i++){
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(flightList.get(i).getDepartureTime());
			boolean sameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
			                  cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
			if(sameDay){
				returnResults.add(flightList.get(i));
			}
		}
		
		
		
	}
	
	public static void increasingPriceOrder(){
		//quicksort a flightList[i].getPrice()
	}
	

	public static void main(String[] args){
		Date depart = new Date(117, 8, 20);
		Date arrive = new Date(117, 8, 25);
		search = new SearchInfo("KEF", "JFK", depart, arrive);
		searchForFlights(search);
		for(int i =0; i< departResults.size(); i++){
			System.out.println(departResults.get(i).departureTime);
		}
		
		if(returnResults.size()==0){
			System.out.println("engin flug heim");
		}
		
		for(int i =0; i< returnResults.size(); i++){
			System.out.println(returnResults.get(i).departureTime);
		}
	}
	
	
	
	
	
	
}
