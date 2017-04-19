package frontEnd;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SearchButton extends JButton {
    private Color btnColor = new Color(34, 195, 182);

	public SearchButton(Dimension d){
		setText("Search!");
		setPreferredSize(d);
		setBackground(btnColor);
		setForeground(Color.white);
		setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
	   	setFont(new Font("Monospaced", Font.PLAIN, 15));
	   	setUI(new StyledButtonUI());
	   	
	   	addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(80,250,205));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(btnColor);
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}
		});	
	   	
	   	
	}
	

}
