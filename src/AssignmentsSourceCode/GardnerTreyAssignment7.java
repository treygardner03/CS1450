
/*Name: Trey Gardner
Class: CS1450 (M/W)
Due: March 2nd, 2025
Assignment: #7
Description:
*/

//Homework package, remove before turning in
package AssignmentsSourceCode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;


public class GardnerTreyAssignment7 {

    public static void main(String[] args) throws IOException {

        //Step 1: Create a cargo terminal object
        //Finding parameters for cargo terminal:
        File planes = new File("FedExPlanes.txt");
        File trucks = new File("FedExTrucks.txt");
        Scanner tarmac_reader = new Scanner(planes);
        Scanner dock_reader = new Scanner(trucks);
        int number_of_docks = dock_reader.nextInt();
        int number_of_stands = tarmac_reader.nextInt();

        Cargo_Terminal cargo_terminal = new Cargo_Terminal(number_of_docks, number_of_stands);

        //Step 2: Load cargo terminal with all semi-trucks and cargo planes in the files
        System.out.println("\nLoading semi-trucks and planes into cargo terminal...\n");

        //creating and adding semi trucks from file

        while (dock_reader.hasNext()) {
            int dock_number = dock_reader.nextInt();
            int truck_number = dock_reader.nextInt();
            String destination = dock_reader.nextLine();
            cargo_terminal.add_semi_truck(dock_number, new Semi_Truck(truck_number, destination));
        }
        dock_reader.close();

        //creating and adding planes from file
        while (tarmac_reader.hasNext()) {
            int stand_number = tarmac_reader.nextInt();
            int flight_number = tarmac_reader.nextInt();
            int capacity = tarmac_reader.nextInt();
            String cargo_type = tarmac_reader.next();
            String destination = tarmac_reader.nextLine();
            cargo_terminal.add_cargo_plane(stand_number, new Cargo_Plane(flight_number, capacity, cargo_type, destination));
        }
        tarmac_reader.close();


        //Step 3: Display the cargo terminal
        cargo_terminal.display_cargo_terminal();
        //Step 4: Print a status report for the cargo terminal
        print_terminal_status(cargo_terminal);
    }


    public static void print_terminal_status (Cargo_Terminal cargo_terminal) {
        System.out.println("\nCargo Terminal status report:\n");
        ArrayList<Semi_Truck> semi_truck_list = new ArrayList<>();
        ArrayList<Cargo_Plane> cargo_plane_list = new ArrayList<>();
        for (int i = 0; i < cargo_terminal.get_number_of_docks(); i++) {
            if (cargo_terminal.get_semi_truck(i) != null) {
                semi_truck_list.add(cargo_terminal.get_semi_truck(i));
            }
        }

        for (int i = 0; i < cargo_terminal.get_number_of_stands(); i++) {
            if (cargo_terminal.get_cargo_plane(i) != null) {
                cargo_plane_list.add(cargo_terminal.get_cargo_plane(i));
            }
        }

        Collections.sort(semi_truck_list);
        Collections.sort(cargo_plane_list);
        System.out.println("\n----------------------------\n\tLoading Dock Status:\n\t(By Destination City)\n----------------------------\n");
        System.out.printf("%-8s%-12s\n", "Truck#", "Destination City");
        for (Semi_Truck semiTruck : semi_truck_list) {
            System.out.println(semiTruck.toString());
        }

        System.out.println("\n----------------------\n\tTarmac Status:\n\t(By Capacity)\n--------------------\n");
        System.out.printf("%-8s%-18s%-16s%-14s\n","Flight#", "Destination City", "Cargo Type", "Capacity (lbs)");
        for (Cargo_Plane cargoPlane : cargo_plane_list) {
            System.out.println(cargoPlane.toString());
        }
    }

}

//All Classes:

class Cargo_Terminal {

    //private data fields: 
    private int number_of_docks;
    private int number_of_stands;
    private Semi_Truck[] loading_dock;
    private Cargo_Plane[] tarmac;

    //constructor:
    public Cargo_Terminal(int number_of_docks, int number_of_stands) {
        this.number_of_docks = number_of_docks;
        this.number_of_stands = number_of_stands;

        loading_dock = new Semi_Truck[number_of_docks];
        tarmac = new Cargo_Plane[number_of_stands];
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
        this.loading_dock[dock] = truck;
    }

    public void add_cargo_plane(int stand, Cargo_Plane plane) {
        this.tarmac[stand] = plane;
    }

    public Semi_Truck get_semi_truck(int dock) {
        return this.loading_dock[dock];
    }

    public Cargo_Plane get_cargo_plane(int stand) {
        return this.tarmac[stand];
    }

    public void display_cargo_terminal() {
        System.out.println("\nCurrent Cargo Terminal :\n------------------------------------"
                + "\nCargo Terminal Stands: ");
        for (int i = 0; i < this.loading_dock.length; i++) {
            System.out.println("\nDock #" + i + ": ");
            if (this.loading_dock[i] != null) {
                System.out.println(this.loading_dock[i].get_truck_number());
            } else {
                System.out.println("-----");
            }
        }
        System.out.println("\nCurrent Cargo Planes: ");

        for (int j = 0; j < this.tarmac.length; j++) {
            System.out.println("\nStand #" + j + ": ");
            if (this.tarmac[j] != null) {
                System.out.println(this.tarmac[j].get_flight_number());
            } else {
                System.out.println("-----");
            }
        }
    }
}

class Cargo_Plane implements Comparable<Cargo_Plane> {

        //private data fields:
        private int flight_number;
        private double capacity;
        private String cargo_type;
        private String destination_city;

        //constructor:
        public Cargo_Plane(int flight_number, double capacity, String cargo_type, String destination_city) {
            this.flight_number = flight_number;
            this.capacity = capacity;
            this.cargo_type = cargo_type;
            this.destination_city = destination_city;
        }

        //getters:
        public int get_flight_number() {
            return this.flight_number;
        }

        //public methods:
        @Override
        public String toString() {
            return String.format("%-8d%-18s%-16s%-14.2f", flight_number, destination_city, cargo_type, capacity);
        }

        @Override
        public int compareTo(Cargo_Plane other_cargo_plane) {
            //Comparing based on destination city (alphabetical order)
            if (this.capacity > other_cargo_plane.capacity) {
                return 1;
            }
            if (this.capacity < other_cargo_plane.capacity) {
                return -1;
            }
            return 0;
        }
    }

class Semi_Truck implements Comparable<Semi_Truck> {

    //private data fields:
    private int truck_number;
    private String destination_city;

    //constructor:
    public Semi_Truck(int truck_number, String destination_city) {
        this.truck_number = truck_number;
        this.destination_city = destination_city;

    }

    //getters:
    public int get_truck_number() {
        return this.truck_number;
    }

    public String get_destination_city() {
        return this.destination_city;
    }

    @Override
    public String toString() {
        return String.format("%-8d%-12s", this.truck_number, this.destination_city);

    }

    @Override
    public int compareTo(Semi_Truck other_semi_truck) {
        //Comparing based on destination city (alphabetical order)
        int compare_truck_number = this.destination_city.compareTo(other_semi_truck.get_destination_city());

        if (compare_truck_number > 0) {
            return 1;
        }

        if (compare_truck_number < 0) {
            return -1;
        }
        return 0;
    }
}

