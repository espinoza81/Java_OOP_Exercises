package wildFarm.Animal;

import wildFarm.Messages;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(Messages.CAT_SOUND);
    }

    @Override
    public String toString() {
        DecimalFormat formatWeight = new DecimalFormat( "##.##" );

        return String.format("%s[%s, %s, %s, %s, %d]",
                getClass().getSimpleName(),
                getAnimalName(),
                breed,
                formatWeight.format(getAnimalWeight()),
                getLivingRegion(),
                getFoodEaten());
    }
}
