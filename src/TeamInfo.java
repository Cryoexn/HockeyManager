 import java.text.DecimalFormat;

 /**********************************************************
 * Class Name     : TeamInfo
 * Author         : Ben Masten
 * Date           : March , 2019
 * Course/Section : CSC 264 - 501
 * Program Description: This class will store information
 *	  about a single team.
 *
 * Methods:
 * -------
 * Constructor 		     - receives team name and max number of players
 * addPlayer			 - adds a new player to the team
 * getMaxPlayers 		 - gets max number of players for a team
 * getCurrentNumPlayers  - gets current number of players for a team
 * getName 				 - gets name of a single team
 * setName 				 - sets name of a single team
 * getTeamGoals 		 - gets total number of goals scored by team
 * getTeamAssists 		 - gets total number of assists made by team
 * getTeamPoints 		 - gets total number of points scored by team
 * getTeamMinPlayed      - gets total minutes played by the team
 * searchPlayerByName 	 - searches for player on a team by name
 * searchPlayersByPoints - searches for players by number of points scored
 * sortPlayersByFirst    - sorts players based on first name
 * sortPlayersByLast     - sorts players based on last name
 * addGameToPlayer		 - adds a game to a player and updates scores
 * removePlayer			 - removes a player at an index from the team
 * getPlayer			 - returns a player at an index
 * getAllPlayers		 - returns the array of players
 * getMaxGames			 - returns the max games a player can have
 * toString				 - returns teams data formatted into a string
 *
 **********************************************************/
public class TeamInfo
{
	//class constants

	//class variables
	PlayerInfo [] players;		   //players on a single team.
	private int playerCount;	   //number of players on a team.
	private int maxGames;		   //max games a player can have.
	private int teamGoals;		   //goals scored by entire team.
	private int teamAssists;	   //assists made by entire team.
	private int teamPoints;		   //points scored by entire team.
	private double teamMinPlayed;  //time played by entire team.
	private String teamName;	   //name of a single team.

    /**********************************************************
	* Method Name    : Constructor
	* Author         : Ben Masten
	* Date           : March, 2019
	* Course/Section : CSC 264 - 501
	* Method Description: This method will set the information
	*	 of a team as passed by the values of the parameters.
	*
	* BEGIN Constructor (String name, int maxPlayers)
	*	 Set team name and max number of players
	* END Constructor
	**********************************************************/
	public TeamInfo (String name, int maxPlayers, int inMaxGames)
	{
		//local constants

		//local variables

		/*********************   Start Constructor *****************/

		//Set team name and maximum number of players
		teamName = name;
		players = new PlayerInfo[maxPlayers];

		teamGoals = 0;
		teamAssists = 0;
		teamPoints = 0;
		teamMinPlayed = 0;

		//Set max games.
		maxGames = inMaxGames;

	}//end Constructor

	/**********************************************************
	* Method Name    : addPlayer
	* Author         : David Pitoniak
	* Date           : 3/13/19
	* Course/Section : CSC-264-501
	* Method Description: This method will add a player to
	*     the team and update the teams stats.
	*
	* BEGIN addPlayer
	*     IF( player isnt null )
	*         Update totals
	*         Add the player to the array of players
	*         Increment counter
	*     ENDIF
	* END getMaxPlayers
	**********************************************************/
	public void addPlayer(PlayerInfo player)
	{
		//local constants

		//local variables

		/*******************************************************************************/

		//If player isnt null.
		if(player != null)
		{
			//Update totals
			teamGoals     += player.getTotalGoals();
			teamAssists   += player.getTotalAssists();
			teamPoints    += player.getTotalPoints();
			teamMinPlayed += player.getTotalTimePlayed();

			//Add the player to the array of players.
			players[playerCount] = player;

			//Increment counter.
			playerCount++;

		}//endif

	}//end addPlayer

    /**********************************************************
   	* Method Name    : getMaxPlayers
   	* Author         : Ben Masten
   	* Date           : March, 13 2019
   	* Course/Section : CSC 264 - 501
   	* Method Description: This method will get the maximum
   	*	 number of players for a single team.  It will return
   	*	 the number of players as an integer.
   	*
   	* BEGIN getMaxPlayers
   	*	 Return the maximum number of players on a team
   	* END getMaxPlayers
	**********************************************************/
	public int getMaxPlayers ()
	{
		//local constants

		//local variables

		/*******************   Start getMaxPlayers *****************/

		//Return max number of players on team
		return players.length;

	}//end getMaxPlayers

