
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
    	
    	//hardcoding array of numbers
        int[] numbers = {1, 18, 10, 2, 16, 8, 15, 9, 9, 17, 14, 18, 1, 19, 18, 2, 1};
        //Displaying Array
        System.out.println(numbers);
        //sorting the arrray using "Arrays.sort();"
        Arrays.sort(numbers);         
        //creating file for writing and reading
        File numbersFile = new File("assignment1.txt");
        //creating counters for even and odd numbers inside numbers array
        int even = 0;
        int odd = 0;
        //writing array to outputfile
        try {
        //creating printwriter for file
        PrintWriter output = new PrintWriter("assignment1.txt");
        	//Printing array and counting odds and evens
        	for(int i = 0; i<numbers.length; i++) {
        		//printing array numbers to file
        		output.write(numbers[i]);
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
       
        //Creating two new arrays for even and odd values
        int[] evenNumbers = new int[even];
        int[] oddNumbers = new int[odd];
        //Redefining even and odd as counters for future index
        even = 0;
        odd = 0;
        //defining value being read by scanner
        int readValue;
        //Reading values from files and writing into appropriate arrays with no duplicates
        try {
        	Scanner readFile = new Scanner(numbersFile);
        	for(int i = 0; i < numbers.length; i++) {
        		readValue = readFile.nextInt();
        		if(readValue%2 == 0) {
        			evenNumbers[even] = readValue;
        			even++;
        		}
        		else {
        			oddNumbers[odd] = readValue;
        			odd++;
        		}
        	}
        	readFile.close();
        } catch (FileNotFoundException e) { 
        	System.out.println("File could not be found");
        }
        
        System.out.println("\tThe Even Number Arrays: " + evenNumbers + "\tThe Odd Number Array: " + oddNumbers);
}
}