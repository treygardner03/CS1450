
/*Name: Trey Gardner
Class: CS1450 (M/W)
Due: Feb 26th, 2025
Assignment #4
DESC: This program will; read truck and plane information from a file to generate objects
that represent their locations and appear in their respective tarmac or terminal
*/

//Homework package, remove before turning in
package AssignmentsSourceCode;

import java.io.IOException;
import java.util.Scanner;
import java.io.File;


public class GardnerTreyAssignment4 {

    public static void main(String[] args) throws IOException {

    //Step 1: Create a cargo terminal object
    	//Finding parameters for cargo terminal:
    	File planes = new File("FedExPlanes.txt");
    	File trucks = new File("FedExTrucks.txt");
    	Scanner reader = new Scanner(planes);
    	

    //Step 2: Load cargo terminal with all semi-trucks and cargo planes in the files
    
    //Step 3: Display the cargo terminal

    //Step 4: Print a status report for the cargo terminal

    }

    public static void print_terminal_status(Cargo_Terminal terminal) {

    }
}


//All Classes:

class Cargo_Terminal {

    //private data fields: 
    private int number_of_docks;
    private int number_of_stands;
    private Semi_Truck[] loading_dock = new Semi_Truck[number_of_docks];
    private Cargo_Plane[] tarmac = new Cargo_Plane[number_of_stands];

    //constructor:
    public Cargo_Terminal(int number_of_docks, int number_of_stands) {

    }

    //getters:
    public int get_number_of_docks() {
        return this.number_of_docks;
    }

    public int get_number_of_stands() {
        return this.number_of_stands;
    }

    //public methods:
    public void add_semi_truck(int dock, Semi_Truck truck) {

    }

    public void add_cargo_plane(int stand, Cargo_Plane plane) {

    }

    public Semi_Truck get_semi_truck(int dock) {
       return this.loading_dock[dock]; 
    }

    public Cargo_Plane get_cargo_plane(int stand) {
    	return this.tarmac[stand];
    } 

    public void display_cargo_terminal() {

    }
}

class Cargo_Plane implements Comparable<Cargo_Plane>{

    //private data fields: 
    private int flight_number;
    private double capacity;
    private String cargo_type;
    private String destination_city; 

    //constructor:
    public Cargo_Plane(int flight_number, double capacity, String cargo_type, String desination_city) {

    }

    //getters:
    public int get_flight_number(){
        return this.flight_number;
    }

    //public methods:
    @Override
    public String toString() {
        return String.format("%d%s%s%f", flight_number, destination_city, cargo_type, capacity);
    }

    @Override
    public int compareTo(Cargo_Plane other_cargo_plane) {

    }
}

class Semi_Truck implements Comparable<Semi_Truck> {

    //private data fields:
    private int truck_number;
    private String desination_city;

    //constructor: 
    public Semi_Truck(int truck_number, String destination_city) {

    }

    //getters:
    public int get_truck_number() {
        return this.truck_number;
    }

    public String get_destination_city() {
        return this.desination_city;
    }

    @Override
    public int compareTo(Semi_Truck other_semi_truck) {

    }
}