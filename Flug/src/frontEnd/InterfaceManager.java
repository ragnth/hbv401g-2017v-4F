package frontEnd;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import com.toedter.components.JLocaleChooser;

import backEnd.InvalidSearchException;
import backEnd.SearchManager;
import backEnd.Trip;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class InterfaceManager extends JFrame {
	private SearchManager controller;
	private Color background = new Color(29,216,200);
	SearchPanel search = new SearchPanel();
	ResultPanel result;
	private String origin;
	private String destination;
	private Date departureDate;
	private Date returnDate;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceManager frame = new InterfaceManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfaceManager() {
		//Settings for JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 800);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setResizable(false);
		add(search);
		search.btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				origin = search.getOrigin();
				destination = search.getDestination();
				departureDate = search.getIn();
				returnDate = search.getOut();
			
				try{				
					//Try SearchManager with a round trip
					if(search.getRoundTrip()){
						controller = new SearchManager(search.getOrigin(), search.getDestination(), search.getOut(), search.getIn(), search.getPassengers(), search.getRoundTrip());
					}
					//Try SearchManager with a one way trip
					else controller = new SearchManager(search.getOrigin(), search.getDestination(), search.getOut(), search.getPassengers(), search.getRoundTrip());
					//Call the search function in SearchManager
					controller.search();
					//Retrieve results for both trips and construct the result panel
					result = new ResultPanel(controller.getOutgoingTrips(), controller.getReturnTrips(), controller.getRoundTrip(), controller.getSearchInfo());
					//
					search.setVisible(false);
					add(result);
					
					 result.book.addActionListener(new ActionListener() {
				         public void actionPerformed(ActionEvent e) {
				        	 JTextField kennitala = new JTextField();
				        	 JTextField fullName = new JTextField();
				        	 final JComponent[] inputs = new JComponent[] {
				        	         new JLabel("Kennitala:"),
				        	         kennitala,
				        	   
				        	         new JLabel("Full name:"),
				        	         fullName
				        	 };
				        	 int result = JOptionPane.showConfirmDialog(null, inputs, "Book flight", JOptionPane.PLAIN_MESSAGE);
				        	 if (result == JOptionPane.OK_OPTION) {
				        	     System.out.println("You entered " +
				        	             kennitala.getText() + ", " +
				        	             fullName.getText());
				        	 } else {
				        	     System.out.println("User canceled / closed the dialog, result = " + result);
				        	 }
				            
				         }
				      });
					
			
				}
				catch (InvalidSearchException e1){
					JOptionPane.showMessageDialog(search, "Please select a valid search!", "Invalid search", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		
		});
		
		
		
		
		
			}
	
	
	

}
