package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.half_term_project;

import static com.karmios.nat.computingwork.Utils.*;

public class Student extends Person {
    private String contactNumber;

    Student(String name, String address, Gender gender, String contactNumber) {
        super(name, address, gender);
        this.contactNumber = contactNumber;
    }

    Student() {
        contactNumber = inputLoop("Enter contact number (digits only): ", "Contact number must only contain digits!",
                str -> str.trim().replace(" ", "").chars().allMatch(inBounds(48, 58))).trim().replace(" ", "");
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