    /**********************************************************
   	* Method Name    : getCurrentNumPlayers
   	* Author         : Ben Masten
   	* Date           : March, 2019
   	* Course/Section : CSC 264 - 501
   	* Method Description: This method will get the current
   	*	 number of players for a single team.  It will return
   	*	 the number of players as an integer.
   	*
   	* BEGIN getCurrentNumPlayers
   	*	 Return the current number of players on the team
   	* END getCurrentNumPlayers
	**********************************************************/
	public int getCurrentNumPlayers ()
	{

		//local constants

		//local variables

		/**************   Start getCurrentNumPlayers ***************/

		//Return the current number of players on the team.
		return playerCount;

	}//end getCurrentNumPlayers

    /**********************************************************
   	* Method Name    : getName
   	* Author         : Ben Masten
   	* Date           : March, 2019
   	* Course/Section : CSC 264 - 501
   	* Method Description: This method will get the name of
   	*	 a single team.  It will return the team name as a
   	*	 String.
   	*
   	* BEGIN getName
   	*	 Return the name of the team
   	* END getName
	**********************************************************/
	public String getName ()
	{
		//local constants

		//local variables

		/*********************   Start getName *********************/

		//Return the team name
		return teamName;

	}//end getName

    /**********************************************************
   	* Method Name    : setName
   	* Author         : Ben Masten
   	* Date           : March, 2019
   	* Course/Section : CSC 264 - 501
   	* Method Description: This method will set the name of a
   	*	 single team.
   	*
   	* BEGIN setName (String name)
   	*	 Set the team name from paramter value
   	* END setName
	**********************************************************/
	public void setName (String name)
	{
		//local constants

		//local variables

		/*********************   Start setName *********************/

		//Set team name from parameter value
		teamName = name;

	}//end setName

    /**********************************************************
    * Method Name    : getTeamGoals
   	* Author         : Ben Masten
   	* Date           : March, 2019
   	* Course/Section : CSC 264 - 501
    * Method Description: This method will get the total number
    *	 of goals scored by all players on a team.  It will
    *	 return the number of goals scored as an integer.
    *
    * BEGIN getTeamGoals
    *	 Return the number of goals scored by the team
    * END getTeamGoals
	**********************************************************/
	public int getTeamGoals ()
	{
		//local constants

		//local variables

		/****************   Start getTeamGoals *********************/

		//Return number of goals scored by team
		return teamGoals;

	}//end getTeamGoals

    /**********************************************************
    * Method Name    : getTeamAssists
    * Author         : Ben Masten
    * Date           : March, 2019
    * Course/Section : CSC 264 - 501
    * Method Description: This method will get the total number
    *	 of assists made by all players on a team.  It will
    *	 return the number of assists made as an integer.
    *
    * BEGIN getTeamAssists
    *	 Return the number of assists made by the team
    * END getTeamAssists
	**********************************************************/
	public int getTeamAssists ()
	{
		//local constants

		//local variables

		/****************   Start getTeamAssists *******************/

		//Return number of assists made by team
		return teamAssists;

	}//end getTeamAssists

    /**********************************************************
    * Method Name    : getTeamPoints
    * Author         : Ben Masten
    * Date           : March, 2019
    * Course/Section : CSC 264 - 501
    * Method Description: This method will get the total number
    *	 of points scored by all players on a team.  It will
    *	 return the number of points scored as an integer.
    *
    * BEGIN getTeamPoints
    *	 Return the total number of points scored by the team
    * END getTeamPoints
	**********************************************************/
	public int getTeamPoints ()
	{
		//local constants

		//local variables

		/****************   Start getTeamPoints ********************/

		//Return total number of points scored by team
		return teamPoints;

	}//end getTeamPoints

	/**********************************************************
	* Method Name    : getTeamMinPlayed
	* Author         : Ben Masten
	* Date           : March, 10 2019
	* Course/Section : CSC 264 - 501
	* Method Description: This method will get the total number
	*	 of minutes played by all players on a team.  It will
	*	 return the number of minutes as a double.
	*
	* BEGIN getTeamMinPlayed
	*	 Return the total minutes played by the team
	* END getTeamMinPlayed
	**********************************************************/
	public double getTeamMinPlayed()
	{
		//local constants

		//local variables

		/****************   Start getTeamMinPlayed ********************/

		//Return total number of points scored by team
		return teamMinPlayed;

	}//end getTeamMinPlayed


