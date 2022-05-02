package com.solvd.hospital.collections;

public class MethodPay implements Comparable<MethodPay> {

    public MethodPay(int num, String type) {
        number = num;
        types = type;
    }

    @Override
    public int compareTo(MethodPay o) {
        return number - o.number;
    }

    private final int number;
    private final String types;

    public String getTypes() {
        return types;
    }

}
