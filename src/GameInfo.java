/**********************************************************
* Class Name     : GameInfo
* Author         : Ben Masten
* Date           : March , 2019
* Course/Section : CSC 264 - 501
* Program Description: This class will store information
*	  about a single game for an individual player.
*
* Methods:
* -------
* Default Constructor - sets a player's game with 0 points and 0 minutes played
* Constructor 		   - receives goals, assists and minutes played in a game
* getGoals 		   - gets goals scored by player in a game and returns goals
* setGoals 		   - sets goals scored by player in a game
* getAssists 		   - gets assists scored by player in a game and returns assists
* setAssists 		   - sets assists scored by player in a game
* getPoints 		   - gets total of goals and assists scored by player in a game
* getTimePlayed	   - gets player time played in a game
* setTimePlayed 	   - sets player time played in a game
*
**********************************************************/
public class GameInfo
{
    //class constants

    //class variables
    private int goals;		  //goals scored by player in one game
    private int assists;	  //assists made by player in one game
    private double minPlayed; //time played by player in one game

    /**********************************************************
	* Method Name    : Default Constructor
	* Author         : Ben Masten
	* Date           : March, 2019
	* Course/Section : CSC 264 - 501
	* Method Description: This method will set the stats of
	*    a single game to default for an individual player.
	*
	* BEGIN Default Constructor
	*	 Set goals, assists and number of minutes played to 0
	* END Default Constructor
	**********************************************************/
	public GameInfo ()
	{
		//local constants
		final int NO_SCORE 	 = 0;		//set goals and assists made to 0
		final double NO_TIME = 0.00;	//set time played to 0.00

		//local variables

		/*************   Start Default Constructor *****************/

		//Set goals, assists and minutes played to 0
		goals = NO_SCORE;
		assists = NO_SCORE;
		minPlayed = NO_TIME;

	}//end Default Constructor

    /**********************************************************
    * Method Name    : Constructor
	* Author         : Ben Masten
	* Date           : March, 2019
	* Course/Section : CSC 264 - 501
	* Method Description: This method will set the stats of a
	*	 single game as passed by the values of the
	*	 parameters.
	*
	* BEGIN Constructor (int inGoals, int inAssists, double inMin)
	*	 Set goals, assists and number of minutes played
	* END Constructor
	**********************************************************/
	public GameInfo (int inGoals, int inAssists, double inMin)
	{
		//local constants

		//local variables

		/*********************   Start Constructor *****************/

		//Set goals, assists and minutes played
		goals = inGoals;
		assists = inAssists;
		minPlayed = inMin;

    }//end Constructor

    /**********************************************************
   	* Method Name    : getGoals
   	* Author         : Ben Masten
   	* Date           : March, 2019
   	* Course/Section : CSC 264 - 501
   	* Method Description: This method will get the number of
   	*	 goals scored by a player in a single game.  It will
   	*    return the number of goals scored as an integer.
   	*
   	* BEGIN getGoals
   	*	 Return the number of goals scored
   	* END getGoals
	**********************************************************/
	public int getGoals ()
	{
		//local constants

		//local variables

		/********************   Start getGoals *********************/

		//Return number of goals scored
		return goals;

	}//end getGoals

    /**********************************************************
   	* Method Name    : setGoals
   	* Author         : Ben Masten
   	* Date           : March, 2019
   	* Course/Section : CSC 264 - 501
   	* Method Description: This method will set the number of
   	*    goals scored by a player in a single game.
   	*
   	* BEGIN setGoals (int inGoals)
   	*	 Set goals scored from parameter value
   	* END setGoals
	**********************************************************/
	public void setGoals (int inGoals)
	{
		//local constants

		//local variables

		/********************   Start setGoals *********************/

		//Set goals scored from parameter value
		goals = inGoals;

	}//end setGoals

    /**********************************************************
   	* Method Name    : getAssists
   	* Author         : Ben Masten
   	* Date           : March, 2019
   	* Course/Section : CSC 264 - 501
   	* Method Description: This method will get the number of
    *    assists made by a player in a single game.  It will
    *	 return the number of assists made as an integer.
   	*
   	* BEGIN getAssists
   	*	 Return the number of assists made
   	* END getAssists
	**********************************************************/
	public int getAssists ()
	{
		//local constants

		//local variables

		/********************   Start getAssists *******************/

		//Return number of assists made
		return assists;

	}//end getAssists

    /**********************************************************
    * Method Name    : setAssists
    * Author         : Ben Masten
    * Date           : March, 2019
    * Course/Section : CSC 264 - 501
    * Method Description: This method will set the number of
    *	 assists made by a player in a single game.
    *
    * BEGIN setAssists (int inAssists)
    *	 Set assists made from paramter value
    * END setAssists
	**********************************************************/
	public void setAssists (int inAssists)
	{
		//local constants

		//local variables

		/********************   Start setAssists *******************/

		//Set assists made from parameter value
		assists = inAssists;

	}//end setAssists

    /**********************************************************
    * Method Name    : getPoints
    * Author         : Ben Masten
    * Date           : March, 2019
    * Course/Section : CSC 264 - 501
    * Method Description: This method will get the total number
    *	 of points scored by a player in a single game from the
    *	 sum of the number of goals scored and assists made.
    *    It will return the total number of points as an integer.
    *
    * BEGIN getPoints
    *	 Return the number of goals scored and assists made
    * END getPoints
	**********************************************************/
	public int getPoints ()
	{
		//local constants

		//local variables

		/********************   Start getPoints ********************/

		//Return number of goals scored and assists made
		return goals + assists;

	}//end getPoints

    /**********************************************************
    * Method Name    : getTimePlayed
    * Author         : Ben Masten
    * Date           : March, 2019
    * Course/Section : CSC 264 - 501
    * Method Description: This method will get the amount of
    *	 time played by a player in a single game.  It will
    *	 return the amount of time played as a double.
    *
    * BEGIN getTimePlayed
  	*	 Return the amount of time played
    * END getTimePlayed
	**********************************************************/
	public double getTimePlayed ()
	{
		//local constants

		//local variables

		/****************   Start getTimePlayed ********************/

		//Return amount of time played
		return minPlayed;

	}//end getTimePlayed

    /**********************************************************
    * Method Name    : setTimePlayed
    * Author         : Ben Masten
    * Date           : March, 2019
    * Course/Section : CSC 264 - 501
    * Method Description: This method will set the amount of
    *	 time played by a player in a single game.
    *
    * BEGIN setTimePlayed (double inTime)
    *	 Set amount of time played from paramter value
    * END setTimePlayed
	**********************************************************/
	public void setTimePlayed (double inTime)
	{
		//local constants

		//local variables

		/****************   Start setTimePlayed ********************/

		//Set amount of time played from parameter value
		minPlayed = inTime;

	}//end setTimePlayed

}//end GameInfo