import java.text.DecimalFormat;

/****************************************************************************************
* Class Name	: PlayerInfo
* Author		: David Pitoniak
* Date			: 2/23/19
* Course/Section: CSC-264-501
* Program Description: This class will store data for a sports player.
*
* Methods:
* -------
* getName 			 - gets the players NameInfo.
* setName 			 - sets the players NameInfo.
* getGame 			 - gets a game at an index.
* addGame			 - adds a game to the array of games.
* getMaxGames 		 - gets the max games that can be added.
* getCurrentNumGames - gets the current number of games that are in the array.
* getTotalGoals 	 - gets the total of all the games goals.
* getTotalAssists 	 - gets the total of all the games assists.
* getTotalPoints 	 - gets the total of all the games points.
* getTotalTimePlayed - gets the total time played of all the games.
* toString			 - Returns a formatted String of all the PlayerInfo data.
*
****************************************************************************************/
public class PlayerInfo
{
	//class constants

	//class variables
	private GameInfo games[];		//Games the player has played
	private NameInfo playerName;	//Players name
	private int gamesCount;			//Number of games the player has played
	private int totalGoals;			//Total goals for player
	private int totalAssists;		//Total assists for player
	private int totalPoints;		//Total points for player
	private double totalTimePlayed;	//Total time played for player

	/***********************************************************************************/

	/************************************************************************************
	* Method Name	: Constructor
	* Author		: David Pitoniak
	* Date			: 2/23/19
	* Course/Section: CSC-264-501
	* Program Description: This method will set the instance data for the class.
	*
	************************************************************************************/
	public PlayerInfo(NameInfo inName, int inMaxGames)
	{
		//Setting instance data.
		playerName      = inName;
		gamesCount      = 0;
		totalGoals      = 0;
		totalAssists    = 0;
		totalPoints     = 0;
		totalTimePlayed = 0.0;

		//Instaciating the array of GameInfo's.
		games = new GameInfo[inMaxGames];

	}//end Constructor

	/************************************************************************************
	* Method Name	: getName
	* Author		: David Pitoniak
	* Date			: 2/28/19
	* Course/Section: 264-501
	* Program Description: This method returns the name obj associated with the player.
	*
	* BEGIN getName
	*     Create temporary name object
	*     Set that object to the players name
	*     Return the temporary Object
	* END getName
	************************************************************************************/
	public NameInfo getName()
	{
		//local constants

		//local variables
		NameInfo tempName;	//Temporary obj for players name.

		/*******************************************************************************/

		//Set the temp object to the players name.
		tempName = playerName;

		//Return the temp object.
		return tempName;

	}//end getName

	/************************************************************************************
	* Method Name	: setName
	* Author		: David Pitoniak
	* Date			: 2/28/19
	* Course/Section: 264-501
	* Program Description: This method sets the players NameInfo to the parameter of the
	*     of the method.
	*
	* BEGIN setName
	*     IF( the name isnt null )
	*         Set the players name to the parameter
	*     ENDIF
	* END setName
	************************************************************************************/
	public void setName(NameInfo name)
	{
		//local constants

		//local variables

		/*******************************************************************************/

		//If the name isnt null.
		if(name != null)
			playerName = name; //Set the players name.

	}//end setName

	/************************************************************************************
	* Method Name	: getGame
	* Author		: David Pitoniak
	* Date			: 2/28/19
	* Course/Section: 264-501
	* Program Description: This method will return the GameInfo in games at the index
	*     passed into the parameters.
	*
	* BEGIN getGame
	*     Set the temp object to the GameInfo at the index
	*     Return the temp game object
	* END getGame
	************************************************************************************/
	public GameInfo getGame(int index)
	{
		//local constants

		//local variables
		GameInfo tempGame;	//Temporary obj for a game.

		/*******************************************************************************/

		//Set the temp object to the GameInfo at the index.
		tempGame = games[index];

		//Return the temp game object.
		return tempGame;

	}//end getGame

