
/*Name: Trey Gardner
Class: CS1450 (M/W)
Due: March 2nd, 2025
Assignment: #7
Description:
*/

//Homework package, remove before turning in
package AssignmentsSourceCode;

import java.io.IOException;
import java.util.*;
import java.io.File;


public class GardnerTreyAssignment7 {

    public static void main(String[] args) throws IOException {

        //Step 1: Create a cargo terminal object
        //Finding parameters for cargo terminal:
        File planes = new File("FedExPlanes7.txt");
        File trucks = new File("FedExTrucks7.txt");
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


    //Assignment #7 Start:
        //creating traffic control
        Air_Traffic_Controller air_traffic_controller = new Air_Traffic_Controller();

        //creating taxiways
        Taxiways taxiways = new Taxiways();

        //creating runway
        Runway runway = new Runway();

        //moving planes from tarmac to taxiways
        System.out.println("\nControl Tower: Moving planes from tarmac to taxiways..." +
                           "\n-------------------------------------------------------\n");
        air_traffic_controller.move_planes_to_taxiway(cargo_terminal, taxiways);

        //Proving tarmac is empty
        cargo_terminal.display_cargo_terminal();

        //moving planes from taxiway to runway
        System.out.println("\nControl Tower: Moving planes from tarmac to runway..." +
                           "\n-----------------------------------------------------\n");
        air_traffic_controller.move_planes_to_runway(taxiways, runway);

        //clearing planes for takeoff
        System.out.println("\nControl Tower: Clearing planes for takeoff!" +
                           "\n-------------------------------------------\n");
        air_traffic_controller.clear_for_takeoff(runway);

    }

//print_terminal_status:
  /*  public static void print_terminal_status (Cargo_Terminal cargo_terminal) {
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
    }*/

}

//All Classes:

//The entire tarmac and loading dock
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
    //adds truck to specified dock
    public void add_semi_truck(int dock, Semi_Truck truck) {
        this.loading_dock[dock] = truck;
    }

    //adds plane to specified stand
    public void add_cargo_plane(int stand, Cargo_Plane plane) {
        this.tarmac[stand] = plane;
    }

    //returns truck at specified dock
    public Semi_Truck get_semi_truck(int dock) {
        return this.loading_dock[dock];
    }

    //returns plane at specified stand
    public Cargo_Plane get_cargo_plane(int stand) {
        return this.tarmac[stand];
    }

    //displays cargo terminal
    public void display_cargo_terminal() {
        System.out.println("\n------------------------------\nCurrent Cargo Terminal :\n------------------------------------"
                + "\n\nCargo Loading Docks: \n-------------------------");
        for (int i = 0; i < this.loading_dock.length; i++) {
            System.out.println("\nDock #" + i + ": ");
            if (this.loading_dock[i] != null) {
                System.out.println(this.loading_dock[i].get_truck_number());
            } else {
                System.out.println("-----");
            }
        }
        System.out.println("\nCargo Tarmac Stands: \n-----------------------------\n");

        for (int j = 0; j < this.tarmac.length; j++) {
            System.out.println("\nStand #" + j + ": ");
            if (this.tarmac[j] != null) {
                System.out.println(this.tarmac[j].get_flight_number());
            } else {
                System.out.println("-----");
            }
        }
    }

    //remove plane from current stand
    public Cargo_Plane remove_plane(int stand) {
        if (this.tarmac[stand] != null) {
            Cargo_Plane plane = this.tarmac[stand];
            this.tarmac[stand] = null;
            return plane;
        }
        return null;
    }

}

//Planes carrying cargo
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

        //checking priority
        public boolean is_priority() {
            return this.cargo_type.equals("Military") || this.cargo_type.equals("Perishables") || this.cargo_type.equals("Medical");

        }

        //checking basic
        public boolean is_basic() {
            return !this.cargo_type.equals("Military") && !this.cargo_type.equals("Perishables") && !this.cargo_type.equals("Medical");

        }

        @Override
        public String toString() {
            return String.format("%-5d%-15s%-15s", flight_number, destination_city, cargo_type);
        }

        @Override
        public int compareTo(Cargo_Plane other_plane) {

            //if not changed, plane is not priority
            int current_cargo = 0;
            int other_cargo = 0;

            //assigning current plane
            if(this.cargo_type.equals("Military")) {
                current_cargo = 3;
            }
            if(this.cargo_type.equals("Perishables")) {
                current_cargo = 2;
            }
            if(this.cargo_type.equals("Medical")) {
                current_cargo = 1;
            }

            //assigning other plane
            if(other_plane.cargo_type.equals("Military")) {
                other_cargo = 3;
            }
            if(other_plane.cargo_type.equals("Perishables")) {
                other_cargo = 2;
            }
            if(other_plane.cargo_type.equals("Medical")) {
                other_cargo = 1;
            }

            //comparing
            return Integer.compare(other_cargo, current_cargo);
        }

    }