    /**********************************************************
    * Method Name    : searchPlayerByName
    * Author         : David Pitoniak
    * Date           : 3/6/19
    * Course/Section : CSC 264 - 501
    * Method Description: This method will search for a player
    *	 on a single team based on the name given.
    *
    * BEGIN searchPlayerByName
    *	 FOR( number of players )
    *        IF( the players name is equal to the name parameter )
    *		     Set the player being returned to that player
    *        ENDIF
    *    ENDFOR
    *    Return the player
    * END searchPlayerByName
	**********************************************************/
	public PlayerInfo searchPlayerByName(NameInfo name)
	{
		//local constants

		//local variables
		PlayerInfo tempPlayer = null;

		/****************   Start searchPlayerByName ***************/

		//For the number of players.
		for(int i = 0; i < playerCount; i++)
		{
			//If the players name is equal to the name parameter.
			if(players[i].getName().getFirstName().equals(name.getFirstName())
			   && players[i].getName().getLastName().equals(name.getLastName()))
			{
				//Set the result to the player at the index.
				tempPlayer = players[i];

			}//end if

		}//end for

		//Return the result.
		return tempPlayer;

	}//end searchPlayerByName

    /**********************************************************
    * Method Name    : searchPlayersByPoints
    * Author         : David Pitoniak
    * Date           : 3/6/19
    * Course/Section : CSC-264-501
    * Method Description: This method will search for players
    *     on a single team based on the points given and return
    *     all the players on that team that have the specified
    *     number of points.
    *
    * BEGIN searchPlayersByPoints
    *     Create an array to store the players with the points
    *     FOR( the number of players currently on the team )
    *         IF( the players points are equal to the inPoints )
    *             Set the result to the player at the index
    *             Increment the count
    *         ENDIF
    *     ENDFOR
    *     Return array of players with inPoints
    * END searchPlayersByPoints
	**********************************************************/
	public PlayerInfo[] searchPlayersByPoints(int inPoints)
	{
		//local constants

		//local variables
		int count = 0;				    //Number of players with inPoints.
		PlayerInfo []playersWithPoints;	//Array of players with inPoints.

		/**************   Start searchPlayersByPoints ***************/

		//Create an array to store the players with the points.
		playersWithPoints = new PlayerInfo[playerCount];

		//For the number of players currently on the team.
		for(int i = 0; i < playerCount; i++)
		{
			//If the players points are equal to the inPoints.
			if(players[i].getTotalPoints() == inPoints)
			{
				//Set the result to the player at the index.
				playersWithPoints[count] = players[i];

				//Increment the counter.
				count++;

			}//end if

		}//end for

		//Return the result.
		return playersWithPoints;

	}//end searchPlayersByPoints

	/**********************************************************
	* Method Name    : sortPlayersByFirst
	* Author         : David Pitoniak
	* Date           : 3/6/19
	* Course/Section : CSC-264-501
	* Method Description: This method will sorts the players
	*     on the team by their first name in alphabetical order.
	*
	* BEGIN sortPlayersByFirst
	*     FOR( each player )
	*         FOR( each player not sorted )
	*             IF( the players first name is greater than the next players )
	*                 Swap the players
	*             ENDIF
	*         ENDFOR
	*     ENDFOR
	* END sortPlayersByFirst
	**********************************************************/
	public void sortPlayersByFirst()
	{
		//local constants

		//local variables
		PlayerInfo tempPlayer;		//Temp PlayerInfo for swapping.

		/*******************************************************************************/

		//For the players on the team.
		for(int i = 0; i < playerCount; i++)
		{
			//For the players on the team - the sorted ones.
			for(int j = 0; j < playerCount-i-1; j++)
			{
				//If the players first name is greater than the next players.
				if(players[j].getName().getFirstName()
				   .compareToIgnoreCase(players[j+1].getName().getFirstName()) > 0)
				{
					//Swap the current player and the next player.
					tempPlayer = players[j];
					players[j] = players[j+1];
					players[j+1] = tempPlayer;

				}//end if

			}//end for

		}//end for

	}//end sortPlayersByFirst

	/**********************************************************
	* Method Name    : sortPlayersByLast
	* Author         : David Pitoniak
	* Date           : 3/6/19
	* Course/Section : CSC-264-501
	* Method Description: This method will sorts the players
	*     on the team by their last name in alphabetical order.
	*
	* BEGIN sortPlayersByLast
	*     FOR( each player )
	*         FOR( each player not sorted )
	*             IF( the players last name is greater than the next players )
	*                 Swap the players
	*             ENDIF
	*         ENDFOR
	*     ENDFOR
	* END sortPlayersByLast
	**********************************************************/
	public void sortPlayersByLast()
	{
		//local constants

		//local variables
		PlayerInfo tempPlayer;		//Temp PlayerInfo for swapping.

		/*******************************************************************************/

		//For the players on the team.
		for(int i = 0; i < playerCount; i++)
		{
			//For the players on the team.
			for(int j = 0; j < playerCount-i-1; j++)
			{
				//If the players first name is greater than the next players.
				if(players[j].getName().getLastName()
				   .compareToIgnoreCase(players[j+1].getName().getLastName()) > 0)
				{
					//Swap the current player and the next player.
					tempPlayer = players[j];
					players[j] = players[j+1];
					players[j+1] = tempPlayer;

				}//end if

			}//end for

		}//end for

	}//end sortPlayersByLast

