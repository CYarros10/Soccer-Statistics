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

public class PossessionV2 {


	public static void main(String[] args) {
		// creates frame object
		JFrame frame = new JFrame();
		// Closes frame when user clicks x
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// title of frame
		frame.setTitle("Possession Stats");
		// Centers the jframe
		frame.setLocationRelativeTo(null);
		// Set the size of the frame
		frame.setSize(100, 100);
		// Set layout of frame
		frame.setLayout(new BoxLayout(frame.getContentPane(),
				BoxLayout.PAGE_AXIS));

		frame.setMinimumSize(new Dimension(100, 100));
		frame.getContentPane().add(new PossessionPanel());
		frame.pack();
		frame.setVisible(true);
	}
}

class PossessionPanel extends JPanel {

	// ==============
	static double passAttempts = 0;
	static double passCompletions = 0;
	static double turnovers = 0;
	static double offsides = 0;
	static double fouls = 0;
	// ==============
	
	public static double getPassAttempts() {
		return passAttempts;
	}
	
	public static double getPassCompletions() {
		return passCompletions;
	}
	
	public static double getTurnovers() {
		return turnovers;
	}
	
	public static double getOffsides() {
		return offsides;
	}
	
	public static double getFouls() {
		return fouls;
	}
	


	public static double getPossessionScore() {

		double score = 50;

		// start with 50 points
		// pass completion = 1 points;
		// turnover = -3 point
		// passPercentage = up to 30 points

		double passPercentScore = (passCompletions/passAttempts);

		if (passCompletions < 15)
			passPercentScore *= 10;
		else if (passCompletions < 30)
			passPercentScore *=20;
		else if (passCompletions > 30) 
			passPercentScore *=30;

		if (passCompletions != 0) 
			score += passCompletions + passPercentScore;
		if (turnovers != 0)
			score += turnovers*(-1);

		return score;


	}

