package militaryElite.Soldiers;

import militaryElite.Enum.Corps;
import militaryElite.Interfaces.Engineer;
import militaryElite.Repair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private Collection<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    public void addRepair(Repair repair){
        repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return repairs;
    }

    @Override
    public String toString() {
        //"Name: {firstName} {lastName} Id: {id} Salary: {salary}
        //Corps: {corps}
        //Repairs:
        //  {repair1 ToString()}
        //  {repair2 ToString()}
        //  …
        //  {repairN ToString()}"

        return super.toString() + System.lineSeparator() +
                "Repairs:" + (repairs.isEmpty() ? "" : System.lineSeparator() +
                repairs.stream().
                        map(r -> "  " + r).
                        collect(Collectors.joining(System.lineSeparator())));
    }
}
