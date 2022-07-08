package vehicles;

import java.text.DecimalFormat;

public abstract class Vehicles {
    private double fuelQuantity;
    private double fuelConsumption; //in liters per km

    public Vehicles(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public abstract String driving(double distance);

    public abstract void refueling(double liters);

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String traveling(double fuelConsumption, double distance){
        DecimalFormat format = new DecimalFormat( "#.##" );
        if(fuelConsumption <= getFuelQuantity()){
            setFuelQuantity(getFuelQuantity() - fuelConsumption);
            return String.format(Messages.TRAVELING, getClass().getSimpleName(), format.format(distance));
        }
        return String.format(Messages.NOT_TRAVELING, getClass().getSimpleName());
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), getFuelQuantity());
    }
}
