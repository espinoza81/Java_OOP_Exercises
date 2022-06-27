package studentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        String input;

        while (!"Exit".equals(input = console.nextLine())) {
            String[] attributes = input.split("\\s+");
            String command = attributes[0];

            if (command.equals("Create")) {
                studentSystem.create(attributes);
            } else if (command.equals("Show")) {
                String name = attributes[1];
                Student student = studentSystem.getStudent(name);
                if (student != null) {
                    System.out.println(student + " " + student.getCommentary());
                }
            }
        }
    }
}
