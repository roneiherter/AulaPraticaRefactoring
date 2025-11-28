import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    // delega para a implementação de texto
    public String statement() {
        return new TextStatement().value(this);
    }

    // delega para a implementação HTML
    public String htmlStatement() {
        return new HtmlStatement().value(this);
    }

    // ------------ métodos públicos usados pelas Statements ------------

    // retorna o enumerador tipado de rentals
    public Enumeration<Rental> getRentals() {
        return _rentals.elements();
    }

    // total charge (public para ser usado pelas Statements)
    public double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    // total frequent renter points (public para ser usado pelas Statements)
    public int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
