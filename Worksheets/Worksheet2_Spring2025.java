// CS1450 Assignment #6 Spring 2025
// Worksheet #2: Simple Nested Objects (Queues: not nested in a class and nested in a class)
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

import java.util.LinkedList;
import java.util.Queue;

public class Worksheet2_Spring2025 {

	public static void main(String[] args) {
		
		//*******************************************
		// Worksheet2 Question #1 
		// Queue in main - queue is NOT nested inside a class
		// Practice creating a queue and adding the values 68, 8, 17, 47
		//*******************************************
		// ADD CODE HERE
		// Name the queue -> queueNotNested
		
		
		
		
		
		
		// Test your non-nested queue by displaying the values in the queue
		System.out.println("Values in a queue that is not nested in a class");
		int queueLength = queueNotNested.size();
		for (int i = 0; i < queueLength; i++) {
			System.out.println("aQueue[" + i + "] = " + queueNotNested.remove());
		}

		//********************************
		// Worksheet2 Question #2
		// See IntegerQueue Class below
		//********************************

		
		//********************************
		// Worksheet2 Question #3a 
		// Use this code to test your IntegerQueue class
		// The queue is now nested inside a class called IntegerQueue
		// Create an object of type IntegerQueue and add the values 68, 8, 17, 47
		//********************************
		// ADD CODE HERE






		//********************************
		// Worksheet2 Question #3b
		// Test your nested queue by displaying the values in the queue
		//********************************
		// ADD CODE HERE		
		System.out.println();
		System.out.println("Values in a queue nested in a class");
		
		
		
		

		
	} // main

} // Worksheet2


//****************************************************
//Worksheet2 Question #2
//This class "contains" a queue of integers - HAS-A relationship
//The class will provide methods to access the queue
//Write the code for each method
//****************************************************
class IntegerQueueW2 {
	
	private Queue<Integer> numberQueue = new LinkedList<>();

	public int size() {
		// ADD CODE HERE
		
		
	}
	
	public void offer(Integer value) {
		// ADD CODE HERE
		
		
	}
	
	public Integer remove() {
		// ADD CODE HERE
		
		
	}
	
} // IntegerQueueW2


