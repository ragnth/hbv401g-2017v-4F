package backEnd;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SearchManager {
	static SearchInfo search;
	 static FlightStorage storage = new FlightStorage(); //tilvik af FlightStorage
	static ArrayList <Flight> flightList = new ArrayList<Flight>(storage.getList()); //saekjum listan
	
	//breyta seinna
	Time maximumTravelTime = new Time(0);
	Boolean maxOneStop = false;
	Boolean directFlight = false;
	Boolean excludeOvernightFlights = false;
	static ArrayList<Flight> departResults;
	static ArrayList<Flight> returnResults;
    
	public static void createSearch(String origin, String destination, Date in, Date out){
		search = new SearchInfo(origin, destination, in, out);
		//display search
		System.out.println("My search: ." + search.getOrigin() + ". to ." + search.getDestination() + ". " + search.getDepartureDate());

		searchForFlights(search);
		if(departResults.size()==0)
			System.out.println("No outbound flights match this date!");
		
		for(int i =0; i< departResults.size(); i++){
			System.out.println("Outbound flight: From " + departResults.get(i).getOrigin() + " to  " + departResults.get(i).getDestination() + " " +  departResults.get(i).departureTime);
		}
		
		
		//ef engin flug heim
		if(returnResults.size()==0){
			System.out.println("No return flights match this date!");
		}
		
		for(int i =0; i< returnResults.size(); i++){
			System.out.println("Return flight: From " + returnResults.get(i).getOrigin() + " to  " + returnResults.get(i).getDestination() + " " +  returnResults.get(i).departureTime);
		}
	}
	
	public static void searchForFlights(SearchInfo search){
		//Flug ut
		departResults = new ArrayList<Flight>();
		
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(search.getDepartureDate()); //
		for(int i = 0; i<flightList.size(); i++){
			//if countries match search for dates
			if(search.getOrigin().equals(flightList.get(i).getOrigin()) && search.getDestination().equals(flightList.get(i).getDestination())) {

				Calendar cal2 = Calendar.getInstance();
				cal2.setTime(flightList.get(i).getDepartureTime());
				boolean sameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
				                  cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
				
				if(sameDay){
					departResults.add(flightList.get(i));
			    }
		      }
		}
		
		//Heimflug
		returnResults = new ArrayList<Flight>();
		cal1 = Calendar.getInstance();
		cal1.setTime(search.getReturnDate()); //
		for(int i = 0; i<flightList.size(); i++){
			if(search.getDestination().equals(flightList.get(i).getOrigin())  && search.getOrigin().equals(flightList.get(i).getDestination())){
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime(flightList.get(i).getDepartureTime());
				boolean sameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
				                  cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
				if(sameDay){
					returnResults.add(flightList.get(i));
				}
			}
		}
	}
	
	
	public static void increasingPriceOrder(){
		//quicksort a flightList[i].getPrice()
	}
	
}
