package backEnd;

import java.util.ArrayList;

public class BookingManager {
	Trip outgoingTrip;
	Trip returnTrip;
	ArrayList<Passenger> passenger;
	int numberOfPassengers;
	ArrayList<Booking> booking;
	
	public BookingManager(Trip outgoingTrip, Trip returnTrip, ArrayList<Passenger> passenger){
		this.outgoingTrip = outgoingTrip;
		this.returnTrip = returnTrip;
		this.passenger = passenger;
		
		//Creates a list of type Booking for each passenger
		for(Passenger p: passenger){
			booking.add(new Booking(outgoingTrip, p));
			decreaseSeats(outgoingTrip);
			if(!(returnTrip==null)){
				booking.add(new Booking(returnTrip, p));
				decreaseSeats(returnTrip);
			}
		}
		
	}
	
	public void decreaseSeats(Trip trip){
		//Function decreases available seats in the flight, or both flights(if there is a stopover)

	}
	
}
