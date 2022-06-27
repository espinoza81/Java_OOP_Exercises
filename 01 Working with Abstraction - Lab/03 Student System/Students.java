package studentSystem;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return this.name + " is " + this.age + " years old.";
    }

    public String getCommentary() {
        String commentary;

        if (this.grade >= 5.00) {
            commentary = "Excellent student.";
        } else if (this.grade < 5.00 && this.grade >= 3.50) {
            commentary = "Average student.";
        } else {
            commentary = "Very nice person.";
        }
        return commentary;
    }
}
