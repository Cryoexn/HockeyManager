import java.util.StringTokenizer;
import java.io.IOException;

/****************************************************************************************
* Class Name    : TeamManagerDriver
* Author	    : David Pitoniak, Ben Masten
* Date		    : 3/6/19
* Course/Section: CSC-264-501
* Program Description: This class is the Driver for a Hockey Team Manager program.
*
* Methods:
* -------
* loadTeamsFile      	- reads the data from a file and returns array of TeamInfos. (Done)
* displayInitialMenu 	- displays initial menu so user can add teams.
* displayMainMenu	 	- displays main menu so user can manage the teams.
* addTeam			 	- adds a team to the array of teams.
* listTeams			 	- displays a numbered list of teams.
* listPlayers	     	- displays a numbered list of players.
* delPlayer			 	- removes a player from specified team.
* addPlayer				- allows user to add a new player to a specified team.
* initMenu				- displays the initial menu
* mainMenu				- displays the main menu
* displayLeaugeData		- displays all the teams in the leauge
* manageTeamData		- allows user to make changes to a team
* addGameToPlayer		- adds a new game to a player
* displayPlayerData		- displays a players data
* addPlayer				- adds a player to a team
* veiwSortedData		- allows user to sort alphabeticlly
* searchByPlayersName	- displays all players with the same name on a team
* searchByPlayersPoints - displays all players with the same points on a team
*
****************************************************************************************/
public class TeamManagerDriver
{
	/************************************************************************************
	* Method Name 	: main
	* Author 		: David Pitoniak
	* Date			: 3/6/19
	* Course/Section: CSC-264-501
	* Program Description: This method controls the flow of the program and calls the
	*     menu methods to allow the user to traverse the program and manage a hockey
	*     team and its data.
	*
	* BEGIN TeamManagerDriver
	*     Display initial menu
	*     WHILE( user doesnt quit )
	*         IF( user chooses to create a team )
	*             call the createTeam method
	*         ELSEIF( user chooses to load a file )
	*             call loadFile method
	*         ELSE
	*             Display error message
	*             Display initial menu
	*         ENDIF
	*     ENDWHILE
	*     IF( user hasnt quit )
	*         Display main menu
	*     	  WHILE( user doesnt quit )
	*             IF( user chooses to add a new team )
	*                 Call addNewPlayer method
	*             ELSEIF( user chooses to add a new player )
	*                 Call addNewPlayer method
	*             ELSEIF( user chooses to remove a player )
	*                 Call removePlayer method
	*             ELSEIF( user chooses to display data )
	*                 Call displayData method
	*             ELSEIF( user chooses to manage teams (menu) )
	*                 Call method
	*             ELSE
	*                 Display error message
	*             ENDIF
	*             IF( user didnt quit )
	*                 Display main menu
	*             ENDIF
	*        ENDWHILE
	*    ENDIF
	* END TeamManagerDiver
	************************************************************************************/
	public static void main(String []args)
	{
		//local constants
		final String CHOICE_CREATE_TEAM  = "1";
		final String CHOICE_LOAD_FILE    = "2";
		final String QUIT_VALUE_INITIAL  = "3";
		final String CHOICE_ADD_TEAM     = "1";
		final String CHOICE_DISPLAY_DATA = "2";
		final String CHOICE_MANAGE_TEAMS = "3";
		final String QUIT_VALUE_MAIN     = "4";
		final String BACK_VALUE = "b";
		final int MAX_TEAMS  = 25;
		final int ZERO_TEAMS = 0;

		//local variables
		String fileName;	//File name input by user.
		String choice = "";	//Choice returned by menu methods.
		TeamInfo teams[];   //Array of teams.
		int teamsCount = 0; //Number of teams in the array.

		/*******************************************************************************/

		//Set the max teams in the league.
		teams = new TeamInfo[MAX_TEAMS];

		//Display initial menu.
		choice = initMenu();

		//While choice isnt quit.
		while(!choice.equals(QUIT_VALUE_INITIAL) && teamsCount == ZERO_TEAMS)
		{
			//If user chooses to create a team.
			if(choice.equals(CHOICE_CREATE_TEAM))
			{
				//Add a team to the array.
				teamsCount = addTeam(teams, teamsCount);
			}
			//Else if user chooses to load a file.
			else if(choice.equals(CHOICE_LOAD_FILE))
			{
				//Get the file name from the user.
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.print(Util.setLeft("Enter file name (w/o .txt) or b to return to menu: "));
				fileName = Keyboard.readString();

				//If the file name isnt the back value.
				if(!fileName.equals(BACK_VALUE))
				{
					//Call the loadTeamsFile method and load the file data.
					teamsCount = loadTeamsFile(teams, fileName+".txt");
					choice = QUIT_VALUE_INITIAL;

				}//end if
			}
			//Else the choice was invalid.
			else
			{
				//Display error message.
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
								   + Util.setLeft("Error Invalid Input")
								   + "\n\n\n\n\n\n\n\n\n\n\n\n\n");

				//Pause the screen.
				Util.pressAnyKeyToContinue();

			}//end if

			if(teamsCount == 0)
				choice = initMenu();

		}//end while