	public PossessionPanel() {

		TitledBorder title;
		title = BorderFactory.createTitledBorder("Possession");
		setBorder(title);
		setLayout(new GridLayout(1,2));



		JPanel Buttons = new JPanel();
		Buttons.setLayout(new GridLayout(5,2));

		JPanel Labels = new JPanel();
		Labels.setLayout(new GridLayout(5,1));

		add(Buttons);
		add(Labels);


		// ===========================
		// Turnovers
		// ===========================

		// + Turnover
		JButton turnPlus = new JButton("+");
		turnPlus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(turnPlus);

		// - Turnover
		JButton turnMinus = new JButton("-");
		turnMinus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(turnMinus);

		// Counter
		final JLabel turnLabel = new JLabel("Turnovers: 0");
		Labels.add(turnLabel);

		// ActionListener waits for a button to be clicked and then does
		// something
		// Turnovers +1
		turnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				turnLabel.setVisible(true);
				turnovers += 1;
				turnLabel.setText("Turnovers: "+String.valueOf((int) turnovers));
			}
		});

		turnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				turnLabel.setVisible(true);
				if (turnovers > 0 && turnovers > (passAttempts - passCompletions))
					turnovers -= 1;
				turnLabel.setText("Turnovers: "+String.valueOf((int) turnovers));
			}
		});

		// ===========================
		// Offsides
		// ===========================

		// + Offsides 
		JButton offPlus = new JButton("+");
		offPlus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(offPlus);

		// - Offsides 
		JButton offMinus = new JButton("-");
		offMinus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(offMinus);

		// Counter Label
		final JLabel offLabel = new JLabel("Offsides: 0");
		Labels.add(offLabel);

		// ActionListener waits for a button to be clicked and then does
		// something
		// Turnovers
		offPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				offLabel.setVisible(true);
				turnLabel.setVisible(true);
				offsides += 1;
				turnovers += 1;
				turnLabel.setText(String.valueOf("Turnovers: "+(int) turnovers));
				offLabel.setText("Offsides: "+String.valueOf((int) offsides));
			}
		});

		offMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				offLabel.setVisible(true);
				turnLabel.setVisible(true);
				if(turnovers > 0 && offsides > 0) {
					offsides -= 1;
					turnovers -= 1;
				}
				turnLabel.setText(String.valueOf("Turnovers: "+(int) turnovers));
				offLabel.setText("Offsides: "+String.valueOf((int) offsides));
			}
		});


		// ===========================
		// Fouls
		// ===========================

		// Button for incrementing and decrementing

		// + Fouls
		JButton foulPlus = new JButton("+");
		foulPlus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(foulPlus);

		// Fouls
		JButton foulMinus = new JButton("-");
		foulMinus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(foulMinus);

		// Counter
		final JLabel foulLabel = new JLabel("Fouls: 0");
		Labels.add(foulLabel);

		// ActionListener waits for a button to be clicked and then does
		// something
		// Fouls +1
		foulPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				foulLabel.setVisible(true);
				fouls += 1;
				turnovers += 1;
				turnLabel.setText("Turnovers: "+String.valueOf((int) turnovers));
				foulLabel.setText("Fouls: "+String.valueOf((int) fouls));
			}
		});

		// Fouls -1
		foulMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				foulLabel.setVisible(true);
				if(fouls > 0) 
					fouls -= 1;
				if(turnovers > 0)
					turnovers -= 1;
				turnLabel.setText("Turnovers: "+String.valueOf((int) turnovers));
				foulLabel.setText("Fouls: "+String.valueOf((int) fouls));
			}
		});




		// ============================
		// PASSING
		// ============================

		// Button for incrementing and decrementing

		// Completion +
		JButton passComPlus = new JButton("+");
		passComPlus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(passComPlus);

		// Completion -
		JButton passComMinus = new JButton("-");
		passComMinus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(passComMinus);

		// Completion Counter
		final JLabel passComLabel = new JLabel("Pass Completions: 0");
		Labels.add(passComLabel);



		// Attempt +
		JButton passAttPlus = new JButton("+");
		passAttPlus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(passAttPlus);

		// Attempt -
		JButton passAttMinus = new JButton("-");
		passAttMinus.setFont(new Font("Arial", Font.PLAIN, 20));
		Buttons.add(passAttMinus);

		// Total Attempt Counter
		final JLabel passAttLabel = new JLabel("Pass Attempts: 0");
		Labels.add(passAttLabel);

		// Pass Completion +1
		passComPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				passComLabel.setVisible(true);
				passAttempts += 1;
				passCompletions += 1;
				passComLabel.setText("Pass Completions: "+String.valueOf((int) passCompletions));
				passAttLabel.setText("Pass Attempts: "+String.valueOf((int) passAttempts));
			}
		});


		// Pass Completion -1
		passComMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				passComLabel.setVisible(true);
				if(passAttempts > 0) 
					passAttempts -= 1;
				if (passCompletions > 0) 
					passCompletions -=1;
				passComLabel.setText("Pass Completions: "+String.valueOf((int) passCompletions));
				passAttLabel.setText("Pass Attempts: "+String.valueOf((int) passAttempts));
			}
		});


		//Pass Attempt +1 (Turnover +1)
		passAttPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				passComLabel.setVisible(true);
				passAttempts += 1;
				turnLabel.setVisible(true);
				turnovers += 1;
				turnLabel.setText("Turnovers: "+String.valueOf((int) turnovers));
				passAttLabel.setText("Pass Attempts: "+String.valueOf((int) passAttempts));
			}
		});

		//Pass Attempt -1 (Turnover -1)
		passAttMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				passComLabel.setVisible(true);
				turnLabel.setVisible(true);
				if (passAttempts > passCompletions) 
					passAttempts -= 1;
				if (turnovers > 0 && passAttempts > passCompletions) 
					turnovers -= 1;
				turnLabel.setText("Turnovers: "+String.valueOf((int) turnovers));
				passAttLabel.setText("Pass Attempts: "+String.valueOf((int) passAttempts));
			}
		});
	}
}