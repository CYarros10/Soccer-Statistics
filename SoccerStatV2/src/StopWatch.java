//********************************************************************
// This program displays the tim(in seconds) as it increments. The
// user is able to start, stop and reset the time using buttons
//********************************************************************

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

import javax.swing.border.*;

public class StopWatch
{
	//-----------------------------------------------------------------
	//  Creates and presents the StopWatch frame.
	//-----------------------------------------------------------------
	public static void main(String[] args)
	{
		JFrame frame = new JFrame ("Stop Watch");
		frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

		frame.getContentPane().add (new StopWatchPanel());

		frame.pack();
		frame.setVisible (true);
	}
}

class StopWatchPanel extends JPanel
{
	private JLabel timeDisplay;
	private Timer timer;
	private static int time;
	private final String ZERO_TIME = "0:00";
	private final int DELAY = 1000;
	private final String START = "Start";
	private final String STOP = "Stop";
	private final String RESET = "Reset";

	//-----------------------------------------------------------------
	//  Sets up the GUI for the stop watch
	//-----------------------------------------------------------------
	public StopWatchPanel()
	{
		setLayout(new GridLayout(2,1));

		// initialize the time display
		setTime(0);
		timeDisplay = new JLabel(ZERO_TIME);
		timeDisplay.setBackground(Color.white);
		timeDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		timeDisplay.setFont(new Font("SAN_SERIF",Font.BOLD,24));
		add(timeDisplay,BorderLayout.NORTH);

		// add the start, stop and reset buttons
		JPanel buttonPanel = new JPanel();

		JButton button;
		ButtonActionListener buttonPressed = new ButtonActionListener();

		button = new JButton(START);
		button.setFont(new Font("Arial", Font.PLAIN, 10));
		button.setMnemonic('S');
		button.addActionListener(buttonPressed);
		buttonPanel.add(button);

		button = new JButton(STOP);
		button.setFont(new Font("Arial", Font.PLAIN, 10));
		button.setMnemonic('P');
		button.addActionListener(buttonPressed);
		buttonPanel.add(button);

		button = new JButton(RESET);
		button.setFont(new Font("Arial", Font.PLAIN, 10));
		button.setMnemonic('R');
		button.addActionListener(buttonPressed);
		buttonPanel.add(button);

		add(buttonPanel, BorderLayout.CENTER);
		
		setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Stop Watch"));

		// create the timer
		timer = new Timer(DELAY, new TimerActionListener());
	}

	//-----------------------------------------------------------------
	//  Start the stop watch.
	//-----------------------------------------------------------------
	private void startTime()
	{
		timer.start();
	}

	//-----------------------------------------------------------------
	//  Stop the stop watch.
	//-----------------------------------------------------------------
	private void stopTime()
	{
		timer.stop();
	}

	//-----------------------------------------------------------------
	//  Reset the stop watch.
	//-----------------------------------------------------------------
	private void resetTime()
	{
		timer.stop();
		timeDisplay.setText(ZERO_TIME);
		setTime(0);
	}

	//-----------------------------------------------------------------
	//  Increment the display by 1 second.
	//-----------------------------------------------------------------
	void incrementDisplay()
	{
		setTime(getTime() + 1);
		int mins = getTime()/60;
		int seconds = getTime()%60;
		
		if (seconds < 10)
		timeDisplay.setText(mins+":0"+ seconds);
		
		else
			timeDisplay.setText(mins+":"+ seconds);

	}

	public static int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	//********************************************************************
	//  Represents the action listener for the timer
	//********************************************************************
	class TimerActionListener implements ActionListener
	{
		//-----------------------------------------------------------------
		//  reset the stop watch
		//-----------------------------------------------------------------
		public void actionPerformed(ActionEvent actionEvent)
		{
			incrementDisplay();
		}
	}

	//********************************************************************
	//  Represents the action listener for the buttons
	//********************************************************************
	class ButtonActionListener implements ActionListener
	{
		//-----------------------------------------------------------------
		//  determine which button was pressed and execute appropriate
		//  command
		//-----------------------------------------------------------------
		public void actionPerformed(ActionEvent evt)
		{
			JButton source = (JButton)evt.getSource();
			String text = source.getText();
			if (text.equals(START))
				startTime();
			else
				if (text.equals(STOP))
					stopTime();
				else
					if (text.equals(RESET))
						resetTime();
		}

	}
}
