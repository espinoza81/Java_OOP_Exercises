package pizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!IngredientsTypes.flourTypes.containsKey(flourType)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_DOUGH_TYPE);
        }

        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!IngredientsTypes.bakingTechniques.containsKey(bakingTechnique)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_DOUGH_TYPE);
        }

        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight <= 0 || weight > 200) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_DOUGH_WEIGHT);
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return 2 * weight * IngredientsTypes.flourTypes.get(flourType) * IngredientsTypes.bakingTechniques.get(bakingTechnique);
    }
}
