import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String name) {
        this._name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        Enumeration<Rental> rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";

        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();

            // linha mostrando o valor de cada aluguel
            result += "\t" + each.getMovie().getTitle() + "\t" +
                      each.getCharge() + "\n";
        }

        // rodapé com total e pontos
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() +
                  " frequent renter points";

        return result;
    }

    // NOVO — comprovante em HTML
    public String htmlStatement() {
        Enumeration<Rental> rentals = _rentals.elements();
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";

        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getMovie().getTitle() + ": " +
                      each.getCharge() + "<BR>\n";
        }

        result += "<P>You owe <EM>" + getTotalCharge() + "</EM><P>\n";
        result += "On this rental you earned <EM>" +
                  getTotalFrequentRenterPoints() +
                  "</EM> frequent renter points<P>";

        return result;
    }

    // ----- MÉTODOS DE APOIO (REUTILIZADOS PELA VERSÃO HTML) -----

    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentals = _rentals.elements();

        while (rentals.hasMoreElements()) {
            result += rentals.nextElement().getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> rentals = _rentals.elements();

        while (rentals.hasMoreElements()) {
            result += rentals.nextElement().getFrequentRenterPoints();
        }
        return result;
    }
}
