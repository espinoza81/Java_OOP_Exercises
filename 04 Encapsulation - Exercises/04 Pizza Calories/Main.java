package pizzaCalories;

import java.util.Scanner;

public class Main {
    static String[] input = null;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        readAttributes(console); //read pizza
        //Pizza {pizzaName} {numberOfToppings}

        try {
            Pizza pizza = new Pizza(input[1], Integer.parseInt(input[2]));

            readAttributes(console); //read dough
            //Dough {flourType} {bakingTechnique} {weightInGrams}
            Dough dough = new Dough(input[1], input[2], Double.parseDouble(input[3]));
            pizza.setDough(dough);

            readAttributes(console);//read topping;

            while (!"END".equals(input[0])) {
                //Topping {toppingType} {weightInGrams}
                Topping topping = new Topping(input[1], Double.parseDouble(input[2]));
                pizza.addTopping(topping);
                readAttributes(console);
            }

            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void readAttributes(Scanner console) {
        input = console.nextLine().split("\\s+");
    }
}
