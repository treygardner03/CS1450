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
import java.util.Collections;

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
        for(int i = 0; i < numbers.length; i++) {
            numbers_stack.push(numbers[i]);
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

        //filling integer stacks with integers
        fill_integer_stack(int_stack_1, integers_1);
        fill_integer_stack(int_stack_2, integers_2);

        //Printing values from integer stacks
        System.out.println("\n\nInteger Stack #1: values from file: " + integers_1.toString());
        print_stack(int_stack_1);

        System.out.println("\n\nInteger Stack #2: values from file: " + integers_2.toString());
        print_stack(int_stack_2);

        //filling string stacks with values
        fill_string_stack(string_stack_1, strings_1);
        fill_string_stack(string_stack_2, strings_2);

        //Printing values from stacks with strings
        System.out.println("\n\nString Stack #1: values from file: " + strings_1.toString());
        print_stack(string_stack_1);

        System.out.println("\n\nString Stack #2: values from file: " + strings_2.toString());
        print_stack(string_stack_2);

        //sorting ALL stacks
        sort_stack(int_stack_1);
        sort_stack(int_stack_2);
        sort_stack(string_stack_1);
        sort_stack(string_stack_2);

        //Printing ALL sorted stacks
        System.out.println("\n\nSorted Integer Stack #1: values from file: " + integers_1.toString());
        print_stack(int_stack_1);
        System.out.println("\n\nSorted Integer Stack #2: values from file: " + integers_2.toString());
        print_stack(int_stack_2);
        System.out.println("\n\nSorted String Stack #1: values from file: " + strings_1.toString());
        print_stack(string_stack_1);
        System.out.println("\n\nSorted String Stack #2: values from file: " + strings_2.toString());
        print_stack(string_stack_2);

        //merging sorted integer stacks
        Generic_Stack<Integer> merged_int_stack = merge_stacks(int_stack_1, int_stack_2);
        Generic_Stack<String> merged_string_stack = merge_stacks(string_stack_1, string_stack_2);

        //Printing merged Stacks
        System.out.println("\n\nMerged Integer Stack #1: values from file: " + integers_1.toString() + " and " + integers_2.toString());
        print_stack(merged_int_stack);
        System.out.println("\n\nMerged String Stack #1: values from file: " + strings_1.toString() + " and " + strings_2.toString());
        print_stack(merged_string_stack);

    }

    //Replaces all 0's in stack with 10's
    public static void replace_zero_with_10(Stack<Integer> int_stack) {
        Stack<Integer> temp_stack = new Stack<Integer>();
        while(!int_stack.isEmpty()) {
           int temp = int_stack.pop();
            if (temp == 0) {
                temp = 10;
            }//if
            temp_stack.push(temp);
        }// while (replace zeros, in temp stack)
        while(!temp_stack.isEmpty()) {
            int_stack.push(temp_stack.pop());
        }//while (restoring original stack)
    }//replace_zeros_with_ten

    public static <E extends Comparable<E>> void sort_stack(Generic_Stack<E> stack) {
        //temporary generic stack
        Generic_Stack<E> temp_stack = new Generic_Stack<E>();
        E item_popped;
        E item_temp;
        while(!stack.isEmpty()) {
            item_popped = stack.pop();
            if (temp_stack.isEmpty()) {
                temp_stack.push(item_popped);
                continue;
            }
            item_temp = temp_stack.peek();
            if (item_popped.compareTo(item_temp) < 0) {
                temp_stack.push(item_popped);
            }
            else {
                while (item_popped.compareTo(item_temp) >= 0) {
                    stack.push(temp_stack.pop());
                    if(!temp_stack.isEmpty()) {
                        item_temp = temp_stack.peek();
                    } else break;
                }
                temp_stack.push(item_popped);
            }

        }
        while(!temp_stack.isEmpty()) {
            stack.push(temp_stack.pop());
        }
    }//sort stack body


    public static <E extends Comparable<E>> Generic_Stack<E> merge_stacks(Generic_Stack<E> stack1, Generic_Stack<E> stack2) {
        //final merged stack for return
        Generic_Stack<E> merged_stack = new Generic_Stack<E>();

        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            if(stack1.peek().compareTo(stack2.peek()) > 0) {
                merged_stack.push(stack1.pop());
            }
            else {
                merged_stack.push(stack2.pop());
            }
        }
        while(!stack1.isEmpty()) {
            merged_stack.push(stack1.pop());
        }
        while(!stack2.isEmpty()) {
            merged_stack.push(stack2.pop());
        }
        return merged_stack;
    }

    //printing stack then restoring to original
    public static void print_stack(Stack<Integer> int_stack) {
        Stack<Integer> temp_stack = new Stack<>();
        int temp = 0;
        int counter = 0;
        System.out.println("\nAll Values in stack after zeros are replaces with tens: \n"
                + "-------------------------------------------------------");
        while(!int_stack.isEmpty()) {
            temp = int_stack.pop();
            System.out.print("\nStack Value " + counter + ": " + temp);
            if (temp == 10) {
                temp = 0;
            }//if
            temp_stack.push(temp);
            counter++;
        }//while (replace 10's with 0's
        while(!temp_stack.isEmpty()) {
            int_stack.push(temp_stack.pop());
        }//while (restore original stack)
    }//print_stack

    public static <E extends Comparable<E>> void print_stack(Generic_Stack<E> stack) {
        //local values
        E temp;
        Generic_Stack<E> temp_stack = new Generic_Stack<E>();

        //printing each value in stack
        while (!stack.isEmpty()) {
            temp = stack.pop();
            System.out.println("Stack Value :" + temp);
            temp_stack.push(temp);
        }
        //restoring the original stack
        while (!temp_stack.isEmpty()) {
            stack.push(temp_stack.pop());
        }
    }

    public static void fill_integer_stack(Generic_Stack<Integer> int_stack, File integers) {
        try {
            Scanner reader = new Scanner(integers);
            while (reader.hasNextInt()) {
                int_stack.push(reader.nextInt());
            }//while loop
        } catch (IOException E) {
            System.out.println(E.getMessage());
        }//try/catch
    }//fill_integer_stack

    public static void fill_string_stack(Generic_Stack<String> string_stack, File strings) {
        try {
            Scanner reader = new Scanner(strings);
            while (reader.hasNextLine()) {
                string_stack.push(reader.nextLine());
            }//while loop
        } catch (IOException E) {
            System.out.println(E.getMessage());
        }//try/catch
    }//fill_string_stack

}//Assignment Class

class Generic_Stack<E extends Comparable <E>> {
    //private data fields
    private ArrayList<E> stack;
    //public methods
    public Generic_Stack() {
        stack = new ArrayList<E>();
    }
    public boolean isEmpty() {
        return stack.isEmpty();
    }//is empty body

    public int get_size() {
        return stack.size();
    }//get size body

    public E peek() {
        if (!isEmpty()) {
            return stack.getLast();
        } else {
            return null;
        }
    }//peek body

    public E pop() {
        if (!isEmpty()) {
            return stack.removeLast();
        }
        return null;
    }//pop body

    public void push(E e) {
        if(isEmpty()) {
          stack.add(e);
        } else {
            stack.add(stack.size() - 1, e);
        }
    }//push body

    public int compareTo(E e) {
        return Integer.compare(pop().compareTo(e), 0);
    }

}//Generic Stack Class
