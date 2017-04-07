package frontEnd;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;

import backEnd.Trip;

import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.Font;

public class ResultPanel extends JPanel {
	private JLabel logo;
	private IndividualPanel panel;
	private JPanel panel1, panel2, panel3, center;
	private searchPane search = new searchPane();
	private ArrayList<Trip> outgoingTrips;
	private ArrayList<Trip> returnTrips;

	
	/**
	 * Create the panel.
	 */
	public ResultPanel(ArrayList<Trip> outgoingTrips, ArrayList<Trip> returnTrips) {
		setSize(1000, 800);
		setBackground(new Color(49,219,205));
	   	setLayout(new BorderLayout());
	   	
	   	this.outgoingTrips = outgoingTrips;
	   	this.returnTrips = returnTrips;
	   	
	   	
	   	//Logo panel
	    panel1 = new JPanel();
	    panel1.setOpaque(false);
	   	panel1.setPreferredSize(new Dimension(1000, 220));
	   	panel1.setOpaque(false);
	   	logo = new JLabel("");
	   	logo.setIcon(new ImageIcon(getClass().getResource("/images/logoSmall.png")));
	   	panel1.add(logo);
	   	add(panel1, BorderLayout.NORTH);
	   	logo = new JLabel("");
	   	logo.setIcon(new ImageIcon(getClass().getResource("/images/logoSmall.png")));
	   	
	   	panel2 = new JPanel(new BorderLayout());
	   	panel2.setOpaque(false);
	   	add(panel2, BorderLayout.CENTER);
	   	
	   	panel3 = new JPanel();
	   	panel3.setBorder(BorderFactory.createLineBorder(Color.black));
	   	panel3.setOpaque(false);
	   	panel3.setPreferredSize(new Dimension(100,50));
	   	panel2.add(panel3, BorderLayout.NORTH);
	   	panel3.add(search);
	   	
        center = new JPanel(new GridLayout(2, 0, 0, 20));
        center.setOpaque(false);
        panel2.add(center, BorderLayout.CENTER);
        
        //Outgoing trip panel
        JPanel outgoingTripsPanel = new JPanel();
        outgoingTripsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        outgoingTripsPanel.setOpaque(false);
        
        center.add(outgoingTripsPanel);
        
        
        //Manual entries
       /* IndividualPanel out1 = new IndividualPanel();
        IndividualPanel out2 = new IndividualPanel();
        IndividualPanel out3 = new IndividualPanel();
        IndividualPanel out4 = new IndividualPanel();*/
        
        //The pane for the scrollpane
        JPanel outResults = new JPanel();
        outResults.setOpaque(false);
        
        for(Trip trip: outgoingTrips){
        	outResults.add(new IndividualPanel(trip));
        }
        //Add individualpanels
     /*   outResults.add(out1);
        outResults.add(out2);
        outResults.add(out3);
        outResults.add(out4);*/
        //Scrollpane
        JScrollPane scrollPane1 = new JScrollPane(outResults);
        scrollPane1.setOpaque(false);
        scrollPane1.setBorder(BorderFactory.createLineBorder(Color.pink, 5, true));
        scrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane1.setPreferredSize(new Dimension(950, 120));
        
        JLabel outgoing = new JLabel("Outgoing trips:");
        outgoing.setForeground(Color.WHITE);
        outgoing.setFont(new Font("Monospaced", Font.PLAIN, 14));

        
        outgoingTripsPanel.add(outgoing);
        outgoingTripsPanel.add(scrollPane1);
        //Return trip panel
        JPanel returnTripsPanel = new JPanel();
        returnTripsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        returnTripsPanel.setOpaque(false);
        center.add(returnTripsPanel);
     
       //IndividualPanel indi1 = new IndividualPane);
       /*
        IndividualPanel indi2 = new IndividualPanel();
        IndividualPanel indi3 = new IndividualPanel();
        IndividualPanel indi4 = new IndividualPanel();*/
        JPanel resultPanel = new JPanel();
        resultPanel.setOpaque(false);
       /* resultPanel.add(indi1);
        resultPanel.add(indi2);

        resultPanel.add(indi3);

        resultPanel.add(indi4);*/
        
        JLabel returnLabel = new JLabel("Return trips:");
        returnLabel.setForeground(Color.WHITE);
        returnLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(resultPanel);
        scrollPane.setOpaque(false);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.pink, 5, true));

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(950, 120));
       returnTripsPanel.add(returnLabel);
        returnTripsPanel.add(scrollPane);


        
        
      
        JPanel south = new JPanel();
        south.setOpaque(false);
        south.setPreferredSize(new Dimension(1000, 200));
        add(south, BorderLayout.SOUTH);

		/*
		Icon icon = new ImageIcon(getClass().getResource("/images/giphy.gif"));
		JLabel loadingGIF = new JLabel(icon);
		loadingGIF.setBounds(300, 300, 300, 300);
		add(loadingGIF);
	
		
		*/
		
		//logo.setBorder(BorderFactory.createLineBorder(Color.white));

		
		
		
	}
}
