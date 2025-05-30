package lab7;

import java.lang.UnsupportedOperationException;
import avl.AVL;
import heap.HashTable;
import java.util.HashMap;
import java.util.PriorityQueue;

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
    throw new UnsupportedOperationException();
  }

  /** buildTree - builds a Huffman tree for the given frequency Hashmap. */
  public static AVL buildTree(HashMap<String, Integer> freq) {
    // TODO: Howard implement this.
    PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>();
    for (String key : freq.keySet()) {
      queue.add(new HuffmanNode(key, freq.get(key)));
    }
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
