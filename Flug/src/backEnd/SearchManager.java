package backEnd;

import java.sql.*;

import java.util.ArrayList;
import org.joda.time.DateTime;

import backEnd.FlightStorage;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class SearchManager {
	private FlightStorage mockObject; //mock object 
	private ArrayList<Trip> departResults;
	private ArrayList<Trip> returnResults;
	
	
	// ### PART OF SQL DATABASE CONNECTIVITY
	private DatabaseSearch dbSearch;
	private ArrayList<Trip> departResultsFromDB;
	private ArrayList<Trip> returnResultsFromDB;
	// ###
	
	public SearchInfo searchInfo;
	


	public SearchManager(String origin, String destination, Date departureDate, Date returnDate, int passengers, Boolean roundTrip) 
					throws InvalidSearchException{
			if( !origin.equals(destination) && departureDate!=null && returnDate!= null && departureDate.after(Calendar.getInstance().getTime()) && 
					passengers>0 && departureDate.before(returnDate)) {
				searchInfo = new SearchInfo(origin, destination, departureDate, returnDate, passengers, roundTrip);		
		    }
		    else{
			    throw new InvalidSearchException("Invalid search");
		    }	
						
			
	}
	
	public SearchManager(String origin, String destination, Date departureDate, int passengers, Boolean roundTrip) 
					throws InvalidSearchException{
			if(!origin.equals(destination) && departureDate!=null && departureDate.after(Calendar.getInstance().getTime()) && 
					passengers>0) {
				 searchInfo = new SearchInfo(origin, destination, departureDate, passengers, roundTrip);			
		    }
		    else{
			    throw new InvalidSearchException("Invalid search");
		    }		
	
	}


	public void search(){
		mockObject = new FlightStorage();
		
		
		departResults = new ArrayList<Trip>();
		returnResults = new ArrayList<Trip>();
		
		// ### PART OF DATABASE CONNECTIVITY
		departResultsFromDB = new ArrayList<Trip>();
		returnResultsFromDB = new ArrayList<Trip>();
		
		if(searchInfo.getRoundTrip())
		{
		    dbSearch = new DatabaseSearch(searchInfo.getDepartureDate().getTime(),searchInfo.getReturnDate().getTime(), searchInfo.getOrigin(), searchInfo.getDestination(), searchInfo.getPassengers()); // NÝTT
			System.out.println("populating departResults");
		    departResultsFromDB.addAll(searchTripsForDB(searchInfo.getOrigin(), searchInfo.getDestination(), searchInfo.getDepartureDate(),dbSearch.getOutFlightList()));
			System.out.println("populating returnResults");
		    returnResultsFromDB.addAll(searchTripsForDB(searchInfo.getDestination(), searchInfo.getOrigin(), searchInfo.getReturnDate(),dbSearch.getHomeFlightList()));

		}
		else
		{
		    dbSearch = new DatabaseSearch(searchInfo.getDepartureDate().getTime(), searchInfo.getOrigin(), searchInfo.getDestination(), searchInfo.getPassengers()); // NÝTT
		    departResultsFromDB.addAll(searchTripsForDB(searchInfo.getOrigin(), searchInfo.getDestination(), searchInfo.getDepartureDate(),dbSearch.getOutFlightList()));
		}
		// ###
		
		//Find outbound trips
		departResults.addAll(searchTrips(searchInfo.getOrigin(), searchInfo.getDestination(), searchInfo.getDepartureDate()));
		departResults.addAll(searchDirect(searchInfo.getOrigin(), searchInfo.getDestination(), searchInfo.getDepartureDate()));
		
		
		//Find return trips 
		if(searchInfo.getRoundTrip()){
			returnResults.addAll(searchTrips(searchInfo.getDestination(), searchInfo.getOrigin(), searchInfo.getReturnDate()));
			returnResults.addAll(searchTrips(searchInfo.getDestination(), searchInfo.getOrigin(), searchInfo.getReturnDate()));

		}
		
		increasingPriceOrder();
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
	
	
	// ### PART OF DATABASE CONNECTIVITY
	public ArrayList<Trip> searchDirectForDB(String from, String to, Date date,ArrayList<Flight> flightList){
		ArrayList<Trip> tripList = new ArrayList<Trip>(); 
		System.out.println("direct");
		for(Flight temp: flightList){
			if(temp.getOrigin().equals(from)  && temp.getDestination().equals(to) && compareDates(temp.getDepartureTime(), date))
					tripList.add(new Trip(temp));
			}
		return tripList;
		}
	
	@SuppressWarnings("deprecation")
	public ArrayList<Trip> searchTripsForDB(String from, String to, Date date, ArrayList<Flight> flightList){
		ArrayList<Trip> tripList = new ArrayList<Trip>();
        System.out.println("Inside searchTripsForDB");
		
		for (Flight temp : flightList) {
	        

			if(temp.getOrigin().equals(from) && temp.getDestination().equals(to)){
				System.out.println("found A to B flight");
				tripList.add(new Trip(temp));	
			}
		}
        
		for (Flight temp : flightList) {
				for(Flight temp2: flightList){
					if(temp.getDestination().equals(temp2.getOrigin()) && isStopoverPossible(temp.getArrivalTime(), temp2.getDepartureTime())) 
					{
						System.out.println("found A to C to B flight");
			            tripList.add(new Trip(temp, temp2));
					}
		        }	
		}
		return tripList;		
	}
	// ###
	
	
	
	//Input: flight1.arrivalTime, flight2.departureTime
	public Boolean isStopoverPossible(Date flight1, Date flight2){
		
		DateTime dt1 = new DateTime(flight1);
		DateTime dt2 = new DateTime(flight2);

		//Time in between flights should be more than one hour, but no
		//more than a whole day
	    return (dt2.isAfter(dt1.plusHours(1)) && dt1.plusDays(1).isAfter(dt2));
	}
	
	public void increasingPriceOrder(){
		Collections.sort(departResultsFromDB, new CustomComparator());
		Collections.sort(returnResultsFromDB, new CustomComparator());
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
	
	public ArrayList<Trip> getOutgoingTrips(){
		return departResultsFromDB;
	}
	
	public ArrayList<Trip> getReturnTrips(){
		return returnResultsFromDB;
	}
	
	public Boolean getRoundTrip(){
		return searchInfo.getRoundTrip();
	}
	
	public SearchInfo getSearchInfo(){
		return searchInfo;
	}

	
	public class CustomComparator implements Comparator<Trip> {
	    @Override
	    public int compare(Trip o1, Trip o2) {
	        return ((Integer)o1.getPrice()).compareTo((Integer)o2.getPrice());
	    }
	}
	
	
	
}