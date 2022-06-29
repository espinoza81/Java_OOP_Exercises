package sortByNameAndAge;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
  
    @Override
    public String toString() {
        return getFullName() + " is " + age + " years old.";
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }
}
