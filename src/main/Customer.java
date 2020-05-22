package main;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        StringBuilder resultBuilder = new StringBuilder("Rental Record for ").append(this.getName()).append("\n");
        resultBuilder.append("\tTitle\t\tDays\tAmount\n");

        rentals.forEach(rental ->
                resultBuilder.append("\t").append(rental.getMovie().getTitle()).append("\t\t").append(rental.getDaysRented()).append("\t").append(rental.getCharge()).append("\n")
        );
        resultBuilder.append("Amount owed is ").append(getTotalCharge()).append("\n");
        resultBuilder.append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points");
        return resultBuilder.toString();
    }

    public String htmlStatement() {
        StringBuilder resultBuilder = new StringBuilder("<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n");

        rentals.forEach(rental ->
                resultBuilder.append(rental.getMovie().getTitle()).append(": ").append(rental.getCharge()).append("<BR>\n")
        );
        resultBuilder.append("<P>You owe <EM>").append(getTotalCharge()).append("</EM><P>\n");
        resultBuilder.append("On this rental you earned <EM>").append(getTotalFrequentRenterPoints()).append("</EM> frequent renter points<P> ");
        return resultBuilder.toString();
    }

    private double getTotalCharge() {
        return rentals.stream()
                .mapToDouble(Rental::getCharge)
                .sum();
    }

    private int getTotalFrequentRenterPoints() {
        return rentals.stream()
                .mapToInt(Rental::getFrequentRenterPoints)
                .sum();
    }

}
