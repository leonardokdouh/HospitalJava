package com.solvd.hospital.collections;

import com.solvd.hospital.enums.Gender;
import com.solvd.hospital.medicines.CMedicine;
import com.solvd.hospital.medicines.MAntibiotic;
import com.solvd.hospital.medicines.MVaccine;
import com.solvd.hospital.persons.CPersons;
import com.solvd.hospital.persons.PDoctors;
import com.solvd.hospital.persons.PNurses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Collections {

    private static final Logger LOG = LogManager.getLogger(Collections.class);

    public void givingNewTurn() {
        LinkedList<String> turns = new LinkedList<>();
        turns.add("Patient #1  08:00");
        turns.add("Patient #2  09:00");
        ListIterator<String> it = turns.listIterator();

        LOG.debug("Need next turn? Let me check. There are only "
                + turns.size() + " " + "left");
        it.next();
        it.add("Free turn  08:30");
        it.next();
        it.add("Free turn  09:30");
        for (String persona : turns) {
            LOG.debug(persona);
        }
    }

    public void availableDoctors() {
        PDoctors doctorOne = new PDoctors("Jake Peralta", "Clinical Doctor", Gender.MALE);
        PDoctors doctorTwo = new PDoctors("Adrian Pimento", "X-Ray Doctor", Gender.MALE);
        PDoctors doctorThree = new PDoctors("Charles Boyle", "Emergency Doctor", Gender.MALE);
        PNurses nurseOne = new PNurses("Gina", "General Nursery", Gender.FEMALE);

        Set<CPersons> listDoctors = new HashSet<>();
        java.util.Collections.addAll(listDoctors, doctorOne, doctorTwo, doctorThree, nurseOne);

        for (CPersons docs : listDoctors) {
            LOG.debug(docs.getType() + " ---->" + docs.getName());
        }
    }

    public void antibiotics() {
        List<CMedicine> pills = new ArrayList<>();
        CMedicine caplets = new MAntibiotic("MedTabs", "solid", 4);
        CMedicine gumtabs = new MAntibiotic("Gummy", "gum", 7);
        CMedicine shot1 = new MVaccine("Vaccine", "intravenous", 1);
        pills.add(caplets);
        pills.add(gumtabs);
        pills.add(shot1);


        pills.forEach(p -> LOG.info(p.getData() + "\n"));


    }

    public void howToPay() {
        MethodPay cash = new MethodPay(1, "Cash");
        MethodPay debit = new MethodPay(2, "Debit Card");
        MethodPay credit = new MethodPay(3, "Credit Card");

        TreeSet<MethodPay> newTreePay = new TreeSet<>();
        newTreePay.add(cash);
        newTreePay.add(credit);
        newTreePay.add(debit);

        newTreePay.forEach(p -> LOG.debug(p.getTypes()));

    }


}





