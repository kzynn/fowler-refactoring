package test;

import org.junit.jupiter.api.Test;

import java.Customer;
import java.Movie;
import java.Rental;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CustomerTest {

    @Test
    public void customerTest1() {
        Movie m1 = new Movie("movie1", 1);
        Movie m2 = new Movie("movie2", 2);

        Rental r1 = new Rental(m1, 10);
        Rental r2 = new Rental(m2, 5);

        Customer c1 = new Customer("joe");
        c1.addRental(r1);
        c1.addRental(r2);

        String result = c1.statement();

        assertThat(result, is("Rental Record for joe\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tmovie1\t\t10\t30.0\n" +
                "\tmovie2\t\t5\t4.5\n" +
                "Amount owed is 34.5\n" +
                "You earned 3 frequent renter points"));
    }

    @Test
    public void customerTest2() {
        Movie m1 = new Movie("movie1", 0);

        Rental r1 = new Rental(m1, 20);

        Customer c1 = new Customer("john");
        c1.addRental(r1);

        String result = c1.statement();

        assertThat(result, is("Rental Record for john\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tmovie1\t\t20\t29.0\n" +
                "Amount owed is 29.0\n" +
                "You earned 1 frequent renter points"));
    }

    @Test
    public void customerHtmlTest1() {
        Movie m1 = new Movie("movie1", 1);
        Movie m2 = new Movie("movie2", 2);

        Rental r1 = new Rental(m1, 10);
        Rental r2 = new Rental(m2, 5);

        Customer c1 = new Customer("joe");
        c1.addRental(r1);
        c1.addRental(r2);

        String result = c1.htmlStatement();

        assertThat(result, is("<H1>Rentals for <EM>joe</EM></H1><P>\n" +
                "movie1: 30.0<BR>\n" +
                "movie2: 4.5<BR>\n" +
                "<P>You owe <EM>34.5</EM><P>\n" +
                "On this rental you earned <EM>3</EM> frequent renter points<P> "));
    }

    @Test
    public void customerHtmlTest2() {
        Movie m1 = new Movie("movie1", 0);

        Rental r1 = new Rental(m1, 20);

        Customer c1 = new Customer("john");
        c1.addRental(r1);

        String result = c1.htmlStatement();

        assertThat(result, is("<H1>Rentals for <EM>john</EM></H1><P>\n" +
                "movie1: 29.0<BR>\n" +
                "<P>You owe <EM>29.0</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P> "));
    }
}
