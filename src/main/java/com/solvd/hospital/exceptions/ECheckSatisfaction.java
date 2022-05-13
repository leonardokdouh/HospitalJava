package com.solvd.hospital.exceptions;

public class ECheckSatisfaction extends RuntimeException {
    @Override
    public String getMessage() {
        return "You enter an invalid argument";
    }
}
