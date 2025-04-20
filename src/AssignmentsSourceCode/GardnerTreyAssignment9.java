/*Name: Trey Gardner
Class: CS1450 (M/W)
Assignment: 9
Due: 04-17-2025
Description: This program will; Simulate a train journey (represented by a LinkedList) that will be assembled in New York
and "travel" to West Palm Beach, Florida with 4 stoops along the way. At each stop the "train cars" who have reached their
destination will be removed and any new "train cars" waiting will be added.
 */

//local package remove before turning in
package AssignmentsSourceCode;

//Libraries
import java.util.LinkedList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

//main class
public class GardnerTreyAssignment9 {
    //main
    public static void main(String[] args) throws FileNotFoundException {
    //1. Assemble a train into single and doubly LinkedLists
        //opening file for reading
        File railcars_file = new File("Railcars.txt");
        Scanner read_railcars = new Scanner(railcars_file);

        //declaring LinkedLists
        Train train = new Train();
        Train_History train_history = new Train_History();

        //reading railcar info
        while(read_railcars.hasNextLine()) {

            //grab info
            int id = read_railcars.nextInt();
            String freight = read_railcars.next();
            String destination = read_railcars.nextLine().trim();

            //adding to train
            train.add_by_destination(new Rail_Car(id, freight, destination));

            //adding to train history
            train_history.add(new Rail_Car(id, freight, destination));

        }//while

    //2. Display train (single) after all rail cars have been added
        train.display_train();

    //3. At each destination stop
        for(int i = 0; i < 4; i++) {
            String destination = "New York";
            if(i == 0) {
                destination = "Washington DC";
            }//Stop 1
            if(i == 1) {
                destination = "Charleston";
            }//Stop 2
            if(i == 2) {
                destination = "Orlando";
            }//Stop 3
            if(i == 3) {
                destination = "West Palm Beach";
                train.remove_by_freight("parrots");
            }//Stop 4

            //Simulating Train Stop...
            arrival_notice(destination);
            int cars_removed = train.remove_by_destination(destination);
            departure_notice(destination, cars_removed);
            train.display_train();

        }//simulation loop

    }//main

    //arriving at destination
    public static void arrival_notice(String destination) {
        System.out.println("Welcome to " + destination);
    }//arrival

    //departing from destination
    public static void departure_notice(String destination, int cars_removed) {
        System.out.println("Now leaving " + destination + ".\nWe have removed " + cars_removed + " cars from the train.");
    }//departure
}//Assignment Class

//Classes:

//Rail Car
class Rail_Car implements Comparable<Rail_Car>{
//private data fields
    private int id_number;//car number
    private String freight;//cargo
    private String destination;//travel destination

//Public Methods
    //constructor
    public Rail_Car(int number, String freight, String destination) {
        this.id_number = number;
        this.freight = freight;
        this.destination = destination;
    }//constructor

    //Getters
    public String get_freight(){
        return this.freight;
    }
    public String get_destination(){
        return this.destination;
    }

    //Setters: NONE

    //toString
    public void to_string(){
       //display id number, freight, and destination
        System.out.println("Rail Car #" + this.id_number + " is carrying " + this.freight + " and is headed to " + this.destination);

    }//to_string

    //CompareTo
    public int compareTo(Rail_Car other_car) {
        //compare based on destination
        //Priority: Washington DC, Charleston, Orlando, West Palm Beach

        //the destinations have the same priority
        if (this.destination.equals(other_car.destination)) {
            return 0;
        }

        //current car has priority
        if (this.destination.equals("West Palm Beach")) {
            return 1;
        }

        //current car has priority
        if (this.destination.equals("Orlando") && !other_car.get_destination().equals("West Palm Beach")) {
        return 1;
        }

        if(this.destination.equals("Charleston") && other_car.get_destination().equals("Washington DC")) {
            return 1;
        }
        //other has priority
        return -1;
    }//compareTo

}//Class Rail_Car

//Train
class Train {
//private data fields
    private Node head;

//Public Methods
    //constructor: NONE

    //getters\setters: NONE

    //add (by destination)
    public void add_by_destination(Rail_Car car){
        Node new_node = new Node(car);

        if(this.head == null) {
            this.head = new_node;
        }
        else {
            //iterating through LinkedList
            Node previous = this.head;
            Node current = this.head;

            while(current != null) {
                int comparative = current.car.compareTo(new_node.car);

                //if new_node has priority over current node
                if(comparative > 0) {
                    previous.next = new_node;
                    new_node.next = current;
                    break;
                }//if
                else {
                    previous = current;
                    current = previous.next;
                }//else

            }//while

            if(current == null && new_node.next == null) {
                previous.next = new_node;
                new_node.next = null;
            }//if

        }//else
    }//add by destination

    //remove (by destination)
    public int remove_by_destination(String destination){

        Node previous = this.head;
        Node current = this.head;
        int cars_removed = 0;

        while(current != null) {
            //if LinkedList is empty
            //if removing first element
            if(current == head && current.car.get_destination().equals(destination)) {
                   this.head = previous.next;
                   current = previous.next;
                   cars_removed++;
            }//if
            //removing from middle of list
            else if (current.car.get_destination().equals(destination)) {
                previous.next = current.next;
                current = previous.next;
                cars_removed++;
            }//else-if
            else {
                previous = current;
                current = previous.next;
            }//else
        }//while

        return cars_removed;

    }//remove by destination


    //remove (by freight)
    public int remove_by_freight(String freight) {

        Node previous = this.head;
        Node current = this.head;
        int cars_removed = 0;
        while(current != null) {
            //if LinkedList is empty
            //if removing first element
            if(current == head && current.car.get_destination().equals(freight)) {
                this.head = previous.next;
                current = previous.next;
                cars_removed++;
            }//if
            //removing from middle of list
            else if (current.car.get_destination().equals(freight)) {
                previous.next = current.next;
                current = previous.next;
                cars_removed++;
            }//else-if
            else {
                previous = current;
                current = previous.next;
            }//else
        }//while

        return cars_removed;

    }//remove by freight

    //display all railcars in train
    public void display_train() {
        System.out.println("\nCurrent train cars: \n");
        Node current = this.head;

        while(current != null) {
            current.car.to_string();
            current = current.next;
        }
    }//display train

//Private Inner Class
    private class Node {
    //private data fields
        private Rail_Car car;
        private Node next;

    //Public Methods
        //constructor
        public Node(Rail_Car car) {
            this.car = car;
            this.next = null;
        }//constructor
    }//Node

}//Class Train

//Train History
class Train_History {
//private data fields
    private Node head;
    private Node tail;

//Public Methods
    //constructor: NONE

    //add to end
    public void add(Rail_Car car){
        Node new_node = new Node(car);

        //if LinkedList is empty
        if(tail == null) {
            this.head = new_node;
            this.tail = new_node;
        }//if
        //if LinkedList is NOT empty
        else {
            tail.next = new_node;
            tail = new_node;
        }

    }//add

    //displays in reverse order
    public void display_history()  {
        System.out.println("\nFull Train History: \n");
        Node current = this.tail;

        while(current != null) {
            current.car.to_string();
            current = current.previous;
        }
    }//display

//Private Inner Class
    private class Node {
    //Private data fields
        private Rail_Car car;
        private Node next;
        private Node previous;

    //Public Methods
        //constructor
        public Node(Rail_Car car) {
            this.car = car;
            this.next = null;
            this.previous = null;
        }//constructor
    }//Node

}//Class Train History