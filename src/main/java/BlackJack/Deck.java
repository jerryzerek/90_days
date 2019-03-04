package BlackJack;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
    int counter = 0;
    List<Card> deck = new ArrayList<>();

    public Deck() {
        clean();
    }

    public void clean() {
        deck.clear();
        for (Suit suit: Suit.values()) {
            for (Rank rank: Rank.values()){
                Card card = new Card(suit, rank);
                deck.add(card);
            }
        }
        Collections.shuffle(deck);
    }

    public Card drawCard() {
        Card card = deck.get(counter);
        counter ++;
        return card;
    }

    public List<Card> getDeck() {
        return deck;
    }
}
