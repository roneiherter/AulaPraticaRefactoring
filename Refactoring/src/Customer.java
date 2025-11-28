   public String statement() {
   double totalAmount = 0;
   int frequentRenterPoints = 0;
   Enumeration rentals = _rentals.elements();
   String result = "Rental Record for " + getname() + "\n";

   while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();

      // agora o cálculo está na classe Rental
      double thisAmount = each.getCharge();

      // add frequent renter points
      frequentRenterPoints++;

      if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
           each.getDaysRented() > 1)
         frequentRenterPoints++;

      result += "\t" + each.getMovie().getTitle() + "\t" +
            String.valueOf(thisAmount) + "\n";

      totalAmount += thisAmount;
   }

   result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
   result += "You earned " + String.valueOf(frequentRenterPoints) +
           " frequent renter points";
   return result;
}