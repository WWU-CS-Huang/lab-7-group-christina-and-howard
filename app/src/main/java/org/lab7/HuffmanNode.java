package lab7;

import java.lang.Comparable;
import java.lang.NullPointerException;
import java.lang.ClassCastException;

public class HuffmanNode implements Comparable{
  protected String charecter;
  protected Integer frequency;

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
}
