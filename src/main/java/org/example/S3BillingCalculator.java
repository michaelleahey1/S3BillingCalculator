package org.example;

import java.util.HashMap;

public class S3BillingCalculator {
    //
    // Data members
    //

    private final int REQUEST_QUANTITY = 1000;
    private final float storageCost;
    private final float getRequestsCost;
    private final float putRequestsCost;
    private final HashMap<Integer, S3BillingItem> s3BillingMap; // Key = UserId

    //
    // Constructors
    //

    public S3BillingCalculator(float storage, float putRequests, float getRequests) {
        this.storageCost = storage;
        this.putRequestsCost = putRequests / REQUEST_QUANTITY;
        this.getRequestsCost = getRequests / REQUEST_QUANTITY;
        this.s3BillingMap = new HashMap<Integer, S3BillingItem>();
    }

    //
    // Public Methods
    //

    public void addStorageGB(int userId, int amount) {
        var s3BillingItem = getOrCreateS3BillingItem(userId);
        s3BillingItem.incrementStorage(amount);
    }

    public void addPutRequests(int userId, int number) {
        var s3BillingItem = getOrCreateS3BillingItem(userId);
        s3BillingItem.incrementPutRequests(number);
    }

    public void addGetRequests(int userId, int number) {
        var s3BillingItem = getOrCreateS3BillingItem(userId);
        s3BillingItem.incrementGetRequests(number);
    }

    public Invoice createInvoice(int userId) {
        var s3BillingItem = s3BillingMap.get(userId);
        var totalStorageCost = s3BillingItem.getStorage() * storageCost;
        var totalPutRequestCost = s3BillingItem.getPutRequests() * putRequestsCost;
        var totalGetRequestCost = s3BillingItem.getGetRequests() * getRequestsCost;
        var totalCost = totalStorageCost + totalPutRequestCost + totalGetRequestCost;
        return new Invoice(userId, totalStorageCost, totalGetRequestCost, totalPutRequestCost, totalCost);
    }

    //
    // Private Methods
    //

    private S3BillingItem getOrCreateS3BillingItem(int userId) {
        S3BillingItem retval;
        if (!s3BillingMap.containsKey(userId)) {
            retval = new S3BillingItem();
            s3BillingMap.put(userId, retval);
        } else {
            retval = s3BillingMap.get(userId);
        }
        return retval;
    }

}
