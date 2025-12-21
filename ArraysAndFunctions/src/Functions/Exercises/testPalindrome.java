package Functions.Exercises;

import java.util.ArrayList;
import java.util.Arrays;

public class testPalindrome {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(search("lalala heleh")));
    }

    public static Object[] search(String text) {

        char[] textToArray = text.toCharArray();
        ArrayList<String> arrayOfPalindromes = new ArrayList<>();
        int continueCharVer = 0;

        for (int arrayEnd = 0; arrayEnd < textToArray.length; arrayEnd++) {
            for (int arrayStart = 0; arrayStart < textToArray.length; arrayStart++) {
               int palindromeWordLength = textToArray.length - arrayEnd - arrayStart;
                if (palindromeWordLength >= 3) {
                    char[] palindromeWord = new char[textToArray.length - arrayEnd - arrayStart];
                    int dNumberOfLoops = (textToArray.length - arrayEnd - arrayStart + 1) / 2;
//                    if (palindromeWord.length >= 3) {
                        for (int d = 0; d < dNumberOfLoops; d++) {
                            int charStartIndex = arrayStart + d;
                            int charEndIndex = textToArray.length - 1 - arrayEnd - d;

                            if (textToArray[charStartIndex] == textToArray[charEndIndex]) {
                                palindromeWord[d] = textToArray[arrayStart + d];
                                palindromeWord[textToArray.length - 1 - arrayStart - arrayEnd - d] = textToArray[arrayStart + d];
                                continueCharVer = 1;
                            } else {
                                continueCharVer = 3;
                                for (int i = 0; i < palindromeWord.length; i++) {
                                    palindromeWord[i] = ' ';
                                }
                                break;
                            }
                        }
                        if (continueCharVer == 1) {
                            String finalWordConversion = new String(palindromeWord);
                            arrayOfPalindromes.add(finalWordConversion);
                            continueCharVer = 0;
                            for (int i = 0; i < palindromeWord.length; i++) {
                                palindromeWord[i] = ' ';
                            }
                        }
//                    }

                }
            }
        }

//        code written without end position offset first (no for loop considering arrayEnd):
//        for (int j = 0; j < textToArray.length; j++) {
//            char[] palindromeWord = new char[textToArray.length - j];
//            int dNumberOfLoops = (textToArray.length - j + 1) / 2;
//        if (palindromeWord.length >=3) {
//            for (int d = 0; d < dNumberOfLoops; d++) {
//                int charStartIndex = j + d;
//                int charEndIndex = textToArray.length - 1 - d;
//
//                if (textToArray[charStartIndex] == textToArray[charEndIndex]) {
//                    palindromeWord[d] = textToArray[j + d];
//                    palindromeWord[textToArray.length - 1 - j - d] = textToArray[j + d];
//                    continueCharVer = 1;
//                } else {
//                    continueCharVer = 3;
//                    for (int i = 0; i < palindromeWord.length; i++) {
//                        palindromeWord[i] = ' ';
//                    }
//                    break;
//                }
//            }
//
//            if (continueCharVer == 1) {
//                String finalWordConversion = new String(palindromeWord);
//                arrayOfPalindromes.add(finalWordConversion);
//                continueCharVer = 0;
//                for (int i = 0; i < palindromeWord.length; i++) {
//                    palindromeWord[i] = ' ';
//                }
//            }
//        } }

        Object[] objectArray = arrayOfPalindromes.toArray();
            return objectArray;
    }
}
