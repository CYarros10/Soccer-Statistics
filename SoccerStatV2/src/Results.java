import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


public class Results {

	public static void main(String[] args) {

	}

}

class ResultPanel extends JPanel {
	
	public static double getFinalScore() {

		double finalScore = 0;
		double weightedOffenseScore = (OffensePanel.getOffenseScore()*(1) 
										+ DefensePanel.getDefenseScore()*(.5) 
										+ PossessionPanel.getPossessionScore()*(1.5))/3;
		
		double weightedDefenseScore = (OffensePanel.getOffenseScore()*(.5)
										+ DefensePanel.getDefenseScore()*(1) 
										+ PossessionPanel.getPossessionScore()*(1.5))/3;
		
		double weightedPossessionScore = (OffensePanel.getOffenseScore()*(.75) 
											+ DefensePanel.getDefenseScore()*(.75) 
											+ PossessionPanel.getPossessionScore()*(1.5))/3;
		
		
		System.out.println(PositionSelectPanel.getSelected());
		
		//MULTIPLE POSITIONS
		if (PositionSelectPanel.getSelected().equals("More than one")) {
			finalScore= (OffensePanel.getOffenseScore() 
					+ DefensePanel.getDefenseScore() 
					+ PossessionPanel.getPossessionScore())/3;
		}
		// Depending on position, weight scores differently
		// FORWARD
		if (PositionSelectPanel.getSelected().equals("Forward")) {
			if (weightedOffenseScore > 100)
				weightedOffenseScore = 100;
			finalScore = weightedOffenseScore;
		}
		
		//MIDFIELD
		if (PositionSelectPanel.getSelected().equals("Midfielder")) {
			if (weightedPossessionScore > 100)
				weightedPossessionScore = 100;
			finalScore = weightedPossessionScore;
		}
		
		//DEFENSE
		if (PositionSelectPanel.getSelected().equals("Defender")) {
			if (weightedDefenseScore > 100)
				weightedDefenseScore = 100;
			finalScore = weightedDefenseScore;
		}
		
		finalScore -= (StopWatchPanel.getTime()/60)*(.1115);
		
		if (finalScore > 100) {
			finalScore = 100;
		}
		
		finalScore = finalScore*10 / 100;
		
		return finalScore;
	}
	
	public ResultPanel() {

		TitledBorder title;
		title = BorderFactory.createTitledBorder("Match Rating");
		setBorder(title);
		setLayout(new GridLayout(2,1));
		
		JButton submit = new JButton("Calculate Statistics");
		submit.setFont(new Font("Arial", Font.PLAIN, 15));
		add(submit,BorderLayout.CENTER);
		
		JButton save = new JButton("Save And Close");
		save.setFont(new Font("Arial", Font.PLAIN, 15));
		add(save, BorderLayout.CENTER);
		
		final JLabel report = new JLabel("");
		report.setFont(new Font("Arial", Font.PLAIN, 18));
		add(report);
	
		submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				DecimalFormat df = new DecimalFormat("#,###,##0.0");
				
				report.setVisible(true);
				report.setText("Match Rating: "+String.valueOf(df.format(ResultPanel.getFinalScore())));
				
				
			}
		});
		
		save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				
				String alert = "Stats saved to file: " + PlayerNamePanel.getPlayerName()+"soccerStats.txt";

				FileWrite.fileWritten();
				JOptionPane.showMessageDialog(null, alert, "Notice",
					    JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
				
			}
		});
		
	}
	
}