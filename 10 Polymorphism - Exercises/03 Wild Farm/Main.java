package wildFarm;

import wildFarm.Animal.*;
import wildFarm.Food.Food;
import wildFarm.Food.Meat;
import wildFarm.Food.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String animalFromConsole;

        while (!"End".equals(animalFromConsole = console.nextLine())) {
            Animal animal = getAnimal(animalFromConsole);

            String foodFromConsole = console.nextLine();
            Food food = getFood(foodFromConsole);

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            animals.add(animal);
        }

        animals.forEach(System.out::println);
    }

    private static Food getFood(String food) {
        String[] attributes = food.split("\\s+");
        String foodKind = attributes[0];
        Integer quantity = Integer.parseInt(attributes[1]);
        if("Vegetable".equals(foodKind)){
            return new Vegetable(quantity);
        }
        return new Meat(quantity);
    }

    private static Animal getAnimal(String input) {
        String[] attributes = input.split("\\s+");
        //"{AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion} {CatBreed}".
        String animal = attributes[0];
        String name = attributes[1];
        Double weight = Double.parseDouble(attributes[2]);
        String region = attributes[3];

        switch (animal) {
            case "Tiger":
                return new Tiger(name, animal, weight, region);
            case "Zebra":
                return new Zebra(name, animal, weight, region);
            case "Mouse":
                return new Mouse(name, animal, weight, region);
            case "Cat":
                String breed = attributes[4];
                return new Cat(name, animal, weight, region, breed);
            default:
                return null;
        }
    }
}
