package com.solvd.hospital.areas;

import com.solvd.hospital.exceptions.ECheckXRay;
import com.solvd.hospital.interfaces.ISanitacer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AXray extends CAreas implements ISanitacer {

    private final Scanner scanner = new Scanner(System.in);
    private static final Logger LOG = LogManager.getLogger(AXray.class);

    public AXray(String specialization) {
        super(specialization);
    }

    public int SpecialFunction() throws ECheckXRay {
        int pain = 0;

        LOG.debug("Please in a scale from 1 to 10, how much it hurts");
        try {
            pain = scanner.nextInt();
            if (pain < 0) {
                throw new ECheckXRay("Pain cannot be negative");
            }
        } catch (InputMismatchException e) {
            LOG.debug("e" + "I see it hurts a lot");
        } finally {
            if (pain <= 4 && pain > 0) {
                LOG.debug("You are ok");
            }
            if (pain > 4 && pain < 8) {
                LOG.debug("I will take a better look there");
            }
            if (pain > 8 && pain < 11) {
                LOG.debug("You need to go to the Xray lab ASAP");
            }
        }
        return pain;
    }


    @Override
    public void sanitacer() {
        LOG.debug("You should take care and use sanitacers more often");
    }
}
