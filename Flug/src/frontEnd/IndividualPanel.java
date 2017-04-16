package frontEnd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import backEnd.Trip;
import frontEnd.StyledButtonUI;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class IndividualPanel extends JPanel {

    private JPanel leftPanel;
    private JPanel rightPanel;
    private Dimension preferredSize = new Dimension(400, 100);
    private Color inputColor = new Color(155, 237, 231);
	private Color background = new Color(49,219,205);
	private Color sideReel = new Color(230,107,117);
	private Boolean isSelected = false;
	public JToggleButton select;
	private Trip trip;


    
	public IndividualPanel(Trip trip) {
		setSize(350,100);
		setLayout(null);
		setOpaque(false);
		this.trip = trip;
		

		//Flight info Panel
		leftPanel = new JPanel(new BorderLayout());
		leftPanel.setBounds(0, 0, 250, 100);
		leftPanel.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));
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
	

		if(trip.getFlightTwo()!=null){
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
		}
		

		
		//Price Panel
		rightPanel = new JPanel(new GridLayout(3, 0, 0 , 0));
		rightPanel.setBorder(BorderFactory.createMatteBorder(3, 0, 3, 3, Color.white));
		rightPanel.setBounds(250, 0, 100, 100);
		rightPanel.setBackground(Color.pink);

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
		
		JPanel button = new JPanel();
		button.setOpaque(false);
		rightPanel.add(button);
		
		select = new JToggleButton("Select");
		select.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setSelected();
				if(isSelected){
					select.setBackground(new Color(80, 250, 205));
				}
				else select.setBackground(background);
				
			}
		});
		

		select.setBorder(BorderFactory.createLineBorder(Color.white, 1, true));
		select.setBackground(new Color(49,219,205));
		select.setPreferredSize(new Dimension(70, 25));
		select.setUI(new StyledButtonUI());
		select.setFont(new Font("Monospaced", Font.PLAIN, 10));
		select.setForeground(Color.white);

		select.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				select.setBackground(new Color(80,250,205));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!isSelected){
					select.setBackground(background);
				}
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}
		});	
		button.add(select);

	
	}

	public Dimension getPreferredSize(){
		return preferredSize;
	}
	
	public Boolean isSelected(){
		return isSelected;
	}
	
	public void setSelected(){
		isSelected = !isSelected;
	}
	
	public JToggleButton getButton(){
		return select;
	}
	
	public Trip getTrip(){
		return trip;
	}
}
