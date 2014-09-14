import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

class DefensePanel extends JPanel {


	//===================
	static double passInterceptions = 0;
	static double tacklesWon = 0;
	static double headersWon = 0;
	static double clearances = 0;
	static double goalLineSaves = 0;
	//===================

	public static double getPassInterceptions() {
		return passInterceptions;
	}
	public static double getTacklesWon() {
		return tacklesWon;
	}
	
	public static double getHeadersWon() {
		return headersWon;
	}
	
	public static double getClearances() {
		return clearances;
	}
	
	public static double getGoalLineSaves() {
		return goalLineSaves;
	}
	
	
	
	
	//================
	// Defensive Score
	// ===============

	public static double getDefenseScore() {

		// Start with 50 points
		// Goal line save = 15 points
		// tackleWon = 3 points
		// headerWon = 2 points
		// passInterception = 3 point
		// Clearance = 1 point

		double score = 50 + goalLineSaves*20 + tacklesWon*5 + headersWon*3 
				+ passInterceptions*5 + clearances;

		return score;
	}


	public DefensePanel() {

		TitledBorder title;
		title = BorderFactory.createTitledBorder("Defense");
		setBorder(title);
		setLayout(new GridLayout(1,2));



		JPanel Buttons = new JPanel();
		Buttons.setLayout(new GridLayout(5,2));

		JPanel Labels = new JPanel();
		Labels.setLayout(new GridLayout(5,1));
		
		//===========================
		// Pass Interceptions
		//===========================

		// Button for incrementing and decrementing 

		//Pass Intercept
		JButton interceptPlus = new  JButton("+");
		interceptPlus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(interceptPlus,BorderLayout.NORTH);

		JButton interceptMinus = new  JButton("-");
		interceptMinus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(interceptMinus,BorderLayout.NORTH);


		//Counter
		final JLabel interceptLabel = new JLabel("Pass Interceptions: 0");
		Labels.add(interceptLabel,BorderLayout.NORTH);


		// ActionListener waits for a button to be clicked and then does something
		//Steals
		interceptPlus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				interceptLabel.setVisible(true);         
				passInterceptions += 1 ;
				interceptLabel.setText("Pass Interceptions: "+String.valueOf((int) passInterceptions));
			}
		}
				);

		interceptMinus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				interceptLabel.setVisible(true);
				if (passInterceptions > 0) 
					passInterceptions -= 1 ;
				interceptLabel.setText("Pass Interceptions: "+String.valueOf((int) passInterceptions));
			}
		}
				);


		//===========================
		// Tackles Won
		//===========================

		// Button for incrementing and decrementing 

		//Pass Intercept
		JButton tacklePlus = new  JButton("+");
		tacklePlus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(tacklePlus,BorderLayout.NORTH);

		//Pass Intercept
		JButton tackleMinus = new  JButton("-");
		tackleMinus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(tackleMinus,BorderLayout.NORTH);


		//Counter
		final JLabel tackleLabel = new JLabel("Tackles Won: 0");
		Labels.add(tackleLabel,BorderLayout.NORTH);


		// ActionListener waits for a button to be clicked and then does something
		//Steals
		tacklePlus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				tackleLabel.setVisible(true);         
				tacklesWon += 1 ;
				tackleLabel.setText("Tackles Won: "+String.valueOf((int) tacklesWon));
			}
		}
				);

		// ActionListener waits for a button to be clicked and then does something
		//Steals
		tackleMinus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				tackleLabel.setVisible(true);  
				if (tacklesWon > 0)
					tacklesWon -= 1 ;
				tackleLabel.setText("Tackles Won: "+String.valueOf((int) tacklesWon));
			}
		}
				);


		//===========================
		// Headers Won
		//===========================

		// Button for incrementing and decrementing 

		//Header Won Plus
		JButton headerPlus = new  JButton("+");
		headerPlus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(headerPlus,BorderLayout.NORTH);

		JButton headerMinus = new  JButton("-");
		headerMinus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(headerMinus,BorderLayout.NORTH);


		//Counter
		final JLabel headerLabel = new JLabel("Headers Won: 0");
		Labels.add(headerLabel,BorderLayout.NORTH);


		// Add 1 to header count if plus is pressed
		headerPlus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				headerLabel.setVisible(true);         
				headersWon += 1 ;
				headerLabel.setText("Headers Won: "+String.valueOf((int) headersWon));
			}
		}
				);

		// Subtract 1 to header count if minus is pressed
		headerMinus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				headerLabel.setVisible(true); 
				if (headersWon > 0)
					headersWon -= 1 ;
				headerLabel.setText("Headers Won: "+String.valueOf((int) headersWon));
			}
		}
				);


		//===========================
		// Defensive Clearances
		//===========================

		// Buttons for incrementing and decrementing 
		JButton clearancePlus = new  JButton("+");
		clearancePlus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(clearancePlus,BorderLayout.NORTH);

		JButton clearanceMinus = new  JButton("-");
		clearanceMinus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(clearanceMinus,BorderLayout.NORTH);

		//Counter
		final JLabel clearanceLabel = new JLabel("Defensive Clearances: 0");
		Labels.add(clearanceLabel,BorderLayout.NORTH);


		// ActionListener waits for a button to be clicked and then does something
		//Add 1 to defensive clearances
		clearancePlus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				clearanceLabel.setVisible(true);         
				clearances += 1 ;
				clearanceLabel.setText("Defensive Clearances: "+String.valueOf((int) clearances));
			}
		}
				);
		
		//Subtract 1 from defensive clearances
		clearanceMinus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				clearanceLabel.setVisible(true);         
				if (clearances > 0)
					clearances -= 1 ;
				clearanceLabel.setText("Defensive Clearances: "+String.valueOf((int) clearances));
			}
		}
				);


		//===========================
		// Goal Line Saves
		//===========================

		// + Button
		JButton goalSavePlus = new  JButton("+");
		goalSavePlus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(goalSavePlus,BorderLayout.NORTH);
		
		// - Button
		JButton goalSaveMinus = new  JButton("-");
		goalSaveMinus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(goalSaveMinus,BorderLayout.NORTH);


		//Counter
		final JLabel goalSaveLabel = new JLabel("Goal Line Saves: 0");
		Labels.add(goalSaveLabel,BorderLayout.NORTH);


		// ActionListener waits for a button to be clicked and then does something
		//Add 1 to goal line saves
		goalSavePlus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				goalSaveLabel.setVisible(true);         
				goalLineSaves += 1 ;
				goalSaveLabel.setText("Goal Line Saves: "+String.valueOf((int) goalLineSaves));
			}
		}
				);
		
		
		goalSaveMinus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				goalSaveLabel.setVisible(true);   
				if (goalLineSaves > 0)
					goalLineSaves -= 1 ;
				goalSaveLabel.setText("Goal Line Saves: "+String.valueOf((int) goalLineSaves));
			}
		}
				);
		
		
		
		add(Buttons);
		add(Labels);


	}
}
