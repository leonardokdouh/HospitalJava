package com.solvd.hospital.enums;

public enum DrugsTypesDescription {
    IBUPROFEN("Used for treating pain, fever and inflammation."),
    ANTIVIRALS("used for treating viral infections"),
    ANESTHETICS("used to induce anesthesia-in other words, to result in a temporary loss of sensation or awareness.");


    public final String data;

    DrugsTypesDescription(String data) {
        this.data = data;
    }

}
