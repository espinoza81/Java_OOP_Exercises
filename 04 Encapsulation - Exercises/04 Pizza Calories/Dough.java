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
        if("White".equals(flourType) || "Wholegrain".equals(flourType)) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        if("Crispy".equals(bakingTechnique) ||
                "Chewy".equals(bakingTechnique) ||
                "Homemade".equals(bakingTechnique)) {
            this.bakingTechnique = bakingTechnique;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if(weight >= 1 && weight <= 200) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public double calculateCalories() {
        double modifierFlourType = 0.0;
        double modifierBakingTechnique = 0.0;

        //White – 1.5;
        //Wholegrain – 1.0;
        switch (flourType) {
            case "White":
                modifierFlourType = 1.5;
                break;
            case "Wholegrain":
                modifierFlourType = 1.0;
                break;
        }

        //Crispy – 0.9;
        //Chewy – 1.1;
        //Homemade – 1.0;
        switch (bakingTechnique) {
            case "Crispy":
                modifierBakingTechnique = 0.9;
                break;
            case "Chewy":
                modifierBakingTechnique = 1.1;
                break;
            case "Homemade":
                modifierBakingTechnique = 1.0;
                break;
        }

        return 2 * weight * modifierFlourType * modifierBakingTechnique;
    }
}
