package militaryElite.Soldiers;

import militaryElite.Interfaces.LieutenantGeneral;
import militaryElite.Interfaces.Private;
import militaryElite.Interfaces.Soldier;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private List<Private> commandPrivateImpl;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.commandPrivateImpl = new ArrayList<>();
    }

    public void addPrivate(Private priv){
        commandPrivateImpl.add(priv);
    }

    @Override
    public List<Private> getCommandPrivateImpl() {
        return commandPrivateImpl;
    }



    @Override
    public String toString() {
        //"Name: {firstName} {lastName} Id: {id} Salary: {salary}
        //Privates:
        //  {private1 ToString()}
        //  {private2 ToString()}
        //  …
        //  {privateN ToString()}"
        //Note: privates must be sorted by id in descending order.
        return super.toString() + System.lineSeparator() +
                "Privates:" + (this.commandPrivateImpl.isEmpty() ? "" : System.lineSeparator() +
                commandPrivateImpl.stream().
                        sorted(Comparator.comparing(Soldier::getId).reversed()).
                        map(p -> "  " + p).
                        collect(Collectors.joining(System.lineSeparator())));
    }
}
