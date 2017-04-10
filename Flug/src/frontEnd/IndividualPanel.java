package frontEnd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

import backEnd.Trip;

import javax.swing.SwingConstants;
import java.awt.Font;

public class IndividualPanel extends JPanel {

    private JPanel leftPanel;
    private JPanel rightPanel;
    private Dimension preferredSize = new Dimension(400, 100);
    private Color inputColor = new Color(155, 237, 231);
    
	public IndividualPanel(Trip trip) {
		setSize(350,100);
		setLayout(null);
		setOpaque(false);
		
		
		//Flight info Panel
		leftPanel = new JPanel(new BorderLayout());
		leftPanel.setBounds(0, 0, 250, 100);
		leftPanel.setBackground(inputColor);
		add(leftPanel);
		
		
		//Airline title panel
		JLabel airline = new JLabel();
		airline.setText(trip.getFlightOne().getAirline());
		airline.setFont(new Font("Avenir", Font.PLAIN, 16));
		airline.setHorizontalAlignment(SwingConstants.CENTER);
		airline.setPreferredSize(new Dimension(180, 40));
		leftPanel.add(airline, BorderLayout.NORTH);

		//Flight information
		JPanel flights = new JPanel(new GridLayout(2, 0, 0, 0));
		flights.setBackground(inputColor);
		//flights.setBorder(BorderFactory.createLineBorder(Color.black));
		leftPanel.add(flights, BorderLayout.CENTER);
		leftPanel.setBackground(inputColor);
		
		
		
	   
		
		JPanel firstTrip = new JPanel();
		firstTrip.setBackground(inputColor);
		JLabel firstFlightA = new JLabel(trip.getFlightOne().getOrigin());
		JLabel rightIcon = new JLabel();
		rightIcon.setIcon(new ImageIcon(getClass().getResource("/images/paperRight.png")));
		JLabel firstFlightB = new JLabel(trip.getFlightOne().getDestination());
		firstTrip.add(firstFlightA);
		firstTrip.add(rightIcon);
		firstTrip.add(firstFlightB);
		flights.add(firstTrip);
	

	//	if(trip.getFlightTwo()!=null){
			JPanel secondTrip = new JPanel();
			secondTrip.setBackground(inputColor);
	
			JLabel leftIcon = new JLabel();
			leftIcon.setIcon(new ImageIcon(getClass().getResource("/images/paperRight.png")));
			JLabel secondFlightA = new JLabel(trip.getFlightTwo().getOrigin());
			JLabel secondFlightB = new JLabel(trip.getFlightTwo().getDestination());
			secondTrip.add(secondFlightA);
			secondTrip.add(leftIcon);
			secondTrip.add(secondFlightB);
			flights.add(secondTrip);			
	//	}
		

		
		//Price Panel
		rightPanel = new JPanel(new GridLayout(3, 0, 0 , 0));
		rightPanel.setBounds(250, 0, 100, 100);
		rightPanel.setOpaque(false);
		add(rightPanel);
		
		
		JLabel price = new JLabel();
		price.setText(Integer.toString(trip.getPrice()) + " ISK");
		price.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(price);
		
		if(trip.getFlightOne().getBags()){
		JLabel icon = new JLabel();
		icon.setHorizontalAlignment(SwingConstants.CENTER);
		icon.setIcon(new ImageIcon(getClass().getResource("/images/briefcase.png")));
		rightPanel.add(icon);
		}
		
		JButton select = new JButton("SELECT");
		select.setSize(80, 20);
		rightPanel.add(select);
	}
	
	public Dimension getPreferredSize(){
		return preferredSize;
	}



}
