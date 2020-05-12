public abstract class Price {
    abstract int getPriceCode();
    abstract double getCharge(int daysRented);

    int getFrequentRentalPoints(int daysRented) {
        return 1;
    }
}
