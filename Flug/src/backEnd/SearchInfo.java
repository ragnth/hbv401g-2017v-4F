package backEnd;

import java.util.Date;

public class SearchInfo {
	private String origin;
	private String destination;
	private Date departureDate;
	private Date returnDate;
	private Boolean roundTrip = true;
	private int passenger;
	
	
	public SearchInfo(String origin, String destination, Date departureDate, Date returnDate, int passengers, Boolean roundTrip){
		this.origin = origin;
		this.destination = destination; 

		this.departureDate = departureDate;
		this.returnDate = returnDate;
		//roundTrip
		//baeta vid passenger	
	}
	
	public String getOrigin(){
		return origin;
	}
	
	public String getDestination(){
		return destination;
	}
	
	public Date getDepartureDate(){
		return departureDate;
	}
	
	public Date getReturnDate(){
		return returnDate;
	}
	
	public Boolean getRoundTrip(){
		return roundTrip;
	}
}
