
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
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;

//assignment class
public class GardnerTreyAssignment2 {
	
	public static void main(String[] args) throws IOException {
		
	//Test with provided file, but do not assume that file information will be static

	//Task A: Open the test files "Actors.txt" for reading 
	//A.1: Creating Reader and opening file (in working directory)

		Scanner reader = new Scanner("Actors.txt");
	
	//Task B: Create Polymorphic Array to store the actors
		
		int number_of_actors = reader.nextInt();
		Actor[] actor = new Actor[number_of_actors];
		
	//Task C: Fill the array with actor objects
		
		String read_type;
		String read_name;

		for(int i = 0; i < number_of_actors; i++) {
			read_type = reader.next();
			
			if(read_type.equals("Hero")) { 

			}
			
			if(read_type.equals("Villian")) {
				
			}

			if(read_type.equals("Monster")) {
				
			}

			if(read_type.equals("Droid")) {
				
			}
				
			}
		}
	
	//Task D: Print all Actor objects in table (After read and "write")
	
	//Task E: Create a Movie Object

	}

}

//Actor Classes:

//Actor "super" class
class Actor {
	
	//Private fields
	private String type;
	private String name;
	
	//super constructor
	public Actor(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
//public methods (getters and setters) 
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	//Actor motto
	public String motto() {
		return "This is my motto!";
	}
}

//Hero subclass
class Hero extends Actor {
	
	public Hero(String name) {
		super(name, "Hero");
	}
	
	@Override
	public String motto() {
		return "To the rescue! KAPOW!! BAM!! POW!!";
	}
}

//Villian subclass
class Villian extends Actor {
	
	public Villian(String name) {
		super(name, "Villian");
	}	
	
	@Override
	public String motto() {
		return "You’ll never stop me! Haaaaaaa!";
	}
}

//Monster subclass
class Monster extends Actor {
	
	public Monster(String name) {
		super(name, "Monster");
	}

	@Override
	public String motto() {
		return "RRAAAUUGGHH GRROWR!!!";
	}
	
}
//Droid subclass
class Droid extends Actor {
	
	public Droid(String name) {
		super(name, "Droid");
	}

	@Override
	public String motto() {
		return "Beep Beep Bloop Boop Beep!";
	}
}

//Movie class - only contains heros and villians
class Movie {

	private int number_of_heros;
	private int number_of_villains;
	private Actor[] actors_in_movie;
	
	public void selectCast(Actor[] actors) {
		//determine how many heros/villians
		
		
		//create and fill the actors_in_movie array
	}

}










