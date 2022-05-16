package org.example;

public class S3BillingItem {
    //
    // Data members
    //

    private float storageInGB;
    private int numPutRequests;
    private int numGetRequests;

    //
    // Constructors
    //

    public S3BillingItem() {
        this.storageInGB = 0;
        this.numPutRequests = 0;
        this.numGetRequests = 0;
    }

    //
    // Public Methods
    //

    public void incrementStorage(float storage) {
        this.storageInGB += storage;
    }

    public void incrementPutRequests(float putRequests) {
        this.numPutRequests += putRequests;
    }

    public void incrementGetRequests(float getRequests) {
        this.numGetRequests += getRequests;
    }

    //
    // Accessors
    //

    public float getStorage() {
        return storageInGB;
    }

    public int getPutRequests() {
        return numPutRequests;
    }

    public int getGetRequests() {
        return numGetRequests;
    }

}
