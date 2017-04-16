package backEnd;

import java.util.ArrayList;

public class BookingManager {
	Trip outgoingTrip;
	Trip returnTrip;
	Passenger passenger;
	int numberOfPassengers;
	ArrayList<Booking> booking;
	
	public BookingManager(Trip outgoingTrip, Trip returnTrip, Passenger passenger, int numberOfPassengers){
		this.outgoingTrip = outgoingTrip;
		this.returnTrip = returnTrip;
		this.passenger = passenger;
		this.numberOfPassengers = numberOfPassengers;
		
		//Creates a list of type Booking for each passenger
		for(int i = 0; i < numberOfPassengers; i++){
			booking.add(new Booking(outgoingTrip, passenger));
			decreaseSeats(outgoingTrip);
			if(!(returnTrip==null)){
				booking.add(new Booking(returnTrip, passenger));
				decreaseSeats(returnTrip);
			}
		}
		
	}
	
	public void decreaseSeats(Trip trip){
		//Function decreases available seats in the flight, or both flights(if there is a stopover)
		
		
	}
	
}
