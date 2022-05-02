package com.solvd.hospital.areas;

import com.solvd.hospital.exceptions.ECheckTemperature;
import com.solvd.hospital.interfaces.ISanitacer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.Scanner;


public class ANursery extends CAreas implements ISanitacer {
    private static final Logger LOG = LogManager.getLogger(ANursery.class);
    private final Scanner scanner = new Scanner(System.in);

    public ANursery(String specialization) {
        super(specialization);
    }

    public int SpecialFunction() throws ECheckTemperature {
        Random random = new Random();
        LOG.debug("Sir i will take your temperature. OK ? Write any number for consent");
        try {
            int yes = scanner.nextInt();
            if (yes >= 0) {
                int temp = (random.nextInt(43) + 15);
                if (temp >= 38 && temp < 60) {
                    LOG.debug("Your temperature is: " + temp);
                }
                if (temp < 38) {
                    LOG.debug("Your temperature is: " + temp);
                    LOG.debug("Is not that high but anyways. You can go home");
                }
                return temp;
            }
            if (yes < 0) {
                throw new ECheckTemperature();
            }
            return 0;

        } catch (ECheckTemperature e) {
            LOG.debug("You are not getting your temp. We are going to hospitalize you");
            return 50;
        }
    }


    @Override
    public void sanitacer() {
        LOG.debug("WASH YOUR HANDS BEFORE ENTERING");

    }
}

