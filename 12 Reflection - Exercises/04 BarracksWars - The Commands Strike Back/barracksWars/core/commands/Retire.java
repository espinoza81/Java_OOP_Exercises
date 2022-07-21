package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class Retire extends Command{
    public Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // If there are no such units currently in the repository print: "No such units in repository."
        // If there is such a unit currently in the repository, print: "{UnitType} retired!"

        String unitType = super.getData()[1];
        try {
            super.getRepository().removeUnit(unitType);
            return unitType + " retired!";
        } catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }
}