package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.half_term_project;

import static com.karmios.nat.computingwork.utils.Utils.*;

@SuppressWarnings("unused")
class Student extends Person {
    private String contactNumber;

    // <editor-fold desc="Constructors">

    Student(String name, String address, Gender gender, String contactNumber) {
        super(name, address, gender);
        this.contactNumber = contactNumber;
    }

    Student() {
        contactNumber = inputLoop("Enter contact number (digits only): ", "Contact number must only contain digits!",
                str -> str.trim().replace(" ", "").chars().allMatch(inBounds(48, 58))).trim().replace(" ", "");
    }

    // </editor-fold>

    public String getContactNumber() {
        return contactNumber;
    }

    // <editor-fold desc="Setters">

    public void setName(String name) {
        super.setName(name);
    }

    public void setAddress(String address) {
        super.setAddress(address);
    }

    public void setGender(Gender gender) {
        super.setGender(gender);
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    // </editor-fold>

    @Override
    public String toString() {
        return super.toString() + ", " +
                "Contact Number: " + contactNumber;
    }
}
