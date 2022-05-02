package com.solvd.hospital;

import com.solvd.hospital.Generics.GenericPayment;
import com.solvd.hospital.Generics.GenericPrinter;
import com.solvd.hospital.Generics.GenericSummery;
import com.solvd.hospital.areas.AEmergencyRoom;
import com.solvd.hospital.areas.ANursery;
import com.solvd.hospital.areas.ARegularConsult;
import com.solvd.hospital.areas.AXray;
import com.solvd.hospital.collections.Collections;
import com.solvd.hospital.collections.CollectionsForLambdas;
import com.solvd.hospital.enums.DrugsTypesDescription;
import com.solvd.hospital.enums.Gender;
import com.solvd.hospital.enums.MedicalReport;
import com.solvd.hospital.enums.PaymentMethods;
import com.solvd.hospital.exceptions.ECheckMenu;
import com.solvd.hospital.exceptions.ECheckSatisfaction;
import com.solvd.hospital.exceptions.ECheckTemperature;
import com.solvd.hospital.exceptions.ECheckXRay;
import com.solvd.hospital.functionalInterface.Discounter;
import com.solvd.hospital.functionalInterface.FIPrinter;
import com.solvd.hospital.functionalInterface.Multiplier;
import com.solvd.hospital.medicines.CMedicine;
import com.solvd.hospital.medicines.MAntibiotic;
import com.solvd.hospital.medicines.MVaccine;
import com.solvd.hospital.persons.PAdministrative;
import com.solvd.hospital.persons.PDoctors;
import com.solvd.hospital.persons.PNurses;
import com.solvd.hospital.persons.PPatients;
import com.solvd.hospital.threads.FirstThread;
import com.solvd.hospital.threads.SecondThread;
import com.solvd.hospital.threads.ThirdThread;
import com.solvd.hospital.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class App {
    private static final Logger LOG = LogManager.getLogger(App.class);

    public static void main(String[] args) throws ECheckMenu,
            ECheckXRay, ECheckSatisfaction, ECheckTemperature {

        Util utilities = new Util();
        Collections cols = new Collections();
        CollectionsForLambdas lamb = new CollectionsForLambdas();
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);


        GenericPrinter printDate = new GenericPrinter("Today is " + " " + date);
        GenericPrinter printTime = new GenericPrinter("The actual time is: " + " " +
                java.time.LocalTime.now());
        Intro introduction = new Intro();
        printDate.printing();
        printTime.printing();


        int introOption = introduction.ChoseOption();

        switch (introOption) {
            case 1:
                printingThings(p -> LOG.debug("WELCOME TO THE HOSPITAL" + p));

                LOG.debug("Right now this professionals are available:");
                cols.availableDoctors();

                int option = utilities.menu();
                turns(option);
                utilities.finalCheck();
                utilities.satisfaction();
                break;
            case 2:
                printingThings(p -> LOG.debug("HOSPITAL BROCHURE" + p));

                lamb.doctorsClasification();

                cols.antibiotics();
                lamb.antibiotics();

                printingThings(p -> LOG.debug("\nThis2 are the available Payment methods" + p));
                cols.howToPay();

                break;
            case 3:
                printingThings(p -> LOG.debug("THE COVID TEXT IT'S DONE" + p));
                utilities.readFile();
                break;

            case 4:
                printingThings(p -> LOG.debug("THIS IS A COVID SIMULATION EMERGENCY " + p + "\n"));

                ExecutorService thePool = Executors.newFixedThreadPool(3);

                FirstThread firsT = new FirstThread();
                Thread seconT = new Thread(new SecondThread());
                Thread thirdT = new Thread(new ThirdThread());

                firsT.setPriority(5);
                seconT.setPriority(5);
                thirdT.setPriority(10);
                thePool.execute(firsT);
                thePool.execute(seconT);
                thePool.execute(thirdT);
                thePool.shutdown();

                break;
        }

    }


    public static void turns(int number) throws ECheckXRay, ECheckTemperature {

        Collections col = new Collections();

        GenericSummery<Character, String, String> sum1 = new GenericSummery<>('A', "Regular Consult", "15/10/2020");
        GenericSummery<Integer, String, Integer> sum2 = new GenericSummery<>(4, "Downtown", 15);

        Map<String, String> tickets = new HashMap<>();
        tickets.put("0001", "$150 pesos");
        tickets.put("0002", "Br 150 Ruble");
        tickets.put("0003", "€ 560 euros");
        tickets.put("0004", "£ 150 pounds");
        tickets.put("0005", "¥ 150 yens");
        tickets.put("0006", "Br 240 Ruble");


        Multiplier mult = (x, y) -> {
            LOG.debug("The total of your bill is:" + "\n" + (x * y));
            if (x * y > 200) {
                LOG.debug("You are eligible for a discount");

                Discounter discounter = (z, p, q) -> {
                    LOG.debug("You get a " + q + "% off discount" +
                            "\n" + "So the total now is: " + "\n" + (p * (100 - q) / 100));
                };
                discounter.discount('$', (x * y), 20);

            }
        };

        switch (number) {
            case 1:
                GenericPayment pay1 = new GenericPayment<>(tickets.get("0001"));
                PAdministrative AdminOne = new PAdministrative("Meg", "Secretary", Gender.FEMALE, 40);
                PPatients newPatient = new PPatients("Billie");
                PDoctors DoctorOne = new PDoctors("Jake Peralta", "Clinical Doctor", Gender.MALE);
                ARegularConsult newConsult = new ARegularConsult("Covid");
                CMedicine newMed = new MAntibiotic("ibup", "pills", 4);
                Collections howPay0 = new Collections();
                LOG.debug(AdminOne.getData());
                DoctorOne.working();
                newPatient.waiting();
                DoctorOne.free();
                LOG.debug(DoctorOne.getData());
                LOG.debug(newPatient.getData());
                newConsult.SpecialFunction();
                LOG.debug(newMed.getData());
                newPatient.reading();
                LOG.debug(DrugsTypesDescription.IBUPROFEN.data);
                LOG.info(MedicalReport.REPORT1.data + "\n" + MedicalReport.REPORT2.data);
                newPatient.out();
                AdminOne.pay();
                howPay0.howToPay();
                LOG.info("I want to pay in " + PaymentMethods.CASH.data);
                AdminOne.change();
                pay1.payCash();
                col.givingNewTurn();

                LOG.debug(sum1.getSummery());


                break;

            case 2:
                GenericPayment pay2 = new GenericPayment<>(tickets.get("0002"));
                GenericPayment pay22 = new GenericPayment<>(tickets.get("0006"));
                MVaccine newVaccine = new MVaccine("Shot1", "Antiviral", 1);
                PAdministrative AdminTwo = new PAdministrative("Louis", "Secretary", Gender.FEMALE, 20);
                PPatients newPatientTwo = new PPatients("Joe");
                PDoctors DoctorTwo = new PDoctors("Adrian Pimento", "X-Ray Doctor", Gender.MALE);
                AXray newX = new AXray("Ultimate XRay ");
                Collections howPay1 = new Collections();

                LOG.debug(AdminTwo.getData());
                DoctorTwo.working();
                newPatientTwo.waiting();
                DoctorTwo.free();
                newX.sanitacer();
                LOG.debug(DoctorTwo.getData());
                LOG.debug(newPatientTwo.getData());
                LOG.debug(newX.getSpecialization());
                int thisFunc = newX.SpecialFunction();
                if (thisFunc > 6) {
                    LOG.info(MedicalReport.REPORT2.data);
                    newVaccine.takemed();
                    newVaccine.getData();
                    LOG.debug("The afraid patient read the Drug description");
                    LOG.info(DrugsTypesDescription.ANTIVIRALS.data);
                    newPatientTwo.outTwo();
                    AdminTwo.pay();
                    howPay1.howToPay();
                    mult.multiplication(100, 3);
                    pay22.payDebit();
                }
                if (thisFunc <= 6) {
                    LOG.info(MedicalReport.REPORT1.data);
                    AdminTwo.pay();
                    howPay1.howToPay();
                    pay2.payDebit();
                }
                LOG.debug(sum2.getSummery());
                break;

            case 3:
                GenericPayment pay3 = new GenericPayment<>(tickets.get("0003"));
                GenericPayment pay33 = new GenericPayment<>(tickets.get("0005"));
                PAdministrative AdminThree = new PAdministrative("Peter", "Secretary", Gender.MALE, 15);
                PNurses theNurse = new PNurses("Amy Santiago", "Nurse", Gender.FEMALE);
                PPatients newPatientThree = new PPatients("Timmy");
                ANursery areaNursery = new ANursery("Nursery ");
                CMedicine newMedTwo = new MVaccine("FormulaX", "Shoot", 1);
                Collections howPay2 = new Collections();

                LOG.debug(AdminThree.getData());
                theNurse.working();
                newPatientThree.waiting();
                theNurse.free();
                areaNursery.sanitacer();
                LOG.debug(theNurse.getData());
                LOG.debug(newPatientThree.getData());
                LOG.debug(areaNursery.getSpecialization());
                int option = areaNursery.SpecialFunction();

                if (option >= 38) {
                    LOG.debug(newMedTwo.getData());
                    LOG.info(MedicalReport.REPORT3.data);
                    newPatientThree.out();
                    AdminThree.pay();
                    howPay2.howToPay();
                    mult.multiplication(100, 7);
                    pay3.payCredit();
                    LOG.debug("The vaccine was an Anesthetics " + " " +
                            DrugsTypesDescription.ANESTHETICS.data);
                }
                if (option < 37) {
                    newPatientThree.out();
                    AdminThree.pay();
                    howPay2.howToPay();
                    pay33.payCredit();
                }
                break;

            case 4:
                GenericPayment pay4 = new GenericPayment<>(tickets.get("0004"));
                PAdministrative AdminFour = new PAdministrative("Stewie", "Helper", Gender.MALE, 2);
                PPatients newPatientFour = new PPatients("Rose");
                PDoctors doctorThree = new PDoctors("Charles Boyle", "Emergency Doctor", Gender.MALE);
                AEmergencyRoom newEmergency = new AEmergencyRoom("Emergency Room");
                Collections howPay3 = new Collections();

                LOG.debug(AdminFour.getData());
                newEmergency.callAmbulance();
                newEmergency.sanitacer();
                newPatientFour.waiting();
                newEmergency.rest();
                LOG.debug(doctorThree.getData());
                LOG.debug(newPatientFour.getData());
                LOG.debug(newEmergency.getSpecialization());
                newEmergency.SpecialFunction();
                LOG.info(MedicalReport.REPORT4.data);
                LOG.info(MedicalReport.REPORT5.data);
                howPay3.howToPay();
                LOG.debug(tickets.get("0005"));
                pay4.payDebit();

                break;
        }
    }

    static void printingThings(FIPrinter thing) {
        thing.print('!');
    }


}


