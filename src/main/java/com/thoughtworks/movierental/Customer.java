package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private List<Rental> rentals = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public String getName() {
    return name;
  }

  private String getTitle() {
    return  "Rental Record for " + getName() + "\n";
  }

  private double getRentalAmount(Rental rental) {
    double amount = 0;
    switch (rental.getMovie().getPriceCode()) {
      case Movie.REGULAR:
        amount += 2;
        if (rental.getDaysRented() > 2)
          amount += (rental.getDaysRented() - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        amount += rental.getDaysRented() * 3;
        break;
      case Movie.CHILDRENS:
        amount +=  1.5;
        if (rental.getDaysRented() > 3)
          amount += (rental.getDaysRented() - 3) * 1.5;
        break;
    }
    return amount;
  }

  public String statement() {
    double totalAmount = 0;
    int frequentRenterPoints = 0;
    String result = getTitle();
    for (Rental each : rentals) {
      double thisAmount = getRentalAmount(each);
      // add frequent renter points
      frequentRenterPoints++;
      // add bonus for a two day new release rental
      if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
          &&
          each.getDaysRented() > 1) frequentRenterPoints++;

      //show figures for this rental
      result += "\t" + each.getMovie().getTitle() + "\t" +
          String.valueOf(thisAmount) + "\n";
      totalAmount += thisAmount;
    }

    //add footer lines result
    result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints)
        + " frequent renter points";
    return result;
  }
}

