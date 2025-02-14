
/*Name: Trey Gardner
 * Class: CS1450(M/W)
 * Due: Feb 19th, 2025
 * Assignment #3
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
		int read_skill_swimming;
		int read_skill_running;
		int read_skill_climbing;
		
		//loop through .txt file and create objects
		for(int i = 0; i < number_of_animals; i++) {
			read_name = reader.next();
			read_species = reader.next();
			read_skill_swimming = reader.nextInt();
			read_skill_running = reader.nextInt();
			read_skill_climbing = reader.nextInt();
			
			if(read_species.equals("alligator")) {
				all_animals[i] = new Alligator(read_name, read_skill_swimming, read_skill_running);
			}

			if(read_species.equals("bear")) {
				all_animals[i] = new Bear(read_name, read_skill_swimming, read_skill_running, read_skill_climbing);
			}

			if(read_species.equals("giraffe")) {
				all_animals[i] = new Giraffe(read_name, read_skill_running);
			}

			if(read_species.equals("monkey")) {
				all_animals[i] = new Monkey(read_name, read_skill_running, read_skill_climbing);
			}

			if(read_species.equals("sloth")) {
				all_animals[i] = new Sloth(read_name, read_skill_swimming, read_skill_climbing);
			}
		}
		reader.close();
		
		//1.) Display all animals in array (neatly)
		display_animals(all_animals);
		
		//2.) Create array list that only holds animals that can climb
		ArrayList<Animal> climbers = find_climbers(all_animals);
		display_climbers(climbers);

		//3.) Find and Display the "Most Skilled" animal based on all 3 available skills
		int most_skilled_index = find_most_skilled(all_animals);
		
		System.out.println("\n\nThe Most Skilled Animal Provided Is: \n " + all_animals[most_skilled_index].get_name());
		
	}
	
	//display climbers (array lists)
	private static void display_climbers(ArrayList<Animal> climbers) {
		
		System.out.println("\n\nAll Climbers!\n==============\n");
		for(int i = 0; i < climbers.size(); i++) {
			System.out.println("\n" + climbers.get(i).get_name() + " the " + climbers.get(i).get_species() + " says " 
							 + climbers.get(i).make_noise() + " " + climbers.get(i).make_noise() + " " + climbers.get(i).make_noise() + "!!!");
		
			if(climbers.get(i) instanceof Swimmer) {
				System.out.println("Swim Speed: " + ((Swimmer) climbers.get(i)).swim());
			}

			if(climbers.get(i) instanceof Runner) {
				System.out.println("Run Speed: " + ((Runner)climbers.get(i)).run());
			}

			if(climbers.get(i) instanceof Climber) {
				System.out.println("Climb Speed: " + ((Climber)climbers.get(i)).climb());
			}
		}
	}

	
	//display animals (arrays)
	public static void display_animals(Animal[] animals) {
		
		System.out.println("All Animals: \n==============\n");
		for(int i = 0; i < animals.length; i++) {
			System.out.println(animals[i].get_name() + " the " + animals[i].get_species() + " says " 
							 + animals[i].make_noise() + " " + animals[i].make_noise() + " " + animals[i].make_noise() + "!!!");
		
			if(animals[i] instanceof Swimmer) {
				System.out.println("Swim Speed: " + ((Swimmer)animals[i]).swim());
			}

			if(animals[i] instanceof Runner) {
				System.out.println("Run Speed: " + ((Runner)animals[i]).run());
			}

			if(animals[i] instanceof Climber) {
				System.out.println("Climb Speed: " + ((Climber)animals[i]).climb());
			}

			
			
		}
	}
	
	public static ArrayList<Animal> find_climbers(Animal[] animals) {
		int counter = 0;
		ArrayList<Animal> climbers = new ArrayList();
		
		for(int i = 0; i < animals.length; i++) {
			if(animals[i] instanceof Climber) {
				counter++;
				climbers.add(animals[i]);
			}
		}
		return climbers;
	}

	//Finish Method!!!
	public static int find_most_skilled(Animal[] animals) {
		int most_skilled_index = 0;
		int current_skill = 0;
		int tested_skill = 0;
		int swim_skill = 0;
		int run_skill = 0; 
		int climb_skill = 0;
		for(int i = 0; i < animals.length; i++) {


			if(animals[i] instanceof Swimmer) {
				swim_skill = ((Swimmer)animals[i]).swim();
			}

			if(animals[i] instanceof Runner) {
				run_skill = ((Runner)animals[i]).run();
			}

			if(animals[i] instanceof Climber) {
				climb_skill = ((Climber)animals[i]).climb();
			}

			if(i == 0) {
				current_skill = swim_skill + run_skill + climb_skill;
				swim_skill = 0;
				run_skill = 0;
				climb_skill = 0;
			}
			
			if(i > 0) {
				if(tested_skill > current_skill) {
					tested_skill = current_skill;
					most_skilled_index = i;
				}
			}
		}
	return most_skilled_index;
	}
}

interface Swimmer {
	public abstract int swim();
}

interface Runner {
	public abstract int run();
}

interface Climber {
	public abstract int climb();
}

abstract class Animal {
	
	private String name;
	private String species;
	
	public void set_name(String name) {
		this.name = name;
	}
	
	public void set_species(String species) {
		this.species = species;
	}
	
	public String get_name() {
		return this.name;
	}
	
	public String get_species() {
		return this.species;
	}
	
	public abstract String make_noise();

}

class Alligator extends Animal implements Swimmer, Runner{

	private int swim_speed;
	private int run_speed;
	
	public Alligator(String name, int swim_speed, int run_speed) {
		set_name(name);
		set_species("Alligator");
		this.swim_speed = swim_speed;
		this.run_speed = run_speed;
	}
	
	@Override
	public String make_noise() {
		return "Crunch";
	}
	
	@Override
	public int swim() {
		return this.swim_speed;
	}
	
	@Override
	public int run() {
		return this.run_speed;
	}
}

class Bear extends Animal implements Swimmer, Runner, Climber {

	private int swim_speed;
	private int run_speed;
	private int climb_speed;
	
	public Bear(String name, int swim_speed, int run_speed, int climb_speed) {
		set_name(name);
		set_species("Bear");
		this.swim_speed = swim_speed;
		this.run_speed = run_speed;
		this.climb_speed = climb_speed;
	}

	public String make_noise() {
		return "Growl";
	}
	
	@Override
	public int swim() {
		return this.swim_speed;
	}
	
	@Override
	public int run() {
		return this.run_speed;
}
	
	@Override
	public int climb() {
		return this.climb_speed;
	}
}

class Giraffe extends Animal implements Runner {
	
	private int run_speed;
	
	public Giraffe(String name, int run_speed) {
		set_name(name);
		set_species("Giraffe");
		this.run_speed = run_speed;
	}

	public String make_noise() {
		return "Bleat";
	}
	
	@Override
	public int run() {
		return this.run_speed;
	}
}
	
class Monkey extends Animal implements Runner, Climber {
	
	private int run_speed;
	private int climb_speed;
	
	public Monkey(String name, int run_speed, int climb_speed) {
		set_name(name);
		set_species("Monkey");
		this.run_speed = run_speed;
		this.climb_speed = climb_speed;
	}
	
	public String make_noise() {
		return "Screech";
	}
	
	@Override
	public int run() {
		return this.run_speed;
}
	
	@Override
	public int climb() {
		return this.climb_speed;
	}
}

class Sloth extends Animal implements Swimmer, Climber {
	
	private int swim_speed;
	private int climb_speed;
	
	public Sloth(String name, int swim_speed, int climb_speed) {
		set_name(name);
		set_species("Sloth");
		this.swim_speed = swim_speed;
		this.climb_speed = climb_speed;
	}

	public String make_noise() {
		return "Squeak";
	}

	@Override
	public int swim() {
		return this.swim_speed;
	}
	@Override
	public int climb() {
		return this.climb_speed;
	}
}