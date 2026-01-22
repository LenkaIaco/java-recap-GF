package unitTesting.cowsAndBulls;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CowsAndBulls {

    private String numberToGuess;
    private GameState gameState;

    private int counterOfGuesses;
    private int cows;
    private int bulls;
    private int numberOfDigits;

    public CowsAndBulls() {
        cows = 0;
        bulls = 0;
        numberOfDigits = 4;
        numberToGuess = "";
        //        moving the random 4-digit number generation into the constructor for testing purposes:
        for (int i = 0; i < numberOfDigits; i++) {
            numberToGuess = numberToGuess + ((int) (Math.random() * 10));
        }
    }

    public int getCows() {
        return cows;
    }

    public int getBulls() {
        return bulls;
    }

    public int getNumberOfDigits() {
        return numberOfDigits;
    }

    public String getNumberToGuess() {
        return numberToGuess;
    }

    public String guessTheNumber(String fourDigitNumber) {

        if (fourDigitNumber == null||fourDigitNumber == "") {
            System.out.println("Please restart the game and insert a four digit number as your guess");
            return "";
        }

        Scanner myScanner = new Scanner(System.in);
        while (fourDigitNumber.length() != numberOfDigits) {
            System.out.println("Try again: Please insert a four digit number.");
            fourDigitNumber = myScanner.next();
        }

        String possibleDigits = "0123456789";
        boolean playerInputAreNumbers = true;
        char[] fourCharsPlayer = fourDigitNumber.toCharArray();
        boolean corrected = false;
        while (!corrected) {
            while (fourDigitNumber.length() != 4) {
                System.out.println("Try again: Please insert a four digit number, containing digits between 0 and 9");
                fourDigitNumber = myScanner.next();
                System.out.println(fourDigitNumber);
                fourCharsPlayer = fourDigitNumber.toCharArray();
                System.out.println(fourCharsPlayer);
            }
            for (int i = 0; i < numberOfDigits; i++) {
                if (!possibleDigits.contains(String.valueOf(fourCharsPlayer[i]))) {
                    playerInputAreNumbers = false;
                }
            }
            if (!playerInputAreNumbers) {
                playerInputAreNumbers = true;
//            System.out.println("Invalid input: required is a four digit number, containing digits between 0 and 9.\nPlease restart the game.");
//            return "";
                System.out.println("Try again: Please insert a four digit number, containing digits between 0 and 9");
                fourDigitNumber = myScanner.next();
                System.out.println(fourDigitNumber);
                fourCharsPlayer = fourDigitNumber.toCharArray();
                System.out.println(fourCharsPlayer);

            } else {
                corrected = true;
            }
        }
//ArrayList<Integer> numberToBeGuessed = new ArrayList<>();
//  int[] possibleDigits = {0,1,2,3,4,5,6,7,8,9};
        //  char[] fourCharsPlayer = fourDigitNumber.toCharArray();
//  ArrayList<Integer> fourIntegersPlayer = new ArrayList<>();

//        moving the random 4-digit number generation into the constructor for testing purposes:
//        for (int i = 0; i < numberOfDigits; i++) {
//            numberToGuess = numberToGuess + ((int) (Math.random() * 10));
//    numberToBeGuessed.add((int)Math.random()*10);
//    fourIntegersPlayer.add(Integer.valueOf(Character.valueOf(fourCharsPlayer[i]).toString()));
//        }
        System.out.println("Number to be guessed was:" + numberToGuess);
        StringBuilder numToGuess = new StringBuilder(numberToGuess);
        StringBuilder playerGuess = new StringBuilder(fourDigitNumber);

        for (int i = 0; i < numberOfDigits; i++) {
            if (playerGuess.charAt(i) != 'X') {
                int digitFoundAt = numToGuess.indexOf(String.valueOf(playerGuess.charAt(i)));
                if (digitFoundAt != -1) {
                    if (playerGuess.charAt(i) == numberToGuess.charAt(i)) {
                        cows++;
//      int indexOfGuessed = fourDigitNumber.indexOf(numberToGuess.charAt(i));
                        numToGuess.replace(i, i, "X");
                    } else if
                    (numberToGuess.charAt(digitFoundAt) == playerGuess.charAt(digitFoundAt)) {
                        cows++;
                        numToGuess.replace(digitFoundAt, digitFoundAt, "X");
                        playerGuess.replace(digitFoundAt, digitFoundAt, "X");
                    } else {
                        bulls++;
                        numToGuess.replace(digitFoundAt, digitFoundAt, "X");
                    }
                }
            }
        }
        String cowText;
        String bullText;
        if (cows == 1) {
            cowText = " cow";
        } else {
            cowText = " cows";
        }
        if (bulls == 1) {
            bullText = " bull";
        } else {
            bullText = " bulls";
        }

        return cows + cowText + ", " + bulls + bullText;
    }


}
