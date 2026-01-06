package twentyPlusOne;


public class Card {
    private Color color;
    private Suit suit;
    private Rank rank;

    public Card(Color c, Suit cs, Rank cr){
        this.color = c;
        this.suit = cs;
        this.rank = cr;
    }

    public Color getColor(){
        return color;
    }
    public Suit getSuit(){
        return suit;
    }
    public Rank getRank(){
        return rank;
    }
}