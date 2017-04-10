package frontEnd;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.components.JLocaleChooser;

import backEnd.InvalidSearchException;
import backEnd.SearchManager;
import backEnd.Trip;

import javax.swing.JTextField;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class InterfaceManager extends JFrame {
	private SearchManager controller;
	private Color background = new Color(29,216,200);
	SearchPanel search = new SearchPanel();
	ResultPanel result;



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
				try{				
					controller = new SearchManager(search.getOrigin(), search.getDestination(), search.getOut(), search.getIn(), search.getPassengers(), search.getRoundTrip());
					controller.search();
					//get both trips, put in result pane
					result = new ResultPanel(controller.getOutgoingTrips(), controller.getReturnTrips(), controller.getRoundTrip());
					
					
					search.setVisible(false);
					add(result);
					
					

					
			
				}
				catch (InvalidSearchException e1){
					System.out.println("Input error!");
				}
				
			}
		});
		
		
			}

}
