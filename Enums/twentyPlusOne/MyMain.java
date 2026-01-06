package twentyPlusOne;


import java.util.List;

public class MyMain {
    public static void main(String[] args){
        Deck d = new Deck();
        List<Card> shuffledDeck = d.shuffleDeck();

        Game g = new Game();

        for(Card c: shuffledDeck){
            System.out.println(c.getColor()+ " " + c.getSuit() + " " + c.getRank());
        }

        System.out.println("--------------------------");

        for (int i = 0; i<10; i++){
            Card c = d.pullRandom(shuffledDeck);
            System.out.println(c.getColor()+" "+ c.getSuit() + " " + c.getRank());
        }

        for (int i=0; i < 50; i++){
            System.out.print(g.generateNumber() + " ");
        }
        System.out.println("--------------------------");

        g.play();
    }
}
