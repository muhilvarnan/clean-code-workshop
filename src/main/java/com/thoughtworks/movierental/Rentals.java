package com.thoughtworks.movierental;

import java.util.List;
import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {

    public Double getRentalTotalAmount() {
        double totalAmount = 0;
        for (Rental each : this) {
            totalAmount += each.getRentalAmount();
        }
        return totalAmount;
    }

    public int getFrequentPoints() {
        int frequentRenterPoints = 0;
        for (Rental each : this) {
            frequentRenterPoints += each.getFrequentPoint();
        }
        return frequentRenterPoints;
    }

}
