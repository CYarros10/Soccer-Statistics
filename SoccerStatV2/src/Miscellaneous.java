import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


class MiscPanel extends JPanel {

	static double yellows = 0;
	static double reds = 0;

	public MiscPanel() {

		TitledBorder title;
		title = BorderFactory.createTitledBorder("Miscellaneous");
		setBorder(title);
		
		//===========================
		// Yellows
		//===========================

		// Button for incrementing and decrementing 

		//yellow
		JButton yellowButton1 = new  JButton("Yellow Card");
		yellowButton1.setFont(new Font("Arial", Font.PLAIN, 11));
		add(yellowButton1,BorderLayout.NORTH);


		//Counter
		final JLabel yellowCount = new JLabel("0");
		add(yellowCount,BorderLayout.NORTH);


		// ActionListener waits for a button to be clicked and then does something
		//Steals
		yellowButton1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				yellowCount.setVisible(true);         
				yellows += 1 ;
				yellowCount.setText(String.valueOf((int) yellows));
			}
		}
				);

		//===========================
		// Reds
		//===========================

		// Button for incrementing and decrementing 

		//Red
		JButton redButton1 = new  JButton("Red Card");
		redButton1.setFont(new Font("Arial", Font.PLAIN, 11));
		add(redButton1,BorderLayout.NORTH);


		//Counter
		final JLabel redCount = new JLabel("0");
		add(redCount,BorderLayout.NORTH);


		// ActionListener waits for a button to be clicked and then does something
		//Steals
		redButton1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				redCount.setVisible(true);         
				reds += 1 ;
				redCount.setText(String.valueOf((int) reds));
			}
		}
				);
	}
}
