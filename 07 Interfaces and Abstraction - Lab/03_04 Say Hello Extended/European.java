package sayHello;

public class European extends BasePerson implements Person {

    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return HelloMessages.EUROPEAN;
    }
}
