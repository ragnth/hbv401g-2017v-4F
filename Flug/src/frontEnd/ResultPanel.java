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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ResultPanel extends JPanel {
	private JLabel logo;
	/**
	 * Create the panel.
	 */
	public ResultPanel() {
		setSize(1000, 800);
		setBackground(new Color(49,219,205));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{300, 0, 511, 0};
		gridBagLayout.rowHeights = new int[]{330, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
	   	
	   			logo = new JLabel("");
	   			
	   	GridBagConstraints gbc_logo = new GridBagConstraints();
	   	gbc_logo.insets = new Insets(0, 0, 0, 5);
	   	gbc_logo.fill = GridBagConstraints.BOTH;
	   	gbc_logo.gridx = 1;
	   	gbc_logo.gridy = 0;
	   	add(logo, gbc_logo);
	   	logo.setIcon(new ImageIcon(getClass().getResource("/images/logoSmall.png")));
		
		/*
		Icon icon = new ImageIcon(getClass().getResource("/images/giphy.gif"));
		JLabel loadingGIF = new JLabel(icon);
		loadingGIF.setBounds(300, 300, 300, 300);
		add(loadingGIF);
	
		
		*/
		
		//logo.setBorder(BorderFactory.createLineBorder(Color.white));

		
		
		
	}
}
