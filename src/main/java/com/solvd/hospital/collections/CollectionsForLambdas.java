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
import java.util.stream.Collectors;

public class CollectionsForLambdas {
    private static final Logger LOG = LogManager.getLogger(CollectionsForLambdas.class);

    public void doctorsClasification() {
        PDoctors doctor1 = new PDoctors("Jake Peralta", "Clinical Doctor", Gender.MALE);
        PDoctors doctor2 = new PDoctors("Adrian Pimento", "X-Ray Doctor", Gender.MALE);
        PDoctors doctor3 = new PDoctors("Charles Boyle", "Emergency Doctor", Gender.MALE);
        PDoctors doctor4 = new PDoctors("Tania", "Emergency Doctor", Gender.FEMALE);
        PDoctors doctor5 = new PDoctors("Amy Santiago", "Clinical Doctor", Gender.FEMALE);
        PNurses nurse3 = new PNurses("Gina", "General Nursery", Gender.FEMALE);
        PNurses nurse4 = new PNurses("Ted", "General Nursery", Gender.MALE);
        PNurses nurse5 = new PNurses("Bob", "General Nursery", Gender.MALE);
        PNurses nurse6 = new PNurses("Bill", "General Nursery", Gender.MALE);
        PNurses nurse7 = new PNurses("Wendy", "General Nursery", Gender.FEMALE);

        Set<CPersons> listDoctors = new HashSet<>();
        java.util.Collections.addAll(listDoctors, doctor1, doctor2, doctor3, doctor5, doctor4
                , nurse3, nurse4, nurse5, nurse6, nurse7);

        long counting = listDoctors.stream().count();
        LOG.info("There are a total of " + counting + " " + "Professionals\n");

        List<CPersons> listMale = listDoctors.stream().filter(CPersons ->
                CPersons.getGender().equals(Gender.MALE)).collect(Collectors.toList());
        LOG.debug("\n This are the Male professionals\n");
        listMale.forEach(male -> LOG.info(male + "\n"));

        List<CPersons> listFemale = listDoctors.stream().filter(CPersons ->
                CPersons.getGender().equals(Gender.FEMALE)).collect(Collectors.toList());
        LOG.debug("\n This are the Female professionals \n");
        listFemale.forEach(female -> LOG.info(female + "\n"));

    }

    public void antibiotics() {
        List<CMedicine> pills = new ArrayList<>();
        CMedicine ibup = new MAntibiotic("Ibuprofene", "soli", 3);
        CMedicine caplets = new MAntibiotic("MedTabs", "solid", 4);
        CMedicine gumtabs = new MAntibiotic("Gummy", "gum", 7);
        CMedicine shot1 = new MVaccine("Shot", "intravenous", 1);

        pills.add(ibup);
        pills.add(caplets);
        pills.add(gumtabs);
        pills.add(shot1);

        Optional<CMedicine> result = pills.stream().findFirst();

        LOG.debug("The best seller in medicine is : " + " " + result.get() + "\n" +
                "The most used medicine is:");
        pills.stream().filter(p -> p.getName().startsWith("M")).forEach(LOG::info);

    }
}
