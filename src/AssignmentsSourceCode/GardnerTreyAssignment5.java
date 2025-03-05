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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.Stack;

public class GardnerTreyAssignment5 {
    //main
    public static void main(String[] args) {
        //Creating Files to read from
        File integers_1 = new File("integers1.txt");
        File integers_2 = new File("integers2.txt");
        File strings_1 = new File("strings1.txt");
        File strings_2 = new File("strings2.txt");

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
        //creating integer stacks from generic class
        Generic_Stack<Integer> int_stack_1 = new Generic_Stack<Integer>();
        Generic_Stack<Integer> int_stack_2 = new Generic_Stack<Integer>();
        Generic_Stack<String> string_stack_1 = new Generic_Stack<String>();
        Generic_Stack<String> string_stack_2 = new Generic_Stack<String>();

        //filling integer stacks with values
        fill_integer_stack(int_stack_1, integers_1);
        fill_integer_stack(int_stack_2, integers_2);

        //filling string stacks with values
        fill_string_stack(string_stack_1, strings_1);
        fill_string_stack(string_stack_2, strings_2);

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

    public static <E> void sort_stack(Generic_Stack<E> stack) {

    }

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

   public static <E> void print_stack(Generic_Stack<E> stack) {

   }

    public static void fill_integer_stack(Generic_Stack<Integer> int_stack, File integers) {
        try {
            Scanner reader = new Scanner(integers);
            while (reader.hasNextInt()) {
                int_stack.add(reader.nextInt());
            }//while loop
        } catch (IOException E) {
            System.out.println(E.getMessage());
        }//try/catch
    }//fill_integer_stack

    public static void fill_string_stack(Generic_Stack<String> string_stack, File strings) {
        try {
            Scanner reader = new Scanner(strings);
            while (reader.hasNextInt()) {
                string_stack.add(reader.next());
            }//while loop
        } catch (IOException E) {
            System.out.println(E.getMessage());
        }//try/catch
    }//fill_string_stack

}//Assignment Class

class Generic_Stack<E> {
    //private data fields
    private ArrayList<E> list = new ArrayList<E>();

    //public methods
    public void add(E e) {
        list.add(e);
    }//add body

}//Generic Stack Class
