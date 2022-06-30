package shoppingSpree;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<String, Person> people = new LinkedHashMap<>();
    static Map<String, Product> products = new LinkedHashMap<>();
    static boolean catchException = false;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        fillPeople(console);
        if(catchException) {
            return;
        }

        fillProduct(console);
        if(catchException) {
            return;
        }

        String command;

        while (!"END".equals(command = console.nextLine())) {
            buyProduct(command);
        }

        printPeopleList();
    }

    private static void printPeopleList() {
        people.values().forEach(System.out::println);
    }

    private static void buyProduct(String command) {
        String name = command.split("\\s+")[0];
        String product = command.split("\\s+")[1];

        try {
            people.get(name).buyProduct(products.get(product));
            System.out.println(name + " bought " + product);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private static void fillPeople(Scanner console) {
        String[] peopleWhitMoney = console.nextLine().split(";");

        Arrays.stream(peopleWhitMoney).forEach(s -> {
            String name = s.split("=")[0];
            double money = Double.parseDouble(s.split("=")[1]);

            try {
                Person personToAdd = new Person(name, money);
                people.put(name, personToAdd);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                catchException = true;
            }
        });
    }

    private static void fillProduct(Scanner console) {
        String[] productWithPrice = console.nextLine().split(";");

        Arrays.stream(productWithPrice).forEach(s -> {
            String name = s.split("=")[0];
            double cost = Double.parseDouble(s.split("=")[1]);

            try {
                Product productToAdd = new Product(name, cost);
                products.put(name, productToAdd);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                catchException = true;
            }
        });
    }
}
