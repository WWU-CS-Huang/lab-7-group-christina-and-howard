package lab7;

import java.lang.UnsupportedOperationException;
import java.io.File;
import avl.AVL;
import heap.HashTable;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.lang.StringBuilder;

public class Huffman {

  /** filenames are relative to the app directory */
  public static void main(String[] args) {
    String input = "bee nuts.!!!!!";
    HashMap<Character, Integer> dummyHash = new HashMap<Character, Integer>();
    dummyHash.put('b', 1);
    dummyHash.put('e', 2);
    dummyHash.put(' ', 1);
    dummyHash.put('n', 1);
    dummyHash.put('u', 1);
    dummyHash.put('t', 1);
    dummyHash.put('s', 1);
    dummyHash.put('.', 1);
    dummyHash.put('!', 5);
    HuffmanNode root = buildTree(dummyHash);
    HuffmanNode.printSubtree(root, 0);
    System.out.println("==========================================");
    System.out.println(encode(root, input));
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
    HashMap<String, Integer> bitTable = generateBitTable(tree);
    StringBuilder sb = new StringBuilder();
    for(char c : input.toCharArray()) {
      Integer current = bitTable.get(Character.toString(c));
      sb.append(Integer.toBinaryString(current));
    }
    return sb.toString();
  }

  /** generates a bit table for use in encoding. */
  private static HashMap<String, Integer> generateBitTable(HuffmanNode root) {
    HashMap<String, Integer> table = new HashMap<String, Integer>();
    bitTableTraversal(table, root, 0);
    return table;
  }

  /** traverses the tree and finds bitstrings for all charecters */
  private static void bitTableTraversal(HashMap<String, Integer> map, HuffmanNode node, int bitString) {
    if (node != null && node.left == null && node.right == null) {
      map.put(node.charecter, bitString);
    } else if (node != null) {
      bitTableTraversal(map, node.left, bitString << 1);
      bitTableTraversal(map, node.right, (bitString << 1) | 0x1);
    }
  }
}
