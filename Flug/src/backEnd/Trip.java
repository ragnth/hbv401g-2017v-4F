package backEnd;

import java.util.Date;

public class Trip {
	private Flight flightOne;
	private Flight flightTwo;
	private int	price;
	private Date departureTime;
	private Date arrivalTime;
	
	public Trip(Flight flightOne){
		this.flightOne = flightOne;
		this.price = flightOne.getPrice();
		this.departureTime = flightOne.getDepartureTime();
		this.arrivalTime = flightOne.getArrivalTime();
	}
	
	public Trip(Flight flightOne, Flight flightTwo){
		this.flightOne = flightOne;
		this.flightTwo = flightTwo;
		this.price = (flightOne.getPrice())+(flightTwo.getPrice());
		this.departureTime = flightOne.departureTime;
		this.arrivalTime = flightTwo.arrivalTime;
	}
	
	public Flight getFlightOne(){
		return flightOne;
	}
	
	public Flight getFlightTwo(){
		return flightTwo;
	}
	
	public int getPrice(){
		return price;
	}
	
	

}
