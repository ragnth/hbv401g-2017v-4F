package backEnd;

import java.util.ArrayList;
import java.util.Date;

public class FlightStorage {

	ArrayList <Flight> flightList = new ArrayList<Flight>();
	@SuppressWarnings("deprecation")
	static
	ArrayList <Date> dateList = new ArrayList<Date>();
	
	public static void main(String[] args){
		for(int i = 0; i<100; i++){
			int a = 0 + (int)(Math.random()*12);
			int b = 1 + (int)(Math.random()*30);
			int c = 1 + (int)(Math.random()*60);
			int e = 1 + (int)(Math.random()*24);
			int m = 1 + (int)(Math.random()*60);
			Date d = new Date(117, a, b, e, c, m);
			dateList.add(d);
		
		}
		
		for(int i = 0; i<100; i++)
			System.out.println(dateList.get(i).toString());

		//flightList.add( new Flight("FB0101", "Wow Air", (new Date(2017+1990, 5, 23, 0800, 45, 23))  ));
		
		
		
		
		
	}

}
