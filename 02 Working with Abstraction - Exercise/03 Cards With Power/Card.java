package cardsWithPower;

public class Card {
    public static String printInformation(CardSuits cardSuits, CardRank cardRank){
        int power = cardRank.getValue() + cardSuits.getValue();
        return "Card name: " + cardRank.name() + " of " + cardSuits.name() + "; Card power: " + power;
    }
}
