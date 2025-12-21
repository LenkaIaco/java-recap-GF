package Functions.Exercises;

import java.util.ArrayList;
import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
//        Create a function named isAnagram() following your current language's style guide.
//        It should take two strings and return a boolean value depending on whether it's an anagram or not.
//       The function should ignore the letter case as well as any non (latin) letter characters
       boolean myWordCheck = isAnagram("hello", "olleh");
        System.out.println(Boolean.toString(myWordCheck));

    }
    public static boolean isAnagram(String a, String b){
        boolean result = true;
        char[] charA = a.toCharArray();
        char[] charB =  b.toCharArray();

        //option 1:
        Arrays.sort(charA); // time complexity O(n logn)
        Arrays.sort(charB);

        //option 2:
//        mySort(charA); // time complexity O(n^2)
//        mySort(charB);

        for (int i = 0; i < charA.length; i++) {
            if (charA[i]!=charB[i]){
           result = false;
            return result;}
        }
        return result;

        //option 3:
//        ArrayList charAAslist = new ArrayList();
//        ArrayList charBAslist = new ArrayList();
//        for (int i = 0; i < charA.length; i++) {
//            charAAslist.add(charA[i]);
//        }
//        for (int j = 0; j < charB.length; j++) {
//            charBAslist.add(charB[j]);
//        }
//        if ((charAAslist.containsAll(charBAslist)) && (charAAslist.size()==charBAslist.size())){
//            return true;
//        }else {return false;}


    };



public static void mySort (char [] arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int y = i + 1; y < arr.length; y++) {
            if (arr[i] > arr[y]) {
                char temp = arr[i];
                arr[i] = arr[y];
                arr[y] = temp;
            }
        }
    }
}



}