		//If user hasnt quit.
		if(teamsCount != 0)
		{
			//Display main menu.
			choice = mainMenu();

			//While user doesnt quit.
			while(!choice.equals(QUIT_VALUE_MAIN))
			{
				//If user chooses to add a new team.
				if(choice.equals(CHOICE_CREATE_TEAM))
				{
					teamsCount = addTeam(teams, teamsCount);
				}
				//Else if user chooses to display data.
				else if(choice.equals(CHOICE_DISPLAY_DATA))
				{
					//Call displayData method.
					System.out.println("\n\n\n\n\n\n\n\n\n");
					displayLeaugeData(teams, teamsCount);
					Util.pressAnyKeyToContinue();
				}
				//Else if user chooses to manage teams (menu).
				else if(choice.equals(CHOICE_MANAGE_TEAMS))
				{
					manageTeamData(teams, teamsCount);
				}
				//Else
				else
				{
					//Display error message.
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
								   	   + Util.setLeft("Error Invalid Input")
								   	   + "\n\n\n\n\n\n\n\n\n\n\n\n\n");

					//Pause the screen.
					Util.pressAnyKeyToContinue();

				}//end if

				//If user didnt quit.
				if(!choice.equals(QUIT_VALUE_MAIN))
				{
					//Display main menu.
					choice = mainMenu();

				}//end if

			}//end while

		}//end if

	}//end main

	/**********************************************************
	* Method Name    : initMenu
	* Author         : Ben Masten
	* Date           : March 7, 2019
	* Course/Section : CSC 264 - 501
	* Method Description: This method is the starting home
	*	 menu that will be displayed when the user starts the
	*	 program.  It will return the user choice as an
	*    integer.
	*
	* BEGIN initMenu
	*	 Clear the screen
	*	 Display menu and options
	*	 Input choice (or sentinel)
	*	 Return user choice
	* END getMaxPlayers
	**********************************************************/
	public static String initMenu ()
	{

		//local constants
		final String NEW_TEAM 	 = "1"; //choice to add a new team
		final String LOAD_FILE   = "2"; //choice to load in from a file
		final String QUIT		 = "3"; //sentinel value to end program

		//local variables
		String choice; 			   //user input

		/*******************   Start initMenu **********************/

		//Clear screen
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		//Display the starting menu and its options
		System.out.print(Util.setLeft("Home Menu"));
		System.out.print("\n\n");
		System.out.print(Util.setLeftFixed(50, NEW_TEAM + ".) "
						 +  "Create a Team"));
		System.out.print("\n\n");
		System.out.print(Util.setLeftFixed(50, LOAD_FILE + ".) " + "Load from File"));
		System.out.print("\n\n");
		System.out.print(Util.setLeftFixed(50, QUIT + ".) " + "Quit"));
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.print(Util.setLeftFixed(50, "Enter your choice: "));

		//Input choice - or sentinel value to quit
		choice = Keyboard.readString();

		//Return user choice
		return choice;

	}//end initMenu

	/**********************************************************
	* Method Name    : mainMenu
	* Author         : Ben Masten
	* Date           : March 7, 2019
	* Course/Section : CSC 264 - 501
	* Method Description: This method is the main menu that will
	*	 be displayed should the user create a team or load a
	*	 file following the starting home menu.  It will
	*	 return the user choice as an integer.
	*
	* BEGIN mainMenu
	*	 Clear the screen
	*	 Display menu and options
	*	 Input choice (or sentinel)
	*	 Return user choice
	* END mainMenu
	**********************************************************/
	public static String mainMenu ()
	{

		//local constants
		final String NEW_TEAM 	  = "1"; //choice to add a new team
		final String DISP_DATA	  = "2"; //choice to display team data
		final String MANAGE_TEAM  = "3"; //choice to manage team data
		final String QUIT		  = "4"; //sentinel value to end program

		//local variables
		String choice;				   //user choice

		/*********************   Start mainMenu ********************/

		//Clear screen
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		//Display the main menu and its options
		System.out.print(Util.setLeft("Main Menu"));
		System.out.print("\n\n\n");
		System.out.print(Util.setLeftFixed(50, NEW_TEAM + ""
						 + ".) Add a New Team"));
		System.out.print("\n\n");
		System.out.print(Util.setLeftFixed(50, DISP_DATA + "" + ".) "
						 + "Display Leauge Data"));
		System.out.print("\n\n");
		System.out.print(Util.setLeftFixed(50, MANAGE_TEAM + "" + ".) "
						 + "Manage Team Data"));
		System.out.print("\n\n");
		System.out.print(Util.setLeftFixed(50, QUIT + "" + ".) "
						 + "Quit"));
		System.out.print("\n\n\n\n\n\n\n\n\n\n");
		System.out.print(Util.setLeftFixed(50, "Enter your choice: "));

		//Input choice - or sentinel value to quit
		choice = Keyboard.readString();

		//Return user choice
		return choice;

	}//end mainMenu

	/**********************************************************
	* Method Name    : addTeam
	* Author         : Ben Masten
	* Date           : March 8, 2019
	* Course/Section : CSC 264 - 501
	* Method Description: This method will allow the user to
	*	 create a new team.  It will prompt the user for the
	*	 team name and the maximum number of players for that
	*	 team.  It will also call a method to display the
	*	 current existing teams.
	*
	* BEGIN addTeam (TeamInfo [] teams, int count, int cap)
	*	 Call method to display existing teams
	*	 Input team name
	*	 Input max number of players
	*	 IF (there are more teams than what league can hold)
	*	    Call method to double league size
	*		Set the max number of teams to the array
	*	 END IF
	*	 Call TeamInfo constructor
	* END addTeam
	**********************************************************/
	public static int addTeam (TeamInfo [] teams, int count)
	{
		//local constants

		//local variables
		String name;
		String playersMax;
		int playersMaxInt;
		String gamesMax;
		int gamesMaxInt;
		TeamInfo tempTeam;

		/**********************   Start addTeam ********************/

		//Call method to display the current existing teams
		listTeams(teams, count);
		System.out.println("\n\n\n\n\n\n");

		//Input the team name
		System.out.print(Util.setLeft("Enter Teams Name   : "));
		name = Keyboard.readString();

		//Input max number of players for the team
		System.out.print(Util.setLeft("Enter Max Players  : "));
		playersMax = Keyboard.readString();

		//Input max number of games for the team
		System.out.print(Util.setLeft("Enter Max Games    : "));
		gamesMax = Keyboard.readString();


		//Make sure the user inputs a valid int.
		try
		{
			//Get the integers from the strings.
			playersMaxInt = Integer.parseInt(playersMax);
			gamesMaxInt   = Integer.parseInt(gamesMax);

			//If the numbers are in range.
			if(playersMaxInt > 0 && gamesMaxInt > 0)
			{
				//Create instance of TeamInfo.
				tempTeam = new TeamInfo(name, playersMaxInt, gamesMaxInt);

				//Add the new team to the array.
				teams[count] = tempTeam;

				//Increment the number of teams.
				count++;

			}//endif
			else
			{
				//Display error message.
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
								   + Util.setLeft("Error Invalid Input")
								   + "\n\n\n\n\n\n\n\n\n\n\n\n\n");

				//Pause the screen.
				Util.pressAnyKeyToContinue();

			}//endif
		}
		catch(Exception e)
		{
			//Display error message.
			System.out.println(Util.setLeft("Error: " + e.getMessage()));

			//Pause the screen.
			Util.pressAnyKeyToContinue();

		}//end try

		//Return the count of teams.
		return count;

	}//end addTeam

	/**********************************************************
	* Method Name    : delPlayer
	* Author         : David Pitoniak
	* Date           : 3/11/19
	* Course/Section : CSC-264-501
	* Method Description: This method will recive a TeamInfo.
	*     It will then display a list of players.
	*     and it will ask the user for the number of the
	*     player they want to remove from the team.
	*
	* BEGIN delPlayer
	*     Display a numbered list of players
	*     Ask the user which player they want to remove
	*     Remove the specified player from the team
	* END delPlayer
	**********************************************************/
	public static void delPlayer(TeamInfo team)
	{
		//local constants

		//local variables
		String index;

		/*******************************************************************************/

		//Display a numbered list of players.
		listPlayers(team);

		//Ask the user which player they want to remove.

		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n"
						 + Util.setLeft("Enter number of player or (b for back): "));
		index = Keyboard.readString();

		//Remove the specified player from the team.
		if(!index.equals("b"))
			team.removePlayer(Integer.parseInt(index)-1);

	}//end delPlayer

	/**********************************************************
	* Method Name    : listPlayers
	* Author         : David Pitoniak
	* Date           : 3/11/19
	* Course/Section : CSC-264-501
	* Method Description: This method will display a numbered
	*     list of players.
	*
	* BEGIN listPlayers
	*     Get the players from the passed in team
	*     FOR( the number of players on the team )
	*         Display the players name
	*     ENDFOR
	* END listPlayers
	**********************************************************/
	public static void listPlayers(TeamInfo team)
	{
		//local constants

		//local variables
		PlayerInfo[] players; //Array of players from team.

		/*******************************************************************************/

		if( team.getCurrentNumPlayers() != 0 )
		{
			//Display team name.
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println(Util.setLeft(team.getName()) + "\n\n");

			//Get the players from the passed in team.
			players = team.getAllPlayers();

			//For the number of players on the team.
			for(int i = 0; i < team.getCurrentNumPlayers(); i++)
			{
				//Display the players name.
				System.out.println(Util.setLeftFixed(50, i+1 + ".) "
			                   	   + players[i].getName().getLastName()
			                   	   + ", " + players[i].getName().getFirstName()));
			}//end for

		}
		else
		{
			//Display no teams are in the leauge.
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
							   + Util.setLeft("No Players on this team.")
							   + "\n\n\n\n\n\n\n\n\n\n\n\n\n");

		}//end if

	}//end listPlayers

	/**********************************************************
	* Method Name    : listTeams
	* Author         : Ben Masten
	* Date           : March 8, 2019
	* Course/Section : CSC 264 - 501
	* Method Description: This method will display a list of
	*	 the current existing teams.
	*
	* BEGIN listTeams (TeamInfo [] teams, int size)
	*	 Clear the screen
	*    IF( there are teams in the leauge )
	*	    Display header
	*	    FOR (each team in the team array)
	*	       Display the team name and the max number of players
	*	    END FOR
	*    ELSE
	*       Display there are no teams in the leauge
	*    ENDIF
	* END listTeams
	**********************************************************/
	public static void listTeams(TeamInfo [] teams, int size)
	{
		//local constants
		final int NO_TEAMS = 0;

		//local variables

		/********************   Start listTeams ********************/

		//Clear the screen
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		//Display header
		if(size != NO_TEAMS)
		{

			System.out.println(Util.setLeft("Hockey League Teams") + "\n");

			//For each team in the team array
			for (int pos = 0; pos < size; pos++)
			{
				//Display the team name and the max number of players
				System.out.print(Util.setLeftFixed(50 ,pos+1 + ".) "
				                 + teams[pos].getName()) + "\n");
			}
			//end for

		}//end if
		else
		{
			//Display no teams are in the leauge.
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
							   + Util.setLeft("No Teams Currently in the leauge")
							   + "\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}

	}//end listTeams

	/**********************************************************
	* Method Name    : displayLeaugeData
	* Author         : David Pitoniak
	* Date           : 3/11/19
	* Course/Section : CSC-264-501
	* Method Description: This method will display all the
	*     data of the current teams and the players on them
	*     for the leauge.
	*
	* BEGIN displayLeaugeData
	*     Display leauge heading
	*     FOR( the teams in the array )
	*         Display the team toString
	*     ENDFOR
	* END displayLeaugeData
	**********************************************************/
	public static void displayLeaugeData(TeamInfo [] teams, int count)
	{
		//local constants

		//local variables

		/*******************************************************************************/

		//Display leauge Heading.
		System.out.println("\n\n\n\n\n\n\n\n\n\n");
		System.out.println(Util.setLeft("+---------------------------------------------------------------------------------------------+"));
		System.out.println(Util.setLeft("| Teams In Current Leauge: " +
		                   Util.addPadding(65-(count+""+teams.length+"").length(), count + "/" + teams.length) + " |"));
		System.out.println(Util.setLeft("+---------------------------------------------------------------------------------------------+") + "\n");


		//For the current number of teams.
		for(int i = 0; i < count; i++)
		{
			//Display the teams toString.
			System.out.println(teams[i]);

		}//end for

	}//end displayLeaugeData

	/************************************************************************************
	* Method Name	: loadTeamsFile
	* Author		: David Pitoniak
	* Date			: 3/6/19
	* Course/Section: CSC-264-501
	* Program Description: This method reads from a specified file and returns the
	*     number of TeamInfos that were added into the teams array.
	*
	* BEGIN loadTeamsFile
	*     TRY
	*         Create new file manager with files
	*         Read first line
	*         WHILE( line isnt null )
	*             IF( line isnt a blank line )
	*                 Tokenize the line
	*                 Set the teamName to the token
	*                 Get the max players allowed on the team
	*			      Get the max games allowed for a player
	*                 Use data to create a TeamInfo
	*			      Add the team to the array
	*			      Increment count
	*			      Read the next line
	*			      WHILE( line isnt null )
	*                     IF( line isnt a blank line )
	*			              Tokenize line
	*				          Set the first name to the first token
	*				          Set the last name to the second token
	*				          Create NameInfo with data
	*				          Create new player with data
	*				          WHILE( the tokenizer still has tokens )
	*				              Get the number of goals
	*					          Get the number of assists
	*					          Get the time played
	*					          Create new GameInfo with data
	*					          Add game to the player
	*                         ENDWHILE
	*                         Add player to the team
	*				          Read the next line
	*                     ELSE
    *                         Set the line to null
	*                     ENDIF
	*                 ENDWHILE
	*			      Read the next line
	*             ELSE
	*                 Set the line to null
	*             ENDIF
	*         ENDWHILE
	*	  CATCH( IOException - thrown by FileIOManager )
	*         Display the exception message
	*     ENDTRY
	*     RETURN the count of teams
	* END loadTeamsFile
	************************************************************************************/
	public static int loadTeamsFile(TeamInfo []teams, String fileName)
	{
		//local constants

		//local variables
		String line;			//The current line read from the file.
		String teamName;		//Temp team name from file.
		String playerFirstName;	//Temp player first name from file.
		String playerLastName;	//Temp player last name from file.
		int maxPlayers;			//Temp max players on a team from file.
		int maxGames;			//Temp max games for a player from file.
		int tempGoals;			//Temp goals from file.
		int tempAssists;		//Temp assists from file.
		int teamCounter = 0;	//Number of players in the team
		double tempTime;		//Temp time played from file.
		TeamInfo tempTeam;		//Temp team to store team data.
		PlayerInfo tempPlayer;	//Temp player to store player data.
		NameInfo tempName;		//Temp name to store players name data.
		GameInfo tempGame;		//Temp game to store game data.
		FileIOManager man;		//File Manager to allow file to be read.
		StringTokenizer tok;	//String tokenizer to break up lines read from the file.

		/*******************************************************************************/

		//To catch IOExceptions thrown by FileIOManager.
		try
		{
			//Create new file manager with files.
			man = new FileIOManager(fileName);

			//Read first line.
			line = man.readLine();

			//While line isnt null.
			while(line != null)
			{
				//If the length of the line is not 0
				if(line.length() != 0)
				{
					//Set the teamName line.
					teamName = line;

					//Get the next line.
					line = man.readLine();

					//Tokenize the line.
					tok = new StringTokenizer(line);

					//Get the max players allowed on the team.
					maxPlayers = Integer.parseInt(tok.nextToken());

					//Get the max games allowed for a player.
					maxGames = Integer.parseInt(tok.nextToken());

					//Use data to create a TeamInfo.
					tempTeam = new TeamInfo(teamName, maxPlayers, maxGames);

					//Read the next line.
					line = man.readLine();

					//While the line isnt null.
					while(line != null)
					{
						//If the length of the line isnt 0.
						if(line.length() != 0)
						{
							//Tokenize line.
							tok = new StringTokenizer(line);

							//Set the first name to the first token.
							playerFirstName = tok.nextToken();

							//Set the last name to the second token.
							playerLastName  = tok.nextToken();

							//Create NameInfo with data.
							tempName = new NameInfo(playerFirstName, playerLastName);

							//Create new player with data.
							tempPlayer = new PlayerInfo(tempName, tempTeam.getMaxGames());

							//While the tokenizer still has tokens.
							while(tok.hasMoreTokens())
							{
								//Get the number of goals.
								tempGoals = Integer.parseInt(tok.nextToken());

								//Get the number of assists.
								tempAssists = Integer.parseInt(tok.nextToken());

								//Get the time played.
								tempTime = Double.parseDouble(tok.nextToken());

								//Create new GameInfo with data.
								tempGame = new GameInfo(tempGoals, tempAssists, tempTime);

								//Add game to the player.
								tempPlayer.addGame(tempGame);

							}//end while for games.

							//Add player to the team.
							tempTeam.addPlayer(tempPlayer);

							//Read the next line.
							line = man.readLine();
						}
						else
						{
							//Set line to null.
							line = null;

						}//endif

					}//end while for players.

					//Add the team to the array.
					teams[teamCounter] = tempTeam;

					//Increment count.
					teamCounter++;

					//Read the next line.
					line = man.readLine();

				}
				else
				{
					//Set line to null.
					line = null;

				}//endif

			}//end while for teams.

			//Close the reader.
			man.closeReader();

		}
		catch(IOException e)
		{
			//Display error message.
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
							   + Util.setLeft("ERROR: " + e.getMessage())
							   + "\n\n\n\n\n\n\n\n\n\n\n\n\n");

			//Pause the screen.
			Util.pressAnyKeyToContinue();

		}//end try

		//Return array of teams.
		return teamCounter;

	}//end loadTeamsData

	/**********************************************************
   	* Method Name    : manageTeamData
   	* Author         : Ben Masten
   	* Date           : March 10, 2019
   	* Course/Section : CSC 264 - 501
   	* Method Description: This method will display a menu
   	*	 allowing the user to utilize team data, such as adding
   	*	 and removing players, sorting data alphabetically and
   	*	 searching for players based on their names or by
   	*	 points scored.
   	*
   	* BEGIN manageTeamData (TeamInfo team, int teamCount)
   	*	  Clear screen
   	*	  Display heading, menu and options
   	*	  Input user choice
   	*     TRY
   	*         Parse the string for the index
   	*         Set the team chosen from the user
   	*     CATCH
   	*         Display error message
   	*         Pause the screen
   	*     ENDTRY
   	*     IF( the index was valid and there is a team )
   	*	      WHILE (user does not choose to return to main menu)
   	*	          IF (user chooses to add a player)
   	*	              Call method to add a new player
	*	          ELSE IF (user chooses to remove a player)
	*	              Call method to remove a player
	*	          ELSE IF (user chooses to sort data)
	*		          Call method to sort data
	*	          ELSE IF (user chooses to search players by name)
	*		          Call method to search for players by name
	*	          ELSE IF (user chooses to search players by points)
   	*		          Call method to search for players by points
   	*	          ELSE
   	*		          Display error message
   	*		          Call method to "press any key to continue"
   	*		      END IF
   	*		      Clear screen
   	*		      Display heading, menu and options
   	*	 	      Input user choice
   	*	      END WHILE
   	*     ENDIF
   	* END manageTeamData
	**********************************************************/

	public static void manageTeamData (TeamInfo [] teams, int teamCount)
	{

		//local constants
		final String ADD_PLAYER     = "1"; //choice to add a player
		final String DEL_PLAYER     = "2"; //choice to remove a player
		final String SORT_ALPHA     = "3"; //sort players alphabetically
		final String ADD_GAME       = "4"; //add game to player
		final String DISP_PLAYER    = "5"; //display a single player
		final String DISP_TEAM		= "6"; //display the team
		final String NAME_SEARCH    = "7"; //search players by name
		final String POINTS_SEARCH  = "8"; //search by number of poStrings
		final String RETURN_TO_MAIN = "9"; //sentinel value to end program

		//local variables
		String choice;			//user input
		TeamInfo team = null;	//selected team
		int teamNum = 0;		//team from the list

		/*****************   Start manageTeamData ******************/

		//Clear screen
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		//Call method to display the current existing teams
		listTeams(teams, teamCount);

		//Get the desired team
		System.out.print("\n\n\n\n\n\n\n\n\n");
		System.out.print(Util.setLeft("Select your designated team : "));
		choice = Keyboard.readString();

		try
		{
			//Parse the string for the index.
			teamNum = Integer.parseInt(choice);

			//Set the team chosen from the user
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			team = teams[teamNum - 1];
		}
		catch(Exception e)
		{
			//Display error message.
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
							   + Util.setLeft("Error Invalid Input")
							   + "\n\n\n\n\n\n\n\n\n\n\n\n\n");

			//Pause the screen.
			Util.pressAnyKeyToContinue();

		}//endtry

		//If the index was valid and there is a team.
		if(team != null)
		{
			//Display heading, menu and options
			System.out.print(Util.setLeft("Manage " + team.getName()));
			System.out.print("\n\n");
			System.out.print(Util.setLeftFixed(50, ADD_PLAYER + "" + ".) "
							 + "Add a New Player"));
			System.out.print("\n\n");
			System.out.print(Util.setLeftFixed(50, DEL_PLAYER + "" + ".) "
							 + "Remove Player"));
			System.out.print("\n\n");
			System.out.print(Util.setLeftFixed(50, SORT_ALPHA + "" + ".) "
							 + "Sort Data Alphabetically"));
			System.out.print("\n\n");
			System.out.print(Util.setLeftFixed(50, ADD_GAME + "" + ".) "
							 + "Add Game To Player"));
			System.out.print("\n\n");
			System.out.print(Util.setLeftFixed(50, DISP_PLAYER + "" + ".) "
							 + "Display Player Data"));
			System.out.print("\n\n");
			System.out.print(Util.setLeftFixed(50, DISP_TEAM + "" + ".) "
							 + "Display Teams's Stats"));
			System.out.print("\n\n");
			System.out.print(Util.setLeftFixed(50, NAME_SEARCH + "" + ".) "
							 + "Search by Name"));
			System.out.print("\n\n");
			System.out.print(Util.setLeftFixed(50, POINTS_SEARCH + "" + ".) "
							 + "Search by Points"));
			System.out.print("\n\n");
			System.out.print(Util.setLeftFixed(50, RETURN_TO_MAIN + "" + ".) "
							 + "Return to Main Menu"));
			System.out.print("\n\n\n\n\n\n");

			//Input user choice
			System.out.print(Util.setLeftFixed(50, "Enter a choice: "));
			choice = Keyboard.readString();

			//While the user does not want to return to the main menu
			while (!choice.equals(RETURN_TO_MAIN))
			{
				//Test if user chooses to add a new player
				if (choice.equals(ADD_PLAYER))
				{
					//Call method to add a new player
					addPlayer(team);

				}

				//Test if user chooses to remove a player
				else if (choice.equals(DEL_PLAYER))
				{
					//Call method to remove a player
					delPlayer(team);

				}

				//Test if user chooses to view data sorted alphabetically
				else if (choice.equals(SORT_ALPHA))
				{
					//Call method to view data sorted alphabetically
					viewSortedData(team);

				}

				//Test if user chooses to add game to player
				else if (choice.equals(ADD_GAME))
				{
					//Call method to add game to player
					addGameToPlayer(team);

				}

				//Test if user chooses to display a player.
				else if (choice.equals(DISP_PLAYER))
				{
					//Call method to display the player
					displayPlayerData(team);
				}

				//Test if user chooses to display the team
				else if (choice.equals(DISP_TEAM))
				{
					//Display the team
					System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println(team);
					System.out.print("\n\n\n");
					Util.pressAnyKeyToContinue();
				}

				//Test if user chooses to search players by name
				else if (choice.equals(NAME_SEARCH))
				{
					//Call method to search for players by name
					searchByPlayersName(team);

				}

				//Test if user chooses to search players by points
				else if (choice.equals(POINTS_SEARCH))
				{
					//Call method to search for players by points
					searchByPlayersPoints(team);

				}

				//User choice is invalid
				else
				{
					//Display error message
					System.out.print("\n\n" + Util.setLeft("ERROR: INVALID INPUT"));
					System.out.print("\n\n");

					//Call method to "press any key to continue"
					Util.pressAnyKeyToContinue();

				}
				//end if

				//Clear screen
				System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

				//Display heading, menu and options
				System.out.print(Util.setLeft("Manage " + team.getName()));
				System.out.print("\n\n");
				System.out.print(Util.setLeftFixed(50, ADD_PLAYER + "" + ".) "
								 + "Add a New Player"));
				System.out.print("\n\n");
				System.out.print(Util.setLeftFixed(50, DEL_PLAYER + "" + ".) "
								 + "Remove Player"));
				System.out.print("\n\n");
				System.out.print(Util.setLeftFixed(50, SORT_ALPHA + "" + ".) "
								 + "Sort Data Alphabetically"));
				System.out.print("\n\n");
				System.out.print(Util.setLeftFixed(50, ADD_GAME + "" + ".) "
								+ "Add Game To Player"));
				System.out.print("\n\n");
				System.out.print(Util.setLeftFixed(50, DISP_PLAYER + "" + ".) "
								+ "Display Player Data"));
				System.out.print("\n\n");
				System.out.print(Util.setLeftFixed(50, DISP_TEAM + "" + ".) "
							 	 + "Display Teams's Stats"));
				System.out.print("\n\n");
				System.out.print(Util.setLeftFixed(50, NAME_SEARCH + "" + ".) "
								 + "Search by Name"));
				System.out.print("\n\n");
				System.out.print(Util.setLeftFixed(50, POINTS_SEARCH + "" + ".) "
								 + "Search by Points"));
				System.out.print("\n\n");
				System.out.print(Util.setLeftFixed(50, RETURN_TO_MAIN + "" + ".) "
								 + "Return to Main Menu"));
				System.out.print("\n\n\n\n\n\n");

				//Input user choice
				System.out.print(Util.setLeftFixed(50, "Enter a choice: "));
				choice = Keyboard.readString();

			}//end while

		}//endif

	}//end manageTeamData

	/************************************************************************************
	* Method Name	: addGameToPlayer
	* Author		: David Pitoniak
	* Date			: 3/14/19
	* Course/Section: CSC-264-501
	* Program Description: This method will allow the user to select a player to add a
	*    game to and then prompt them for the game data.
	*
	* BEGIN addGameToPlayer
	*     Display the players
	*     Recive what player to add the game to
	*     Get the game data
	*     Create the game
	*     Add the game to the player
	* END addGameToPlayer
	************************************************************************************/
	public static void addGameToPlayer(TeamInfo team)
	{
		//local constants

		//local variables
		GameInfo tempGame;	//Game being added.
		int index = 0;		//Index of player.
		int goals;			//Goals for the game.
		int assists;		//Assists for the game.
		double timePlayed;  //Time played for the game.

		/*******************************************************************************/

		//Display the players.
		System.out.println("\n\n\n\n\n\n\n\n\n\n");
		listPlayers(team);
		System.out.println("\n\n\n\n\n\n\n");

		//Recive what player to add the game to.
		System.out.print(Util.setLeft("Enter Player Number        : "));
		index = Keyboard.readInt();

		//Check if the player has reached max number of games.
		if(team.getPlayer(index-1).getCurrentNumGames() != team.getMaxGames())
		{
			//Get the game data.
			System.out.print(Util.setLeft("Enter Number Of Goals      : "));
			goals = Keyboard.readInt();
			System.out.print(Util.setLeft("Enter Number Of Assists    : "));
			assists = Keyboard.readInt();
			System.out.print(Util.setLeft("Enter Number Of Time Played: "));
			timePlayed = Keyboard.readDouble();

			//Create the game.
			tempGame = new GameInfo(goals, assists, timePlayed);

			//Add the game to the player.
			team.addGameToPlayer(index-1, tempGame);
		}
		else
		{
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println(Util.setLeft("ERROR: This player has played the max number of games"));
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			Util.pressAnyKeyToContinue();

		}//endif

	}//end addGameToPlayer

	/************************************************************************************
	* Method Name	: displayPlayerData
	* Author		: David Pitoniak
	* Date			: 3/14/19
	* Course/Section: CSC-264-501
	* Program Description: This method will allow the user to select a player to add a
	*    game to and then prompt them for the game data.
	*
	* BEGIN displayPlayerData
	*     IF( there are players on the team )
	*         Display the players
	*         Recive what player to display
	*         IF( the index is in range )
	*             Display the player
	*             Pause the screen
	*         ENDIF
	*     ELSE
	*         Display error message
	*     ENDIF
	* END displayPlayerData
	************************************************************************************/
	public static void displayPlayerData(TeamInfo team)
	{
		//local constants

		//local variables
		GameInfo tempGame;	//Game being added.
		int index = 0;		//Index of player.
		int goals;			//Goals for the game.
		int assists;		//Assists for the game.
		double timePlayed;  //Time played for the game.

		/*******************************************************************************/

		//If there are players on the team
		if(team.getCurrentNumPlayers() > 0)
		{
			//Display the players.
			System.out.println("\n\n\n\n\n\n\n\n\n\n");
			listPlayers(team);
			System.out.println("\n\n\n\n\n\n\n");

			//Recive what player to add the game to.
			System.out.print(Util.setLeft("Enter Player Number: "));
			index = Keyboard.readInt();

			if(index > 0 && index-1 < team.getCurrentNumPlayers())
			{
				//Display player at index.
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println(team.getPlayer(index-1));
				System.out.println("\n\n\n\n\n\n\n");

				//Pause the screen.
				Util.pressAnyKeyToContinue();

			}//endif

		}
		else
		{
			//Display a new player created message
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
							 + Util.setLeft("ERROR: Team Is Empty")
							 + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			Util.pressAnyKeyToContinue();

		}//endif

	}//end displayPlayerData

   /**********************************************************
   	* Method Name    : addPlayer
   	* Author         : Ben Masten
   	* Date           : March 12, 2019
   	* Course/Section : CSC 264 - 501
   	* Method Description: This method will add a player to the
   	*	 team chosen by the user.
   	*
   	* BEGIN addPlayer (TeamInfo team)
   	*    Call listPlayers method
   	*	 IF (current no. of players is at its cap)
   	*	    Display maxed-out team message
   	*	 ELSE
   	*	    Input first name
   	*		Input last name
   	*		Call NameInfo constructor
   	*	 	Set max games for player
   	*		Call PlayerInfo constructor
   	*		Add player to team
   	*		Display player created message
   	* 	 END IF
   	*	 Prompt user to continue
   	* END addPlayer
	**********************************************************/

	public static void addPlayer (TeamInfo team)
	{

		//local constants

		//local variables
		PlayerInfo tempPlayer;		//player to be added
		NameInfo name;				//full name of player
		String firstName;			//first name of player
		String lastName;			//last name of player
		int maxGames;				//max no. of games for player

		/********************   Start addPlayer ********************/

		//Call method to display the current players of team
		listPlayers(team);

		//Test if team has reached its max number of players
		if (team.getCurrentNumPlayers() == team.getMaxPlayers())
		{
			//Display team maxed out on players mesage
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.print(Util.setLeft("The " + team.getName()
							 + " have maxed out on players. Remove a player to try again. "));
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			Util.pressAnyKeyToContinue();

		}

		//Team can add more players
		else
		{
			//Input first name of player
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
			System.out.print(Util.setLeft("Enter player's first name or (b for back): "));
			firstName = Keyboard.readString();

			//If user doesnt go back.
			if(!firstName.equals("b"))
			{
				//Input surname of player
				System.out.print(Util.setLeft("Enter player's last name                 : "));
				lastName = Keyboard.readString();

				//Call NameInfo constructor to create player
				name = new NameInfo(firstName, lastName);

				//Set max number of games for the player
				maxGames = team.getMaxGames();

				//Call the PlayerInfo constructor to create the player
				tempPlayer = new PlayerInfo(name, maxGames);

				//Add the new player to the team
				team.addPlayer(tempPlayer);

				//Display a new player created message
				System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
								 + Util.setLeft("New Player Created")
								 + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

				//Prompt user to continue
				Util.pressAnyKeyToContinue();

			}//end if
		}
		//end if

	}//end addPlayer

   /**********************************************************
   	* Method Name    : viewSortedData
   	* Author         : Ben Masten
   	* Date           : March 12, 2019
   	* Course/Section : CSC 264 - 501
   	* Method Description: This method will allow the user to
   	*    view the players of the team sorted in alphabetical
   	*	 order by either first name or last name.  If the user
   	*	 input is invalid, it will display the players of the
   	*	 team regardless of invalid input.
   	*
   	* BEGIN viewSortedData (TeamInfo team)
    *    Call method to display team players
    *	 Display heading, menu and options
    *	 Input user choice
    *	 IF (user chooses to sort by first name)
    *	    Call method to sort by first name
    *	 ELSE IF (user chooses to sort by last name)
    *		Call method to sort by last name
    *	 ELSE
    *	    Display error message
    *	 END IF
    *	 Call method to display team players
    *	 Prompt user to continue
   	* END viewSortedData
	**********************************************************/

	public static void viewSortedData (TeamInfo team)
	{

		//local constants
		final int SORT_BY_FIRST = 1;	//choice to sort by first name
		final int SORT_BY_LAST	= 2;	//choice to sort by last name
		final int BACK_TO_MENU  = 3;	//choice to return to menu

		//local variables
		int choice;				//user input

		/*****************   Start viewSortedData ******************/

		//Call method to display the current players of team
		listPlayers(team);
		System.out.println("\n\n\n");

		//Display heading, menu and options
		System.out.print(Util.setLeft("Sorting Preferences"));
		System.out.print("\n\n");
		System.out.print(Util.setLeftFixed(49, SORT_BY_FIRST + ".) Sort By First Name"));
		System.out.print("\n" + Util.setLeftFixed(49, SORT_BY_LAST + ".) Sort By Last Name"));
		System.out.print("\n" + Util.setLeftFixed(49, BACK_TO_MENU + ".) Back To Menu     "));

		//Input choice
		System.out.print("\n\n\n\n" + Util.setLeftFixed(49, "Enter a choice: "));
		choice = Keyboard.readInt();

		//Test if user chose to select sort by first name option
		if (choice == SORT_BY_FIRST)
		{
			//Call method to sort by first name
			team.sortPlayersByFirst();

		}

		//Test if user chose to select sort by last name option
		else if (choice == SORT_BY_LAST)
		{
			//Call method to sort by last name
			team.sortPlayersByLast();

		}

		//User choice is invalid
		else if(choice != BACK_TO_MENU)
		{
			//Display error message
			System.out.print("\n\n" + Util.setLeft("ERROR: INVALID INPUT"));

		}
		//end if

		if(choice != BACK_TO_MENU)
		{

			//Call method to display team players
			listPlayers(team);
			System.out.println("\n\n\n\n\n");

			//Prompt user to continue
			Util.pressAnyKeyToContinue();

		}//endif

	}//end viewSortedData

   /**********************************************************
   	* Method Name    : searchByPlayersName
   	* Author         : Ben Masten
   	* Date           : March 13, 2019
   	* Course/Section : CSC 264 - 501
   	* Method Description: This method will
   	*
   	* BEGIN searchByPlayersName
    *     Get the first name from the user
    *     Get the last name from the user
    *     Create a name to search with
    *     Search by the name
    *     IF( the player exists )
    *         Display player
    *         Pause the screen
    *     ELSE
    *         Display error
    *     ENDIF
   	* END searchByPlayersName
	**********************************************************/

	public static void searchByPlayersName (TeamInfo team)
	{
		//local constants

		//local variables
		String first;		//First name being searched
		String last;        //Last name being searched
		PlayerInfo player;	//Player that is returned
		NameInfo tempName;  //Name being searched for

		/**************   Start searchByPlayersName    **************/

		//Get the first name from the user.
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.print(Util.setLeft("Enter First Name: "));
		first = Keyboard.readString();

		//Get the last name from the user.
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.print(Util.setLeft("Enter Last Name: "));
		last = Keyboard.readString();

		//Create a name to search with.
		tempName = new NameInfo(first, last);

		//Search by the name.
		player = team.searchPlayerByName(tempName);

		//If the player exists.
		if(player != null)
		{
			//Display player and increment to the next.
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println(player);

			//Pause the screen
			System.out.println("\n\n\n\n\n\n\n");
			Util.pressAnyKeyToContinue();
		}
		else
		{
			//Display error.
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println(Util.setLeft("No Player By '" + tempName + "' Was Found."));

			//Pause the screen
			System.out.println("\n\n\n\n\n\n\n");
			Util.pressAnyKeyToContinue();

		}//endif

	}//end searchByPlayersName

   /**********************************************************
   	* Method Name    : searchByPlayersPoints
   	* Author         : Ben Masten
   	* Date           : March 13, 2019
   	* Course/Section : CSC 264 - 501
   	* Method Description: This method will
   	*
   	* BEGIN searchByPlayersPoints
   	*     Create the array
   	*     Get the points from the user
   	*     Search by the number of points
   	*     Adding spacing
   	*     IF( players exists )
   	*         WHILE( the array still has players )
   	*             Display player and increment to the next
   	*         ENDWHILE
   	*         Pause the screen
   	*     ELSE
   	*         Display error
   	*     ENDIF
   	* END searchByPlayersPoints
	**********************************************************/

	public static void searchByPlayersPoints (TeamInfo team)
	{
		//local constants

		//local variables
		int points = 0;			//Points being searched for
		int index  = 0;			//Index of player array
		PlayerInfo[] players;	//Array of players being searched

		/**************   Start searchByPlayersPoints **************/

		//Create the array.
		players = new PlayerInfo[team.getCurrentNumPlayers()];

		//Get the points from the user.
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.print(Util.setLeft("Enter Points: "));
		points = Keyboard.readInt();

		//Search by the number of points.
		players = team.searchPlayersByPoints(points);

		//Adding spacing.
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		//If there are players with the points.
		if( players[0] != null)
		{
			//While the array still has players.
			while(players[index] != null)
			{
				//Display player and increment to the next.
				System.out.println(players[index]);
				index++;

			}//end while

			//Pause the screen
			System.out.println("\n\n\n\n\n\n\n");
			Util.pressAnyKeyToContinue();
		}
		else
		{
			//Display error.
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println(Util.setLeft("No Players With '" + points + "' Points Was Found."));

			//Pause the screen
			System.out.println("\n\n\n\n\n\n\n");
			Util.pressAnyKeyToContinue();

		}//endif

	}//end searchByPlayersPoints

}//end TeamManagerDriver