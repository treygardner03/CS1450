
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
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//assignment class
public class GardnerTreyAssignment2 {
	
	public static void main(String[] args) throws IOException {
		
	//Test with provided file, but do not assume that file information will be static

	//Task A: Open the test files "Actors.txt" for reading 
	//A.1: Creating Reader and opening file (in working directory)

		File actors = new File("Actors.txt");
		Scanner reader = new Scanner(actors);
	
	//Task B: Create Polymorphic Array to store the actors
		
		int number_of_actors = reader.nextInt();
		Actor[] actor = new Actor[number_of_actors];
		
	//Task C: Fill the array with actor objects
		
		String read_type;
		String read_name;

		for(int i = 0; i < number_of_actors; i++) {
			read_type = reader.next();
			read_name = reader.nextLine();
			
			if(read_type.equals("Hero")) { 
				actor[i] = new Hero(read_name);
			}
			
			if(read_type.equals("Villain")) {
				actor[i] = new Villain(read_name);
			}

			if(read_type.equals("Monster")) {
				actor[i] = new Monster(read_name);
			}

			if(read_type.equals("Droid")) {
				actor[i] = new Droid(read_name);
				
			}
				
		}
		reader.close();
	
	//Task D: Print all Actor objects in table (After read and "write")
		System.out.println("\n============================================================");
		System.out.printf("%-20s%-10s%-20s","Actor", "Type", "Motto to live by:");
		System.out.println("\n============================================================");

		for(int i = 0; i < actor.length; i++) {
			System.out.printf("\n%-20s%-10s%-20s", actor[i].getName(), actor[i].getType(), actor[i].motto());
		}
		
		Movie CS1450_movie = new Movie();
		CS1450_movie.selectCast(actor);
		CS1450_movie.printMovieDetails();
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

//Villain subclass
class Villain extends Actor {
	
	public Villain(String name) {
		super(name, "Villain");
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
	for(int j = 0; j < 2; j++) {
		int index_counter = 0;
		for(int i = 0; i < actors.length; i++ ) {

			if(actors[i].getType().equals("Hero")) { 
				this.number_of_heros++;

				if(j == 1 && i < this.actors_in_movie.length) {
					this.actors_in_movie[index_counter] = actors[i]; 
					index_counter++;
				}
			}
			else if(actors[i].getType().equals("Villain")) {
				this.number_of_villains++;
				
				if(j == 1 && i < this.actors_in_movie.length) {
					this.actors_in_movie[index_counter] = actors[i];
					index_counter++;
				}
			}
		}
		if(j == 0) {
		this.actors_in_movie = new Actor[this.number_of_heros + this.number_of_villains];
		}
	}
	}

	public void printMovieDetails() {
		System.out.println("\n\n=================================\n"
							+ "CS1450 Heros V.S. Villains Movie"
						 + "\n=================================");
			System.out.println("\nNumber of Heros " + this.number_of_heros
							 + "\nNumber of Villains " + this.number_of_villains);

		for(int i = 0; i < this.actors_in_movie.length; i++) {
			System.out.printf("\n%7s\t--%20s", this.actors_in_movie[i].getType(), this.actors_in_movie[i].getName());
		}
	}
}










