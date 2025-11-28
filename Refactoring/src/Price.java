public abstract class Price {

    public abstract int getPriceCode();

    // Agora é abstrato
    public abstract double getCharge(int daysRented);

    // Pode ser sobrescrito por NewReleasePrice
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
