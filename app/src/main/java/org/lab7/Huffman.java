package lab7;

import java.lang.UnsupportedOperationException;
import avl.AVL;
import heap.HashTable;
import java.util.HashMap;
import java.util.Scanner;

public class Huffman {

  public static void main(String[] args) {
    // TODO: update the match Lab spec (will do last).
    System.out.println("Huffman");
  }

  /** countFrequencies - Counts the frequencies of each charecter in the string.
    * stores the results in a HashTable with Strings as keys and  Integers as values.
    */
  public static HashMap<String, Integer> countFrequencies(String input) {
    // TODO: Christina implement this.

    // TODO: make sure to change the method types, public is bad
    // TODO: small issue with declaration with input
        Scanner input = new Scanner(System.in);

        char inputChar; 
        //char inputChar = input.nextChar();

        char[] characters = new Array[input.length()];
            throw new UnsupportedOperationException();
  }

  // helper for above: count the number of times each char appears 
    public static char[] readInput(Scanner input, char inputChar) {

        char[] characters = new Array[input.length()]

        // read and store in an array ---> remove this later and use string.subString();
        for (int i = 0; i < input.length(); i++) {

            //small fix here for later
            char[i] = char[inputChar];
            char inputChar = input.nextChar();
        }

        //return characters;
    }

    // put the array created above into a hashmap that determines the value based off of
    // if we've seen the character or not
    public static HashMap<Character, Integer> hashInput(Scanner input, char inputChar, char[] characters) {

        HashMap<Character, Integer> hash = new Hashmap<>();

        for (int i = 0; i < input.length(); i++) {

            // hash.put -> gets value for key,      hash.get -> value which key is mapped
            hash.put(characters[i], hash.get(characters[i]) == null ? 1 : mp.get(arr[i] + 1));

        }        
        
    }

    // sort the hashmap linkedlist style
    static HashMap<Character, Integer> sortHashMapValues(Hashmap<Character, Integer> hash) {

        // TODO: create a new hashmap to store the sorted hashmap for now, later change this to 
        // a better implementation (probably using heap method to change orders of values and such)
        // ideas for later to help - some classes/methods to look into: entrySet(), linkedhashmap, treeset

        HashMap<Character, Integer> sortedHash = new Hashmap<>();

    }


  /** buildTree - builds a Huffman tree for the given frequency Hashmap. */
  public static AVL buildTree(HashMap<String, Integer> freq) {
    // TODO: Howard implement this.
    throw new UnsupportedOperationException();
  }

  /** decode - uses given tree to decode the given bitstring. */
  public static String decode(AVL tree, String bitString) {
    // TODO: Christina implement this.
    throw new UnsupportedOperationException();
  }

  /** encode - uses the given tree to encode the given input string. */
  public static String encode(AVL tree, String input) {
    // TODO: Howard implement this.
    throw new UnsupportedOperationException();
  }
}
