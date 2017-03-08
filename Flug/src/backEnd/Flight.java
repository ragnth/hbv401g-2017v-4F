package backEnd;

import java.sql.Time;
import java.util.Date;

public class Flight {
	public int id;
	//implement flightNumber later 
	public Date date;
	public Time departureTime;
	public Time arrivalTime;
	public String flyingFrom;
	public String flyingTo;
	public Boolean bags;
	public double price;
	public int availableSeats;
	
	public Flight(Date date, Time departureTime, Time arrivalTime, String flyingFrom, String flyingTo, Boolean bags, double price, int availableSeats){
		this.date = date;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.flyingFrom = flyingFrom;
		this.flyingTo = flyingTo;
		this.bags = bags;
		this.price = price;
		this.availableSeats = availableSeats;
		
	}
	
	
}
