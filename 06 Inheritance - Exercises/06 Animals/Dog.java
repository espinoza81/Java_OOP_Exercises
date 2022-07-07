package animals;

public class Dog extends Animal implements Sound {
    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return Messages.DOG_SOUND;
    }
}
