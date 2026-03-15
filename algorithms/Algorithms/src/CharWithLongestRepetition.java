import java.util.Arrays;

public class CharWithLongestRepetition {
//    https://www.codewars.com/kata/586d6cefbcc21eed7a001155
    /*
    For a given string s find the character c (or C) with longest consecutive repetition and return:
    Object[]{c, l};
    where l (or L) is the length of the repetition. If there are two or more characters with the same l return the first in order of appearance.

    For empty string return:
    Object[]{"", 0}
     */
public static void main(String[] args) {
    String s = "aaabbcdcdccc";
    System.out.println(Arrays.toString(longestRepetition(s)));  //exp.{"a", 3}
    System.out.println(Arrays.toString(longestRepetition("aaaabb")));  //exp.{"a", 4}
    System.out.println(Arrays.toString(longestRepetition("bbbaaabaaaa")));  //exp.{"a", 4}
    System.out.println(Arrays.toString(longestRepetition("cbdeuuu900")));  //exp.{"u", 3}
    System.out.println(Arrays.toString(longestRepetition("abbbbb")));  //exp.{"b", 5}
    System.out.println(Arrays.toString(longestRepetition("aabb")));  //exp.{"a", 2}
    System.out.println(Arrays.toString(longestRepetition("")));  //exp.{"", 0}

}

public static Object[] longestRepetition(String s){
    if (s==null){return null;}
    if(s.isEmpty()){return new  Object[]{"", 0};}

    char maxChar = (char)0;
    int maxCount = 0;
    char otherChar = (char)0;
    char otherCount = 0;

    for (int i=0;i<s.length();i++){
        if (i==0){maxChar = s.charAt(i); maxCount = 1;}
        else {
            if (s.charAt(i)==maxChar){
                if (s.charAt(i-1)==maxChar) {
                    maxCount++; } else{
                    if (otherChar==maxChar){
                        otherCount++;
                        if (maxCount<otherCount){
                            maxCount = otherCount;
                            otherChar = (char)0;
                            otherCount = 0;
                        }
                    }
                    else{
                        otherChar=maxChar;
                        otherCount = 1;
                    }
                }
            }
            else if (s.charAt(i)==otherChar){
                otherCount++;
                if (maxCount<otherCount){
                    maxChar = otherChar;
                    maxCount = otherCount;
                    otherChar = (char)0;
                    otherCount = 0;
                }
            }
            else{
                if (maxCount<otherCount){
                    maxChar = otherChar;
                    maxCount = otherCount;
                    otherChar = s.charAt(i);
                    otherCount = 1;
                } else {
                    otherChar = s.charAt(i);
                    otherCount = 1;
                }
            }
        }
    }
    return new Object[]{String.valueOf(maxChar), maxCount};
}
}
