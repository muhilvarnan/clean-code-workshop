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

  private Double getRentalTotalAmount() {
    double totalAmount = 0;
    for (Rental each : rentals) {
      totalAmount += each.getRentalAmount();
    }
    return totalAmount;
  }

  private int getFrequentPoints() {
    int frequentRenterPoints = 0;
    for (Rental each : rentals) {
      frequentRenterPoints += each.getFrequentPoint();
    }
    return frequentRenterPoints;
  }


  public String statement() {
    double totalAmount = getRentalTotalAmount();
    int frequentRenterPoints = getFrequentPoints();
    String result = getTitle();
    for (Rental each : rentals) {
      double thisAmount = each.getRentalAmount();
      //show figures for this rental
      result += "\t" + each.getMovie().getTitle() + "\t" +
          String.valueOf(thisAmount) + "\n";
    }

    //add footer lines result
    result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints)
        + " frequent renter points";
    return result;
  }
}

