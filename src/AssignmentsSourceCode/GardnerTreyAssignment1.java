
/*Name: Trey Gardner
 * Class: CS1450(M/W)
 * Due: Jan 29, 2025
 * Assignment #1
 * DESC: This program will show proficiency in creating an manipulating arrays and
 * reading/writing from files
package AssignmentsSourceCode;
*/
//package for all assignments
package AssignmentsSourceCode;

//Importing Java packages
import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

//assignment class
public class GardnerTreyAssignment1 {
    
    public static void main(String[] args){
    	
    //TASK 1: Create an array and fill it with values
		//Part A: create array
        int[] numbers = {1, 18, 10, 2, 16, 8, 15, 9, 9, 17, 14, 18, 1, 19, 18, 2, 1};
        
		//Part B: display array

			System.out.println("The full array of unsorted integers: ");
		for(int i = 0; i < numbers.length - 1; i++) { 
			System.out.println("\nnumbers[" + i + "] = " + numbers[i]);
		}

		//Part C: sort array
        Arrays.sort(numbers);         

	//TASK 2: Write Values in the array to a file in sorted order:
		//Part A: create file and file object 
        File numbersFile = new File("assignment1.txt");
		
		//Part B, C, and D: Open file for writing, write all values in array to file, and close file
        int even = 0;
        int odd = 0;
        //writing array to outputfile
        try {
        //creating printwriter for file
        PrintWriter output = new PrintWriter("assignment1.txt");
        	//Printing array and counting odds and evens
        	for(int i = 0; i < numbers.length; i++) {
        		//printing array numbers to file
        		output.println(numbers[i]);
        		//checking if value printed in divisible by 2 (is or is not even)
        		if(numbers[i]%2 == 0) {
        			//counting even numbers
        			even++;
        		}
        		else {
        			//counting odd numbers
        			odd++;
        		}
        	}
        	//closing PrintWriter
        	output.close();
        	} catch (FileNotFoundException e) {
        		System.out.println("File could not be found");
        		
        	}
			
			int totalIntegers = numbers.length - 1;
			System.out.println("\nBreak down of values in written file: \nThe total number of integers: "
			+ totalIntegers + "\nThe total number of even integers: " + even + 
			"\nThe total number of odd integers: " + odd);
			
	//TASK 3: Read the values in the file and fill the even and odd arrays with no duplicates 
		//Part B: creating two new arrays (Based on number of odds and evens written in file)
        int[] evenNumbers = new int[even];
        int[] oddNumbers = new int[odd];
        even = 0;
        odd = 0;
        int readValue;
		//Part A, C: reopening the file for reading and placing values in corresponding arrays
        try {
			//Reading file and assigning first int to "readValue"
        	Scanner input = new Scanner(numbersFile);
        	for(int i = 0; i < numbers.length; i++) {
        		readValue = input.nextInt();
				//is readValue even?
        		if(readValue%2 == 0) {
					//checking if readValue is duplicate in evenNumbers array
					if(even == 0 || readValue != evenNumbers[even-1]){
        				evenNumbers[even] = readValue;
						//index counter
        				even++;
   		     		}
				}
        		else {
					//checking if readValue is duplicate in oddNumbers array
					if(odd == 0 || readValue != oddNumbers[odd - 1]){
        				oddNumbers[odd] = readValue;
						//index counter
        				odd++;
					}
        		}
        	}
        	input.close();
        } catch (FileNotFoundException e) { 
        	System.out.println("File could not be found");
        }
		System.out.println("\nEven Numbers Array: ");
		for(int i = 0; i < evenNumbers.length; i++){
			System.out.println("\nevenNumbers[" + i + "] = " + evenNumbers[i]);
		}

		System.out.println("\nOdd Numbers Array: ");
		for(int i = 0; i < oddNumbers.length; i++){
			System.out.println("\noddNumbers[" + i + "] = " + oddNumbers[i]);
		}

		int[] fittedEvenNumbers = new int[even];
		int[] fittedOddNumbers = new int[odd];

		for(int i = 0; i < even; i++){
				fittedEvenNumbers[i] = evenNumbers[i];	
		}
		for(int i = 0; i < odd; i++){
				fittedOddNumbers[i] = oddNumbers[i];	
		}

		System.out.println("\nEven Numbers Array: ");
		for(int i = 0; i < fittedEvenNumbers.length; i++){
			System.out.println("\nfittedEvenNumbers[" + i + "] = " + fittedEvenNumbers[i]);
		}

		System.out.println("\nOdd Numbers Array: ");
		for(int i = 0; i < fittedOddNumbers.length; i++){
			System.out.println("\nfittedOddNumbers[" + i + "] = " + fittedOddNumbers[i]);
		}


	} 

}
