import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class StatPanelv2
{

	public static void main(String[] args)
	{
		JFrame frame = new JFrame ("Soccer Statistics");
		frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

		JPanel container = new JPanel();
		container.setLayout(new GridLayout(2,3));
		frame.setMinimumSize(new Dimension(1050, 300));

		frame.getContentPane().add(container);

		OffensePanel offense = new OffensePanel();
		PossessionPanel possession = new PossessionPanel();
		DefensePanel defense = new DefensePanel();
		StopWatchPanel stopWatch = new StopWatchPanel();
		PositionSelectPanel position = new PositionSelectPanel();
		ResultPanel result = new ResultPanel();
		PlayerNamePanel name = new PlayerNamePanel();
		MiscPanel misc = new MiscPanel();

		container.add(name);
		
		
		
		JPanel timeAndPosition = new JPanel();
		timeAndPosition.setLayout(new GridLayout(1,2));
		container.add(stopWatch);
		container.add(position);
		container.add(result, BorderLayout.EAST);
	//	container.add(timeAndPosition, BorderLayout.WEST);
		container.add(offense, BorderLayout.WEST);
		container.add(possession, BorderLayout.WEST);
		container.add(defense, BorderLayout.WEST);
		container.add(misc);

		frame.pack();
		frame.setVisible (true);
	}
}
