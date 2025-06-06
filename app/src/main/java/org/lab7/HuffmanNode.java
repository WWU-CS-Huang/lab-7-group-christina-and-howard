package lab7;

import java.lang.Comparable;
import java.lang.NullPointerException;
import java.lang.ClassCastException;

public class HuffmanNode implements Comparable{
  protected String charecter;
  protected Integer frequency;
  protected HuffmanNode left;
  protected HuffmanNode right;

  public HuffmanNode(String charecter, Integer frequency) {
    this.charecter = charecter;
    this.frequency = frequency;
  }

  public int compareTo(Object o) {
    if (o == null) {
      throw new NullPointerException();
    } else if (o instanceof HuffmanNode) {
      return this.frequency - ((HuffmanNode) o).frequency;
    } else {
      throw new ClassCastException();
    }
  }

  /** prints a tree starting at HuffmanNode n at level level.
   *  Copied directly from A2.
   */
  public static void printSubtree(HuffmanNode n, int level) {
    if (n == null) {
      return;
    }
    printSubtree(n.right, level + 1);
    for (int i = 0; i < level; i++) {
      System.out.print("        ");
    }
    System.out.println(n);
    printSubtree(n.left, level + 1);
  }

  public String toString() {
    return charecter + ":" + frequency;
  }
}
