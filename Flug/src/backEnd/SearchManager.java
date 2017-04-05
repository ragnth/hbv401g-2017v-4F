package backEnd;

import java.util.ArrayList;
import org.joda.time.DateTime;

import backEnd.FlightStorage;

import java.util.Calendar;
import java.util.Date;

public class SearchManager {
	private FlightStorage mockObject; //mock object 
	private ArrayList<Trip> departResults;
	private ArrayList<Trip> returnResults;
	SearchInfo search;
	


	public SearchManager(String origin, String destination, 
			Date departureDate, Date returnDate, int passengers, Boolean roundTrip) 
					throws InvalidSearchException{
		if(!origin.equals(destination) && departureDate.after(Calendar.getInstance().getTime()) && 
				passengers>0 && departureDate.before(returnDate)){
			//The search process
			search = new SearchInfo(origin, destination, departureDate, returnDate, passengers, roundTrip);
			mockObject = new FlightStorage();
			departResults = new ArrayList<Trip>();
			returnResults = new ArrayList<Trip>();
			System.out.println("search manager");
			//Find outbound trips
			departResults.addAll(searchTrips(search.getOrigin(), search.getDestination(), search.getDepartureDate()));
			departResults.addAll(searchDirect(search.getOrigin(), search.getDestination(), search.getDepartureDate()));
			
			//Find return trips 
			if(search.getRoundTrip()){
				returnResults.addAll(searchTrips(search.getDestination(), search.getOrigin(), search.getReturnDate()));
				returnResults.addAll(searchTrips(search.getDestination(), search.getOrigin(), search.getReturnDate()));

			}
			
		}
		else{
			throw new InvalidSearchException("Invalid search");
		}		
	}


		
	public ArrayList<Trip> searchDirect(String from, String to, Date date){
		ArrayList<Trip> tempList = new ArrayList<Trip>(); 
		for(Flight temp: mockObject.flightList){
			if(temp.getOrigin().equals(from)  && temp.getDestination().equals(to) && compareDates(temp.getDepartureTime(), date))
					tempList.add(new Trip(temp));
			}
		return tempList;
		}
		
	
	public ArrayList<Trip> searchTrips(String from, String to, Date date){
		ArrayList<Trip> tripList = new ArrayList<Trip>();
	
		for (Flight temp : mockObject.flightList) {
			if(temp.getOrigin().equals(from) && compareDates(temp.getDepartureTime(), date)){
				for(Flight temp2: mockObject.flightList){
					if(temp2.getOrigin().equals(temp.getDestination()) && temp2.getDestination().equals(to) && isStopoverPossible(temp.getArrivalTime(), temp2.getDepartureTime()) ){
						// Found trip that fits, add to list
						tripList.add(new Trip(temp, temp2));
					}
				}
			}
		}
 		
		
		
		return tripList;
		
	}
	
	
	
	//Input: flight1.arrivalTime, flight2.departureTime
	public Boolean isStopoverPossible(Date flight1, Date flight2){
		
		DateTime dt1 = new DateTime(flight1);
		DateTime dt2 = new DateTime(flight2);

		//Time in between flights should be more than one hour, but no
		//more than a whole day
	    return (dt2.isAfter(dt1.plusHours(1)) && dt1.plusDays(1).isAfter(dt2));
	}
	
	public static void increasingPriceOrder(){
		//sorts flightResults, returns nothing
	}
	
	public Boolean compareDates(Date d1, Date d2){
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(d1); //
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(d2);
		boolean sameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
		                  cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
	
		return sameDay;
	}
}
