/* Name: Trey Gardner
   Class: CS1450 (M/W)
   Due: March 5th, 2025
   Assignment: #5
   Description: This program will; create 2 JFC stacks of integers read from files,
   sort the stacks, and the merge the two stacks into one sorted stack.
 */

//assignment package, delete before submitting
package AssignmentsSourceCode;

//Java imports
import java.util.Scanner;
import java.io.IOException;
import java.util.Stack;

public class GardnerTreyAssignment5 {
    //main
    public static void main(String[] args) {
        //array of integers
        int[] numbers = {0, 0, 4, 3, 0, 2, 1, 0, 0};
        //empty stack
        Stack<Integer> numbers_stack = new Stack<Integer>();
        //placing array values in stack
        for (int number : numbers) {
            numbers_stack.push(number);
        }
        //calling replace with 10's method
        replace_zero_with_10(numbers_stack);

        //printing stack with no 0's then restoring to original state
        print_stack(numbers_stack);


    }
    //Replaces all 0's in stack with 10's
    public static void replace_zero_with_10(Stack<Integer> int_stack) {
        Stack<Integer> temp_stack = new Stack<Integer>();
        int temp = 0;
        for (int i = 0; i < int_stack.size(); i++) {
           temp = int_stack.pop();
           if(temp == 0) {
               temp = 10;
           }//if
           temp_stack.push(temp);
        }// for (replace zeros, in temp stack)
        for (int j = 0; j < temp_stack.size(); j++) {
            int_stack.push(temp_stack.pop());
        }//for (restoring original stack)
    }//replace_zeros_with_ten

    //printing stack then restoring to original
    public static void print_stack(Stack<Integer> int_stack) {
        Stack<Integer> temp_stack = new Stack<>();
        int temp = 0;
        System.out.println("\nAll Values in stack after zeros are replaces with tens: \n"
                         + "-------------------------------------------------------");
        for (int i = 0; i < int_stack.size(); i++) {
            temp = int_stack.pop();
            System.out.print("Stack Value " + i + ": " + temp);
            if(temp == 10) {
                temp = 0;
            }//if
            temp_stack.push(temp);
        }//for (replace 10's with 0's
        for (int j = 0; j < temp_stack.size(); j++) {
            int_stack.push(temp_stack.pop());
        }//for (restore original stack)
    }//print_stack

}//Assignment Class

class Generic_Stack<E> {
    
}
