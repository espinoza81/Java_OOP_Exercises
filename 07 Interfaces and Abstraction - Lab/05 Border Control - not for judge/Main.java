package borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<BasePeople> listOfWhoEnter = new ArrayList<>();
        String peopleWantEnter;
        BasePeople basePeople = null;

        while (!"End".equals(peopleWantEnter = console.nextLine())){
            String[] peopleFromConsole = peopleWantEnter.split("\\s+");
            String nameModel = peopleFromConsole[0];
            if(peopleFromConsole.length == 2) {
                basePeople = new Robot(peopleFromConsole[1], nameModel);
            } else {
                basePeople = new Citizen(peopleFromConsole[2], Integer.parseInt(peopleFromConsole[1]), nameModel);
            }
            listOfWhoEnter.add(basePeople);
        }

        String idEnds = console.nextLine();

        listOfWhoEnter.stream().filter(s -> s.getId().endsWith(idEnds)).forEach(s -> System.out.println(s.getId()));
    }
}
