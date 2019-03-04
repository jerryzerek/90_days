package BlackJack;

public enum Rank {
    ACE("Ace", "A", 1),
    TWO("Two", "2", 2),
    THREE("Three", "3", 3),
    FOUR( "Four", "4", 4 ),
    FIVE( "Five", "5", 5 ),
    SIX( "Six", "6", 6),
    SEVEN( "Seven", "7", 7 ),
    EIGHT( "Eight", "8", 8 ),
    NINE( "Nine", "9", 9 ),
    TEN( "Ten", "10", 10 ),
    JACK("Jack", "J", 10),
    QUEEN("Queen", "Q", 10),
    KING("King", "K", 10);


    private String name;
    private String symbol;
    private int rankValue;

    Rank (String name, String symbol, int rankValue) {
        this.name = name;
        this.symbol = symbol;
        this.rankValue = rankValue;
    }

    public int getRankValue() {
        return rankValue;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return name;
    }
}
