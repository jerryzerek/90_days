package BlackJack;

public enum Suit {
    HEARTS("Hearts", "H"),
    DIAMONDS("Diamonds", "D"),
    CLUBS("Clubs", "C"),
    SPADES("Spades", "S");


    private String name;
    private String suitSymbol;

    Suit(String name, String suitSymbol) {
        this.name = name;
        this.suitSymbol = suitSymbol;
    }

    public String getName() {
        return name;
    }

    public String getSuitSymbol() {
        return suitSymbol;
    }

    @Override
    public String toString() {
        return name;
    }
}
