package borderControl;

public class Robot extends BasePeople {
    private String model;

    public Robot(String id, String model) {
        super(id);
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}
