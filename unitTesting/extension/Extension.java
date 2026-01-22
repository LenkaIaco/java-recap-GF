package unitTesting.extension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aze on 2017.04.04..
 */
public class Extension {
  public static void main(String[] args) {
    Extension exampleClass = new Extension();
/**    If the variable value exceeds the capacity of the variable type - int max val + 1; the number being returned
 * stops making sense. This is java's way to signalize that the input  being manipulated is incorrect
 */
//    System.out.println(exampleClass.add(Integer.MAX_VALUE + 1, 0));
//
//    List<Integer> integerList = Arrays.asList(1, 4, 3, 5, 2, 2, 2, Integer.MAX_VALUE+1);
//    integerList.sort(Comparator.naturalOrder());
//    System.out.println(integerList.toString());

  }

  int add(int a, int b) {
    return a+b;
  }

  int maxOfThree(int a, int b, int c) {
    if (a > b) {
      if (a > c) {
        return a;
      } else {
        return c;
      }
    } else if (b < c) {
      return c;
    } else {
      return b;
    }
  }


  int median(List<Integer> pool) {
//    https://www.calculatorsoup.com/calculators/statistics/mean-median-mode.php
    pool.sort(Comparator.naturalOrder());
    return pool.get((pool.size() - 1) / 2);
  }

  boolean isVowel(char c) {
    Character convertedC = Character.toLowerCase(c);
    System.out.println(convertedC);
    return Arrays.asList('a', 'u', 'o', 'e', 'i', 'y').contains(convertedC);
  }

  //  String translate(String hungarian) {
//    String teve = hungarian;
//    int length = teve.length();
//    for (int i = 0; i < length; i++) {
//      char c = teve.charAt(i);
//      if (isVowel(c)) {
//        teve = String.join(c + "v" + c, teve.split("" + c));
//        i += 2;
//        length += 2;
//      }
//          }
//    return teve;
//  }
  String correctTranslate(String expression) {
    if (expression == null) {return null;}
    expression = expression.toLowerCase();
//  https://stackoverflow.com/questions/6319775/java-collections-convert-a-string-to-a-list-of-characters
    List<Character> characterList =
        expression.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
    Iterator<Character> it = characterList.iterator();
    ArrayList<Character> vowelsAlreadyUsed = new ArrayList<>();
    while (it.hasNext()) {
      Character c = it.next();
      if (isVowel(c.charValue()) && !vowelsAlreadyUsed.contains(c)) {
        if (c.charValue() == expression.charAt(expression.length() - 1)) {
          expression = String.join(c + "v" + c, expression.split("" + c)) + c + "v" + c;
          vowelsAlreadyUsed.add(c);
        } else {
          expression = String.join(c + "v" + c, expression.split("" + c));
          vowelsAlreadyUsed.add(c);
        }
      }
    }
    return expression;

  }


}
// Check out the folder. There's a work file and a test file.

//  -  Run the tests, all 10 should be green (passing).
//  -  The implementations though are not quite good.
//  -  Create tests that'll fail, and will show how the implementations are wrong(You can assume that the implementation of join and split are good)
//  -  After creating the tests, fix the implementations
//  -  Check again, if you can create failing tests
//  -  Implement if needed
