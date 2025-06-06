package lab7;

import java.lang.UnsupportedOperationException;
import java.io.File;
import java.io.FileNotFoundException; 
import avl.AVL;
import heap.HashTable;
import java.util.HashMap;
import java.util.Scanner;

public class Huffman {

  public static void main(String[] args) {
    // TODO: update the match Lab spec (will do last).
    System.out.println("Huffman");

    // Grab args[0], the filename, and send it to countFrequencies to intiate the file object
    // Send HashMap elsewhere later
    HashMap<Character, Integer> dummyHash;
    dummyHash = countFrequencies(args[0]);

<<<<<<< Updated upstream
=======
    System.out.println("DummyHash: " + dummyHash);

    HuffmanNode root = buildTree(dummyHash);
    HuffmanNode.printSubtree(root, 0);
>>>>>>> Stashed changes
  }

  /** countFrequencies - Counts the frequencies of each charecter in the string.
    * stores the results in a HashTable with Strings as keys and  Integers as values.
    */
  private static HashMap<Character, Integer> countFrequencies(String fileName) {
    // Christina Part 1
    
    // Use to create and access the text file
    String directory = "src/main/resources/";
    File fileLocation = new File(directory + fileName);

    // Create Hashmap to hash individual chars into
    HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
    char inputChar;

    try {

      Scanner fileToTally = new Scanner(fileLocation);
    
      // Go through entire file
      while (fileToTally.hasNext()) {
      
        // Get next input, and hash it to where it needs to go
        // Get next "string", each string needs to be broken into individual chars
        // Each string is missing a space (fencepost a space in there)
        inputChar = fileToTally.next().charAt(0);

        // If existing in the hashmap, increment value
        if (hash.containsKey(inputChar)) {
          hash.put(inputChar, hash.get(inputChar) + 1);
        } 
      
        // Otherwise create a new entry
        else if (hash.get(inputChar) == null) {
          hash.put(inputChar, 1);
        } 
      
        // ???
        else {
          throw new UnsupportedOperationException(); 
        }
      }
    }

    catch (FileNotFoundException e) {
      System.out.println("File Not Found!");
    }

    return hash;
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
