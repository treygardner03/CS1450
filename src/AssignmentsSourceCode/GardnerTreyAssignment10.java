/*Name: Trey Gardner
Class: CS1450 (M/W)
Assignment: #10
Due: May 1st, 2025
Description: This program will;
1.) create a custom binary tree
2.) add parrots as nodes to the tree
3.) traverse the tree by level order
4.) use the traversal to print the song word by word
 */

//remove when turning in
package AssignmentsSourceCode;

//libraries
import java.util.Scanner;

//assignment 10
public class GardnerTreyAssignment10 {
    //main
    public static void main(String[] args) {

    //A.) create an instance of a binary tree

    //B.) create parrots and add to tree
        //open file

        //read from file

        //create parrot

        //add parrot to tree

    //C.) traverse tree in level order to print song

    //D.) traverse leaves to print parrot's names
        
    }//main
}//assignment 10

//CLASSES:

//Parrot Class
class Parrot implements Comparable<Parrot> {
//PRIVATE DATA FIELDS
   private int id;
   private String name;
   private String song_word;

//PUBLIC METHODS

    //constructor
    public Parrot(int id, String name, String song_word) {
       this.id = id;
       this.name = name;
       this.song_word = song_word;
    }//constructor

    //getter - name
    public String get_name() {
       return this.name;
    }//getter - name

    //getter - song_word
    public String sing() {
        return this.song_word;
    }//getter - song_word

    //compareTo
    public int compareTo(Parrot other_parrot) {
        if(this.id > other_parrot.id) {
            return 1;
        }
        else if(this.id < other_parrot.id) {
            return -1;
        }
        return 0;
    }//compareTo

}//Parrot Class

//Binary Tree Class
class Binary_Tree {
//PRIVATE DATA FIELDS:
    private Tree_Node root;

//PUBLIC METHODS:

    //constructor
    public Binary_Tree() {
        this.root = null;
    }//constructor

    //insert parrot
    public boolean insert_parrot(Parrot parrot) {
        //if tree is empty
        if (this.root == null) {
            this.root = new Tree_Node(parrot);
        }//if

    }//insert parrot

    //tree traversal
    public void level_order() {

    }//leve_order

//PRIVATE METHODS:
    //leaf traversal
    private void visit_leaves(Tree_Node a_node) {
        //must be recursive
    }//visit leaves

//PRIVATE INNER CLASS:
    //Node Class
    private class Tree_Node {
    //PRIVATE DATA FIELDS
        Parrot parrot;
        Parrot left;
        Parrot right;

    //PUBLIC METHODS
        //constructor
        public Tree_Node(Parrot parrot) {
            this.parrot = parrot;
            this.left = null;
            this.right = null;
        }//constructor
    }//private tree node

}//Binary Tree Class
