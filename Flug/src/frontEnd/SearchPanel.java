package frontEnd;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.toedter.calendar.JDateChooser;

import backEnd.FlightStorage;
import backEnd.InvalidSearchException;
import backEnd.SearchManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Locale;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class SearchPanel extends JPanel {
	
	private SearchManager controller;
	public JButton btnSearch;
	private searchPane searchPane;
	private JLabel logo;
	private Color background = new Color(49,219,205);
    private Color btnColor = new Color(34, 195, 182);

	
 
	public SearchPanel() {
		setSize(1000, 800);
		setBackground(background);
		setLayout(new BorderLayout());
		
		logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon(getClass().getResource("/images/logo2.png")));
		logo.setPreferredSize(new Dimension(500, 400));
		add(logo, BorderLayout.NORTH);
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setOpaque(false);
		add(panel, BorderLayout.CENTER);
		searchPane = new searchPane();
		searchPane.setPreferredSize(new Dimension(700, 50));
		panel.add(searchPane);
		
		JPanel panel2 = new JPanel();
	   	panel2.setPreferredSize(new Dimension(120, 280));
	   	panel2.setOpaque(false);
	   	add(panel2, BorderLayout.SOUTH);
	   	
	   	
		btnSearch = new JButton("Search!");
		btnSearch.setPreferredSize(new Dimension(120, 30));
		btnSearch.setBackground(btnColor);
		btnSearch.setForeground(Color.white);
		btnSearch.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
	   	btnSearch.setFont(new Font("Monospaced", Font.PLAIN, 15));
	   	btnSearch.setUI(new StyledButtonUI());

		panel2.add(btnSearch);
		
		
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSearch.setBackground(new Color(80,250,205));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSearch.setBackground(btnColor);
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}
		});	
	}
	
	public void load(){
			
		ImageIcon loading = new ImageIcon(getClass().getResource("/images/ring-alt.gif"));
		btnSearch.setText(null);
		btnSearch.setIcon(loading);
		btnSearch.setPreferredSize(new Dimension(60, 60));
		btnSearch.setBorder(null);
		

	}
	
	public String getOrigin(){
		return searchPane.textOrigin.getSelectedItem().toString();
	}
	
	public String getDestination(){
		return searchPane.textDestination.getSelectedItem().toString();
	}
	
	
	public Date getIn(){
		return searchPane.returnDate.getDate();
	}
	
	public Date getOut(){
		return searchPane.departureDate.getDate();
	}	
	 
	public int getPassengers(){
		return Integer.parseInt(searchPane.passengers.getSelectedItem().toString());
	}

	public Boolean getRoundTrip(){
		return searchPane.roundTrip.isSelected();
	}
}
