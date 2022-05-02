package com.solvd.hospital.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;

public class SecondThread implements Runnable {

    private static final Logger LOG = LogManager.getLogger(SecondThread.class);


    @Override
    public void run() {
        IntStream.range(0, 2).forEach(p -> {
            LOG.info("Run for your life everyone, run!!");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }
}
