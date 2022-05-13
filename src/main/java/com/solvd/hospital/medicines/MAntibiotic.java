package com.solvd.hospital.medicines;

public class MAntibiotic extends CMedicine {


    public MAntibiotic(String nam, String type, int freque) {
        super(nam, type, freque);
    }

    @Override
    public String getData() {
        return "This medicine is called " + getName() + " it's " + getType()
                + " and you have to take it " + getFrequency() + "times per day";
    }
}


