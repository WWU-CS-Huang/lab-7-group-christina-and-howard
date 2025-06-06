package lab7;

import java.lang.UnsupportedOperationException;
import java.io.File;
import avl.AVL;
import heap.HashTable;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.lang.StringBuilder;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class Huffman {

  /** filenames are relative to the app directory */
  public static void main(String[] args) throws IOException{
    String directory = "src/main/resources/";
    File fileLocation = new File(directory + args[0]);
    String input = Files.readString(fileLocation.toPath());
    HashMap<Character, Integer> dummyHash = countFrequencies(input);

    HuffmanNode root = buildTree(dummyHash);
    String bitString = encode(root, input);
    String decoded = decode(root, bitString);
    
    if (input.length() < 100) {
      System.out.println("Input: " + input);
      System.out.println("Encoded String: " + bitString);
      System.out.println("Decoded String: " + decoded);
    }

    System.out.println("Equality: " + input.equals(decoded));
    System.out.println("Compression Ratio: " + bitString.length() / input.length() / 8.0);
  }

  /** countFrequencies - Counts the frequencies of each charecter in the string.
    * stores the results in a HashTable with Strings as keys and  Integers as values.
    */
  private static HashMap<Character, Integer> countFrequencies(String input) {
    HashMap<Character, Integer> hash = new HashMap<Character, Integer>();

    for (char c : input.toCharArray()) {
      hash.put(c, hash.get(c) == null ? 1 : hash.get(c) + 1);
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
    HuffmanNode current = tree;
    StringBuilder sb = new StringBuilder();
    char[] arr = bitString.toCharArray();
    int i = 0;

    while (i < arr.length) {
      if (arr[i] == '1') {
	current = current.right;
      } else {
	current = current.left;
      }

      if (current.charecter != null) {
	sb.append(current.charecter);
	current = tree;
      }

      i++;
    }

    return sb.toString();
  }

  /** encode - uses the given tree to encode the given input string. */
  public static String encode(HuffmanNode tree, String input) {
    HashMap<String, String> bitTable = generateBitTable(tree);
    StringBuilder sb = new StringBuilder();
    for(char c : input.toCharArray()) {
      String current = bitTable.get(Character.toString(c));
      sb.append(current);
    }
    return sb.toString();
  }

  /** generates a bit table for use in encoding. */
  private static HashMap<String, String> generateBitTable(HuffmanNode root) {
    HashMap<String, String> table = new HashMap<String, String>();
    bitTableTraversal(table, root, "");
    return table;
  }

  /** traverses the tree and finds bitstrings for all charecters */
  private static void bitTableTraversal(HashMap<String, String> map, HuffmanNode node, String bitString) {
    if (node != null && node.left == null && node.right == null) {
      map.put(node.charecter, bitString);
    } else if (node != null) {
      bitTableTraversal(map, node.left, bitString + "0");
      bitTableTraversal(map, node.right, bitString + "1");
    }
  }
}
