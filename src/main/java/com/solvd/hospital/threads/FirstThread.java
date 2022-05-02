package com.solvd.hospital.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;

public class FirstThread extends Thread {
    private static final Logger LOG = LogManager.getLogger(FirstThread.class);

    @Override
    public void run() {
        IntStream.range(-4, 0).forEach(p -> {
            LOG.info("All the Hospital will shut down in... " + -p);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        LOG.info("ALL THE HOSPITAL HAS BEEN CLOSED DUE TO A COVID INFECTION");
    }
}
