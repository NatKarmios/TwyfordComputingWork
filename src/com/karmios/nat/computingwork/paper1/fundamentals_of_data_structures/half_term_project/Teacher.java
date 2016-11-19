package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.half_term_project;

import static com.karmios.nat.computingwork.utils.Utils.*;

@SuppressWarnings("unused")
class Teacher extends Person {
    private Department department;
    private float salary;
    private Course course;

    // <editor-fold desc="Constructors">

    Teacher(String name, String address, Gender gender, Department department, float salary, Course course){
        super(name, address, gender);
        this.department = department;
        this.salary = salary;
        this.course = course;
    }

    Teacher() throws ActionCancelledException {
        this.department = CollegeRegistration.inputDepartment();
        this.salary = Float.valueOf(inputLoop("Enter salary in thousands of pounds: ",
                                              "Must be a real number and at least 0!",
                                              runsCleanly(str -> Float.valueOf(str) >= 0) ));
        this.course = CollegeRegistration.inputCourse();
    }

    // </editor-fold>

    // <editor-fold desc="Getters">

    public Department getDepartment() {
        return department;
    }

    public float getSalary() {
        return salary;
    }

    public Course getCourse() {
        return course;
    }

    // </editor-fold>

    @Override
    public String toString() {
        return super.toString() + ", " +
                "Department: " + department +
                ", Salary: " + salary +
                ", Course: " + course.getCode();
    }
}
