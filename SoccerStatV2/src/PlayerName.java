import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


class PlayerNamePanel extends JPanel {
	
	static String names = "";
	static String numbers = "";
	static String teams = "";
	static String dates = "";
	static String opponents = "";
	
	
	public static String getPlayerName() {
		return names;
	}
	
	public static String getPlayerNumber() {
		return numbers;
	}
	
	public static String getPlayerTeam() {
		return teams;
	}
	
	public static String getPlayerDate() {
		return dates;
	}
	public static String getPlayerOpponent() {
		return opponents;
	}
	
	
	
	public PlayerNamePanel() {
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Player Info");
		setBorder(title);
		
		setLayout(new GridLayout(3,1));
		
		JTextField name = new JTextField();
		JTextField number = new JTextField();
		JTextField team = new JTextField();
		JTextField date = new JTextField();
		JTextField opponent = new JTextField();
		
		Object[] fields = {
				" Notice: Following information is only \n "
				+ "necessary if you plan to save the \n"
				+ " results to a file.",
				"\n",
				
				"Player Initials: ", name, "Number: ", number, "Team: ", team, 
				"Date: ", date, "Opponent: ", opponent
		};
		
		JOptionPane.showConfirmDialog(null, fields, "Enter Info: ", JOptionPane.CANCEL_OPTION);
		
		JLabel nameLabel = new JLabel("Player Initials: "+name.getText());
		nameLabel.setFont(new Font("Garamond", Font.PLAIN, 20));
		add(nameLabel);
		
		JLabel numberLabel = new JLabel("Number: "+ number.getText());
		numberLabel.setFont(new Font("Garamond", Font.PLAIN, 19));
		add(numberLabel);
		
		JLabel teamLabel = new JLabel("Team: "+team.getText());
		teamLabel.setFont(new Font("Garamond", Font.PLAIN, 20));
		add(teamLabel);
		
		names = name.getText();
		numbers = number.getText();
		teams = team.getText();
		dates = date.getText();
		opponents = opponent.getText();
	}
}