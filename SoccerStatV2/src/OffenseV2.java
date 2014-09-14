import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


class OffensePanel extends JPanel {

	//============
	static double shotAttempts = 0;
	static double shotsOnGoal = 0;
	static double goals = 0;
	static double assists = 0;
	static double crosses = 0;
	//============

	
	//----------
	//Getters
	//----------
	
	public static double getShotAttempts() {
		return shotAttempts;
	}
	
	public static double getShotsOnGoal() {
		return shotsOnGoal;
	}
	
	public static double getGoals() {
		return goals;
	}
	
	public static double getAssists() {
		return assists;
	}
	
	public static double getCrosses() {
		return crosses;
	}
	
	
	// Return the Offensive Score base on the following stat scores:
	// Start with 50 points
	// Goal = 30 points
	// Assist = 25 points
	// Shot on goal = 5 points
	// shot miss = -2 points
	// crosses = 1 point
	public static double getOffenseScore() {
		double shotsMissed = shotAttempts - shotsOnGoal;
		double score = 50 + goals*30 + assists*25 + shotsOnGoal*5 + shotsMissed*(-2) + crosses;
		return score;
	}

	
	// Constructor
	public OffensePanel() {

		TitledBorder title;
		title = BorderFactory.createTitledBorder("Offense");
		setBorder(title);
		setLayout(new GridLayout(1,2));

		JPanel Buttons = new JPanel();
		Buttons.setLayout(new GridLayout(5,2));

		JPanel Labels = new JPanel();
		Labels.setLayout(new GridLayout(5,1));

		//===========================
		// Goals
		//===========================

		JButton goalPlus = new  JButton("+");
		goalPlus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(goalPlus, BorderLayout.NORTH);

		JButton goalMinus = new  JButton("-");
		goalMinus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(goalMinus, BorderLayout.NORTH);

		final JLabel goalLabel = new JLabel("Goals: 0");
		Labels.add(goalLabel);

		//Shot Counters
		final JLabel sogLabel = new JLabel("Shots on Goal: 0");
		final JLabel shotAttLabel = new JLabel("Shot Attempts: 0");


		// Add 1 to goals if button pressed
		goalPlus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				goalLabel.setVisible(true);         
				goals += 1 ;
				shotsOnGoal +=1;
				shotAttempts += 1;
				goalLabel.setText("Goals: " + String.valueOf((int) goals));
				sogLabel.setText("Shots on Goal: "+String.valueOf(String.valueOf((int) shotsOnGoal)));
				shotAttLabel.setText("Shot Attempts: "+String.valueOf(String.valueOf((int) shotAttempts)));
			}
		}
				);

		// Subtract 1 from goals if button pressed
		goalMinus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//goalCount.setVisible(true);         
				goals -= 1 ;
				shotsOnGoal -=1;
				shotAttempts -= 1;

				if (goals < 0)
					goals = 0;
				if (shotsOnGoal < 0)
					shotsOnGoal = 0;
				if (shotAttempts < 0)
					shotAttempts =0;

				goalLabel.setText("Goals: "+String.valueOf((int) goals));
				sogLabel.setText("Shots on Goal: "+String.valueOf(String.valueOf((int) shotsOnGoal)));
				shotAttLabel.setText("Shot Attempts: "+String.valueOf(String.valueOf((int) shotAttempts)));
			}
		}
				);

		//===========================
		// Assists
		//===========================

		// PLUS ASSIST
		JButton assistPlus = new  JButton("+");
		assistPlus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(assistPlus,BorderLayout.NORTH);

		// MINUS ASSIST
		JButton assistMinus = new  JButton("-");
		assistMinus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(assistMinus,BorderLayout.NORTH);

		final JLabel assistLabel = new JLabel("Assists: 0");
		Labels.add(assistLabel);


		add(Buttons);
		add(Labels);

		//Assists +1
		assistPlus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				assistLabel.setVisible(true);         
				assists += 1 ;
				assistLabel.setText("Assists: "+String.valueOf((int) assists));

			}
		}
				);

		//Assists -1
		assistMinus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				assistLabel.setVisible(true);   
				if (assists > 0)
					assists -= 1;
				assistLabel.setText("Assists: "+String.valueOf((int) assists));

			}
		}
				);
		
		//===========================
		// Crosses
		//===========================

		// PLUS ASSIST
		JButton crossPlus = new  JButton("+");
		crossPlus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(crossPlus,BorderLayout.NORTH);

		// MINUS ASSIST
		JButton crossMinus = new  JButton("-");
		assistMinus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(crossMinus,BorderLayout.NORTH);

		final JLabel crossLabel = new JLabel("Crosses/Corners: 0");
		Labels.add(crossLabel);


		add(Buttons);
		add(Labels);

		// Crosses +1
		crossPlus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				crossLabel.setVisible(true);         
				crosses += 1 ;
				crossLabel.setText("Crosses/Corners: "+String.valueOf((int) crosses));

			}
		}
				);

		// Crosses -1
		crossMinus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				crossLabel.setVisible(true);   
				if (crosses > 0)
					crosses -= 1;
				crossLabel.setText("Crosses/Corners: "+String.valueOf((int) crosses));

			}
		}
				);
		
		
		//===========================
		// SHOOTING ON GOAL
		//===========================

		// Button for incrementing and decrementing 

		//shot on goal plus
		JButton sogPlus = new  JButton("+");
		sogPlus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(sogPlus);

		//shot on goal minus
		JButton sogMinus = new  JButton("-");
		sogMinus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(sogMinus);


		Labels.add(sogLabel);


		//Shots On Goal +1
		sogPlus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				sogLabel.setVisible(true);         
				shotAttempts += 1 ;
				shotsOnGoal += 1;
				sogLabel.setText("Shots on Goal: "+String.valueOf(String.valueOf((int) shotsOnGoal)));
				shotAttLabel.setText("Shot Attempts: "+String.valueOf(String.valueOf((int) shotAttempts)));
			}
		}
				);


		//Shots On Goal -1
		sogMinus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				sogLabel.setVisible(true);         
				shotAttempts -= 1 ;
				shotsOnGoal -= 1;
				sogLabel.setText("Shots on Goal: "+String.valueOf(String.valueOf((int) shotsOnGoal)));
				shotAttLabel.setText("Shot Attempts: "+String.valueOf(String.valueOf((int) shotAttempts)));
			}
		}
				);

		//===========================
		// SHOT ATTEMPTS
		//===========================

		// Button for incrementing and decrementing 

		//shot on goal plus
		JButton shotAttPlus = new  JButton("+");
		shotAttPlus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(shotAttPlus);

		//shot on goal minus
		JButton shotAttMinus = new  JButton("-");
		shotAttMinus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(shotAttMinus);

		Labels.add(shotAttLabel);


		//Shots Attempts +1
		shotAttPlus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				shotAttLabel.setVisible(true);         
				shotAttempts += 1 ;
				shotAttLabel.setText("Shot Attempts: "+String.valueOf(String.valueOf((int) shotAttempts)));
			}
		}
				);


		//Shots Attempts -1
		shotAttMinus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				shotAttLabel.setVisible(true);
				if (shotAttempts > shotsOnGoal)
					shotAttempts -= 1;
				shotAttLabel.setText("Shot Attempts: "+String.valueOf(String.valueOf((int) shotAttempts)));
			}
		}
				);

	}
}