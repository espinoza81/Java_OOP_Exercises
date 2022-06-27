package hotelReservation;

public enum DiscountType {
    VIP(20),
    SecondVisit(10),
    None(0);

    private int percentage;

    DiscountType(int percentage) {
        this.percentage = percentage;
    }

    public int getPercentage() {
        return percentage;
    }
}
