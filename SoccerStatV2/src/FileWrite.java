import java.io.*;
class FileWrite 
{
	
	public static String getName() {
		return PlayerNamePanel.getPlayerName();
	}
	
	public static String getNumber() {
		return PlayerNamePanel.getPlayerNumber();
	}
	
	public static String getTeam() {
		return PlayerNamePanel.getPlayerTeam();
	}
	
	public static String getDate() {
		return PlayerNamePanel.getPlayerDate();
	}
	public static String getOpponent() {
		return PlayerNamePanel.getPlayerOpponent();
	}
	
	
	public static void fileWritten()
	{
		try{
			
			
			String path = getName()+"soccerStats.txt";

	        File file = new File(path);

	        FileWriter fileWriter = new FileWriter(file,true);

	        BufferedWriter bufferFileWriter  = new BufferedWriter(fileWriter);

	        fileWriter.append("\n");
	        fileWriter.append("-------------------------------------------------------- " +
	        				"\n" +
	        				" Name: " + getName() + " Number: " + getNumber() + " Team: " + getTeam() +
	        				"\n" +
	        				"\n" +
	        				" Date: " + getDate() + " Opponent: " + getOpponent() +
	        				"\n" +
	        				"\n" +
	        				"Position: "+ PositionSelectPanel.getSelected() +
	        				"\n" +
	        				"\n" +
	        				"Match Rating: "+ResultPanel.getFinalScore() +
	        				"\n" +
	        				"\n" +
	        				"Minutes Played: " + StopWatchPanel.getTime()/60 +
	        				"\n" +
	        				"\n" +
	        				"---Offense Stats ---" +
	        				"\n" +
	        				"Goals: " + (int) OffensePanel.getGoals() +
	        				"\n" +
	        				"Assists: " + (int) OffensePanel.getAssists() +
	        				"\n" +
	        				"Crosses/Corners: " + (int) OffensePanel.getCrosses() +
	        				"\n" +
	        				"Shots On Goal: " + (int) OffensePanel.getShotsOnGoal() +
	        				"\n" +
	        				"Shot Attempts: " + (int) OffensePanel.getShotAttempts() +
	        				"\n" +
	        				"\n" +
	        				"---Possession Stats---" +
	        				"\n" +
	        				"Pass Completions: " + (int) PossessionPanel.getPassCompletions() +
	        				"\n" +
	        				"Pass Attempts: " + (int) PossessionPanel.getPassAttempts() +
	        				"\n" +
	        				"Turnovers: " + (int) PossessionPanel.getTurnovers() +
	        				"\n" +
	        				"Fouls: " + (int) PossessionPanel.getFouls() +
	        				"\n" +
	        				"Offsides: " + (int) PossessionPanel.getOffsides() +
	        				"\n" +
	        				"\n" +
	        				"---Defense Stats---" +
	        				"\n" +
	        				"Pass Interceptions: " + (int) DefensePanel.getPassInterceptions() +
	        				"\n" +
	        				"Tackles Won: " + (int) DefensePanel.getTacklesWon() +
	        				"\n" +
	        				"Headers Won: " + (int) DefensePanel.getHeadersWon() +
	        				"\n" +
	        				"Clearances: " + (int) DefensePanel.getClearances() +
	        				"\n" +
	        				"Goal Line Saves: " + (int) DefensePanel.getGoalLineSaves() +
	        				"\n" +
	        				"\n"
	        				
	        		);


	        bufferFileWriter.close();

	        System.out.println("File Written");

		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}