package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

  private String name;
  public List<Rental> rentals = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public String getName() {
    return name;
  }

  public Double getRentalTotalAmount() {
    double totalAmount = 0;
    for (Rental each : rentals) {
      totalAmount += each.getRentalAmount();
    }
    return totalAmount;
  }

  public int getFrequentPoints() {
    int frequentRenterPoints = 0;
    for (Rental each : rentals) {
      frequentRenterPoints += each.getFrequentPoint();
    }
    return frequentRenterPoints;
  }


  public String statement() {
    String result = "Rental Record for " + getName() + "\n";
    for (Rental each : rentals) {
      //show figures for this rental
      result += "\t" + each.getMovie().getTitle() + "\t" +
          String.valueOf(each.getRentalAmount())+ "\n";
    }

    //add footer lines result
    result += "Amount owed is " + String.valueOf(getRentalTotalAmount()) + "\n";
    result += "You earned " + String.valueOf(getFrequentPoints())
        + " frequent renter points";
    return result;
  }


  public String htmlStatement() {

      String result = "<h1>Rental Record for <b>" + getName() + "</b></h1><br />";
      for (Rental each : rentals) {
          //show figures for this rental
          result += each.getMovie().getTitle() + " " +
                  String.valueOf(each.getRentalAmount())+ "<br />";
      }

      //add footer lines result
      result += "Amount owed is <b>" + String.valueOf(getRentalTotalAmount()) + "</b><br />";
      result += "You earned <b>" + String.valueOf(getFrequentPoints()) + "</b>"
              + " frequent renter points";
      return result;

  }
}

