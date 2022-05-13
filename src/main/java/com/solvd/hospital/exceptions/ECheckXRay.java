package com.solvd.hospital.exceptions;

public class ECheckXRay extends RuntimeException {
    public ECheckXRay(String coment) {
        super(coment);
    }
}
