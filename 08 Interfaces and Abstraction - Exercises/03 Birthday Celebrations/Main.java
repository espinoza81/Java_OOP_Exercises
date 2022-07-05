package birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Birthable> withBirthday = new ArrayList<>();
        String input;

        while (!"End".equals(input = console.nextLine())) {
            String[] attributes = input.split("\\s+");
            String kindOfPerson = attributes[0];
            String name = attributes[1];

            if ("Citizen".equals(kindOfPerson)) {
                //Citizen {name} {age} {id} {birthdate}
                int age = Integer.parseInt(attributes[2]);
                String id = attributes[3];
                String birthdate = attributes[4];
                Birthable birthable = new Citizen(name, age, id, birthdate);
                withBirthday.add(birthable);

            } else if ("Pet".equals(kindOfPerson)) {
                //Pet {name} {birthdate}
                String birthdate = attributes[2];
                Birthable birthable = new Pet(name, birthdate);
                withBirthday.add(birthable);
            }
        }

        String yearToFindBirth = console.nextLine();

        withBirthday.stream().filter(s -> s.getBirthDate().endsWith(yearToFindBirth)).forEach(s -> System.out.println(s.getBirthDate()));
    }
}
