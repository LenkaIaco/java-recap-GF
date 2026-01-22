package unitTesting.anagram;

public class A {
    public static void main(String[] args) {
        Anagram example = new Anagram();
        System.out.println(example.isAnagram("listen", "silentt"));
        System.out.println(example.isAnagram("listen", "silent"));
    }

    public static boolean isAnagram(String s1, String s2) {

        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        for (int i = 0; i < s2.length(); i++) {
            if (s1.length() == 0) {
                return false;
            }
            if (!s1.contains(String.valueOf(s2.charAt(i)))){
                return false;
            }

            //    s1 = s1.replace(s2.charAt(i), (char)0);    // default value for empty char is NOT '' but: (char)
            s1 = s1.replaceFirst(String.valueOf(s2.charAt(i)), ""); //works only for strings
        }

        return true;
    }
}