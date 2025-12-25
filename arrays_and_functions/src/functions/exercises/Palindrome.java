package Functions.Exercises;

public class Palindrome {
    public static void main(String[] args) {
//        Create a function named build() following your current language's style guide.
//        It should take a string, create a palindrome from it and then return it.
       String result = build("Palindrome");
        System.out.println(result);
}

    public static String build (String baseText){
        char[] baseArray = baseText.toCharArray();
        char[] palindromeArray = new char[(baseArray.length)*2]; // alternatively: new char[(baseArray.length)*2 -1];

        for (int i = 0; i < baseArray.length; i++) {
            palindromeArray[i] = baseArray[i];
            palindromeArray[palindromeArray.length-1-i] = baseArray[i];
        }
        return String.valueOf(palindromeArray);

        /* alternatively:
        StringBuilder sb = new StringBuilder(baseText);
        String reversedText = sb.reverse().toString();
         */

//        https://beginnersbook.com/2014/06/how-to-convert-a-char-array-to-a-string-in-java/
//        alternatively:
//        String result = new String(palindromeArray);
//        return result;

    }
}
