package BlackJack;

import javafx.scene.image.Image;

public class Card {
    private Suit suit;
    private Rank rank;
//    private Image cardImage;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
//        this.cardImage = cardImage;
    }

    public static String getFileName(Rank rank, Suit suit) {
        return "file:src/main/resources/cards/" + rank.getSymbol() + suit.getSuitSymbol() + "jpg";
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

//    public Image getCardImage() {
//        return cardImage;
//    }


    @Override
    public String toString() {
        return rank.toString() + " of " + suit.toString();
    }

}
