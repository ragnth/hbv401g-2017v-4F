package frontEnd;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Locale;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
public class searchPane extends JPanel {
 	JComboBox textOrigin;
	JComboBox textDestination;
	JComboBox passengers;
	JXDatePicker departureDate;
	JXDatePicker returnDate;
	String[] locales = Locale.getISOCountries();
	Locale[] countries;
   	Integer[] pass = {1,2,3,4,5,6,7,8,9};
	private Color background = new Color(49,219,205);
	private Color inputColor = new Color(155, 237, 231);
	Color textInput = new Color(0, 173, 160);
	JCheckBox roundTrip;
	

	public searchPane() {
		setSize(new Dimension(700, 40));
	   	setLayout(new GridLayout(2, 6, 0, 0));
	   	setOpaque(false);
	   	setUpAutoComplete();
	   	
	   	JLabel jRoundTrip = new JLabel("Roundtrip");
	   	jRoundTrip.setHorizontalAlignment(SwingConstants.RIGHT);
	   	jRoundTrip.setForeground(Color.white);
	   	jRoundTrip.setFont(new Font("Monospaced", Font.PLAIN, 13));
	   	add(jRoundTrip);
	   	
	   	JLabel origin = new JLabel("Origin");
	   	origin.setHorizontalAlignment(SwingConstants.CENTER);
	   	origin.setForeground(Color.white);
	   	origin.setFont(new Font("Monospaced", Font.PLAIN, 13));
	   	add(origin);
	   	
	   	JLabel destination = new JLabel("Destination");
	   	destination.setHorizontalAlignment(SwingConstants.CENTER);
	   	destination.setForeground(Color.white);
	   	destination.setFont(new Font("Monospaced", Font.PLAIN, 13));
	   	add(destination);
	   	
	   	JLabel LeavingOn = new JLabel("Leaving on");
	   	LeavingOn.setHorizontalAlignment(SwingConstants.CENTER);
	   	LeavingOn.setForeground(Color.white);
	   	LeavingOn.setFont(new Font("Monospaced", Font.PLAIN, 13));
	   	add(LeavingOn);
	   	
	   	JLabel ReturningOn = new JLabel("Returning On");
	   	ReturningOn.setHorizontalAlignment(SwingConstants.CENTER);
	   	ReturningOn.setForeground(Color.white);
	   	ReturningOn.setFont(new Font("Monospaced", Font.PLAIN, 13));
	   	add(ReturningOn);
	   	

	   	
	   	JLabel Passengers = new JLabel("Passengers");
	   	Passengers.setHorizontalAlignment(SwingConstants.CENTER);
	   	Passengers.setForeground(Color.white);
	   	Passengers.setFont(new Font("Monospaced", Font.PLAIN, 13));
	   	add(Passengers);
	   	
	   	
	   	roundTrip = new JCheckBox();
	   	roundTrip.setHorizontalAlignment(SwingConstants.RIGHT);
	   	roundTrip.setSelected(true);
	   	roundTrip.setBackground(inputColor);
	   	
	   	add(roundTrip);
	   	roundTrip.addActionListener(new ActionListener() {
	   		public void actionPerformed(ActionEvent e) {
	   			if(!roundTrip.isSelected()){
	   				returnDate.setDate(null);
	   				returnDate.setEnabled(false);
	   				
	   			}
	   			if(roundTrip.isSelected()){
	   				returnDate.setEnabled(true);
	   			}
	   		}
	   	});
	   	
	   	
	   	
	   	textOrigin = new JComboBox(locales);
	   	textOrigin.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textOrigin.getEditor().getEditorComponent().setBackground(inputColor);
		textOrigin.setSelectedItem("Iceland");
		AutoCompleteDecorator.decorate(textOrigin);
		add(textOrigin);
	   	
	   	textDestination = new JComboBox(locales);
	   	textDestination.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textDestination.getEditor().getEditorComponent().setBackground(inputColor);
		textDestination.setSelectedItem("Where to?");
		AutoCompleteDecorator.decorate(textDestination);
	   	add(textDestination);

	   	departureDate = new JXDatePicker();
	   	departureDate.getEditor().setBackground(inputColor);
	   	add(departureDate);
	   	
	   	returnDate = new JXDatePicker();
	   	returnDate.getEditor().setBackground(inputColor);
	   	add(returnDate);
	   	
	   	passengers = new JComboBox(pass);
	   	passengers.setFont(new Font("Monospaced", Font.PLAIN, 13));
	   	passengers.getEditor().getEditorComponent().setBackground(inputColor);
		AutoCompleteDecorator.decorate(passengers);
	   	add(passengers);
	 
	   	
	}
	
	public void setUpAutoComplete(){
		countries = new Locale[250];
		int i=0;
		for (String countryCode : locales) {			
			Locale obj = new Locale("", countryCode);
			countries[i]=obj;
			locales[i] = countries[i].getDisplayCountry();
			i++;
		}
	}
	
	public void setOrigin(String origin){
		textOrigin.setSelectedItem(origin);
	}
	
	public void setDestination(String destination){
		textDestination.setSelectedItem(destination);
	}
	
	public void setDepartureDate(Date date){
		departureDate.setDate(date);
	}
	
	public void setReturnDate(Date date){
		returnDate.setDate(date);
	}
}
