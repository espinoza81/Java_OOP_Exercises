package pizzaCalories;

import java.util.Map;

public class IngredientsTypes {
    public static final Map<String, Double> bakingTechniques =
            Map.of("Crispy", 0.9,
                    "Chewy", 1.1,
                    "Homemade", 1.0);

    public static final Map<String, Double> flourTypes =
            Map.of("White", 1.5,
                    "Wholegrain", 1.0);

    public static final Map<String, Double> toppingTypes =
            Map.of("Meat", 1.2,
                    "Veggies", 0.8,
                    "Cheese", 1.1,
                    "Sauce", 0.9);
}
