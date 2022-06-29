package greedyTimes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum ItemKind {
    Gold(new ArrayList<>()),
    Gem(new ArrayList<>()),
    Cash(new ArrayList<>());

    private List<Item> listOfItems;

    ItemKind(List<Item> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public List<Item> getListOfItems() {
        return listOfItems;
    }

    public void setListOfItems(List<Item> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public long sumQuantity() {
        return listOfItems.stream().map(Item::getQuantity).reduce(Long::sum).orElse(0L);
    }

    public void addItem(String item, long quantity) {
        Item itemToUpdate = this.getItem(item);
        if ( itemToUpdate == null) {
            this.listOfItems.add(new Item(item, quantity));
        } else {
            itemToUpdate.setQuantity(itemToUpdate.getQuantity() + quantity);
        }
    }

    public Item getItem(String name) {
        return this.listOfItems.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "<" +  this.name() + "> $" + this.sumQuantity() + System.lineSeparator() +
                this.getListOfItems().stream().
                        sorted(Comparator.comparing(Item::getName, Comparator.reverseOrder())).
                        map(Item::toString).collect(Collectors.joining(System.lineSeparator()));
    }
}