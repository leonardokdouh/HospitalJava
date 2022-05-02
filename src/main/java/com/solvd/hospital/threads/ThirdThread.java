package com.solvd.hospital.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;

public class ThirdThread implements Runnable {

    private static final Logger LOG = LogManager.getLogger(ThirdThread.class);

    @Override
    public void run() {

        IntStream.range(0, 2).forEach(p -> {

            LOG.info("THIS IS A SIMULATION");

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


    }
}


