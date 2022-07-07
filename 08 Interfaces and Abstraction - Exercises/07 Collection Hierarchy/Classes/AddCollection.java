package collectionHierarchy.Classes;

import collectionHierarchy.Interface.Addable;

public class AddCollection extends Collection implements Addable {

    @Override
    public int add(String input) {
        if(getItems().size() < getMaxSize()) {
            getItems().add(input);
            return getItems().size() - 1;
        }
        return -1;
    }
}
