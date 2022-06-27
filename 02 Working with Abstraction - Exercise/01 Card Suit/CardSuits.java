package cardSuit;

public enum CardSuits {
    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);

    private int value;

    CardSuits(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        //Ordinal value: 0; Name value: CLUBS
        return "Ordinal value: " + value + "; Name value: ";
    }

    public static void printAll() {
        System.out.println("Card Suits:");
        for (CardSuits value : CardSuits.values()) {
            System.out.println(value + value.name());
        }
    }
}
