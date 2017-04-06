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

import javax.swing.JTextField;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class InterfaceManager extends JFrame {

	private JTextField origin;
	private JLabel lblDestination;
	private JTextField destination;
	private SearchManager controller;
	private Color background = new Color(29,216,200);
	SearchPanel search = new SearchPanel();
	ResultPanel result = new ResultPanel();
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
		setSize(1000, 650);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setResizable(false);

		//test.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(search);
		search.btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{				
					controller = new SearchManager(search.origin.getText(), search.destination.getText(), search.out.getDate(), search.in.getDate(), 3, true);
					setContentPane(result);
					validate();
					controller.search();

					
					

					
			
				}
				catch (InvalidSearchException e1){
					System.out.println("Input error!");
				}
				
			}
		});
		
		
		//contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPanel.setBackground(background);
		//setContentPane(contentPanel);
		
	
		
		
		
		
		
	}
	
	public Color getBackground(){
		return background;
	}
}
