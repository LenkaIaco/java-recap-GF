package unitTesting.anagram;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnagramTest {

  Anagram example;
  @BeforeEach
  void instance(){
    example = new Anagram();
  }

  @Test
  void twoStringsAreEachOthersAnagramShouldReturnTrue() {
    String one = "silent";
    String two = "listen";

    assertEquals(true, example.isAnagram(one, two));
  }

  @Test
  void twoStringsNotEachOthersAnagramShouldReturnFalse(){
    String one = "silent";
    String two = "salent";
    assertEquals(false, example.isAnagram(one, two));
  }

  @Test
  void StringsHaveDifferentCountOfCharactersShouldReturnFalse(){
    String one = "silent";
    String two = "silentt";
    assertEquals(false, example.isAnagram(one, two));
  }

  @Test
  void emptyStringsComparisomShouldReturnZero(){
    String one = "";
    String two = "";
    assertEquals(true, example.isAnagram(one, two));
}

@Test
  void nullStringComparisomShouldReturnNull(){
    String one = null;
    String two = null;
    assertEquals(false, example.isAnagram(one, two));
}
}
