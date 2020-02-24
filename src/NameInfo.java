/****************************************************************************************
* Class Name	: NameInfo
* Author		: David Pitoniak
* Date			: 2/23/19
* Course/Section: CSC-264-501
* Program Description: This class will store information about a persons name.
*
* Methods:
* -------
* getFirstName 	- gets the first name.
* setFirstName 	- sets the first name.
* getLastName 	- gets the last name.
* setLastName 	- sets the last name.
* getMiddleName - gets the middle name.
* setMiddleName - sets the middle name.
* getPrefix 	- gets the prefix.
* setPrefix 	- sets the prefix.
* toString		- formats the data of NameInfo.
****************************************************************************************/
public class NameInfo
{
	//class constants

	//class variables
	private String firstName;	//First name of person.
	private String lastName;	//Last name of person.
	private String middleName;	//Middle name of person.
	private String prefix; 		//Prefix for persons name.

	/***********************************************************************************/

	/************************************************************************************
	* Method Name	: Constructor
	* Author		: David Pitoniak
	* Date			: 2/23/19
	* Course/Section: CSC-264-501
	* Program Description: This method will set the instance data to the parameter
	*     values.
	*
	************************************************************************************/
	public NameInfo(String inFirst)
	{
		//Set instance data.
		firstName = inFirst;

	}//end Constructor

	/************************************************************************************
	* Method Name	: Constructor
	* Author		: David Pitoniak
	* Date			: 2/23/19
	* Course/Section: CSC-264-501
	* Program Description: This method will set the instance data to the parameter
	*     values.
	*
	************************************************************************************/
	public NameInfo(String inFirst, String inLast)
	{
		//Set instance data.
		firstName = inFirst;
		lastName  = inLast;

	}//end Constructor

	/************************************************************************************
	* Method Name	: Constructor
	* Author		: David Pitoniak
	* Date			: 2/23/19
	* Course/Section: CSC-264-501
	* Program Description: This method will set the instance data to the parameter
	*     values.
	*
	************************************************************************************/
	public NameInfo(String inFirst, String inMiddle, String inLast)
	{
		//Set instance data.
		firstName  = inFirst;
		middleName = inMiddle;
		lastName   = inLast;

	}//end Constructor

	/************************************************************************************
	* Method Name	: Constructor
	* Author		: David Pitoniak
	* Date			: 2/23/19
	* Course/Section: CSC-264-501
	* Program Description: This method will set the instance data to the parameter
	*     values.
	*
	************************************************************************************/
	public NameInfo(String inPrefix, String inFirst, String inMiddle, String inLast)
	{
		//Set instance data.
		prefix     = inPrefix;
		firstName  = inFirst;
	    middleName = inMiddle;
		lastName   = inLast;

	}//end Constructor

	/************************************************************************************
	* Method Name	: getFirstName
	* Author		: David Pitoniak
	* Date			: 2/23/19
	* Course/Section: CSC-264-501
	* Program Description: This method will return the value of firstName.
	*
	* BEGIN getFirstName
	*     Return the firstName
	* END getFirstName.
	************************************************************************************/
	public String getFirstName()
	{
		//local consants

		//local variables

		/*******************************************************************************/

		//Return the firstName.
		return firstName;

	}//end getFirstName

	/************************************************************************************
	* Method Name	: setFirstName
	* Author		: David Pitoniak
	* Date			: 2/23/19
	* Course/Section: CSC-264-501
	* Program Description: This method will set the value of firstName.
	*
	* BEGIN setFirstName
	*     Set firstName to inFirst
	* END setFirstName
	************************************************************************************/
	public void setFirstName(String inFirst)
	{
		//local constants

		//local variables

		/*******************************************************************************/

		//Set firstName to inFirst.
		firstName = inFirst;

	}//end setFirstName

	/************************************************************************************
	* Method Name	: getMiddleName
	* Author		: David Pitoniak
	* Date			: 2/23/19
	* Course/Section: CSC-264-501
	* Program Description: This method will return the value of MiddleName.
	*
	* BEGIN getMiddleName
	*     Return the middleName
	* END getMiddleName
	************************************************************************************/
	public String getMiddleName()
	{
		//local constants

		//local variables

		/*******************************************************************************/

		//Return the middleName.
		return middleName;

	}//end getMiddleName

