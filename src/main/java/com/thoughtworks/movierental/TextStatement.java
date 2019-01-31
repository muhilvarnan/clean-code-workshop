package com.thoughtworks.movierental;

public class TextStatement {
    private Customer customer;

    public TextStatement(Customer customer) {
        this.customer = customer;
    }


    public String statement() {
        String result = "Rental Record for " + customer.getName() + "\n";
        for (Rental each : customer.rentals) {
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(each.getRentalAmount())+ "\n";
        }

        //add footer lines result
        result += "Amount owed is " + String.valueOf(customer.getRentalTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(customer.getFrequentPoints())
                + " frequent renter points";
        return result;
    }
}
