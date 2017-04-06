package frontEnd;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import backEnd.InvalidSearchException;
import backEnd.SearchManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchPanel extends JPanel {
	public JTextField origin;
	private JLabel lblDestination;
	public JTextField destination;
	private Label lblOrigin;
	private JLabel lblLeavingOn;
	private JLabel lblReturningOn;
	public JButton btnSearch;
	private JLabel logo;
	public JDateChooser out;
	public JDateChooser in;
	private SearchManager controller;
	private Color background = new Color(49,219,205);


	public SearchPanel() {
		setSize(1000, 800);
		setLayout(null);
		setBackground(background);
		
		origin = new JTextField();
		origin.setBounds(147, 455, 130, 26);
		add(origin);
		lblOrigin = new Label("Origin");
		lblOrigin.setBounds(189, 427, 61, 16);
		add(lblOrigin);
		
		lblDestination = new JLabel("Destination");
		lblDestination.setBounds(343, 427, 92, 16);
		add(lblDestination);
		
		destination = new JTextField();
		destination.setBounds(317, 455, 130, 26);
		add(destination);
		
		out = new JDateChooser();
		out.setBounds(514, 455, 119, 26);
		add(out);
		
		in = new JDateChooser();
		in.setBounds(658, 455, 119, 26);
		add(in);
		
		lblLeavingOn = new JLabel("Leaving on");
		lblLeavingOn.setBounds(536, 427, 103, 16);
		add(lblLeavingOn);
		
		lblReturningOn = new JLabel("Returning on");
		lblReturningOn.setBounds(675, 427, 92, 16);
		add(lblReturningOn);
		
		btnSearch = new JButton("Search!");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSearch.setOpaque(true);
				btnSearch.setBackground(new Color(80,250,205));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSearch.setBackground(background);
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}
		});
		btnSearch.setBounds(416, 549, 117, 29);
		btnSearch.setBorder(BorderFactory.createLineBorder((Color.white), 2, true));
		btnSearch.setForeground(Color.white);
		btnSearch.setBackground(background);
		add(btnSearch);

		logo = new JLabel("");
		logo.setBounds(120, 50, 730, 330);
	
		add(logo);
		logo.setIcon(new ImageIcon(getClass().getResource("/images/logo2.png")));
	//	logo.setBorder(BorderFactory.createLineBorder(Color.white));
		
		
	}
	

}
