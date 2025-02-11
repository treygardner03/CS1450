
/*Name: Trey Gardner
 * Class: CS1450(M/W)
 * Due: Jan 29, 2025
 * Assignment #1
 * DESC: This program will; Create a polymorphic array that holds animal objects created based on 
 * information read from a .txt file, Then display these animals and organize them based on specific criteria 
 */

//Homework package, remove before turning in
package AssignmentsSourceCode;

//java imports
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GardnerTreyAssignment3 {
	public static void main(String[] args) throws IOException {
		
	//Task A: Create polymorphic arrays
		File animals = new File("Animals.txt");
		Scanner reader = new Scanner(animals);

	//Task B: Read Animals.txt and create objects inside array
		int number_of_animals = reader.nextInt();
		Animal[] all_animals = new Animal[number_of_animals];

	//Task C: After animals are in array, Perform 3 tasks
		String read_name;
		String read_species;
		String read_noise; 
		int read_skill_swimming;
		int read_skill_running;
		int read_skill_climbing;
		
		//loop through .txt file and create objects
		for(int i = 0; i <= number_of_animals; i++) {
			read_name = reader.next();
			read_species = reader.next();
			read_skill_swimming = reader.nextInt();
			read_skill_running = reader.nextInt();
			read_skill_climbing = reader.nextInt();
			
			if(read_species.equals("Alligator")) {
				all_animals[i] = new Alligator(read_name, read_noise, read_skill_swimming, read_skill_running, read_skill_climbing);
			}

			if(read_species.equals("Bear")) {
				all_animals[i] = new Bear(read_name, read_noise, read_skill_swimming, read_skill_running, read_skill_climbing);
			}

			if(read_species.equals("Giraffe")) {
				all_animals[i] = new Giraffe(read_name, read_noise, read_skill_swimming, read_skill_running, read_skill_climbing);
			}

			if(read_species.equals("Monkey")) {
				all_animals[i] = new Monkey(read_name, read_noise, read_skill_swimming, read_skill_running, read_skill_climbing);
			}

			if(read_species.equals("Sloth")) {
				all_animals[i] = new Sloth(read_name, read_noise, read_skill_swimming, read_skill_running, read_skill_climbing);
			}
		}
		
		//1.) Display all animals in array (neatly)
		display_animals(all_animals);
		
		//2.) Create array list that only holds animals that can climb
		ArrayList<Animal> climbers = new find_climbers();
		for(int i = 0; i < climbers.size(); i++) {
			climbers.get(i).toString;
		}

		//3.) Find and Display the "Most Skilled" animal based on all 3 available skills
		int most_skilled_index = find_most_skilled(all_animals);
		all_animals[most_skilled_index].toString;
		
		
	}

}

class  Animal {
	
}
