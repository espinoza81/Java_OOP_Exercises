package hotelReservation;

public class PriceCalculator {

    public static double priceCalculate(double pricePerDay, int numberOfDays, Season season, DiscountType discountType) {
        double finalPrice = pricePerDay * numberOfDays;
        finalPrice *= season.getMultiplayer();
        finalPrice *= 1 - discountType.getPercentage() / 100.0;
        return finalPrice;
    }
}
