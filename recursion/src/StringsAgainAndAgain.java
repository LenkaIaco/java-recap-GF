public class StringsAgainAndAgain {
    /** Task:
     // Given a string, write a recursive (no loops) method which returns a new
     // string with all adjacent chars separated by an `*`. Please note that there
     // should be no trailing `*` at the end of the returned string. For example,
     // the string `word` should be changed to `w*o*r*d`.
     */
    public static void main(String[] args) {
        System.out.println(starText("stars"));
    }

    public static String starText(String s) {
        if (s.length() == 1) {
            return s;
        } else {
            String sub = s.substring(1);
            return s.charAt(0) + "*" + starText(sub);
        }
    }
}
