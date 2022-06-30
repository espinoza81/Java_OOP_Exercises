package pizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if("Meat".equals(toppingType) ||
                "Veggies".equals(toppingType) ||
                "Cheese".equals(toppingType) ||
                "Sauce".equals(toppingType)) {
            this.toppingType = toppingType;
        } else {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
    }

    private void setWeight(double weight) {
        if(weight >= 1 && weight <= 50) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException(toppingType + " weight should be in the range [1..50].");
        }
    }

    public double calculateCalories() {
        //Meat – 1.2;
        //Veggies – 0.8;
        //Cheese – 1.1;
        //Sauce – 0.9;
        double modifierTopping = 0.0;

        switch (toppingType) {
            case "Meat":
                modifierTopping = 1.2;
                break;
            case "Veggies":
                modifierTopping = 0.8;
                break;
            case "Cheese":
                modifierTopping = 1.1;
                break;
            case "Sauce":
                modifierTopping = 0.9;
                break;
        }
        return 2 * weight * modifierTopping;
    }
}
