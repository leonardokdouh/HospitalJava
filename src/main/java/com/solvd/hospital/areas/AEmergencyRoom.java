package com.solvd.hospital.areas;

import com.solvd.hospital.interfaces.ISanitacer;
import com.solvd.hospital.interfaces.IWarning;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class AEmergencyRoom extends CAreas implements IWarning, ISanitacer {
    private static final Logger LOG = LogManager.getLogger(AEmergencyRoom.class);

    private final Scanner scanner = new Scanner(System.in);

    public AEmergencyRoom(String specialization) {
        super(specialization);
    }

    public int SpecialFunction() {

        char pain;
        do {
            LOG.debug("Does this hurt you?     Y=yes       N=No");
            pain = scanner.next().charAt(0);
        } while (pain != 'Y');

        LOG.debug("ok, here is your problem. You arm its broken");
        return 0;
    }

    @Override
    public void callAmbulance() {
        LOG.debug("Bring me a wheel chair and Call the ambulance right now!!!");

    }

    @Override
    public void rest() {
        LOG.debug("Here is the chair, sit back and keep it cool");
    }

    @Override
    public void sanitacer() {
        LOG.debug("SPRAY WITH ALCOHOL PLEASE");
    }
}