//trucks carrying cargo
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

//The midway point between tarmac and runway
class Taxiways {
    //private data fields
   private PriorityQueue<Cargo_Plane> priority_taxiway;
   private Queue<Cargo_Plane> basic_taxiway;

   //constructor
    public Taxiways() {
        this.priority_taxiway = new PriorityQueue<Cargo_Plane>();
        this.basic_taxiway = new LinkedList<Cargo_Plane>();
    }

    //public methods

    //IsEmpty
    public boolean is_priority_taxiway_empty() {
        return this.priority_taxiway.isEmpty();
    }

    //add - priority
    public void add_priority_taxiway(Cargo_Plane plane) {
        this.priority_taxiway.offer(plane);
    }

    //remove - priority
    public Cargo_Plane remove_priority_taxiway() {
        return this.priority_taxiway.poll();
    }

    //IsEmpty - basic
    public boolean is_basic_taxiway_empty() {
        return this.basic_taxiway.isEmpty();
    }

    //add - basic
    public void add_basic_taxiway(Cargo_Plane plane) {
        this.basic_taxiway.offer(plane);
    }

    //remove - basic
    public Cargo_Plane remove_basic_taxiway() {
        return this.basic_taxiway.poll();
    }
}

//final leave space for cargo planes
class Runway {
    //private data fields
    private Queue<Cargo_Plane> runway;

    //public constructor
    public Runway() {
       this.runway = new LinkedList<Cargo_Plane>();
    }

    //public methods

    //IsEmpty
    public boolean is_runway_empty() {
        return this.runway.isEmpty();
    }

    //add
    public void add_runway(Cargo_Plane plane) {
        this.runway.offer(plane);
    }

    //remove
    public Cargo_Plane remove_runway() {
        return this.runway.poll();
    }

}

//organizes cargo plane transfers
class Air_Traffic_Controller {
    //private data fields - none

    //public constructor - none

    //public methods

    //moving planes from tarmac to appropriate taxiway
    public void move_planes_to_taxiway(Cargo_Terminal cargo_terminal, Taxiways taxiways) {
        //rule #1: planes must be moved from tarmac in order of stand location
        //rule #2: planes must be moved to correct taxiway based on cargo
        for (int i = 0; i < cargo_terminal.get_number_of_stands(); i++) {

            //checking stand status
            if(cargo_terminal.get_cargo_plane(i) != null) {

                //checking priority status
                if (cargo_terminal.get_cargo_plane(i).is_priority()) {
                    System.out.printf("Move to taxiway Priority: %s\n", cargo_terminal.get_cargo_plane(i).toString());
                    taxiways.add_priority_taxiway(cargo_terminal.remove_plane(i));
                }

                //checking basic status
                else if (cargo_terminal.get_cargo_plane(i).is_basic()) {
                    System.out.printf("Move to taxiway Basic:    %s\n", cargo_terminal.get_cargo_plane(i).toString());
                    taxiways.add_basic_taxiway(cargo_terminal.remove_plane(i));
                }
            }//null check
        }//for loop
    }//move planes to taxiway

    //moving planes from taxiways to runway
    public void move_planes_to_runway(Taxiways taxiway, Runway runway) {
        //Rule #1: Move planes from priority first then from basic
        //display "Moved to runway" message for each plane
        while(!taxiway.is_priority_taxiway_empty()) {
            Cargo_Plane plane = taxiway.remove_priority_taxiway();
            System.out.printf("Move to runway: %s\n", plane.toString());
            runway.add_runway(plane);
        }
        while(!taxiway.is_basic_taxiway_empty()) {
            Cargo_Plane plane = taxiway.remove_basic_taxiway();
            System.out.printf("Move to runway: %s\n", plane.toString());
            runway.add_runway(plane);
        }

    }

    //removing planes from runway
    public void clear_for_takeoff(Runway runway) {
        //display "Cleared for takeoff" message for each plane
        while(!runway.is_runway_empty()) {
            Cargo_Plane plane = runway.remove_runway();
            System.out.printf("Clear for takeoff: %s\n", plane.toString());
        }
    }


}