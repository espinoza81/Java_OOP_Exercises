package barracksWars.core.commands;

import barracksWars.annotations.Inject;
import barracksWars.interfaces.Repository;

public class Retire extends Command{

    @Inject
    private Repository repository;

    public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        // If there are no such units currently in the repository print: "No such units in repository."
        // If there is such a unit currently in the repository, print: "{UnitType} retired!"

        String unitType = super.getData()[1];

        try {
            this.repository.removeUnit(unitType);
        } catch (Exception e){
            return e.getMessage();
        }

        return unitType + " retired!";
    }
}