import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/************************************************************************************
* Class Name	: FileIOManager
* Author		: David Pitoniak
* Date			: 2/19/2019
* Course/Section: CSC-264-501
* Program Description: This class is used to read and write to a file that is
*     passed in through the constructor. It is only designed to work for one file.
*
************************************************************************************/
public class FileIOManager
{
	//class constants

	//class variables
	private BufferedReader bReader;		//BufferedReader that handles reading from file.

	/***********************************************************************************/

	/************************************************************************************
	* Method Name	: Constructor
	* Author		: David Pitoniak
	* Date			: 2/19/2019
	* Course/Section: CSC-264-501
	* Method Description: Intitializes the instance BufferedReader and BufferedWriter
	*     For the file name that is passed in.
	*
	* BEGIN Constructor
	*     Init BufferedReader
	* END Constructor
	************************************************************************************/
	public FileIOManager(String readFile) throws IOException
	{
		//Init BufferedReader, Init BufferedWriter.
		bReader = new BufferedReader(new FileReader(readFile));

	}//end Constructor.

	/************************************************************************************
	* Method Name	: readLine
	* Author		: David Pitoniak
	* Date			: 2/19/2019
	* Course/Section: CSC-264-501
	* Method Description: This method reads a single line from the file that was passed
	*     into the constructor.
	*
	* BEGIN readLine
	*     Read line from the file store in fileLine
	*     Return fileLine
	* END readLine
	************************************************************************************/
	public String readLine() throws IOException
	{
		//local constants

		//local variables
		String fileLine;

		/*******************************************************************************/

		//Read line from the file store in fileLine.
		fileLine = bReader.readLine();

		//Return fileLine.
		return fileLine;

	}//end readFile.

	/************************************************************************************
	* Method Name	: closeReader
	* Author		: David Pitoniak
	* Date			: 2/19/2019
	* Course/Section: CSC-264-501
	* Method Description: This method closes the BufferedReader.
	*
	* BEGIN closeReader
	*     Close BufferedReader
	* END closeReader
	************************************************************************************/
	public void closeReader() throws IOException
	{
		//local constants

		//local variables

		/*******************************************************************************/

		//Close BufferedReader.
		bReader.close();

	}//end closeReader.

}//end FileIOManager.