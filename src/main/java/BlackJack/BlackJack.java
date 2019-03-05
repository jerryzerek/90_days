package BlackJack;

public class BlackJack {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand player = new Hand();
        Hand dealer = new Hand();
        boolean busted;

        player.drawForPlayer(deck);
        busted = player.isBusted();


        if (!busted) {
            dealer.drawForDealer(deck);
            System.out.println("Player has " + player.calculate() + " points");
            System.out.println("Dealer has " + dealer.calculate() + " points");
        }

        if ((player.calculate() <= 21 && player.calculate() > dealer.calculate()) || dealer.calculate() > 21) {
            System.out.println("Player won");
        } else if (player.calculate() > 21 || player.calculate() < dealer.calculate()) {
            System.out.println("Player lost");
        } else if (player.calculate() == dealer.calculate()){
            System.out.println("Draw");
        }
    }
}
