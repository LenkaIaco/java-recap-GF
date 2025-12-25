public class ReverseString {
    public static void main(String... args) {//varargs
        String toBeReversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";

        // Create a method that can reverse a string which is passed as parameter
        // The method should return the reversed string
        // Pass the `toBeReversed` variable to this method to check if it works well
        // At first, solve this task using the `charAt()` function
        // Try other solutions when you are done

        System.out.println(reverse(toBeReversed));
    }
//    option 1: reverse iteration:
//    public static String reverse (String text){
//        char[] intermediate = new char[text.length()];
//
//        for (int i = 0; i < text.length(); i++) {
//            intermediate[i] = text.charAt(text.length()-1-i);
//        }
//        String s = new String(intermediate); // or String.valueOf(intermediate);
//        return s;
//    }

//    option 2: StringBuilder built-in function reverse:

    public static String reverse (String text){
        StringBuilder sb = new StringBuilder(text);
        sb.reverse();

        return sb.toString();
    }
}
