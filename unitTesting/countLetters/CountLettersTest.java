package unitTesting.countLetters;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CountLettersTest {
  CountLetters testingClass;
  HashMap<Character, Integer> idealResult;

  @BeforeEach
  public void init() {

    testingClass = new CountLetters();
    idealResult = new HashMap<>();

  }

  @Test
  public void countMultipleLetterOccurences() {
    String testText = "hohoho";
    idealResult.put('h', 3);
    idealResult.put('o', 3);
    assertEquals(idealResult, testingClass.textIntoDictionary(testText));
  }
  @Test
  public void populateArrayFromText() {
    String testText = "ho";
    idealResult.put('h', 1);
    idealResult.put('o', 1);
    assertEquals(idealResult, testingClass.textIntoDictionary(testText));
  }
  @Test
  public void countUppercaseAsWellAsLowercaseTogether (){
    String testText = "hoHO";
    idealResult.put('h', 2);
    idealResult.put('o', 2);
    assertEquals(idealResult, testingClass.textIntoDictionary(testText));
  }

  @Test
  public void testEmptyStringInput(){

    assertEquals(idealResult, testingClass.textIntoDictionary(""));
  }

  @Test
  public void testNullStringInput(){

    assertEquals(idealResult, testingClass.textIntoDictionary(null));

  }

}