package borderControl;

public abstract class BasePeople implements Identifiable{
    private String id;

    public BasePeople(String id) {
        this.id = id;
    }

    public String getId(){
        return id;
    }
}
