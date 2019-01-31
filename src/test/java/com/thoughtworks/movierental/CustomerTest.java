package com.thoughtworks.movierental;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void testGetName(){
        Customer customer = new Customer("test");
        assertEquals("test",customer.getName());
    }

    @Test
    public void  testStatementMovieRegularRentLessThan2Days(){
        Movie movie = new Movie("movie1", Movie.REGULAR);
        Rental rental = new Rental(movie, 1);
        Customer customer = new Customer("test");
        customer.addRental(rental);
        TextStatement textStatement = new TextStatement(customer);
        assertEquals("Rental Record for test\n" +
                "\tmovie1\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points",textStatement.statement());

    }

    @Test
    public void  testStatementMovieRegularRentGreaterThan2Days(){
        Movie movie = new Movie("movie1", Movie.REGULAR);
        Rental rental = new Rental(movie, 3);
        Customer customer = new Customer("test");
        customer.addRental(rental);
        TextStatement textStatement = new TextStatement(customer);
        assertEquals("Rental Record for test\n" +
                "\tmovie1\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points",textStatement.statement());

    }

    @Test
    public void  testStatementMovieNewRelease() {
        Movie movie = new Movie("movie1", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 1);
        Customer customer = new Customer("test");
        customer.addRental(rental);
        TextStatement textStatement = new TextStatement(customer);
        assertEquals("Rental Record for test\n" +
                "\tmovie1\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", textStatement.statement());
    }

    @Test
    public void  testStatementMovieNewReleaseRentedMoreThan1Day() {
        Movie movie = new Movie("movie1", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 2);
        Customer customer = new Customer("test");
        customer.addRental(rental);
        TextStatement textStatement = new TextStatement(customer);
        assertEquals("Rental Record for test\n" +
                "\tmovie1\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points", textStatement.statement());
    }

    @Test
    public void testStatementMovieChildrenRentedLessThan3Days(){
        Movie movie = new Movie("movie1", Movie.CHILDRENS);
        Rental rental = new Rental(movie, 2);
        Customer customer = new Customer("test");
        customer.addRental(rental);
        TextStatement textStatement = new TextStatement(customer);
        assertEquals("Rental Record for test\n" +
                "\tmovie1\t1.5\n" +
                "Amount owed is 1.5\n" +
                    "You earned 1 frequent renter points",textStatement.statement());

    }

    @Test
    public void testStatementMovieChildrenRentedGreaterThan3Days(){
        Movie movie = new Movie("movie1", Movie.CHILDRENS);
        Rental rental = new Rental(movie, 4);
        Customer customer = new Customer("test");
        customer.addRental(rental);
        TextStatement textStatement = new TextStatement(customer);
        assertEquals("Rental Record for test\n" +
                "\tmovie1\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points",textStatement.statement());

    }

    @Test
    public void testStatementNoRentals(){
        Customer customer = new Customer("test");
        TextStatement textStatement = new TextStatement(customer);
        assertEquals("Rental Record for test\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points",textStatement.statement());

    }

    @Test
    public void  testHtmlStatementMovieRegularRentLessThan2Days(){
        Movie movie = new Movie("movie1", Movie.REGULAR);
        Rental rental = new Rental(movie, 1);
        Customer customer = new Customer("test");
        customer.addRental(rental);
        assertEquals("Rental Record for test\n" +
                "\tmovie1\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points",customer.statement());

    }

    @Test
    public void  testHtmlStatementMovieRegularRentGreaterThan2Days(){
        Movie movie = new Movie("movie1", Movie.REGULAR);
        Rental rental = new Rental(movie, 3);
        Customer customer = new Customer("test");
        customer.addRental(rental);
        assertEquals("<h1>Rental Record for <b>test</b></h1><br />" +
                "movie1 3.5<br />" +
                "Amount owed is <b>3.5</b><br />" +
                "You earned <b>1</b> frequent renter points",customer.htmlStatement());

    }

    @Test
    public void  testHtmlStatementMovieNewRelease() {
        Movie movie = new Movie("movie1", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 1);
        Customer customer = new Customer("test");
        customer.addRental(rental);
        assertEquals("<h1>Rental Record for <b>test</b></h1><br />movie1 3.0<br />Amount owed is <b>3.0</b><br />You earned <b>1</b> frequent renter points", customer.htmlStatement());
    }

    @Test
    public void  testHtmlStatementMovieNewReleaseRentedMoreThan1Day() {
        Movie movie = new Movie("movie1", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 2);
        Customer customer = new Customer("test");
        customer.addRental(rental);
        assertEquals("<h1>Rental Record for <b>test</b></h1><br />movie1 6.0<br />Amount owed is <b>6.0</b><br />You earned <b>2</b> frequent renter points", customer.htmlStatement());
    }

    @Test
    public void testHtmlStatementMovieChildrenRentedLessThan3Days(){
        Movie movie = new Movie("movie1", Movie.CHILDRENS);
        Rental rental = new Rental(movie, 2);
        Customer customer = new Customer("test");
        customer.addRental(rental);
        assertEquals("<h1>Rental Record for <b>test</b></h1><br />movie1 1.5<br />Amount owed is <b>1.5</b><br />You earned <b>1</b> frequent renter points",customer.htmlStatement());

    }

    @Test
    public void tesHtmlStatementMovieChildrenRentedGreaterThan3Days(){
        Movie movie = new Movie("movie1", Movie.CHILDRENS);
        Rental rental = new Rental(movie, 4);
        Customer customer = new Customer("test");
        customer.addRental(rental);
        assertEquals("<h1>Rental Record for <b>test</b></h1><br />movie1 3.0<br />Amount owed is <b>3.0</b><br />You earned <b>1</b> frequent renter points",customer.htmlStatement());

    }

    @Test
    public void testHtmlStatementNoRentals(){
        Customer customer = new Customer("test");
        assertEquals("<h1>Rental Record for <b>test</b></h1><br />Amount owed is <b>0.0</b><br />You earned <b>0</b> frequent renter points",customer.htmlStatement());
    }

}