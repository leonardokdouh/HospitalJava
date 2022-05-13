package com.solvd.hospital.persons;

import com.solvd.hospital.enums.Gender;

public abstract class CPersons {
    private String name;
    private String type;
    private Gender gender;

    public CPersons(String nam, String typ, Gender gender) {
        this.name = nam;
        this.type = typ;
        this.gender = gender;
    }

    public CPersons(String nam) {
        this.name = nam;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public abstract String getData();

    public Gender getGender() {
        return gender;
    }

    public String toString() {
        return "Person{" + "name='" + name + "type= "
                + type + "gender= " + gender + '}';
    }

}



