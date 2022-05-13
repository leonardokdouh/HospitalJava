package com.solvd.hospital.persons;

import com.solvd.hospital.enums.Gender;
import com.solvd.hospital.interfaces.IWorkingState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PNurses extends CPersons implements IWorkingState {

    private static final Logger LOG = LogManager.getLogger(PNurses.class);

    public PNurses(String nam, String typ, Gender gender) {
        super(nam, typ, gender);

    }

    @Override
    public String getData() {
        return "My name is  " + " " + getName() + " " + "and i will be your " + getType();
    }

    @Override
    public void working() {
        LOG.debug("The nurse will come in a moment");


    }

    @Override
    public void free() {
        LOG.debug("Now she is free, please enter the room");


    }
}



