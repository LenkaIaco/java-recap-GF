package unitTesting.cowsAndBulls;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CowsAndBullsTest {
    CowsAndBulls newGame;

    @BeforeEach
    void init() {
        newGame = new CowsAndBulls();
    }

    @Test
    void constructorAndGetterMethodsReturnEmptyClassFields() {
        assertEquals(0, newGame.getCows());
        assertEquals(0, newGame.getBulls());
        assertEquals(4, newGame.getNumberOfDigits());
        assertEquals("", newGame.getNumberToGuess());
    }

    @Test
    void guessTheNumberParameterNullReturnsEmptyString() {
        assertEquals("", newGame.guessTheNumber(null));
    }

    @Test
    void guessTheNumberParameterEmptyStringReturnsEmptyString() {
        assertEquals("", newGame.guessTheNumber(""));
    }

    @Test
    void guessTheNumberUserPromptToAdjustParameterLengthTo_4() {
        //        https://stackoverflow.com/questions/6415728/junit-testing-with-simulated-user-input
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream byteInReplacement = new ByteArrayInputStream("1234".getBytes());
        System.setIn(byteInReplacement);
        System.out.println(newGame.guessTheNumber("123"));
        System.setIn(sysInBackup);
    }

    @Test
    void guessTheNumberUserPromptToInsertNumbersInsteadOfLetters() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream byteInReplacement = new ByteArrayInputStream("1234".getBytes());
        System.setIn(byteInReplacement);
        System.out.println(newGame.guessTheNumber("1A23"));
        System.setIn(sysInBackup);
    }
//   in this scenario, the only possible assert equals test is, if user gets luckily a hit on all four digits:
//String randomNumber = newGame.getNumberToGuess();
//    if randomNumber == userCorrectedGuess
//    assertEquals("4 cows, 0 bulls", guessTheNumber(userCorrectedGuess))
//   ...otherwise, just manual tests being run
    @Test
    void guessTheNumberAccountsMultipleDigitsOfSameValue() {
        System.out.println(newGame.guessTheNumber("4444"));
    }

}