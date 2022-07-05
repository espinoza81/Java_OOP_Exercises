package foodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int numbersOfInput = Integer.parseInt(console.nextLine());
        Map<String, Buyer> buyers = new HashMap<>();
        Buyer buyer = null;

        while (numbersOfInput -- > 0){
            String[] attributes = console.nextLine().split("\\s+");
            String name = attributes[0];
            int age = Integer.parseInt(attributes[1]);

            if(attributes.length == 4) {
                //"{name} {age} {id} {birthdate}"
                String id = attributes[2];
                String birthdate = attributes[3];
                buyer = new Citizen(name, age, id, birthdate);

            } else {
                //"{name} {age}{group}
                String group = attributes[2];
                buyer = new Rebel(name, age, group);
            }

            buyers.put(name, buyer);
        }

        String bayer;

        while (!"End".equals(bayer = console.nextLine())){
            if(buyers.containsKey(bayer)){
                buyers.get(bayer).buyFood();
            }
        }

        int totalFood = buyers.values().stream().mapToInt(Buyer::getFood).sum();
        System.out.println(totalFood);
    }
}
