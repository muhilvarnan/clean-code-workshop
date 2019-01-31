package com.thoughtworks.movierental;

import java.util.List;

public class Rentals {
    private List<Rental> rentals;
    public Rentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public List<Rental> getItems() {
        return rentals;
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

    public void add(Rental rental) {
        rentals.add(rental);
    }
}
