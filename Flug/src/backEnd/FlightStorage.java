package backEnd;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class FlightStorage {

	static ArrayList <Flight> flightList = new ArrayList<Flight>();
	static
	ArrayList <Date> dateList = new ArrayList<Date>();
	private static Random randomGenerator = new Random();
	
	public FlightStorage(){
		generateDates();
		generateFlights();
		
		//prentum út lista
		//for(int i = 0; i<1000; i++)
		//	System.out.println(flightList.get(i).getDepartureTime().toString()+" : " + flightList.get(i).getPrice());
		
		
	}
	
	//búum til random dagsetningar
	public void generateDates(){
		for(int i = 0; i<1000; i++){
			int a = 0 + (int)(Math.random()*12); //Bua til manud
			int b = 1 + (int)(Math.random()*30); // Bua til dagsetningu
			int e = 1 + (int)(Math.random()*24); //Bua til klukkutima
			int c = 1 + (int)(Math.random()*60); // Bua til minutu
			int m = 1 + (int)(Math.random()*60); // bua til sek
			@SuppressWarnings("deprecation")
			Date d = new Date(117, a, b, e, c, m);
			dateList.add(d);
		}	
	}	
	
	//búum til random flight list
	public void generateFlights(){
		for(int i = 0; i<1000; i++ ){
			int index = randomGenerator.nextInt(dateList.size());
			
			//baetir vid 2 klukkutima vid departureTime og setur i arrival time
			Calendar cal =Calendar.getInstance();
			cal.setTime(dateList.get(index));
			cal.add(Calendar.HOUR_OF_DAY,2); // this will add two hours
			Date myDate = cal.getTime();
			
			//bua til random verd
			int verd = 8000 + (int)(Math.random()*100000);
			
			flightList.add( new Flight("FB0101", "Wow Air", dateList.get(index), myDate, "KEF", "JFK", true, verd, 30));		
		}
	}
	
	public ArrayList<Flight> getList(){
		return flightList;
	}
		
}


