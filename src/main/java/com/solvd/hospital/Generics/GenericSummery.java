package com.solvd.hospital.Generics;

public class GenericSummery<K, T, V> {

    final private K patientNumber;
    final private T area;
    final private V date;

    public GenericSummery(K patientNumber, T area, V date) {
        this.patientNumber = patientNumber;
        this.area = area;
        this.date = date;
    }

    public T getArea() {
        return area;
    }

    public V getDate() {
        return date;
    }

    public K getPatientNumber() {
        return patientNumber;
    }

    public String getSummery() {
        return "The patient  " + getPatientNumber() + " " + "went to the " + getArea() +
                "area, the day: " + getDate();
    }
}


