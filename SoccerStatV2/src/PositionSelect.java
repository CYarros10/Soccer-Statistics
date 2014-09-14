import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class PositionSelect {

	public static void main(String[] args) {

		JFrame frame = new JFrame ("Soccer Statistics");
		frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

		frame.add(new PositionSelectPanel());
		frame.pack();
		frame.setVisible (true);

	}

}

class PositionSelectPanel extends JPanel implements ActionListener {

	ButtonGroup bgroup = new ButtonGroup();
	static String selected = "";
	
	public PositionSelectPanel() {

		JRadioButton forward   = new JRadioButton("Forward"  , false);
		forward.setFont(new Font("Arial", Font.PLAIN, 11));
		JRadioButton midfielder    = new JRadioButton("Midfielder"   , false);
		midfielder.setFont(new Font("Arial", Font.PLAIN, 11));
		JRadioButton defender = new JRadioButton("Defender", false);
		defender.setFont(new Font("Arial", Font.PLAIN, 11));
		JRadioButton multiple = new JRadioButton("More than one", false);
		multiple.setFont(new Font("Arial", Font.PLAIN, 11));
		

		forward.addActionListener(this);
		midfielder.addActionListener(this);
		defender.addActionListener(this);
		multiple.addActionListener(this);


		bgroup.add(forward);
		bgroup.add(midfielder);
		bgroup.add(defender);
		bgroup.add(multiple);


		setLayout(new GridLayout(2,2));
		add(forward);
		add(midfielder);
		add(defender);
		add(multiple);

		setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Position"));

	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("More than one")) {
			selected = "More than one";
			System.out.println(selected);
		}

		if (arg0.getActionCommand().equals("Forward")) {
			selected = "Forward";
			System.out.println(selected);
		}
		if (arg0.getActionCommand().equals("Midfielder")) {
			selected = "Midfielder";
			System.out.println(selected);
		}
		if (arg0.getActionCommand().equals("Defender")) {
			selected = "Defender";
			System.out.println(selected);
		}
	}
	
	public static String getSelected(){
		return selected;	
	}
	

}