	/**********************************************************
	* Method Name    : addGameToPlayer
	* Author         : David Pitoniak
	* Date           : 3/13/19
	* Course/Section : CSC-264-501
	* Method Description: This method adds a game to a player
	*     at a specified index.
	*
	* BEGIN addGameToPlayer
	*     IF( the index is in bounds )
	*         Get the player at index and add the game
	*         Update the team stats
	*     ENDIF
	* END getPlayer
	**********************************************************/
	public void addGameToPlayer(int index, GameInfo game)
	{
		//local constants

		//local variables

		/*******************************************************************************/

		//If the index is in bounds.
		if(index <= playerCount-1)
		{
			//Get player at index.
			players[index].addGame(game);

			//Update the team stats.
			teamGoals     += game.getGoals();
			teamAssists   += game.getAssists();
			teamMinPlayed += game.getTimePlayed();
			teamPoints = teamGoals + teamAssists;

		}//endif

	}//end addGameToPlayer

	/**********************************************************
	* Method Name    : removePlayer
	* Author         : David Pitoniak
	* Date           : 3/13/19
	* Course/Section : CSC-264-501
	* Method Description: This method removes the player at
	*     index.
	*
	* BEGIN removePlayer
	*     IF( the index is in bounds )
	*         Get the player at index
	*         Update the team stats
	*         FOR( the player count -1 )
	*             Swap the current player and the next player
	*         ENDFOR
	*         Decrement the player count
	*     ENDIF
	* END getPlayer
	**********************************************************/
	public void removePlayer(int index)
	{
		//local constants

		//local variables
		PlayerInfo tempPlayer;	//Storage for player being removed.

		/*******************************************************************************/

		//If the index is in bounds.
		if(index <= playerCount-1)
		{
			//Get the player at index.
			tempPlayer = players[index];

			//Update the team stats.
			teamGoals = teamGoals - tempPlayer.getTotalGoals();
			teamAssists = teamAssists - tempPlayer.getTotalAssists();
			teamMinPlayed = teamMinPlayed - tempPlayer.getTotalTimePlayed();
			teamPoints = teamGoals + teamAssists;

			//For the number of players in the array.
			for( int i = index; i < playerCount-1; i++)
			{
				//Swap the current player and the next player.
				tempPlayer = players[i+1];
				players[i] = tempPlayer;
				players[i+1] = null;
			}

			//Decrement the player count.
			playerCount--;

		}//endif

	}//end removePlayer

	/**********************************************************
	* Method Name    : getPlayer
	* Author         : David Pitoniak
	* Date           : 3/13/19
	* Course/Section : CSC-264-501
	* Method Description: This method returns the player at
	*     an index. if the index isnt valid or there isnt a
	*     player at the index a null is returned.
	*
	* BEGIN getPlayer
	*     Set tempPlayer to null
	*     IF( index is in bounds )
	*         Set tempPlayer to player at index
	*     ENDIF
	*     Return the tempPlayer
	* END getPlayer
	**********************************************************/
	public PlayerInfo getPlayer(int index)
	{
		//local constants

		//local variables
		PlayerInfo tempPlayer = null; //Player being returned.

		/*******************************************************************************/

		//If the index is in bounds
		if(index <= playerCount - 1)
		{
			//Set tempPlayer to player at index.
			tempPlayer = players[index];

		}//endif

		//Return the player at index.
		return tempPlayer;

	}//end getPlayer

	/**********************************************************
	* Method Name    : getAllPlayers
	* Author         : David Pitoniak
	* Date           : 3/13/19
	* Course/Section : CSC-264-501
	* Method Description: This method returns the array of
	*     players.
	*
	* BEGIN getAllPlayers
	*     Return the array of players
	* END getAllPlayers
	**********************************************************/
	public PlayerInfo[] getAllPlayers()
	{
		//local constants

		//local variables

		/*******************************************************************************/

		//Return the array of players.
		return players;

	}//end getAllPlayers

