package animals;

public class Tomcat extends Cat implements Sound {
    private static final String GENDER = "Male";

    public Tomcat(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return Messages.TOMCAT_SOUND;
    }
}
