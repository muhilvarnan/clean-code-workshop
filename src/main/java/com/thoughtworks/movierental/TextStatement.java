package com.thoughtworks.movierental;

import java.util.List;

public class TextStatement {

    public String display(String name, List<Rental> rentals, double totalAmount, int frequentPoints) {
        String result = "Rental Record for " + name + "\n";
        for (Rental each : rentals) {
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(each.getRentalAmount())+ "\n";
        }

        //add footer lines result
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentPoints)
                + " frequent renter points";
        return result;
    }
}
