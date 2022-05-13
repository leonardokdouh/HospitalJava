package com.solvd.hospital.persons;

import com.solvd.hospital.enums.Gender;
import com.solvd.hospital.interfaces.IPricing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PAdministrative extends CPersons implements IPricing {
    private static final Logger LOG = LogManager.getLogger(PAdministrative.class);

    final private int minuts;

    public PAdministrative(String nam, String typ, Gender gender, int min) {
        super(nam, typ, gender);
        this.minuts = min;

    }

    public String getData() {
        return "Hello!!I' am" + " " + getName() + "the " + " " + getType() + "." + " You will have to wait " + this.minuts
                + " minutes and please come back after your appointment";
    }


    @Override
    public void pay() {
        LOG.debug("This are the pay methods that we have:");

    }

    @Override
    public void change() {
        LOG.debug("Thank you so much, here is your change");

    }
}






