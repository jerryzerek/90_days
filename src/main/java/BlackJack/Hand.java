package BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    boolean isDrawing = true;

    public void addCard(Card card) {
        cards.add(card);
    }

    public void drawForPlayer(Card card) {
        while (!isLost() && isDrawing){
            Scanner in = new Scanner(System.in);
            System.out.println("Draw card: yes or no");
            String input = in.nextLine();
            if (input.equals("yes")) {
                isDrawing=true;
                addCard(card);
                System.out.println("Drawing a card...the sum is now " + calculate());
                System.out.println();
            } else if (input.equals("no")) {
                isDrawing = false;
                System.out.println("Check next player");
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
            System.out.println("You crossed 21");
            return true;
        }
        return false;
    }

    public void drawForDealer(Card card) {
        while (calculate()<16) {
            addCard(card);
        }
    }
}
