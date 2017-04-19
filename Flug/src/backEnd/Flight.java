package backEnd;

import java.util.Date;

public class Flight {
	public String flightNumber;
	public String airline;
	public String origin;
	public String destination;
	public Date departureTime;
	public Date arrivalTime;
	public Boolean bags;
	public int price;
	public int availableSeats;
	
	public Flight(String flightNumber, String airline, Date departureTime, Date arrivalTime, String origin, String destination, Boolean bags, int price, int availableSeats){
		this.flightNumber = flightNumber;
		this.airline = airline;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.origin = origin;
		this.destination = destination;
		this.bags = bags;
		this.price = price;
		this.availableSeats = availableSeats;
		
	}
	
	public String getFlightNumber(){
		return flightNumber;
	}
	
	public String getAirline(){
		return airline;
	}
	
	public String getOrigin(){
		return origin;
	}
	
	public String getDestination(){
		return destination;
	}
	
	public Date getDepartureTime(){
		return departureTime;
	}
	
	public Date getArrivalTime(){
		return arrivalTime;
	}	

	public Boolean getBags(){
		return bags;
	}

	public int getPrice(){
		return price;
	}
	
}
