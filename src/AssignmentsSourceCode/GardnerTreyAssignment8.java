/*Name: Trey Gardner
Class: CS1450 (M/W)
Due: April 10th, 2025
Assignment: #8
Description: This program will decrypt the secret parrot message to find their location. This decryption
will be done using 2D arrays.
 */

//removing before turning in...
package AssignmentsSourceCode;


//Assignment class
public class GardnerTreyAssignment8 {
    //main
    public static void main(String[] args) {

        //Step 1: prepare to decode messages

            //A. Open the 3 files for reading

            //B. Create a Decoding_Machine object

            //C. Create and fill and ArrayList with the characters in the file "KeyGrid.txt"

            //D. Create an iterator for the ArrayList

            //E. Fill the Decoding_Machine's key grid

            //F. Print the Decoding_Machine's key grid

        //Step 2: read secret message in a file

            //A. Create 2 queues to store Key_Grid_Element objects

            //B. Write a method that fills a queue with the file values

        //Step 3: decode the messages

            //A. Create an iterator for each queue ^

            //B. Call decode_message()

            //C. Display the characters of the decoded secret message in the returned iterator

            //D. Repeat b and c for 2nd message

    }
}

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

//public methods
    //constructor
    public Decoding_Machine(int num_rows, int num_columns) {
        this.num_rows = num_rows;
        this.num_columns = num_columns;
    }//constructor
    
    public void fill_key_grid(Iterator<Character> char_iterator) {

    }//fill key grid

    public Iterator<Character> decode_message(Iterator<Key_Grid_Element> msg_iterator) {

    }//decode message

    public void print_key_grid() {

    }//print key grid
}