	/************************************************************************************
	* Method Name	: addGame
	* Author		: David Pitoniak
	* Date			: 2/28/19
	* Course/Section: 264-501
	* Program Description: This method allows the user to add a GameInfo to the players
	*     array of games.
	*
	* BEGIN addGame
	*     IF( the game isnt null )
	*         Update the players total goals
	*         Update the players total assists
	*         Update the players total time played
	*         Update the players total points
	*         Add the game to the array
	*         Increment game count
	*     ENDIF
	* END addGame
	************************************************************************************/
	public void addGame(GameInfo game)
	{
		//local constants

		//local variables

		/*******************************************************************************/

		//If the game isnt null.
		if(game != null)
		{
			//Update the players total goals.
			totalGoals += game.getGoals();

			//Update the players total assists.
			totalAssists += game.getAssists();

			//Update the players total time played.
			totalTimePlayed += game.getTimePlayed();

			//Update the players total points.
			totalPoints = totalGoals + totalAssists;

			//Add the game to the array.
			games[gamesCount] = game;

			//Increment game count.
			gamesCount++;

		}//end if

	}//end addGame

	/************************************************************************************
	* Method Name	: getMaxGames
	* Author		: David Pitoniak
	* Date			: 2/28/19
	* Course/Section: 264-501
	* Program Description: This method returns the max number of games the player is
	*     allowed to play.
	*
	* BEGIN getMaxGames
	*     Return the maxGames
	* END getMaxGames
	************************************************************************************/
	public int getMaxGames()
	{
		//local constants

		//local variables

		/*******************************************************************************/

		//Return the maxGames.
		return games.length;

	}//end getMaxGames

	/************************************************************************************
	* Method Name	: getCurrentNumGames
	* Author		: David Pitoniak
	* Date			: 2/28/19
	* Course/Section: 264-501
	* Program Description: This method returns the number of games the player has
	*     currently played.
	*
	* BEGIN getCurrentNumGames
	*     Return the current count of games
	* END getCurrentNumGames
	************************************************************************************/
	public int getCurrentNumGames()
	{
		//local constants

		//local variables

		/*******************************************************************************/

		//Return the current count of games.
		return gamesCount;

	}//end getCurrentNumGames

	/************************************************************************************
	* Method Name	: getTotalGoals
	* Author		: David Pitoniak
	* Date			: 2/28/19
	* Course/Section: 264-501
	* Program Description: This method returns the total goals from all games
	*     the player has played.
	*
	* BEGIN getTotalGoals
	*     Return total goals
	* END getTotalGoals
	************************************************************************************/
	public int getTotalGoals()
	{
		//local constants

		//local variables

		/*******************************************************************************/

		//Return total goals.
		return totalGoals;

	}//end getTotalGoals

	/************************************************************************************
	* Method Name	: getTotalAssists
	* Author		: David Pitoniak
	* Date			: 2/28/19
	* Course/Section: 264-501
	* Program Description: This method returns the total assists from all games the
	*     player has played.
	*
	* BEGIN getTotalAssists
	*     Return the total assists
	* END getTotalAssists
	************************************************************************************/
	public int getTotalAssists()
	{
		//local constants

		//local variables

		/*******************************************************************************/

		//Return the total assists.
		return totalAssists;

	}//end getTotalAssists

	/************************************************************************************
	* Method Name	: getTotalPoints
	* Author		: David Pitoniak
	* Date			: 2/28/19
	* Course/Section: 264-501
	* Program Description: This method returns the total points based on the total
	*     goals and assists the player has.
	*
	* BEGIN getTotalPoints
	*     Return the total points
	* END getTotalPoints
	************************************************************************************/
	public int getTotalPoints()
	{
		//local constants

		//local variables

		/*******************************************************************************/

		//Return the total points.
		return totalPoints;

	}//end getTotalPoints

