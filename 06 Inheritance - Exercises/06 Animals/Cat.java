package animals;

public class Cat extends Animal implements Sound {
    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return Messages.CAT_SOUND;
    }
}
