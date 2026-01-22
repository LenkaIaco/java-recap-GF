package unitTesting.extension;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by aze on 2017.04.04..
 */
class Extension2Test {

    Extension2 extension = new Extension2();

    @Test
    void testAdd_2and3is5() {
        assertEquals(4, extension.add(2, 2));
    }

    @Test
    void testAdd_1and4is5() {
        assertEquals(5, extension.add(1, 4));
    }

    @Test
    void testMaxOfThree_second() {
        assertEquals(5, extension.maxOfThree(4, 5, 3));
    }

    @Test
    void testMaxOfThree_firstAndSecond() {
        assertEquals(5, extension.maxOfThree(5, 5, 4));
    }

    @Test
    void testMedian_four() {
        assertEquals(5, extension.median(Arrays.asList(5,7,3,5)));
    }

    @Test
    void testMedian_five() {
        assertEquals(3, extension.median(Arrays.asList(3,2,1,4,5)));
    }

    @Test
    void testIsVowel_a() {
        assertTrue(extension.isVowel('a'));
    }

    @Test
    void testIsVowel_u() {
        assertTrue(extension.isVowel('u'));
    }

    @Test
    void testTranslate_bemutatkozik() {
        assertEquals("bEvEmuvutavatkovozivik", extension.translate("bEmutatkozik"));
    }

    @Test
    void testTranslate_lagopus() {
        assertEquals("lAvAgovopuvus", extension.translate("lAgopus"));
    }
}