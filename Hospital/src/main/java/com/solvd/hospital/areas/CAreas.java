package com.solvd.hospital.areas;


import com.solvd.hospital.exceptions.ECheckTemperature;
import com.solvd.hospital.exceptions.ECheckXRay;

public abstract class CAreas {

    public final String specialization;

    public CAreas(String special) {
        this.specialization = special;
    }

    public String getSpecialization() {
        return "Ok partner, this is the  " + this.specialization + " specialization area. Please sit";
    }

    public abstract int SpecialFunction() throws ECheckXRay, ECheckTemperature;
}
