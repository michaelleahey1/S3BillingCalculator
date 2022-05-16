package org.example;

import java.text.NumberFormat;

public class Invoice {
    //
    // Data members
    //

    private final int userId;
    private final float total;
    private final float totalStorageCost;
    private final NumberFormat formatter;
    private final float totalGetRequetCost;
    private final float totalPutRequestCost;

    //
    // Constructors
    //

    public Invoice(int userId, float totalStorageCost, float totalGetRequetCost, float totalPutRequestCost, float total) {
        this.total = total;
        this.userId = userId;
        this.totalStorageCost = totalStorageCost;
        this.totalGetRequetCost = totalGetRequetCost;
        this.totalPutRequestCost = totalPutRequestCost;
        this.formatter = NumberFormat.getCurrencyInstance();
    }

    //
    // Overrides
    //

    @Override
    public String toString() {
        return "UserId: " + userId + "\n" +
                "Storage: " + formatter.format(this.totalStorageCost) + "\n" +
                "GET Requests: " + formatter.format(this.totalGetRequetCost) + "\n" +
                "PUT Requests: " + formatter.format(this.totalPutRequestCost) + "\n" +
                "Total Cost: " +  formatter.format(this.total) + "\n";
    }

}
