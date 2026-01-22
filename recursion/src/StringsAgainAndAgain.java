public class StringsAgainAndAgain {
    /** Task:
     // Given a string, write a recursive (no loops) method which returns a new
     // string with all adjacent chars separated by an `*`. Please note that there
     // should be no trailing `*` at the end of the returned string. For example,
     // the string `word` should be changed to `w*o*r*d`.
     */
    public static void main(String[] args) {
        System.out.println(addAsterisk("word"));
        System.out.println(addAsterisk("stars"));
    }

    public static String addAsterisk(String s){
        if (s==null || s.length()==0){return "";}
        if (s.length()==1){return s;}

        return String.valueOf(s.charAt(0))
                .concat("*")
                .concat(addAsterisk(s.substring(1)));
    }
}