	/************************************************************************************
	* Method Name	: setMiddleName
	* Author		: David Pitoniak
	* Date			: 2/23/19
	* Course/Section: CSC-264-501
	* Program Description: This method will set the value of middleName.
	*
	* BEGIN setMiddleName
	*     Set the middle name to inMiddle
	* END setMiddleName
	************************************************************************************/
	public void setMiddleName(String inMiddle)
	{
		//local constants

		//local variables

		/*******************************************************************************/

		//Set the middleName to inMiddle.
		middleName = inMiddle;

	}//end setMiddleName

	/************************************************************************************
	* Method Name	: getLastName
	* Author		: David Pitoniak
	* Date			: 2/23/19
	* Course/Section: CSC-264-501
	* Program Description: This method will return the value of lastName.
	*
	* BEGIN getLastName
	*     Return the last name
	* END getLastName
	************************************************************************************/
	public String getLastName()
	{
		//local constants

		//local variables

		/*******************************************************************************/

		//Return the last name.
		return lastName;

	}//end getLastName

	/************************************************************************************
	* Method Name	: setLastName
	* Author		: David Pitoniak
	* Date			: 2/23/19
	* Course/Section: CSC-264-501
	* Program Description: This method will set the value of lastName.
	*
	* BEGIN setLastName
	*     Set the value of lastName
	* END setLastName
	************************************************************************************/
	public void setLastName(String inLast)
	{
		//local constants

		//local variables

		/*******************************************************************************/

		//Set the value of lastName.
		lastName = inLast;

	}//end setLastName

	/************************************************************************************
	* Method Name	: getPrefix
	* Author		: David Pitoniak
	* Date			: 2/23/19
	* Course/Section: CSC-264-501
	* Program Description: This method will return the value of prefix.
	*
	* BEGIN getPrefix
	*     Return the prefix of the name
	* END getPrefix
	************************************************************************************/
	public String getPrefix()
	{
		//local constants

		//local variables

		/*******************************************************************************/

		//Return the prefix of the name.
		return prefix;

	}//end getPrefix

	/************************************************************************************
	* Method Name	: setPrefix
	* Author		: David Pitoniak
	* Date			: 2/23/19
	* Course/Section: CSC-264-501
	* Program Description: This method will set the value of prefix.
	*
	* BEGIN setPrefix
	*     Set the prefix to the inPrefix
	* END setPrefix
	************************************************************************************/
	public void setPrefix(String inPrefix)
	{
		//local constants

		//local variables

		/*******************************************************************************/

		//Set the prefix to the inPrefix.
		prefix = inPrefix;

	}//end setPrefix

	/************************************************************************************
	* Method Name	: toString
	* Author		: David Pitoniak
	* Date			: 3/1/19
	* Course/Section: CSC-264-501
	* Program Description: This method will create a String composed of the instance
	*     data that has a value stored.
	*
	* BEGIN toString
	*     IF( the prefix isnt null )
	*         Concat the prefix onto the finalName
	*     ENDIF
	*     IF( the firstName isnt null )
	*         Concat the  onto the finalName
	*     ENDIF
	*     IF( the middleName isnt null )
	*         Concat the  onto the finalName
	*     ENDIF
	*     IF( the lastName isnt null )
	*         Concat the  onto the finalName
	*     ENDIF
	*     Return the finalName String
	* END toString
	************************************************************************************/
	public String toString()
	{
		//local constants

		//local variables
		String finalName = "";	//The result of the data that isnt null.

		/*******************************************************************************/

		//If the prefix isnt null.
		if(prefix != null)
		{
			finalName += prefix+" ";
		}

		//If the firstName isnt null.
		if(firstName != null)
		{
			finalName += firstName+" ";
		}

		//If the middleName isnt null.
		if(middleName!= null)
		{
			finalName += middleName+" ";
		}

		//If the lastName isnt null.
		if(lastName != null)
		{
			finalName += lastName;
		}

		//Return the finalName String.
		return finalName;

	}//end toString

}//end NameInfo