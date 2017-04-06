package frontEnd;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ResultPanel extends JPanel {
	private JLabel logo;
	/**
	 * Create the panel.
	 */
	public ResultPanel() {
		setSize(1000, 800);
		setLayout(null);
		setBackground(new Color(49,219,205));

		logo = new JLabel("");
		logo.setBounds(300, 20, 511, 330);
		
	   	add(logo);
		 logo.setIcon(new ImageIcon(getClass().getResource("/images/logoSmall.png")));
		
		
			Icon icon = new ImageIcon(getClass().getResource("/images/giphy.gif"));
			JLabel loadingGIF = new JLabel(icon);
			loadingGIF.setBounds(300, 300, 300, 300);
			add(loadingGIF);
	
		
		
		
		//logo.setBorder(BorderFactory.createLineBorder(Color.white));

		
		
		
	}
}
