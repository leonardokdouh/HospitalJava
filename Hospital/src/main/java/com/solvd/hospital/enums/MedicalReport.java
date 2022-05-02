package com.solvd.hospital.enums;

public enum MedicalReport {

    REPORT1("The patient has no pain. No rooms need"),
    REPORT2("The patient do have pain."),
    REPORT3("The patient will stay at the hospital for 1 week"),
    REPORT4("The patient is in coma"),
    REPORT5("The patient died after the doctor's intervention");

    public final String data;

    MedicalReport(String data) {
        this.data = data;
    }
}
