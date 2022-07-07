package collectionHierarchy.Classes;

import collectionHierarchy.Interface.AddRemovable;
import collectionHierarchy.Interface.Addable;
import collectionHierarchy.Interface.MyList;

public class MyListImpl extends Collection implements Addable, AddRemovable, MyList {

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
        return getItems().remove(0);
    }

    @Override
    public int getUsed() {
        return getItems().size();
    }
}
