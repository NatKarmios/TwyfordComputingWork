package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.half_term_project;

import static com.karmios.nat.computingwork.Utils.*;

abstract class Person {
    private String name, address;
    private Gender gender;

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

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Gender getGender() {
        return gender;
    }

    enum Gender {MALE, FEMALE}
}
