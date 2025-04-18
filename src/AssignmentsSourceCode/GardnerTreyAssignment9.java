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
        File railcars_file = new File("Railcars.txt");
        Scanner read_railcars = new Scanner(railcars_file);
        //A. Singly LinkedList (actual train?)

        //B. Doubly LinkedList (train history)

    //2. Display train (single) after all rail cars have been added

    //3. At each destination stop
        //A. Remove rail cars for that destination from the train (single)

        //B. Display the destination, the number of rail cars removed, and the updated train after removal

        //C. If in Orlando (remove rail cars carrying ("crazy parrots")

    //4. Display all rail cars in the history (double) backwards

    }//main
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

    }//to_string

    //CompareTo
    public int compareTo(Rail_Car other_car) {
       //compare based on destination
       //Priority: Washington DC, Charleston, Orlando, West Palm Beach

    }//compareTo

}//Class Rail_Car

//Train
class Train {
//private data fields
    private Rail_Car head;

//Public Methods
    //constructor: NONE

    //getters\setters: NONE

    //add (by destination)
    public void add_by_destination(Rail_Car car){

    }//add by destination

    //remove (by destination)
    public int remove_by_destination(String destination){

    }//remove by destination


    //remove (by freight)
    public int remove_by_freight(String freight) {

    }//remove by freight

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
    private Rail_Car head;
    private Rail_Car tail;

//Public Methods
    //constructor: NONE

    //add to end
    public void add(Rail_Car car){

    }//add

    //displays in reverse order
    public void display()  {

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