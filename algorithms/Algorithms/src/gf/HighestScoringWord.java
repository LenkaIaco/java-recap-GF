package gf;

import java.util.HashMap;
import java.util.Map;

public class HighestScoringWord {
    //https://www.codewars.com/kata/57eb8fcdf670e99d9b000272
    /*
    Given a string of words, you need to find the highest scoring word.
Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.

For example, the score of abad is 8 (1 + 2 + 1 + 4).

You need to return the highest scoring word as a string.
If two words score the same, return the word that appears earliest in the original string.

All letters will be lowercase and all inputs will be valid.
     */

    public static void main(String[] args) {
    String s = "abad aa bb";
    String s1 = "daba b abad";

        System.out.println(highestScoring(s)); // ex. output abad
        System.out.println(highestScoring(s1));  // ex. out:  daba
    }

    public static String highestScoring(String s){
        int index = 0;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] arr = alphabet.toCharArray();
        Map<Character,Integer> mapChart = new HashMap<>();
        for (int i=0; i<arr.length;i++){
            mapChart.put(arr[i], i+1);
        }

        String[] words = s.split(" ");
        int[] scores = new int[words.length];
        for (int i=0;i<words.length;i++){
            int wordScore = 0;
            for (int y=0; y<words[i].length();y++){
                int letterScore = mapChart.get(words[i].charAt(y));
                wordScore+=letterScore;
            }
            scores[i]=wordScore;
        }

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i<scores.length; i++){
            if (scores[i]>max){
                maxIndex = i;
                max = scores[i];
            }
        }

        return words[maxIndex];
    }
}
