package twentyPlusOne;


import java.util.*;

public class Deck {

    private final List<Card> deck;

    public Deck() {
        List<Card> deck = new ArrayList<>();
        int numberOfColors = 2;
        int numberOSuits = 4;
        int numberOfRanks = 13;
        Color[] colors = Color.values();
        Suit[] suits = Suit.values();
        Rank[] ranks = Rank.values();
        for (int i = 0; i < numberOfColors; i++) {
            for (int y = 0; y < numberOSuits; y++) {
                for (int z = 0; z < numberOfRanks; z++) {
                    Card c = new Card(colors[i], suits[y], ranks[z]);
                    deck.add(c);
                }
            }
        }
        this.deck = deck;
    }

    private List<Card> getDeck() {
        return deck;
    }

    // A way of shuffling automatically - alternative :
//            Collections.shuffle(d.deck);
    List<Card> shuffleDeck() {
        Set<Integer> values = new LinkedHashSet<>();

        while (values.size() <= (13 * 4 * 2 - 1)) {
            int random = (int) (Math.random() * (13 * 4 * 2));
            values.add(random);
        }

        List<Card> original = getDeck();
        List<Card> shuffled = new ArrayList<>();

        for (Integer i : values) {
            shuffled.add(original.get(i));
        }

        return shuffled;
    }


    Card pullFirst(List<Card> l) {
        return l.get(0);
    }

    Card pullLast(List<Card> l) {
        return l.get(l.size() - 1);
    }

    Card pullRandom(List<Card> l) {
        int random = (int) (Math.random() * deck.size());
        return l.get(random);
    }

}