package exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnterNumbers {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();

        int start = 1;

        while (numbers.size() < 10) {
            int number;

            try {
                number = readNumber(start, 100, console);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                continue;
            }

            numbers.add(number);
            start = number;
        }

        System.out.println(numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    public static int readNumber(int start, int end, Scanner console){
        int number;

        try {
            number = Integer.parseInt(console.nextLine());
        } catch (NumberFormatException e){
            throw new IllegalStateException("Invalid Number!");
        }

        if(number <= start || number >= end) {
            throw new IllegalStateException("Your number is not in range " + start + " - 100!");
        }

        return number;
    }
}
