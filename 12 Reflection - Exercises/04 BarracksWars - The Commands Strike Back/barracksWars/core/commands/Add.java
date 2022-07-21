package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class Add extends Command {
    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String unitType = super.getData()[1];
        Unit unitToAdd = super.getUnitFactory().createUnit(unitType);
        super.getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
