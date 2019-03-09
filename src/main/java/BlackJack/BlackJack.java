package BlackJack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlackJack {
    public static void main(String[] args) {
        Deck deck = new Deck();
        List<Hand> players = new ArrayList<>();
        int numberOfPlayers = 3;

        for (int i =0; i < numberOfPlayers; i++) {
            Hand hand = new Hand(String.valueOf("Player " + (i)));
            players.add(hand);
        }

        for (int i = 1; i < numberOfPlayers; i++) {
            System.out.println("Player nr " + i + " is drawing");
            players.get(i).drawForPlayer(deck);
        }
        System.out.println("Dealer is drawing");
        players.get(0).drawForDealer(deck);

        for (int i = 1; i < players.size(); i++) {
            System.out.println("Player " + i + " has " + players.get(i).calculate() + " points") ;
        }
        System.out.println("Dealer has " + players.get(0).calculate() + " points");

        Hand winner = new Hand("");
        for (Hand hand: players) {
            if (hand.calculate() > winner.calculate() && hand.calculate() <=21) {
                winner = hand;
            }
        }

        if(winner.equals(players.get(0))) {
            System.out.println("The winner is dealer with points: " + players.get(0).calculate());
        } else {
            System.out.println("The winner is " + winner.getPlayerNumber() + " with points: " + winner.calculate());
        }


    }
}
