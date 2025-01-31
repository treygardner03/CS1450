
/*Name: Trey Gardner
 * Class: CS1450(M/W)
 * Due: Jan 29, 2025
 * Assignment #1
 * DESC: This program will show proficiency in creating an manipulating arrays and
 * reading/writing from files
*/

//package for all assignments
package AssignmentsSourceCode;

//importing Java packages
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

//assignment class
public class GardnerTreyAssignment2 {
	
	public static void main(String[] args) {
		
	//Test with provided file, but do not assume that file information will be static

	//Task A: Open the test files "Actors.txt" for reading 
	//A.1: Creating Reader and opening file (in working directory)

		try {
			BufferedReader reader = new BufferedReader(new FileReader("Actors.txt"));

		}catch (FileNotFoundException e){
			System.out.println("File could not be found, probably not in working directory");

		}
	
	//Task B: Create Polymorphic Array to store the actors
	
	//Task C: Fill the array with actor objects
	
	//Task D: Print all Actor objects in table (After read and "write")
	
	//Task E: Create a Movie Object

	}

}

//Actor Classes:

//Actor "super" class
class Actor {

	private String type;
	private String name;
}












