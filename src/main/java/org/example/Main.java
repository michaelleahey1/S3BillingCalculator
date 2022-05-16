package org.example;

public class Main {
    public static void main(String[] args){
        var s3BillingCalculator = new S3BillingCalculator(.10F, .25F, .50F);
        s3BillingCalculator.addStorageGB(1111, 1);
        s3BillingCalculator.addGetRequests(1111, 1000);
        s3BillingCalculator.addPutRequests(1111, 1000);

        s3BillingCalculator.addStorageGB(2222, 2);
        s3BillingCalculator.addGetRequests(2222, 2000);
        s3BillingCalculator.addPutRequests(2222, 2000);

        var invoice1 = s3BillingCalculator.createInvoice(1111);
        var invoice2 = s3BillingCalculator.createInvoice(2222);

        System.out.println(invoice1);
        System.out.println(invoice2);

    }

}