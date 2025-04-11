
/* Name: Trey Gardner
Class: CS1450 (M/W)
Due: April 10th, 2025
Assignment: #8
Description: This program will decrypt the secret parrot message to find their location. This decryption
will be done using 2D arrays.
 */

//remove before turning in
package AssignmentsSourceCode;

//imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.lang.Character;


//Assignment class
public class GardnerTreyAssignment8 {
    //main
    public static void main(String[] args) throws FileNotFoundException {

        //Step 1: prepare to decode messages

        //A. Open the 3 files for reading
        File key_grid_text = new File("KeyGrid.txt");
        Scanner read_key_grid = new Scanner(key_grid_text);
        File message_1_text = new File("Message1.txt");
        Scanner read_message_1 = new Scanner(message_1_text);
        File message_2_text = new File("Message2.txt");
        Scanner read_message_2 = new Scanner(message_2_text);

        //getting key grid information
        int num_rows = read_key_grid.nextInt();
        int num_columns = read_key_grid.nextInt();

        //B. Create a Decoding_Machine object
        Decoding_Machine decoder = new Decoding_Machine(num_rows, num_columns);

        //C. Create and fill an ArrayList with the characters in the file "KeyGrid.txt"
        ArrayList<Character> key_grid_list = new ArrayList<Character>();
        for (int i = 0; i < (num_rows * num_columns); i++) {
            key_grid_list.add(read_key_grid.next().charAt(0));
        }

        //D. Create an iterator for the ArrayList
        Iterator<Character> iterator = key_grid_list.iterator();

        //E. Fill the Decoding_Machine's key grid
        decoder.fill_key_grid(iterator);

        //F. Print the Decoding_Machine's key grid
        decoder.print_key_grid();

        //Step 2: read secret message in a file

        //A. Create 2 queues to store Key_Grid_Element objects
        Queue<Key_Grid_Element> queue_1 = new LinkedList<>();
        Queue<Key_Grid_Element> queue_2 = new LinkedList<>();

        //B. Write a method that fills a queue with the file values
        fill_queue(queue_1, read_message_1);
        fill_queue(queue_2, read_message_2);

        //Step 3: decode the messages

        //A. Create an iterator for each queue ^
        Iterator<Key_Grid_Element> message_1_iterator = queue_1.iterator();
        Iterator<Key_Grid_Element> message_2_iterator = queue_2.iterator();

        //decoding 1st secret message
        Iterator<Character> secret_message_iterator = decoder.decode_message(message_1_iterator);

        //printing 1st secret message:
        System.out.println("\nSecret Message #1: \n");
        while(secret_message_iterator.hasNext()) {
            System.out.println(secret_message_iterator.next());
        }

        //decoding 2nd secret message
        secret_message_iterator = decoder.decode_message(message_2_iterator);

        //printing 2nd secret message
        System.out.println("\nSecret Message #2: \n");
        while(secret_message_iterator.hasNext()) {
            System.out.println(secret_message_iterator.next());
        }


    }//main

    //methods
    public static void fill_queue(Queue<Key_Grid_Element> queue, Scanner message) {
        //declaring message length

        while (message.hasNext()) {
            queue.offer(new Key_Grid_Element(message.nextInt(), message.nextInt()));
        }
    }

}//Assignment Class

//Classes:

//Key_Grid_Element
class Key_Grid_Element {

//private data fields
    private int row;
    private int column;

//public methods
    //constructor
    public Key_Grid_Element(int row, int column) {
        this.row = row;
        this.column = column;
    }//constructor

//Getter methods
    public int get_row() {
        return row;
    }//get row

    public int get_column() {
        return column;
    }//get column
}
//Decoding_Machine
class Decoding_Machine {

//private data fields
    //2D array of characters
    private int num_rows;
    private int num_columns;
    private char[][] key_grid;
    private ArrayList<Character> secret_message;

//public methods
    //constructor
    public Decoding_Machine(int num_rows, int num_columns) {
        this.num_rows = num_rows;
        this.num_columns = num_columns;
        this.key_grid = new char[num_rows][num_columns];
    }//constructor

    //fills 2D Array key grid
    public void fill_key_grid(Iterator<Character> char_iterator) {
        for(int i = 0; i < num_rows; i++){
            for(int j = 0; j < num_columns; j++){
                key_grid[i][j] = char_iterator.next();
            }
        }

    }//fill key grid

    public Iterator<Character> decode_message(Iterator<Key_Grid_Element> msg_iterator) {

        //secret message
        this.secret_message = new ArrayList<>();

        while (msg_iterator.hasNext()) {
            Key_Grid_Element temp_element = msg_iterator.next();
            char temp_char = this.key_grid[temp_element.get_row()][temp_element.get_column()];
            secret_message.add(temp_char);
        }
        return secret_message.iterator();

    }//decode message

    //prints values in key grid
    public void print_key_grid() {
        System.out.println("Key Grid Values: \n");
        for(int i = 0; i < this.num_rows; i++){
            for(int j = 0; j < this.num_columns; j++){
                System.out.print(this.key_grid[i][j]);
            }
            System.out.println();
        }

    }//print key grid
}
