package com.solvd.hospital.util;

import com.solvd.hospital.enums.Gender;
import com.solvd.hospital.persons.CPersons;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.*;
import java.util.stream.IntStream;

public class Reflection {
    private static final Logger LOG = LogManager.getLogger(Reflection.class);

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {

        try {
            Class theClass = Class.forName("com.solvd.hospital.persons.CPersons");
            Field[] dataList = theClass.getDeclaredFields();
            IntStream.range(0, dataList.length).forEach(p -> {
                Field reflex = dataList[p];
                reflex.getModifiers();

                LOG.info("Name= " + reflex.getName()
                        + " Data = " + reflex.getType()
                        + " Public/Private = " + Modifier.toString(reflex.getModifiers()));
            });


            Constructor<CPersons> constructor = theClass.getConstructor
                    (String.class, String.class, Gender.class);
            CPersons doctor = constructor.newInstance("Pablo", "Doctor", Gender.MALE);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


