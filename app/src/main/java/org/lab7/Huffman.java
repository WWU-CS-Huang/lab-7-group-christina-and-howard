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
  public static HuffmanNode buildTree(HashMap<String, Integer> freq) {
    PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>();
    for (String key : freq.keySet()) {
      queue.add(new HuffmanNode(key, freq.get(key)));
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
