import java.util.*;

public class MostFrequentPhrase {
    public static void main(String[] args) {
        /**
         * Write a function that receives a sentence (string) as a parameter and returns the most frequent word of that sentence. If there is more than one such word return any one of them.
         *
         * Test the method with the sentence from John Updike’s 'Rabbit, Run':
         */

        String text = "But then they were married (she felt awful about being pregnant before but\n" +
                "Harry had been talking about marriage for a while and anyway laughed when\n" +
                "she told him in early February about missing her period and said Great she\n" +
                "was terribly frightened and he said Great and lifted her put his arms around\n" +
                "under her bottom and lifted her like you would a child he could be so\n" +
                "wonderful when you didn’t expect it in a way it seemed important that you\n" +
                "didn’t expect it there was so much nice in him she couldn’t explain to\n" +
                "anybody she had been so frightened about being pregnant and he made her\n" +
                "be proud) they were married after her missing her second period in March\n" +
                "and she was still little clumsy dark-complected Janice Springer and her\n" +
                "husband was a conceited lunk who wasn’t good for anything in the world Daddy\n" +
                "said and the feeling of being alone would melt a little with a little drink.";


        System.out.println(mostFreqWord(text));

        /**
         * Expected result: and
         *
         * BONUS: Using a simple split(" ") may produce some incorrect words, e.g. "(she" instead of "she" or "drink." instead of "drink". Can you fix that?
         *
         * a (a) a, b b c
         * Expected result: a
         */
    }

    public static String mostFreqWord(String text){
        String mostFrequentWord = "";

        String[] words = textToWords(text);
        Map<String,Integer>hm = new HashMap<>();

        for (int i=0; i< words.length; i++){
            if(hm.containsKey(words[i])){
                hm.put(words[i],hm.get(words[i])+1);
            } else{
                hm.put(words[i],1);
            }
        }

        Integer maxx = Collections.max(hm.values());

        for (Map.Entry<String,Integer> e:hm.entrySet()){
            if (e.getValue().equals(maxx)){
                mostFrequentWord =e.getKey();
            }
        }
        return mostFrequentWord;
    }

    public static String[] textToWords(String text){
        text = text.replace("(", "");
        text = text.replace(")", "");
        text = text.replace(".", "");
        text = text.replace("\n", " ");
        text = text.replace("-", " ");
        text = text.replace("/", " ");
//        text = text.replace("?", "");
//        text = text.replace("!", "");
//        text = text.replace(",", "");
//        text = text.replace(";", "");
//        text = text.replace(":", "");

        text = text.toLowerCase();

        String[] words = text.split(" ");

        return words;
    }


    /*
Without text.split() function:
//        int start =0;
//        int end = 0;
//        for (int i=0; i<text.length();i++){
//            if (text.charAt(i)==' '){
//                if (start<i){
//                    String key = text.substring(start,i);
//                    if(hm.containsKey(key)){
//                        hm.put(key,hm.get(key)+1);
//                    }else{
//                        hm.put(key,1);
//                    }
//                }
//                start=i;
//            }
//        }
//
//        Integer maxx = Collections.max(hm.values());
//        for (Map.Entry<String,Integer> e: hm.entrySet()){
//            if (e.getValue().equals(maxx)){
//                System.out.println(e.getKey());
//            }
//        }
 */
}
