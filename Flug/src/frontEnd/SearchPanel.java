package frontEnd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

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

public class SearchPanel extends JFrame {

	private JPanel contentPanel;
	private JTextField origin;
	private JLabel lblDestination;
	private JTextField destination;
	private SearchManager controller;
	private Color background = new Color(29,216,200);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchPanel frame = new SearchPanel();
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
	public SearchPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(background);
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		origin = new JTextField();
		origin.setBounds(158, 588, 130, 26);
		contentPanel.add(origin);
		origin.setColumns(10);
		
		JLabel lblOrigin = new JLabel("Origin");
		lblOrigin.setBounds(193, 572, 61, 16);
		contentPanel.add(lblOrigin);
		
		lblDestination = new JLabel("Destination");
		lblDestination.setBounds(357, 560, 92, 16);
		contentPanel.add(lblDestination);
		
		destination = new JTextField();
		destination.setBounds(343, 588, 130, 26);
		contentPanel.add(destination);
		destination.setColumns(10);
		
		JDateChooser out = new JDateChooser();
		out.setBounds(523, 588, 119, 26);
		contentPanel.add(out);
		
		JDateChooser in = new JDateChooser();
		in.setBounds(690, 588, 119, 26);
		contentPanel.add(in);
		
		JLabel lblLeavingOn = new JLabel("Leaving on");
		lblLeavingOn.setBounds(523, 560, 103, 16);
		contentPanel.add(lblLeavingOn);
		
		JLabel lblReturningOn = new JLabel("Returning on");
		lblReturningOn.setBounds(702, 560, 92, 16);
		contentPanel.add(lblReturningOn);
		
		JButton btnSearch = new JButton("Search!");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					controller = new SearchManager(origin.getText(), destination.getText(), out.getDate(), in.getDate(), 3, true);
				}
				catch (InvalidSearchException e1){
					System.out.println("Inpu error!");
				}
				
			}
		});
		btnSearch.setBounds(418, 643, 117, 29);
		contentPanel.add(btnSearch);
		
		JLabel logo = new JLabel("");
		logo.setBounds(120, 50, 730, 330);
		contentPanel.add(logo);
		logo.setIcon(new ImageIcon(getClass().getResource("/images/logo2.png")));
		logo.setBorder(BorderFactory.createLineBorder(Color.white));
		
	}
}
