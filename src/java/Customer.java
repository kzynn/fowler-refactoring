import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector<Rental> rentals = new Vector<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        Enumeration<Rental> enumRentals = rentals.elements();
        StringBuilder resultBuilder = new StringBuilder("Rental Record for ").append(this.getName()).append("\n");
        resultBuilder.append("\tTitle\t\tDays\tAmount\n");

        while (enumRentals.hasMoreElements()) {
            Rental rental = enumRentals.nextElement();
            resultBuilder.append("\t").append(rental.getMovie().getTitle()).append("\t\t").append(rental.getDaysRented()).append("\t").append(rental.getCharge()).append("\n");
        }
        //add footer lines
        resultBuilder.append("Amount owed is ").append(getTotalCharge()).append("\n");
        resultBuilder.append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points");
        return resultBuilder.toString();
    }

    public String htmlStatement() {
        Enumeration<Rental> enumRentals = rentals.elements();
        StringBuilder resultBuilder = new StringBuilder("<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n");

        while (enumRentals.hasMoreElements()) {
            Rental rental = enumRentals.nextElement();
            //show figures for each rental
            resultBuilder.append(rental.getMovie().getTitle()).append(": ").append(rental.getCharge()).append("<BR>\n");
        }
        //add footer lines
        resultBuilder.append("<P>You owe <EM>").append(getTotalCharge()).append("</EM><P>\n");
        resultBuilder.append("On this rental you earned <EM>").append(getTotalFrequentRenterPoints()).append("</EM> frequent renter points<P> ");
        return resultBuilder.toString();
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> enumRentals = rentals.elements();
        while (enumRentals.hasMoreElements()) {
            Rental each = enumRentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            Rental each = enum_rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

}