	/**********************************************************
	* Method Name    : getMaxGames
	* Author         : David Pitoniak
	* Date           : 3/13/19
	* Course/Section : CSC-264-501
	* Method Description: This method returns the max games
	*     players on the team are allowed to have.
	*
	* BEGIN getMaxGames
	*     Return max games
	* END getMaxGames
	**********************************************************/
	public int getMaxGames()
	{
		//local constants

		//local variables

		/*******************************************************************************/

		//Return max games.
		return maxGames;

	}//end getMaxGames

	/**********************************************************
	* Method Name    : toString
	* Author         : David Pitoniak
	* Date           : 3/13/19
	* Course/Section : CSC-264-501
	* Method Description: This method returns a formatted
	*     String for the teams data.
	*
	* BEGIN toString
	*     Creating instance of DecimalFormat
	*     Setup team heading
	* 	  FOR( number of players )
	*         Store values to prevent using methods excessively
	*         Concat the formatted data
	*     ENDFOR
	*     Format team stats to string
	*     Concat totals to string
	*     Concat base for table
	*     Return formatted string
	* END toString
	**********************************************************/
	public String toString()
	{
		//local constants

		//local variables
		String result = "";		//String being returned.
		String first;			//First name of player for display.
		String last;			//Last name of player for display.
		String goals;			//Goals for display.
		String assists;			//Assists for display.
		String points;			//Points for display.
		String timePlayed;      //Time played for display.
		DecimalFormat fmt;      //Decimal format for the time.

		/*******************************************************************************/

		//Creating instance of DecimalFormat.
		fmt = new DecimalFormat("0.0");

		//Setup team heading.
		result += Util.setLeft("+------------------------------------------+--------------------------------------------+") + "\n";
		result += Util.setLeft("|                                         " + 							 " |              ##   ##  ##   ##  ##          |") + "\n";
		result += Util.setLeft("| Team Name: " + Util.setRight(29, teamName) + 							 " |             ###  ##  ##   ##  ##           |") + "\n";
		result += Util.setLeft("| Players  : " + Util.setRight(29, playerCount + "/" + players.length) + " |            #### ##  #######  ##            |") + "\n";
		result += Util.setLeft("| Points   : " + Util.setRight(29, teamPoints+"") +						 " |           ## ####  ##   ##  ##             |") + "\n";
		result += Util.setLeft("|                                         " +							 " |          ##  ###  ##   ##  ######          |") + "\n";
		result += Util.setLeft("+------------------------------------------+--------------------------------------------+") + "\n";
		result += Util.setLeft("| Last Name            First Name           Goals      Assists    Points     Time (Min) |") + "\n";
		result += Util.setLeft("| -------------------- -------------------- ---------- ---------- ---------- ---------- |") + "\n";

		//For the number of players.
		for(int i = 0; i < playerCount; i++)
		{
			//Store values to prevent using methods excessively.
			last = players[i].getName().getLastName();
			first = players[i].getName().getFirstName();
			goals = players[i].getTotalGoals()+"";
			assists = players[i].getTotalAssists()+"";
			points = players[i].getTotalPoints()+"";
			timePlayed = fmt.format(players[i].getTotalTimePlayed())+"";

			//Concat formatted data.
			result += Util.setLeft("| " + Util.addPadding(20-last.length(), last)
			         + " " + Util.addPadding(20- first.length(), first)
			         + " " + Util.addPadding(10-goals.length(), goals)
			         + " " + Util.addPadding(10-assists.length(), assists)
			         + " " + Util.addPadding(10-points.length(), points)
			         + " " + Util.addPadding(10-timePlayed.length(), timePlayed)
			         + " |") + "\n";

		}//end for

		//Formatting for totals.
		result += Util.setLeft("| -------------------- -------------------- "
		          + "---------- ---------- ---------- ---------- |") + "\n";

		//Format team stats to strings.
		goals = teamGoals+"";
		assists = teamAssists+"";
		points = teamPoints+"";
		timePlayed = fmt.format(teamMinPlayed)+"";

		//Concat team totals to string.
		result += Util.setLeft("| XXXXXXXXXXXXXXXXXXXX"
				 + " XXXXXXXXXXXXXXXXXXXX"
				 + " " + Util.addPadding(10-goals.length(), goals)
				 + " " + Util.addPadding(10-assists.length(), assists)
			     + " " + Util.addPadding(10-points.length(), points)
				 + " " + Util.addPadding(10-timePlayed.length(), timePlayed)+" |")
				 + "\n";

		//Concat base for table.
		result += Util.setLeft("+------------------------------------------"
		          + "---------------------------------------------+") + "\n";

		//Return formatted string.
		return result;

	}//end toString

}//end TeamInfo