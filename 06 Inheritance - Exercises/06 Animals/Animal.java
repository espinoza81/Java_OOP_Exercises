package animals;

public class Animal implements Sound {

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName() + System.lineSeparator() +
                this.name + " " + age + " " + gender + System.lineSeparator() +
                produceSound();
    }

    @Override
    public String produceSound() {
        return "";
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.trim().isEmpty()) {
            throw new IllegalArgumentException(Messages.INVALID_INPUT);
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0) {
            throw new IllegalArgumentException(Messages.INVALID_INPUT);
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(!("Female".equals(gender) || "Male".equals(gender))) {
            throw new IllegalArgumentException(Messages.INVALID_INPUT);
        }
        this.gender = gender;
    }
}
