import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakingAnagrams {
    // https://www.hackerrank.com/challenges/ctci-making-anagrams
    /*
    Two strings are anagrams if the 1st string's letters can be rearranged to the 2nd string.
    Given two strings, that may or may not be of the same length,
    determine the minimum number of character deletions required to make anagrams.

    Example
        abc
        cfb
        Takes 2 deletions

     */
    public static void main(String[] args) {
        System.out.println(makeAnagram("abc", "cfb")); //exp.2
        System.out.println(makeAnagram2("abc", "cfb")); //exp.2
    }

    public static int makeAnagram(String a, String b) {
        if (a==null || b == null || a.isEmpty() ||b.isEmpty()) {return 0;}
        int anagramCounter = 0;
        StringBuilder sbB = new StringBuilder(b);
        for (int i =0; i<a.length();i++){
            if (sbB.length()==0){break;}
            int index = sbB.indexOf(String.valueOf(a.charAt(i)));
            if (index!=-1){
                anagramCounter++;
                sbB.deleteCharAt(index);
            }
        }

        int deletionsA = a.length()-anagramCounter;
        int deletionsB = b.length()-anagramCounter;
        return deletionsA + deletionsB;
    }

    //implementing with charArray deletions the way SB's deleteCharAt() works:
    public static int makeAnagram2(String a, String b) {
        if (a==null || b == null || a.isEmpty() ||b.isEmpty()) {return 0;}
        int anagramCounter = 0;
        char[] deletableB = b.toCharArray();
        int modSize = deletableB.length;

        for (int i=0; i<a.length();i++){
            if(modSize==0){break;}
            char charA = a.charAt(i);

            for (int y=0;y<modSize;y++){
                if (deletableB[y]==charA){
                    anagramCounter+=1;
                    for(int z=y;z<modSize-1;z++){
                        deletableB[z] = deletableB[z+1];
                    }
                    modSize--;
                    break;
                }
            }
        }

        int deletionsA = a.length()-anagramCounter;
        int deletionsB = b.length()-anagramCounter;
        return deletionsA+deletionsB;
    }
}
