package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.mid_term_test.oop;

@SuppressWarnings({"WeakerAccess", "unused"})
public class Teacher extends Person {
    private String contactNumber;
    private String department;

    public Teacher() {}

    public Teacher(String name, int age, String contactNumber, String department) {
        super(name, age);
        this.contactNumber = contactNumber;
        this.department = department;
    }

    public Teacher(String contactNumber, String department) {
        this.contactNumber = contactNumber;
        this.department = department;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("Contact Number: %s; Department: %s; ", getContactNumber(), getDepartment());
    }

    public void printTeacher() {
        System.out.println(this);
    }
}
