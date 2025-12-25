import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class QuoteSwap {
    public static void main(String... args) {

        List<String> list = Arrays.asList("What", "I", "do", "create,", "I", "cannot", "not", "understand.");

        // Accidentally I messed up this quote from Richard Feynman
        // Two words are out of place
        // Your task is to fix it by swapping the right words with code
        // To do this: create a method called "swapQuote()"
        // it should return a sentence formed from the words separated by a single space

        // Expected output: "What I cannot create, I do not understand."
        System.out.println(swapQuote(list));

    }

    public static String swapQuote(List<String> list) {
        int positionCannot = list.indexOf("cannot");
        int positionDo = list.indexOf("do");
        List<String> list2 = new ArrayList<>();
        list2.addAll(list);
        System.out.println(list2);

        list2.remove("cannot");
        list2.add(positionCannot, "do");
        list2.remove("do");
        list2.add(positionDo, "cannot");
        String resultString = "";
        for (int i = 0; i < list2.size(); i++) {
            if (i == 0) {
                resultString = list2.get(i);
            } else {
                resultString = resultString + " " + list2.get(i);
            }
        }
        return resultString;
    }
}
