package com.solvd.hospital.util;

import com.solvd.hospital.exceptions.ECheckMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Intro {

    private static final Logger LOG = LogManager.getLogger(Intro.class);
    private final Scanner scanner = new Scanner(System.in);
    public int option;


    public int ChoseOption() {

        try {
            do {
                LOG.debug("WELCOME DEAR USER. CHOSE YOUR WAY" + "\n" +
                        "Option 1: Enter the Hospital" + "\n" +
                        "Option 2: Read the brochure " + "\n" +
                        "Option 3: Use the Text Util" + "\n" +
                        "Option 4: Close Hospital Simulation (Threads)");

                option = scanner.nextInt();


            } while (option >= 5);
        } catch (InputMismatchException e) {
            LOG.debug(e + "You are entering the Hospital");
            return 1;
        }
        return option;
    }

}