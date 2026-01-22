package unitTesting.anagram;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ATest{
    @Test
    void stringsOfDifferentSizesReturnFalse(){
        String s1 = "A";
        String s2 = "A ";
     assertEquals(A.isAnagram(s1, s2), false);
    }

    @Test
    void anyEmptyStringParameterReturnsFalse(){
        String s1 = "A";
        String s2 = "";
        assertEquals(A.isAnagram(s1,s2),false);
    }

    @Test
    void comparisomIgnoresCaseOfCharacters(){
        String s1 = "A";
        String s2 = "a";
        assertEquals(A.isAnagram(s1,s2),true);
    }

    @Test
    void multipleTwinCharactersAreComparedSeparately(){
    String s1 = "wordd";
    String s2 = "wword";
    assertEquals(A.isAnagram(s1,s2),false);
    }

    @Test
    void anagramWordsReturnTrue(){
        String s1 = "boat";
        String s2 = "bota";
        assertEquals(A.isAnagram(s1,s2),true);
    }


}
