package animals;

public class Frog extends Animal implements Sound {
    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return Messages.FROG_SOUND;
    }
}
