package unitTesting.countLetters;

import java.util.HashMap;

public class CountLetters {
//  Write a function, that takes a string as an argument and returns a dictionary with all letters in the string
//  as keys, and numbers as values that shows how many occurrences there are.

  public static void main(String[] args) {
    CountLetters cl = new CountLetters();
    System.out.println(cl.textIntoDictionary("Hello World"));
  }

  public HashMap<Character, Integer> textIntoDictionary(String text) {
    HashMap<Character, Integer> dictionary = new HashMap<>();
    if (text == null) { // methods text.isBlank() and text.isEmpty() dont work on null String
      return dictionary;}
    text = text.toLowerCase();
    for (int i = 0; i < text.length(); i++) {
      if (dictionary.containsKey(text.charAt(i))) {
        int count = dictionary.get(text.charAt(i));
        dictionary.put(text.charAt(i), count + 1);
      } else {
        dictionary.put(text.charAt(i), 1);
      }
    }
    return dictionary;
  }

}
