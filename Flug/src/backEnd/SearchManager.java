package backEnd;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SearchManager {
	private FlightStorage mockObject; //mock object 
	private ArrayList<Flight> departResults;
	private ArrayList<Flight> returnResults;
	SearchInfo search;
	Date today = Calendar.getInstance().getTime();

	public SearchManager(String origin, String destination, 
			Date departureDate, Date returnDate, int passengers, Boolean roundTrip) 
					throws InvalidSearchException{
		if(!origin.equals(destination) && departureDate.after(today) && 
				passengers>0 && departureDate.before(returnDate)){
			
			//The search process
			search = new SearchInfo(origin, destination, departureDate, returnDate, passengers, roundTrip);
			mockObject = new FlightStorage();
			departResults = new ArrayList<Flight>(searchOutgoingFlights(search));
			if(search.getRoundTrip())
				returnResults = new ArrayList<Flight>(searchReturnFlights(search));
			
			// CHECK RESULTS
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
		else{
			throw new InvalidSearchException("Invalid search");
		}		
	}

	public ArrayList<Flight> searchOutgoingFlights(SearchInfo search){
		ArrayList<Flight> tempList = new ArrayList<Flight>(); 
		for(int i = 0; i<mockObject.flightList.size(); i++){
			//if countries match search for dates
			if(search.getOrigin().equals(mockObject.flightList.get(i).getOrigin()) && search.getDestination().equals(mockObject.flightList.get(i).getDestination())) {		
				if(compareDates(search.getDepartureDate(), mockObject.flightList.get(i).getDepartureTime()))
					tempList.add(mockObject.flightList.get(i));
		      }
		}
		return tempList;
	}
		
	public ArrayList<Flight> searchReturnFlights(SearchInfo search){
		ArrayList<Flight> tempList = new ArrayList<Flight>(); 
		
		returnResults = new ArrayList<Flight>();
		for(int i = 0; i<mockObject.flightList.size(); i++){
			if(search.getDestination().equals(mockObject.flightList.get(i).getOrigin())  && search.getOrigin().equals(mockObject.flightList.get(i).getDestination())){
				if(compareDates(search.getReturnDate(), mockObject.flightList.get(i).getDepartureTime()))
					tempList.add(mockObject.flightList.get(i));
			}
		}
		return tempList;
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
