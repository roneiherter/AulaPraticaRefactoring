public class Movie {

    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;

    private String _title;
    private int _priceCode;

    public Movie(String title, int priceCode) {
        this._title = title;
        this._priceCode = priceCode;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int priceCode) {
        this._priceCode = priceCode;
    }

    public String getTitle() {
        return _title;
    }

    // Novo método contendo o cálculo extraído
    public int getFrequentRenterPoints(int daysRented) {

        // Regra clássica do livro Refactoring:
        // ➜ Filmes lançamentos (NEW_RELEASE) dão 2 pontos se alugados por mais de 1 dia

        if (_priceCode == NEW_RELEASE && daysRented > 1) {
            return 2;
        }

        // Caso contrário, sempre 1 ponto
        return 1;
    }
}
