package BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    private boolean isDrawing = true;
    private String playerNumber;


    public void drawCard(Deck deck) {
        Card card = deck.drawCard();
        cards.add(card);
    }

    public Hand(String playerNumber) {
        this.playerNumber = playerNumber;
    }

    public void drawForPlayer(Deck deck) {
        while (!isLost() && isDrawing){
            Scanner in = new Scanner(System.in);
            System.out.println("Draw card: yes or no");
            String input = in.nextLine();
            if (input.equals("yes")) {
                isDrawing=true;
                drawCard(deck);
                System.out.println("Drawing a card...the sum is now " + calculate());
                System.out.println();
            } else if (input.equals("no")) {
                isDrawing = false;
                System.out.println("Check next player\n");
            } else {
                System.out.println("Please type yes or no");
            }
        }
    }

    public int calculate() {
        int sumOfCards = IntStream.range(0, cards.size())
                .map(n-> cards.get(n).getRank().getRankValue())
                .sum();
        if (cards.stream().anyMatch(card -> card.getRank().equals(Rank.ACE)) && sumOfCards <=11) {
            sumOfCards +=10;
        }
        return sumOfCards;
    }

    public boolean isLost() {
        if(calculate() > 21) {
            return true;
        }
        return false;
    }



    public String getPlayerNumber() {
        return playerNumber;
    }

    //jak wywoluje ta metode to przez to ze mam nowy obiekt hand to zaczyna sie liczenie od poczatku?
    public void drawForDealer(Deck deck) {
        while (calculate()<16) {
            drawCard(deck);
        }
    }
}
