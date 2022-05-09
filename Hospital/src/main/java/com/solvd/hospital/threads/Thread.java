package com.solvd.hospital.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;

public class Thread extends java.lang.Thread {
    private static final Logger LOG = LogManager.getLogger(Thread.class);

    private String text;
    private int number;
    private String textual;

    public Thread(String text, int number) {
        this.text = text;
        this.number = number;
    }

    public Thread(String textual) {
        this.textual = textual;
    }

    @Override
    public void run() {

        if (number > 0) {
            IntStream.range(-2, 0).forEach(p -> {
                LOG.info(text + ".   MESSAGE FROM THREAD nº" + number);
                try {
                    java.lang.Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        } else {
            IntStream.range(-4, 0).forEach(p -> {
                LOG.info(textual + -p);
                try {
                    java.lang.Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            LOG.info("ALL THE HOSPITAL HAS BEEN CLOSED DUE TO A COVID INFECTION");
        }
    }
}