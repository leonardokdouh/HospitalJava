package com.solvd.hospital.Generics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GenericPrinter<T> {

    private static final Logger LOG = LogManager.getLogger(GenericPrinter.class);
    final private T whatToPrint;

    public GenericPrinter(T whatToPrint) {
        this.whatToPrint = whatToPrint;
    }

    public void printing() {
        LOG.debug(whatToPrint);
    }

}
