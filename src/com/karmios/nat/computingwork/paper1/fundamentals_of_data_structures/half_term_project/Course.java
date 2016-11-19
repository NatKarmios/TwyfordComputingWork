package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.half_term_project;

import static com.karmios.nat.computingwork.utils.Utils.*;

@SuppressWarnings("unused")
class Course {
    private String name, code;
    private Department department;

    // <editor-fold desc="Constructors">

    @SuppressWarnings("WeakerAccess")
    Course(String name, String code, Department department) {
        this.name = name;
        this.code = code;
        this.department = department;
    }

    Course() {
        this(
                input("Enter course name: "),
                input("Enter course code: "),
                CollegeRegistration.inputDepartment()
        );
    }

    // </editor-fold>

    // <editor-fold desc="Getters">

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Department getDepartment() {
        return department;
    }

    // </editor-fold>

    @Override
    public String toString() {
        return "Name: " + name +
                ", Code: " + code +
                ", Department: " + department;
    }
}
