package com.solvd.hospital.areas;

import com.solvd.hospital.interfaces.ISanitacer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.stream.IntStream;

public class ARegularConsult extends CAreas implements ISanitacer {
    private static final Logger LOG = LogManager.getLogger(ARegularConsult.class);


    public ARegularConsult(String specialization) {
        super(specialization);
    }

    public int SpecialFunction() {
        LOG.debug("ok we will make 3 covid test's to check that out");


        IntStream.range(1, 3).forEach(i -> {
            Random random = new Random();
            int temp = random.nextInt(50);
            if (temp > 37) {
                LOG.debug("This is the " + i + " " + "test. Your temperature is " + temp);
                LOG.debug("You have covid. Please go to your house");
                return;
            } else {
                LOG.debug("This " + i + "test was negative");
            }
        });
        return 0;
    }

    @Override
    public void sanitacer() {
        LOG.debug("You dont need to take care about Covid");
    }
}
