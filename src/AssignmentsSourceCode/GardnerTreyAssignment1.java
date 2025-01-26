
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
import java.io.File;

//assignment class
public class GardnerTreyAssignment1 {
    
    public static void main(String[] args){
        int[] numbers = {1, 18, 10, 2, 16, 8, 15, 9, 9, 17, 14, 18, 1, 19, 18, 2, 1};
        System.out.println(numbers);
        Arrays.sort(numbers);         
        File numbersFile = new File("assignment1.txt");
        
}
}