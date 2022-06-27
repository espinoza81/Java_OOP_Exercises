package cardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        CardRank cardRank = CardRank.valueOf(console.nextLine());
        CardSuits cardSuits = CardSuits.valueOf(console.nextLine());

        String output = Card.printInformation(cardSuits, cardRank);
        System.out.println(output);
    }
}
