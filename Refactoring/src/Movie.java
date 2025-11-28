public class Movie {

    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;

    private String _title;
    private Price _price;

    public Movie(String name, int priceCode) {
        this._title = name;
        setPriceCode(priceCode); // agora usa herança
    }

    public String getTitle() {
        return _title;
    }

    // Delegação para a classe Price
    public int getPriceCode() {
        return _price.getPriceCode();
    }

    // Agora cria o objeto certo da hierarquia
    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    // Delegação do cálculo de pontos
    public int getFrequentRenterPoints(int daysRented) {
        if (getPriceCode() == NEW_RELEASE && daysRented > 1) {
            return 2;
        }
        return 1;
    }

    // O cálculo do valor ainda está na Movie (passo posterior remove isso)
    public double getCharge(int daysRented) {
        double result = 0;

        switch (getPriceCode()) {
            case REGULAR:
                result += 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;
                break;

            case CHILDRENS:
                result += 1.5;
                if (daysRented > 3)
                    result += (daysRented - 3) * 1.5;
                break;

            case NEW_RELEASE:
                result += daysRented * 3;
                break;
        }

        return result;
    }
}
