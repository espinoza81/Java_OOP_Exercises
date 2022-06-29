package salaryIncrease;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(console.nextLine());
        List<Person> people = new ArrayList<>();

        while (numberOfPeople-- > 0) {
            String[] input = console.nextLine().split("\\s+");

            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);

            Person personToAdd = new Person(firstName, lastName, age, salary);
            people.add(personToAdd);
        }

        double bonus = Double.parseDouble(console.nextLine());

        people.forEach(s -> {
            s.increaseSalary(bonus);
            System.out.println(s);
        });
    }
}
