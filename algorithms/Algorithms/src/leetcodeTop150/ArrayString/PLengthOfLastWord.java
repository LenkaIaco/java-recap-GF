package leetcodeTop150.ArrayString;

public class PLengthOfLastWord {
    public static void main(String[] args) {
        String s = "Hello World";
        String s1 = "   fly me   to   the moon  ";
        String s2 =  "luffy is still joyboy";
        System.out.println(lengthOfLastWord(s));
        System.out.println(lengthOfLastWord(s1));
        System.out.println(lengthOfLastWord(s2));
    }
    public static int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }
}
