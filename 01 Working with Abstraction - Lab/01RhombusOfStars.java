import java.util.Scanner;

public class RhombusOfStars {
    private static int sizeOfRhombus=0;
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        sizeOfRhombus = Integer.parseInt(console.nextLine());

        printTopPart();

        printBottomPart();
    }

    private static void printTopPart() {
        for(int starCount = 1; starCount <= sizeOfRhombus; starCount++){
            printRow(starCount);
        }
    }

    private static void printBottomPart() {
        for(int starCount = sizeOfRhombus-1; starCount >= 1; starCount--){
            printRow(starCount);
        }
    }

    private static void printRow(int starCount) {
        String star = "* ";
        String space = " ".repeat(sizeOfRhombus - starCount);

        String row = space +
                star.repeat(starCount) +
                space;
        System.out.println(row);
    }
}
