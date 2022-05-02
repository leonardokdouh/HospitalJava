package com.solvd.hospital.util;

import com.solvd.hospital.exceptions.ECheckMail;
import com.solvd.hospital.exceptions.ECheckMenu;
import com.solvd.hospital.exceptions.ECheckSatisfaction;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Util {
    private static final Logger LOG = LogManager.getLogger(Util.class);
    private final Scanner scanner = new Scanner(System.in);

    public int menu() throws ECheckMenu {
        int option = 1;
        LOG.debug("\nChose the option below:\n" + "Opcion 1: Medical Department\n" + "Option 2: Radiology \n" + "Option 3:Nursery\n" + "Option 4:Emergency \n ");

        try {
            option = scanner.nextInt();

        } catch (ECheckMenu e) {
            LOG.debug("Sir/Miss, since you did not decide, i will sent you to the Medical department");
        }
        if (option > 4) {
            throw new ECheckMenu("\n" + "You enter a invalid option. Come back later");
        }
        return option;

    }


    public void satisfaction() throws ECheckSatisfaction {
        char note;

        LOG.debug("Can you rate our service?" + "\n" + "C for Bad" + "\n" + "B for Good" + "\n" + "A for Awesome");
        try {
            note = scanner.next().charAt(0);
            if (note != 'A' && note != 'B' && note != 'C') {
                throw new ECheckSatisfaction();
            } else {
                if (note == 'C') {
                    LOG.debug("Sorry that you dont like our services");
                }
                if (note == 'B') {
                    LOG.debug("Thank for your time sir");

                }
                if (note == 'A') {
                    LOG.debug("I'am glad you like our service!");
                }
            }
        } catch (ECheckSatisfaction e) {
            LOG.debug(e + "You just need to put a letter");
        }
    }


    public void checkMail(String mail) throws ECheckMail {
        AtomicInteger arroba = new AtomicInteger();
        AtomicBoolean dot = new AtomicBoolean(false);

        if (mail.length() <= 2) {
            throw new ECheckMail("\n" + "You have to write better");
        } else {
            IntStream.range(0, mail.length()).forEach(p -> {

                if (mail.charAt(p) == '@') {
                    arroba.getAndIncrement();
                }
                if (mail.charAt(p) == '.') {
                    dot.set(true);
                }
            });
        }
        if (dot.get() && arroba.get() == 1) {
            LOG.debug("Thank you sir for your email");
        } else {
            LOG.debug("That mail is incorrect. No problem.");
        }
    }

    public String mail() {
        LOG.debug("If you want notifications, please enter your email. " + "If not, enter whatever you want ");
        return scanner.next();
    }

    public void finalCheck() {

        try {
            String mymail = mail();
            checkMail(mymail);
        } catch (ECheckMail e) {
            LOG.debug("Something went wrong" + e);
        }
    }


    public void readFile() {

        try {
            File myCovidFile = new File("src/main/resources/covid.txt");
            String text = FileUtils.readFileToString(myCovidFile, "UTF-8");
            String[] str = StringUtils.split(text);
            List<String> thisList = new ArrayList<>();
            Collections.addAll(thisList, str);
            FileWriter finalFile = new FileWriter("src/main/resources/final.txt");


            IntStream.range(0, thisList.size() - 1).forEach(i -> {
                AtomicInteger counting = new AtomicInteger(0);
                IntStream.range(i, thisList.size() - 1).forEach(j -> {
                    if (thisList.get(i).equalsIgnoreCase(thisList.get(j))) {
                        counting.getAndIncrement();
                    }
                });
                try {
                    finalFile.append("\n" + thisList.get(i) + "---------" + counting);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            finalFile.close();

        } catch (FileNotFoundException e) {
            LOG.error("Wrong path for the file" + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}








