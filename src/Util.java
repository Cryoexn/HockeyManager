public class Util
{
    /**********************************************************
	* Method Name    : setLeft
	* Author         : Prof Scheemaker
	* Edited By		 : David Pitoniak
	* Date           : 1/25/19
	* Course/Section : CSC264-501
	* Program Description:  This method will insert spaces
	*    in front of a string and return the new string. The
	*    string will be passed in as a parameter.
	*
	* BEGIN setLeft (string)
	*	Init num with the length of word - window size
	*   Divide num by two to find the number of spaces needed
	*   FOR (each space to be inserted)
	*      add a space to be beginning of the string
	*   END FOR
	*   return the new string with the leading spaces
	* END setLeft
	**********************************************************/
	public static String setLeft(String word)
	{
		//local constants
		final int WINDOW_SIZE = 120;

		//local variables
		int num;			//Used to store the length of word.

		/*******************************************************/

		//Initialize num with length of word - window size.
		num = WINDOW_SIZE - word.length();

		//Divide num by two to find the number of spaces needed
		num = num / 2;

		//For each space to be inserted.
		for (int i = 0; i < num; i++)
		   word = " " + word;

		//return the new string with the leading spaces
		return word;

	}

	/**********************************************************
	* Method Name    : addPadding
	* Author         : David Pitoniak
	* Date           : 3/13/19
	* Course/Section : CSC-264-501
	* Program Description:  This method will insert spaces
	*    trailing a string and return the new string. The
	*    string will be passed in as a parameter. as well
	*    as the number of trailing spaces.
	*
	* BEGIN addPadding
	*   FOR (each space to be inserted)
	*      add a space to be end of the string
	*   END FOR
	*   return the new string with the leading spaces
	* END setLeft
	**********************************************************/
	public static String addPadding(int num, String word)
	{
		//For each space to be inserted.
		for(int i = 0; i < num; i++)
			word = word + " ";

		//return the new string with the trailing spaces
		return word;

	}//end addPadding

	/*********************************************************
	* Method Name	 : setLeftFixed
	* Author 		 : Prof Scheemaker
	* Edited By		 : David Pitoniak
	* Date			 : 1/25/19
	* Course/Section : CSC264-501
	* Program Description:	This method will insert spaces
	*    in front of a string and return the new string.
	* 	 The number of spaces and the string itself will be
	* 	 passed in as parameters.
	*
	* BEGIN setLeft (field width, string)
	*   FOR (each space to be inserted)
	*      add a space to be beginning of the string
	*   END FOR
	*   return the new string with the leading spaces
	* END setLeft
	*
	*********************************************************/
	public static String setLeftFixed(int num, String word)
	{
		//local constants

		//local variables

		/*******************************************************/

		//For each space to be inserted.
		for (int i = 0; i < num; i++)
		   word = " " + word;

		//Return string with leading spaces
		return word;

	}

    /**********************************************************
	* Method Name    : setRight
	* Author         : Prof Scheemaker
	* Date           :
	* Course/Section :
	* Program Description:  This method will insert spaces
	*    in front of a string and return the new string. The
	*    number of spaces will be determined by the field
	*    width and the length of the string (Width - Length).
	*    If the string is wider than the field width, no
	*    spaces will be added to the front of the string
	*
	* BEGIN setRight (field width, string)
	*    Find the length of the string
	*    Calc the number of spaces to be added
	*    IF (there is room to add spaces)
	*       FOR (each space to be added)
	*          add a space to the front of the string
	*       END FOR
	*    END IF
	*    return the string
	* END setLeft
	**********************************************************/
	public static String setRight(int width, String word)
	{
		//local constants

        //local variables
		int len = word.length(); //get the string length
		int pad = width - len;   //how many spaces to add to front of string

		/*******************/

        //if there is room to add sapces
		if (len < width)

           //add the spaces to the front of the string
		   for (int i = 0; i < pad; i++)
		      word = " " + word;

        //return the string
		return word;

	}

	/**********************************************************
	* Method Name    : pressAnyKeyToContinue
	* Author         : David Pitoniak
	* Date           : 3/13/19
	* Course/Section : CSC-264-501
	* Program Description:  This method will pause the screen
	*     until you press a key.
	*
	* BEGIN pressAnyKeyToContinue
	*     Display message
	*     TRY
	*         Ask user to press any key
	*     CATCH( Exception )
	*     ENDTRY
	* END pressAnyKeyToContinue
	**********************************************************/
	public static void pressAnyKeyToContinue()
	{
		System.out.print(setLeft("Press Enter Key To Continue..."));
		try
		{
			System.in.read();
		}
		catch(Exception e)
		{}

	}//end pressAnyKeyToContinue
}