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
    return  "Rental Record for " + getName();
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
    String result = getTitle() + "\n";
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

  private String getHtmlHead() {
    return  "<head>" + getTitle() +"</head>";
  }

  private String getHtmlBody() {
    String body = "<body>" +
              "<h1>"+getTitle()+"</h1>";
    body += "<b>Amount owed is " + String.valueOf(getRentalTotalAmount())+ "</b>";
    body += "<br />";
    body += "<b>You earned " + String.valueOf(getFrequentPoints())+ " frequent renter points</b>";
    body += "<br />";
    body += "<b>"+getName()+"</b>";
    body += "<br />";
    body +=   "</body>";
    return body;
  }

  public String htmlStatement() {
    String html = "<html>"+
            getHtmlHead() +
            getHtmlBody() +
            "</html>";
    return html;

  }
}

