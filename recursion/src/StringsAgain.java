public class StringsAgain {
    /**Task:
     * // Given a string, write a recursive (no loops) method which returns
     * // a new string with the lowercase 'x' chars removed.
     */
    public static void main(String[] args) {
        System.out.println(xCharsRemoved("Cinemaxxx"));
        System.out.println(xCharsRemoved("luckx-duckx"));
        System.out.println(xCharsRemoved("xx"));

    }

    public static String xCharsRemoved(String s){
        if (s == null || s.length()==0){return "";}
        if (s.charAt(0)=='x'){
            return xCharsRemoved(s.substring(1));
        }
        return String.valueOf(s.charAt(0)).concat(xCharsRemoved(s.substring(1)));
    }
}
