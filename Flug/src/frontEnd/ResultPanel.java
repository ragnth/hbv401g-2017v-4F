package frontEnd;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;
import java.awt.GridLayout;

public class ResultPanel extends JPanel {
	private JLabel logo;
	private IndividualPanel panel;
	private JPanel panel1, panel2, panel3;


	
	/**
	 * Create the panel.
	 */
	public ResultPanel() {
		setSize(1000, 800);
		setBackground(new Color(49,219,205));
	   	setLayout(new BorderLayout());
	   	
	   	//Logo panel
	    panel1 = new JPanel();
	   	panel1.setPreferredSize(new Dimension(1000, 220));
	   	panel1.setOpaque(false);
	   	logo = new JLabel("");
	   	logo.setIcon(new ImageIcon(getClass().getResource("/images/logoSmall.png")));
	   	panel1.add(logo);
	   	add(panel1, BorderLayout.NORTH);
	   	logo = new JLabel("");
	   	logo.setIcon(new ImageIcon(getClass().getResource("/images/logoSmall.png")));
	   	
	   	panel2 = new JPanel();
	   	add(panel2, BorderLayout.CENTER);
        
		/*
		Icon icon = new ImageIcon(getClass().getResource("/images/giphy.gif"));
		JLabel loadingGIF = new JLabel(icon);
		loadingGIF.setBounds(300, 300, 300, 300);
		add(loadingGIF);
	
		
		*/
		
		//logo.setBorder(BorderFactory.createLineBorder(Color.white));

		
		
		
	}
}
