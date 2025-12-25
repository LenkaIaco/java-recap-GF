public class TakesLonger {
    public static void main(String[] args) {
        String quote = "Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.";

        // When saving this quote a disk error has occurred. Please fix it!
        // Insert the words "always takes longer than" between the words "It" and "you" using the StringBuilder class!

        //alternative 1
        String fix = quote.replaceFirst("It you", "It always takes longer than you");
        //alternative 2
        StringBuilder sb = new StringBuilder(quote);
        int indexOfYou = quote.indexOf("you");
        sb.insert(indexOfYou, "always takes longer than ");

        System.out.println(fix);
        System.out.println(sb);
    }
}