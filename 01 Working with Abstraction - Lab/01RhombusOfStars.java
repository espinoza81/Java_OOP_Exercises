import java.util.Scanner;

public class RhombusOfStars {
    private static int sizeOfRhombus=0;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        sizeOfRhombus = Integer.parseInt(console.nextLine());

        printRhombus();
    }

    private static void printRhombus() {
        for(int rowNumber = 1; rowNumber <= sizeOfRhombus*2-1; rowNumber++){
            int starsOnRow = rowNumber > sizeOfRhombus ? sizeOfRhombus*2 - rowNumber : rowNumber;
            printRow(starsOnRow);
        }
    }

    private static void printRow(int starsOnRow) {
        String star = "* ".repeat(starsOnRow);
        String space = " ".repeat(sizeOfRhombus - starsOnRow);

        String row = space +
                star +
                space;
        System.out.println(row);
    }
}
