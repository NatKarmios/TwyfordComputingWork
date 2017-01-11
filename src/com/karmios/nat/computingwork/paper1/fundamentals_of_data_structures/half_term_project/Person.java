package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.half_term_project;

import static com.karmios.nat.computingwork.utils.Utils.*;

@SuppressWarnings("unused")
abstract class Person {
    private String name, address;
    private Gender gender;

    // <editor-fold desc="Constructors">

    Person(String name, String address, Gender gender) {
        this.name = name;
        this.address = address;
        this.gender = gender;
    }

    Person(){
        this(
                input("Enter name: "),
                input("Enter address: "),
                inputLoop("Enter 'm' for male, or 'f' for female: ", "Invalid gender!",
                        str -> "mf".contains(str.toLowerCase().substring(0, 1)) )
                        .toLowerCase().charAt(0) == 'm' ? Gender.MALE : Gender.FEMALE
        );
    }

    // </editor-fold>

    // <editor-fold desc="Getters">

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Gender getGender() {
        return gender;
    }

    // </editor-fold>

    // <editor-fold desc="Setters">

    protected void setName(String name) {
        this.name = name;
    }

    protected void setAddress(String address) {
        this.address = address;
    }

    protected void setGender(Gender gender) {
        this.gender = gender;
    }

    // </editor-fold>

    enum Gender {MALE, FEMALE}

    @Override
    public String toString() {
        return "Name: " + name +
                ", Address: " + address +
                ", Gender: " + gender;
    }
}
