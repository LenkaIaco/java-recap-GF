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


    public static String swapQuote(List<String> l) {
        int indexDo = l.indexOf("do");
        int indexCannot = l.indexOf("cannot");
        l.set(indexDo, "cannot");
        l.set(indexCannot, "do");
        String s = "";

        for (int i = 0; i < l.size() - 1; i++) {
            s = s.concat(l.get(i)).concat(" ");
        }
        s = s.concat(l.get(l.size() - 1));

        return s;
    }
}
