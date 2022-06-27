package studentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repository;

    public StudentSystem() {
        this.repository = new HashMap<>();
    }

    public void create(String[] attributes) {
        String name = attributes[1];
        int age = Integer.parseInt(attributes[2]);
        double grade = Double.parseDouble(attributes[3]);

        repository.putIfAbsent(name, new Student(name, age, grade));
    }

    public Student getStudent(String name) {
        return this.repository.get(name);
    }
}
