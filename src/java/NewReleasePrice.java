public class NewReleasePrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int getFrequentRentalPoints(int daysRented) {
        // add bonus for a two day new release rental
        if (daysRented > 1)
            return 2;
        return 1;
    }
}
