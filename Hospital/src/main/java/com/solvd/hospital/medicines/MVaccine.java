package com.solvd.hospital.medicines;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MVaccine extends CMedicine {
    private static final Logger LOG = LogManager.getLogger(CMedicine.class);


    public MVaccine(String nam, String type, int frequency) {
        super(nam, type, frequency);
    }

    public void takemed() {
        LOG.debug("Sorry but i need to give you this vaccine");
    }

    @Override
    public String getData() {
        return "This vaccine is called " + getName() + " it's  a " + getType()
                + " and you have to take it " + getFrequency() + "time only";
    }
}
