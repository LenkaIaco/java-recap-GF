package unitTesting.cowsAndBulls;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class CABTest {
    CAB testGame = new CAB();

    @Test
    void defaultConstructorReturnsEmptyFields(){
        assertEquals(new HashMap<>(), testGame.getCountCAB());
        assertEquals("", testGame.getMyGuess());
        assertEquals(false, testGame.isPlaying());
        assertEquals(0, testGame.getCounter());
        assertEquals(CAB.class, testGame.getClass());
    }

    @Test
    void printResultReturnsStringWithPredefinedDefaultValues(){
        String gameStartStatus = "null cow, null bull";
        assertEquals(gameStartStatus, testGame.printResult());
    }

    @Test
    void finalizeGameChangesEndStatusAccordingToGameResults() {

        String myInputs = "y\n" + "4567\n" + "n";
        InputStream myInputStream = new ByteArrayInputStream(myInputs.getBytes());
        Scanner scanner = new Scanner(myInputStream);

        String gameStartStatus = "null cow, null bull";
        assertEquals(gameStartStatus, testGame.printResult());
        assertEquals("Game result: "+ gameStartStatus,testGame.finalizeGame());

        testGame.run(scanner);

        assertNotEquals(gameStartStatus, testGame.printResult());
        assertNotEquals("Game result: "+gameStartStatus, testGame.finalizeGame());
    }


    @Test
   void onlyDigitsReturnsFalseWithNonDigitInput(){
        assertEquals(false, testGame.onlyDigits("1A23"));

    }

    @Test
    void onlyDigitsReturnsTrueForCorrectFormat(){
        assertEquals(true, testGame.onlyDigits("1234567890"));
    }

    @Test
    void setupNewGameTransformsNullHashMapValuesIntoDefaults(){
        HashMap<String, Integer> mapNullValuesInside = new HashMap<>();
        assertEquals(mapNullValuesInside,testGame.getCountCAB());
        testGame.setupNewGame();
        HashMap<String, Integer> mapWithDefaults = mapNullValuesInside;
        mapWithDefaults.put("cow",0);
        mapWithDefaults.put("bull",0);
        assertEquals(mapWithDefaults, testGame.getCountCAB());
    }



}
