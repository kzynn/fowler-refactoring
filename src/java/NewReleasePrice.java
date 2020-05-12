package java;

public class NewReleasePrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRentalPoints(int daysRented) {
        // add bonus for a two day new release rental
        if (daysRented > 1)
            return 2;
        return 1;
    }
}
