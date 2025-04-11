// CS 1450 Assignment #6 Spring 2025
// Worksheet4: Priority Queue
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

import java.util.LinkedList;
import java.util.Queue;

public class Worksheet4_Spring2025 {

	public static void main(String[] args) {
		

		// Setup some hard coded planes to use in the queue questions!
		// Create two hard coded planes - hard coding is the way to go when learning!
		// Of course we would not do this in an assignment!  I'm doing it for testing purposes.
		PlaneW4 plane1 = new PlaneW4("Flight 817", 180000);  
		PlaneW4 plane2 = new PlaneW4("Flight 444", 60000);    

		// Add some containers to each plane
		// Note this time I'm adding the containers with a call to addContainer method on the plane.
		// Create 1 hard coded container objects and add them to plane1's queue
		plane1.addContainer(new ContainerW4("AP12345"));

		// Create 4 hard coded previous owner objects and add them to plane2's queue
		plane2.addContainer(new ContainerW4("AP3321"));
		plane2.addContainer(new ContainerW4("AP3354"));
		plane2.addContainer(new ContainerW4("AP3322"));
		plane2.addContainer(new ContainerW4("AP3378"));

		// ***********************************
		// Worksheet4 Question 3a
		// Write the declaration for a priority queue of planes (PlaneW4 objects)
		// ***********************************
		// ADD CODE HERE
		
		

		
		//********************************
		// Worksheet4 Question #3b
		// See Plane Class below
		//********************************

		
		// ***********************************
		// Worksheet4 Question #3c 
		// Write code to add plane1 and plane2 to the priority queue
		// ***********************************
		// ADD CODE HERE 
		
		
		
		
		System.out.println("Plane #1 is in priority queue");	
		System.out.println("Plane #2 is in priority queue");

	} // main

} // Worksheet4



class ContainerW4  {
	
	private String id;			
	
	public ContainerW4 (String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
} // ContainerW4



class PlaneW4 {	
	
	private String flightNumber;
	private double capacity;
			
	// Queue of containers that will be loaded on plane
	private Queue<ContainerW4> containers = new LinkedList<>();  
		
	
	// Create a plane
	public PlaneW4 (String flightNumber, double capacity) {
		this.flightNumber = flightNumber;
		this.capacity = capacity;
	}
			
	public String getFlightNumber() {
		return flightNumber;
	}
	
	public double getCapacity() {
		return capacity;
	}
	
	
	// ***********************************
	// Worksheet4 Question #3b
	// Copy your answer from Worksheet3 here
	// ***********************************
	public int getContainersSize() {
		// ADD CODE HERE
		
		
	}

	
	// ***********************************
	// Worksheet4 Question #3b
	// Copy your answer from Worksheet3 here
	// ***********************************	
	public void addContainer (ContainerW4 container) {
		// ADD CODE HERE


	}
	
	
	// ***********************************
	// Worksheet4 Question #3b
	// Copy your answer from Worksheet3 here
	// ***********************************	
	public ContainerW4 removeContainer () {
		// ADD CODE HERE


	}

	
	// ***********************************
	// Worksheet4 Question #3g 
	// Add the code from question 3g here
	// ***********************************
	// ADD CODE HERE
	
	
	
	
	
	
	
	
	
	
} // PlaneW4
