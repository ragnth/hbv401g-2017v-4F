package backEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class DatabaseSearch {
	private String origin; 
	private String destination;
	private long departureDate;
	private long returnDate;
	private int nrTickets;
	//Date returnDate; 
	private int passengers;
	
	private Flight oneFlight;
	private ArrayList<Flight> outFlightList;
	private ArrayList<Flight> homeFlightList;
    
	// Tveir smiðir, einn fyrir flug fram og til baka og einn fyrir flug bara "one way"
	public DatabaseSearch(long outFlightDate,long homeFlightDate,String chosenDepLocation,String chosenArrLocation, int nrTickets){
		this.departureDate = outFlightDate;
		this.returnDate = homeFlightDate;
		this.origin = chosenDepLocation;
		this.destination = chosenArrLocation;
		this.nrTickets = nrTickets;
		this.passengers = 1; // RANGT - LAGA
		this.outFlightList = new ArrayList<Flight>();
		this.homeFlightList = new ArrayList<Flight>();
		searchDatabase(departureDate, origin, destination, nrTickets, outFlightList );
        searchDatabase(returnDate, destination, origin, nrTickets, homeFlightList );// ATH SKELLI INN EINUM FARÞEGA SEM ER RANGT
	}
	
	public DatabaseSearch(long outFlightDate,String chosenDepLocation,String chosenArrLocation, int nrTickets){
		this.departureDate = outFlightDate;
		this.origin = chosenDepLocation;
		this.destination = chosenArrLocation;
		this.passengers = 1; // RANGT - LAGA
		this.outFlightList = new ArrayList<Flight>();
		this.homeFlightList = new ArrayList<Flight>();
		searchDatabase(departureDate, origin, destination, nrTickets, outFlightList );
	}
	
	@SuppressWarnings("deprecation")
	public void searchDatabase(
			long flightDate,
			String chosenDepLocation,
			String chosenArrLocation,
			int chosenNumberOfTickets,
			ArrayList<Flight> flightList){
		
		Connection c=null;
		Statement stmt=null;
		long plus24hrs = ((3600*24)-1)*1000L; 
		long plus5hrs =(5000*3600);
		long plus24hrsPlus8hrs = ((24000*3600)-1)+(8000*3600);
		int i = 0;
		try {
	    Class.forName("org.sqlite.JDBC");
	    c = DriverManager.getConnection("jdbc:sqlite:flightDatabase.db");
	    c.setAutoCommit(false);
	    System.out.println("Opened database successfully");

	    stmt = c.createStatement();
	    /*ResultSet rs = stmt.executeQuery( "SELECT * FROM FLIGHTDATA WHERE DepTime BETWEEN "+ flightDate + " AND " + (flightDate+plus24hrs) 
        		//+  " AND DepTime <= "+ flightDate+plus24hrs // Það er semsagt leitað á ákveðnum degi á milli klukkan 00:00 og 23:59. 
        		//Ath að dagsetningin er á töluformi sem er gott fyrir útreikninga
        		+ " AND DepartingFrom == '"+chosenDepLocation 
        		+ "' AND ArrivingAt == '"+ chosenArrLocation 
        		+ "' AND AvailableSeats >= " + chosenNumberOfTickets
        		+ ";"); */
	    
	    ResultSet rs = stmt.executeQuery( 
	    		"SELECT * FROM FLIGHTDATA WHERE (DepTime BETWEEN "+ flightDate + " AND " + (flightDate+plus24hrs) 
        		+ " AND DepartingFrom == '"+chosenDepLocation 
        		+ "' AND ArrivingAt == '"+ chosenArrLocation 
        		+ "' AND AvailableSeats >= " + chosenNumberOfTickets
        		+ ") OR "
        		+ "( DepTime BETWEEN "+(flightDate)
        		+ " AND +"+ (flightDate+plus24hrs)+" AND DepartingFrom == '"+chosenDepLocation+"')"
        		+ " OR "
        		+ "( DepTime BETWEEN "+(flightDate+plus5hrs)
        		+ " AND +"+ (flightDate+plus24hrsPlus8hrs)+" AND ArrivingAt == '"+chosenArrLocation+"')"
        		+ ";"); 
	    
	    while ( rs.next() ) {
	       oneFlight = new  Flight(
	    		   rs.getString("FlightNumber"),
	    		   rs.getString("Airline"),
	    		   rs.getDate("DepTime"),
	    		   rs.getDate("ArrTime"),
	    		   rs.getString("DepartingFrom"),
	    		   rs.getString("ArrivingAt"),
	    		   rs.getBoolean("Bags"),
	    		   rs.getInt("Price"),
	    		   rs.getInt("AvailableSeats")
	    		   );
	       System.out.println(	    		   
	    		   rs.getString("FlightNumber")+
	    		   "    "+
	    		   rs.getString("Airline")+
	    		   "    "+
	    		   rs.getDate("DepTime")+
	    		   "    "+
	    		   rs.getDate("ArrTime")+
	    		   "    "+
	    		   rs.getString("DepartingFrom")+
	    		   "    "+	    		 
	    		   rs.getString("ArrivingAt")+
	    		   "    "+
	    		   rs.getBoolean("Bags")+
	    		   "    "+
	    		   rs.getInt("Price")+
	    		   "    "+
	    		   rs.getInt("AvailableSeats"));
	       flightList.add(oneFlight);
	       

	    }

	    rs.close();
	    stmt.close();
	    c.close();
	  } catch ( Exception e ) {
	    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    System.exit(0);
	  }
	  System.out.println("Operation done successfully");
	}
	
	
	public ArrayList<Flight> getOutFlightList(){
		return outFlightList;
	}
	
	public ArrayList<Flight> getHomeFlightList(){
		return homeFlightList;
	}

	
	

}