package com.solvd.hospital.medicines;

public abstract class CMedicine {
    private int frequency;
    private String type;
    private String name;


    public CMedicine(String nam, String type, int freque) {
        this.name = nam;
        this.type = type;
        this.frequency = freque;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType() {
        this.type = this.type;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency() {
        this.frequency = frequency;
    }

    public String getData() {
        return "a";
    }
}