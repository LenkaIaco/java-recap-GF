package unitTesting.extension;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;


import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;

class ExtensionTest {

  Extension extension = new Extension();

//  We do not test with input value exceeding the parameter input type, that is not the code logic testing, but it
//  would be testing the way how Java program works:

//  @Test
//  if result number is larger than the capacity of an int, why does it return this negative number -2147483648  ?
//  void addWithInputLargerThanParameterTypeCapacity() {
//    assertEquals(Integer.MAX_VALUE+3, extension.add(Integer.MAX_VALUE, 3));
//  }


//  if result number is larger than the capacity of an int, why does it return this negative number?
//  do we need to test this scenario or not?
  /**    If the variable value exceeds the capacity of the variable type - int max val + 1; the number being returned
   * stops making sense. This is java's way to signalize that the input  being manipulated is incorrect.
   * We do not need to test for this scenario.
   */
//  @Test
//  void addResultLargerThanOutputTypeCapacity() {
//    assertEquals(-2147483648, extension.add(Integer.MAX_VALUE+1, 0));
//  }

  @Test
  void maxOfThreeReturnsParam1() {
    assertEquals(4, extension.maxOfThree(4, 1, 2));
  }
  @Test
  void maxOfThreeParameterTypeCapacityExceededGetsIgnoredInComparisom() {
    assertEquals(Integer.MAX_VALUE+1, extension.maxOfThree(Integer.MAX_VALUE+1, 1, 2));
  }


@Test
  void maxOfThreeReturnsParam2() {
    assertEquals(5, extension.maxOfThree(1, 5, 2));
  }
@Test
  void maxOfThreeReturnsParam3() {
    assertEquals(4, extension.maxOfThree(3, 1, 4));
  }

  @Test
  void testMedianReturns_five_withUnorderedListOfNumbers() {
    assertEquals(2, extension.median(Arrays.asList(1, 4, 3, 5, 2, 2, 2)));
  }

//  We do not test scenarios with exceeding the capacity of the primitive data type used(see explanation above)
//  @Test
//  void testMedianContainingAParameterExceedingCapacityOfItsTypeGetsIgnored(){
//    List<Integer> integerList = Arrays.asList(1, 4, 3, 5, 2, 2, 2, Integer.MAX_VALUE+1);
//    integerList.sort(Comparator.naturalOrder());
//    assertEquals(2, extension.median(integerList));
//  }
  @Test
  void testIsVowel_y() {
    assertTrue(extension.isVowel('y'));
  }
  @Test
  void testIsVowel_Uppercase() {
    assertTrue(extension.isVowel('A'));
  }

  @Test
  void testTranslate_mydlo() {
    assertEquals("myvydlovo", extension.correctTranslate("mydlo"));
  }

  @Test
  void testTranslate_AVOCADO_returnsLowercase() {
    assertEquals("avavovocavadovo", extension.correctTranslate("AVOCADO"));
  }

  @Test
  void testTranslateInputEmptyStringReturnsEmptyString(){
    assertEquals("", extension.correctTranslate(""));
  }

  @Test
  void testTranslateInputNullStringReturnsNull(){
    assertEquals(null, extension.correctTranslate(null));
  }

//Original exercise template methods:
  //  @Test
//  void testAdd_2and3is5() {
//    assertEquals(5, extension.add(2, 3));
//  }
//
//  @Test
//  void testAdd_1and4is5() {
//    assertEquals(5, extension.add(1, 4));
//  }

//  @Test
//  void testMaxOfThree_first() {
//    assertEquals(5, extension.maxOfThree(5, 4, 3));
//  }

//  @Test
//  void testMaxOfThree_third() {
//    assertEquals(5, extension.maxOfThree(3, 4, 5));
//
  //  @Test
//  void testMedian_four() {
//    assertEquals(5, extension.median(Arrays.asList(7,5,3,5)));
//  }
//
//  @Test
//  void testMedian_five() {
//    assertEquals(3, extension.median(Arrays.asList(1,2,3,4,5)));
//  }
//  @Test
//  void testIsVowel_a() {
//    assertTrue(extension.isVowel('a'));
//  }
//
//  @Test
//  void testIsVowel_u() {
//    assertTrue(extension.isVowel('u'));
//  }
  //  @Test
//  void testTranslate_bemutatkozik() {
//    assertEquals("bevemuvutavatkovozivik", extension.translate("bemutatkozik"));
//  }

//  @Test
//  void testTranslate_lagopus() {
//    assertEquals("lavagovopuvus", extension.translate("lagopus"));
//  }

}

