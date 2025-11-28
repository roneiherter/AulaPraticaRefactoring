public abstract class Price {

    public abstract int getPriceCode();

    public abstract double getCharge(int daysRented);

    // Aqui está a lógica extraída do Movie.getFrequentRenterPoints()
    public int getFrequentRenterPoints(int daysRented) {
        // Regra padrão: 1 ponto
        return 1;
    }
}
