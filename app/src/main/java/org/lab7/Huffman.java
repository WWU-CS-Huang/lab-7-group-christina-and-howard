package lab7;

import java.lang.UnsupportedOperationException;
import java.io.File;
import avl.AVL;
import heap.HashTable;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Huffman {

  /** filenames are relative to the app directory */
  public static void main(String[] args) {
    // Grab args[0], the filename, and send it to countFrequencies to intiate the file object
    // Send HashMap elsewhere later
    HashMap<Character, Integer> dummyHash;
    dummyHash = countFrequencies(args[0]);

    HuffmanNode root = buildTree(dummyHash);
    HuffmanNode.printSubtree(root, 0);
  }

  /** countFrequencies - Counts the frequencies of each charecter in the string.
    * stores the results in a HashTable with Strings as keys and  Integers as values.
    */
  private static HashMap<Character, Integer> countFrequencies(String fileName) {
    // Christina Part 1

    // Use to create and access the text file
    File fileToTally = new File(fileName);
    String fileAsString = fileToTally.toString();

    // Create Hashmap to hash individual chars into
    HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
    char inputChar;
    
    // Go through entire file
    for (int i = 0; i < fileToTally.length(); i++) {

      // Get next input, and hash it to where it needs to go
      inputChar = fileAsString.charAt(i);

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

    return hash;
  }



  /** buildTree - builds a Huffman tree for the given frequency Hashmap. */
  public static HuffmanNode buildTree(HashMap<Character, Integer> freq) {
    PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>();
    for (Character key : freq.keySet()) {
      queue.add(new HuffmanNode(key.toString(), freq.get(key)));
    }

    while (queue.size() > 1) {
      HuffmanNode one = queue.poll();
      HuffmanNode two = queue.poll();
      HuffmanNode n = new HuffmanNode(null, one.frequency + two.frequency);
      n.left = one;
      n.right = two;
      queue.add(n);
    }

    return queue.poll();
  }

  /** decode - uses given tree to decode the given bitstring. */
  public static String decode(HuffmanNode tree, String bitString) {
    // TODO: Christina implement this.
    throw new UnsupportedOperationException();
  }

  /** encode - uses the given tree to encode the given input string. */
  public static String encode(HuffmanNode tree, String input) {
    // TODO: Howard implement this.
    throw new UnsupportedOperationException();
  }
}
