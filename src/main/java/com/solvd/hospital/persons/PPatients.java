package com.solvd.hospital.persons;

import com.solvd.hospital.interfaces.IPatientsState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PPatients extends CPersons implements IPatientsState {
    private static final Logger LOG = LogManager.getLogger(PPatients.class);


    public PPatients(String nam) {
        super(nam);
    }


    public String getData() {
        return "Hi Doctor! my name is " + "" + getName();
    }


    @Override
    public void waiting() {

        LOG.debug("The patience is waiting for the doctor");
    }

    @Override
    public void out() {
        LOG.debug("The patient remember that he/she has to return to the Secretary");

    }

    @Override
    public void outTwo() {
        LOG.debug("The patient will stay in the Hospital for 3 days");

    }

    @Override
    public void reading() {
        LOG.debug("The patient is reading the Medicine Description ");

    }


}


