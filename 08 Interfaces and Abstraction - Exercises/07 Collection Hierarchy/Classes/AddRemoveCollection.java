package collectionHierarchy.Classes;

import collectionHierarchy.Interface.AddRemovable;
import collectionHierarchy.Interface.Addable;

public class AddRemoveCollection extends Collection implements Addable, AddRemovable {

    @Override
    public int add(String input) {
        if(getItems().size() < getMaxSize()) {
            getItems().add(0, input);
            return 0;
        }
        return -1;
    }

    @Override
    public String remove() {
        return getItems().remove(getItems().size()-1);
    }
}
