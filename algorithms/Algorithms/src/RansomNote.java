import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class RansomNote {
//    https://www.hackerrank.com/challenges/ctci-ransom-note/problem

/*
A kidnapper wants to know if he can cut out whole words from a magazine and use them to create
an untraceable replica of his ransom note (case-sensitive).
Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.
Example
 magazine = "attack at dawn"   ransom note = "Attack at dawn"
The magazine has all the right words, but there is a case mismatch. The answer is No.

Function checkMagazine has the following parameters:

string magazine[m]: the words in the magazine
string note[n]: the words in the ransom note
 */
public static void main(String[] args) {
    List<String> magazine = new ArrayList<>(Arrays.asList("two times three is not four".split(" ")));
    List<String> note = new ArrayList<>(Arrays.asList("two times two is four".split(" ")));
    List<String> magazine1 = new ArrayList<>(Arrays.asList("give me one grand today night".split(" ")));
    List<String> note1 = new ArrayList<>(Arrays.asList("give one grand today".split(" ")));
    List<String> magazine2 = new ArrayList<>(Arrays.asList("ive got a lovely bunch of coconuts".split(" ")));
    List<String> note2 = new ArrayList<>(Arrays.asList("ive got some coconuts".split(" ")));


    System.out.println(checkMagazine(magazine,note)); //exp. result No
    System.out.println(checkMagazine(magazine1,note1)); //exp. result Yes
    System.out.println(checkMagazine(magazine2,note2)); //exp. result No

}

    public static String checkMagazine (List<String> magazine, List<String> note){
        for (int i=0; i<note.size();i++) {
            if (magazine.contains(note.get(i))){
                magazine.remove(note.get(i));
            } else {return "No";}
        }
        return "Yes";
    }
}