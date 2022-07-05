package pizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if(!IngredientsTypes.toppingTypes.containsKey(toppingType)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_TOPPING_TYPE,toppingType));
        }

        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if(weight <= 0 || weight > 50) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_TOPPING_WEIGHT, toppingType));
        }

        this.weight = weight;
    }

    public double calculateCalories() {
        return 2 * weight * IngredientsTypes.toppingTypes.get(toppingType);
    }
}
