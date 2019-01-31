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
        assertEquals("Rental Record for test\n" +
                "\tmovie1\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points",customer.statement());

    }

    @Test
    public void  testStatementMovieRegularRentGreaterThan2Days(){
        Movie movie = new Movie("movie1", Movie.REGULAR);
        Rental rental = new Rental(movie, 3);
        Customer customer = new Customer("test");
        customer.addRental(rental);
        assertEquals("Rental Record for test\n" +
                "\tmovie1\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points",customer.statement());

    }

    @Test
    public void  testStatementMovieNewRelease() {
        Movie movie = new Movie("movie1", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 1);
        Customer customer = new Customer("test");
        customer.addRental(rental);
        assertEquals("Rental Record for test\n" +
                "\tmovie1\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", customer.statement());
    }

    @Test
    public void  testStatementMovieNewReleaseRentedMoreThan1Day() {
        Movie movie = new Movie("movie1", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 2);
        Customer customer = new Customer("test");
        customer.addRental(rental);
        assertEquals("Rental Record for test\n" +
                "\tmovie1\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points", customer.statement());
    }

    @Test
    public void testStatementMovieChildrenRentedLessThan3Days(){
        Movie movie = new Movie("movie1", Movie.CHILDRENS);
        Rental rental = new Rental(movie, 2);
        Customer customer = new Customer("test");
        customer.addRental(rental);
        assertEquals("Rental Record for test\n" +
                "\tmovie1\t1.5\n" +
                "Amount owed is 1.5\n" +
                    "You earned 1 frequent renter points",customer.statement());

    }

    @Test
    public void testStatementMovieChildrenRentedGreaterThan3Days(){
        Movie movie = new Movie("movie1", Movie.CHILDRENS);
        Rental rental = new Rental(movie, 4);
        Customer customer = new Customer("test");
        customer.addRental(rental);
        assertEquals("Rental Record for test\n" +
                "\tmovie1\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points",customer.statement());

    }

    @Test
    public void testStatementNoRentals(){
        Customer customer = new Customer("test");
        assertEquals("Rental Record for test\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points",customer.statement());

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
        assertEquals("<html><head>Rental Record for test</head><body><h1>Rental Record for test</h1><b>Amount owed is 3.5</b><br /><b>You earned 1 frequent renter points</b><br /><b>test</b><br /></body></html>",customer.htmlStatement());

    }

    @Test
    public void  testHtmlStatementMovieNewRelease() {
        Movie movie = new Movie("movie1", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 1);
        Customer customer = new Customer("test");
        customer.addRental(rental);
        assertEquals("<html><head>Rental Record for test</head><body><h1>Rental Record for test</h1><b>Amount owed is 3.0</b><br /><b>You earned 1 frequent renter points</b><br /><b>test</b><br /></body></html>", customer.htmlStatement());
    }

    @Test
    public void  testHtmlStatementMovieNewReleaseRentedMoreThan1Day() {
        Movie movie = new Movie("movie1", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 2);
        Customer customer = new Customer("test");
        customer.addRental(rental);
        assertEquals("<html><head>Rental Record for test</head><body><h1>Rental Record for test</h1><b>Amount owed is 6.0</b><br /><b>You earned 2 frequent renter points</b><br /><b>test</b><br /></body></html>", customer.htmlStatement());
    }

    @Test
    public void testHtmlStatementMovieChildrenRentedLessThan3Days(){
        Movie movie = new Movie("movie1", Movie.CHILDRENS);
        Rental rental = new Rental(movie, 2);
        Customer customer = new Customer("test");
        customer.addRental(rental);
        assertEquals("<html><head>Rental Record for test</head><body><h1>Rental Record for test</h1><b>Amount owed is 1.5</b><br /><b>You earned 1 frequent renter points</b><br /><b>test</b><br /></body></html>",customer.htmlStatement());

    }

    @Test
    public void tesHtmlStatementMovieChildrenRentedGreaterThan3Days(){
        Movie movie = new Movie("movie1", Movie.CHILDRENS);
        Rental rental = new Rental(movie, 4);
        Customer customer = new Customer("test");
        customer.addRental(rental);
        assertEquals("<html><head>Rental Record for test</head><body><h1>Rental Record for test</h1><b>Amount owed is 3.0</b><br /><b>You earned 1 frequent renter points</b><br /><b>test</b><br /></body></html>",customer.htmlStatement());

    }

    @Test
    public void testHtmlStatementNoRentals(){
        Customer customer = new Customer("test");
        assertEquals("<html><head>Rental Record for test</head><body><h1>Rental Record for test</h1><b>Amount owed is 0.0</b><br /><b>You earned 0 frequent renter points</b><br /><b>test</b><br /></body></html>",customer.htmlStatement());

    }

}