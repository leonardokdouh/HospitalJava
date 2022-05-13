package com.solvd.hospital.enums;

public enum PaymentMethods {
    CREDIT("Credit Card"),
    DEBIT("Debit Card"),
    CASH("Cash");

    public final String data;


    PaymentMethods(String thisData) {
        this.data = thisData;
    }

}
