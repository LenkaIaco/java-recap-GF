package unitTesting.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Anagram {
  public static void main(String[] args) {
    Anagram example = new Anagram();
    System.out.println(example.isAnagram("listen", "silentt"));
  }

  boolean isAnagram(String first, String second) {
    if (first == null || second == null) {return false;}
    first = first.toLowerCase();
    second = second.toLowerCase();
    StringBuilder firstSB = new StringBuilder(first);
    StringBuilder secondSB = new StringBuilder(second);
    ArrayList<Integer> indexes = new ArrayList<>();
    int whereLastChar = 0;
    if (firstSB.length() != secondSB.length()) {whereLastChar = -1;} else{
    for (int i = 0; i < firstSB.length(); i++) {
      whereLastChar = secondSB.indexOf(String.valueOf(firstSB.charAt(i)));
      if (whereLastChar == -1 || indexes.contains(whereLastChar)) {
        whereLastChar = -1;
        break;
      } else {
        indexes.add(whereLastChar);
      }
    } }
    return whereLastChar != -1;
//    if (index == -1) {
//      return false;
//    } else {
//      return true;
//    }

  }
}
