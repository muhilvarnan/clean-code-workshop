package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

  private String name;
  private Rentals rentals = new Rentals();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public String getName() {
      return name;
  }


  public String statement() {
      return new TextStatement().display(name, rentals);
  }


  public String htmlStatement() {
      return new HtmlStatement().display(name, rentals);

  }
}

