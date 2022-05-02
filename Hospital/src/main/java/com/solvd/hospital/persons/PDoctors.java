package com.solvd.hospital.persons;

import com.solvd.hospital.enums.Gender;
import com.solvd.hospital.interfaces.IWorkingState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PDoctors extends CPersons implements IWorkingState {
    private static final Logger LOG = LogManager.getLogger(PDoctors.class);


    public PDoctors(String nam, String typ, Gender gender) {
        super(nam, typ, gender);
    }


    public String getData() {
        return "My name is  " + getName() + "" + " and i am the " + getType() + ".";
    }


    @Override
    public void working() {
        LOG.debug("The Doctor is working right now");

    }

    @Override
    public void free() {
        LOG.debug("Now he is free");

    }
}
