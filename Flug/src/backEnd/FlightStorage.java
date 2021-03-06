package backEnd;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class FlightStorage {

	public ArrayList <Flight> flightList = new ArrayList<Flight>();
	static
	ArrayList <Date> dateList = new ArrayList<Date>();
	private static Random randomGenerator = new Random();
	String[] locales = Locale.getISOCountries();
	public static Locale[] countries;
	
 	
   	
	
	public FlightStorage(){
		generateDates();
		generateCountries();
		generateFlights();
	
	}
	
	//búum til random dagsetningar
	public void generateDates(){
		for(int i = 0; i<100000; i++){
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
	
	public void generateCountries(){
		countries = new Locale[250];
		int i=0;
		for (String countryCode : locales) {			
			Locale obj = new Locale("", countryCode);
			countries[i]=obj;
			i++;
		}
	}
	
	//búum til random flight list
	public void generateFlights(){
		for(int i = 0; i<3000000; i++ ){
			int index = randomGenerator.nextInt(dateList.size());
			
			//baetir vid 2 klukkutima vid departureTime og setur i arrival time
			Calendar cal =Calendar.getInstance();
			cal.setTime(dateList.get(index));
			cal.add(Calendar.HOUR_OF_DAY,2); // this will add two hours
			Date myDate = cal.getTime();
			
			//bua til random verd
			int verd = 8000 + (int)(Math.random()*100000);
		
			flightList.add( new Flight("FB0101", "Wow Air", dateList.get(index), myDate, getRandomCountry(), getRandomCountry(), (Math.random() < 0.5), verd, 30));	
			
		}
	}
	
	//erum bar aad prenta ut fyrstu 40 i augnablikinu
	public String getRandomCountry(){
        int c =  (int)(Math.random()*250); 
		return countries[c].getDisplayCountry();
	}		
}


