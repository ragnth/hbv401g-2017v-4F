package backEnd;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class FlightStorage {

	static ArrayList <Flight> flightList = new ArrayList<Flight>();
	@SuppressWarnings("deprecation")
	static
	ArrayList <Date> dateList = new ArrayList<Date>();
	private static Random randomGenerator = new Random();
	
	
	public static void main(String[] args){
		for(int i = 0; i<100; i++){
			int m = 0 + (int)(Math.random()*12); //Bua til manud
			int d = 1 + (int)(Math.random()*30); // Bua til dagsetningu
			int mi = 1 + (int)(Math.random()*60); // Bua til minutu
			int h = 1 + (int)(Math.random()*24); //Bua til klukkutima
			int s = 1 + (int)(Math.random()*60); // bua til sek
			Date d = new Date(117, m, d, h, mi, s);
			dateList.add(d);
		
		}
		
		for(int i = 0; i<10; i++ ){
			int index = randomGenerator.nextInt(dateList.size());
			//baetir vid 2 klukkutima vid departureTime
			Calendar cal =Calendar.getInstance();
			cal.setTime(dateList.get(index));
			cal.add(Calendar.HOUR_OF_DAY,2); // this will add two hours
			Date myDate = cal.getTime();
			
			//bua til random verd
			int verd = 8000 + (int)(Math.random()*100000);
			
			flightList.add( new Flight("FB0101", "Wow Air", dateList.get(index), myDate, "KEF", "JFK", true, verd, 30));		
		}
		
		for(int i = 0; i<10; i++ ){
			
		   System.out.println(flightList.get(i).getAirline() + " " + flightList.get(i).getPrice());
		}
		}
		
	}


