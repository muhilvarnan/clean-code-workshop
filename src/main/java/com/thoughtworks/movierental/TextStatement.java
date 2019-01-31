package com.thoughtworks.movierental;

import java.util.List;

public class TextStatement {

    public String display(String name, Rentals rentals) {
        String result = "Rental Record for " + name + "\n";
        for (Rental each : rentals.getItems()) {
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(each.getRentalAmount())+ "\n";
        }

        //add footer lines result
        result += "Amount owed is " + String.valueOf(rentals.getRentalTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(rentals.getFrequentPoints())
                + " frequent renter points";
        return result;
    }
}