	/************************************************************************************
	* Method Name	: getTotalTimePlayed
	* Author		: David Pitoniak
	* Date			: 2/28/19
	* Course/Section: 264-501
	* Program Description: This method returns the total time played for the player.
	*
	* BEGIN getTotalTimePlayed
	*     Return the total time played
	* END getTotalTimePlayed
	************************************************************************************/
	public double getTotalTimePlayed()
	{
		//local constants

		//local variables

		/*******************************************************************************/

		//Return the total time played.
		return totalTimePlayed;

	}//end getTotalTimePlayed

	/************************************************************************************
	* Method Name	: toString
	* Author		: David Pitoniak
	* Date			: 3/4/19
	* Course/Section: CSC-264-501
	* Program Description: This method formats the data from PlayerInfo into a visually
	*     appealing String for output.
	*
	* BEGIN toString
	*     Concat top of box
	*     Concat players name
	*     Concat bottom of header
	*     Concat column headings
	*     FOR ( each game player has )
	*         Get the game at index i
	*         Concat the goals assists points and time played
	*     ENDFOR
	*     Concat total headings
	*     Concat total values
	*     Concat bottom of box
	* END toString
	************************************************************************************/
	public String toString()
	{
		//local constants

		//local variables
		String result = "";		//Formatted String.
		GameInfo tempGame;		//tempGame for display.
		DecimalFormat fmt;		//Decimal format for time.

		/*******************************************************************************/

		//Intance of decimal format for time.
		fmt = new DecimalFormat("0.0");

		//Concat formatting for visuals.
		result += Util.setLeft("+----------------------------------+") + "\n";

		//Concat players name to the data String.
		result += Util.setLeft("| " + "Player Name:" + Util.setRight(20, playerName.getLastName() + ", " + playerName.getFirstName()) + " |") + "\n";

		//Concat formatting for visuals.
		result += Util.setLeft("+----------------------------------+") + "\n";

		//Concat column headings.
		result += Util.setLeft("| " + Util.setRight(4, "Game") + Util.setRight(6, " Goals") + Util.setRight(8, " Assists") + Util.setRight(7, " Points") + Util.setRight(7, " Time  ") + " |") + "\n";
		result += Util.setLeft("| " + Util.setRight(4, "----") + Util.setRight(6, " -----") + Util.setRight(8, " -------") + Util.setRight(7, " ------") + Util.setRight(7, " ------") + " |") + "\n";

		//For each game the player has played.
		for(int i = 0; i < this.getCurrentNumGames(); i++)
		{
			//Get the game at index i.
			tempGame = this.getGame(i);

			//Concat the goals assists points and time played.
			result += Util.setLeft("| " + Util.setRight(4, (i+1)+"") +
										  Util.setRight(6, tempGame.getGoals()+"") +
										  Util.setRight(8, tempGame.getAssists()+"") +
										  Util.setRight(7, tempGame.getPoints()+"") +
										  Util.setRight(7, tempGame.getTimePlayed()+"") +
										  " |") + "\n";
		}//end for

		//Concat formatting for totals.
		result += Util.setLeft("| " + Util.setRight(4, "----") +
									  Util.setRight(6, " -----") +
									  Util.setRight(8, " -------") +
									  Util.setRight(7, " ------") +
									  Util.setRight(7, " ------") + " |") + "\n";
		//Concat totals data.
		result += Util.setLeft("| " + Util.setRight(4, "XXXX") +
									  Util.setRight(6, this.getTotalGoals()+"") +
									  Util.setRight(8, this.getTotalAssists()+"") +
									  Util.setRight(7, this.getTotalPoints()+"") +
									  Util.setRight(7, fmt.format(this.getTotalTimePlayed())+"") +
									  " |") + "\n";

		//Concat formatting for visuals.
		result += Util.setLeft("+----------------------------------+") + "\n";

		//Return formatted data.
		return result;

	}//end toString

}//end PlayerInfo