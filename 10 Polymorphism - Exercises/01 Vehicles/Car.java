package vehicles;

public class Car extends Vehicles {

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public String driving(double distance) {
        double fuelConsumption = distance * (getFuelConsumption() + 0.9);
        return traveling(fuelConsumption, distance);
    }

    @Override
    public void refueling(double liters) {
        setFuelQuantity(getFuelQuantity() + liters);
    }
}
