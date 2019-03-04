package BlackJack;

public class BlackJack {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand player = new Hand();
        Hand dealer = new Hand();

        deck.clean();

        for (int i =0; i < deck.getDeck().size(); i++){

        }
        player.drawForPlayer(deck.drawCard());
        dealer.drawForDealer(deck.drawCard());


    }
}
