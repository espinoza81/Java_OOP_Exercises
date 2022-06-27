package pointInRectangle;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static List<Integer> coordinatesGetFromConsole = null;
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        coordinatesGetFromConsole = getCoordinatesFromConsole(console);

        Rectangle rectangle = createRectangle();

        int countOfPointToChek = Integer.parseInt(console.nextLine());

        for(int i = 0; i<countOfPointToChek; i++){
            coordinatesGetFromConsole = getCoordinatesFromConsole(console);
            Point pointToChek = getPoint(0, 1);
            System.out.println(rectangle.contains(pointToChek));
        }
    }

    private static List<Integer> getCoordinatesFromConsole(Scanner console) {
        return Arrays.stream(console.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static Rectangle createRectangle() {
        Point bottomLeft = getPoint(0, 1);
        Point topRight = getPoint(2, 3);
        return new Rectangle(bottomLeft, topRight);
    }

    private static Point getPoint(int xIndex, int yIndex) {
        int X = coordinatesGetFromConsole.get(xIndex);
        int Y = coordinatesGetFromConsole.get(yIndex);
        return new Point(X, Y);
    }
}
