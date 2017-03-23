package frontEnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.components.JLocaleChooser;

import backEnd.SearchManager;

import javax.swing.JTextField;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class SearchPane extends JFrame {

	private JPanel contentPane;
	private JTextField origin;
	private JLabel lblDestination;
	private JTextField destination;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchPane frame = new SearchPane();
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
	public SearchPane() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		origin = new JTextField();
		origin.setBounds(66, 75, 130, 26);
		contentPane.add(origin);
		origin.setColumns(10);
		
		JLabel lblOrigin = new JLabel("Origin");
		lblOrigin.setBounds(106, 47, 61, 16);
		contentPane.add(lblOrigin);
		
		lblDestination = new JLabel("Destination");
		lblDestination.setBounds(275, 47, 92, 16);
		contentPane.add(lblDestination);
		
		destination = new JTextField();
		destination.setBounds(244, 75, 130, 26);
		contentPane.add(destination);
		destination.setColumns(10);
		
		JDateChooser out = new JDateChooser();
		out.setBounds(66, 141, 119, 26);
		contentPane.add(out);
		
		JDateChooser in = new JDateChooser();
		in.setBounds(263, 141, 119, 26);
		contentPane.add(in);
		
		JLabel lblLeavingOn = new JLabel("Leaving on");
		lblLeavingOn.setBounds(92, 113, 103, 16);
		contentPane.add(lblLeavingOn);
		
		JLabel lblReturningOn = new JLabel("Returning on");
		lblReturningOn.setBounds(275, 113, 92, 16);
		contentPane.add(lblReturningOn);
		
		JLabel warning = new JLabel("Please select a return date later than the outgoing date");
		warning.setBounds(92, 197, 264, 16);
		contentPane.add(warning);
		warning.setVisible(false);
		
		JButton btnSearch = new JButton("Search!");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				warning.setVisible(false);
				Date date = new Date(); // get date today
				if(!in.getDate().before(out.getDate()) && out.getDate().after(date) || out.getDate().equals(date)){
					SearchManager.createSearch(origin.getText(), destination.getText(), out.getDate(), in.getDate());
				}
				else{
					warning.setVisible(true);
				}
			
				
			}
		});
		btnSearch.setBounds(168, 225, 117, 29);
		contentPane.add(btnSearch);
		
		
	}
}
