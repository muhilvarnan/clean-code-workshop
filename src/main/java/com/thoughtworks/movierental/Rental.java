package com.thoughtworks.movierental;

public class Rental {

  private int daysRented;
  private Movie movie;

  public Rental(Movie movie, int daysRented){
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  public double getRentalAmount() {
    double amount = 0;
    switch (movie.getPriceCode()) {
      case Movie.REGULAR:
        amount += 2;
        if (daysRented > 2)
          amount += (daysRented - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        amount += daysRented * 3;
        break;
      case Movie.CHILDRENS:
        amount +=  1.5;
        if (daysRented> 3)
          amount += (daysRented - 3) * 1.5;
        break;
    }
    return amount;
  }

  private boolean isBonusApplicable() {
    return (movie.getPriceCode() == Movie.NEW_RELEASE)
            &&
            daysRented > 1;
  }

  public int getFrequentPoint() {
    int frequentPoint = 1;
    if (isBonusApplicable()) {
      return frequentPoint+1;
    }
    return  frequentPoint;
  }
}