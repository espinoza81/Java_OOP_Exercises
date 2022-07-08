package vehicles;

public class Truck extends Vehicles {

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public String driving(double distance) {
        double fuelConsumption = distance * (getFuelConsumption() + 1.6);
        return traveling(fuelConsumption, distance);
    }

    @Override
    public void refueling(double liters) {
        setFuelQuantity(getFuelQuantity() + liters*0.95);
    }
}
