package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.half_term_project;

import jdk.nashorn.internal.objects.annotations.Function;

import java.util.NoSuchElementException;

import static com.karmios.nat.computingwork.utils.Utils.*;

@SuppressWarnings("unused")
class Teacher extends Person {
    private final Department department;
    private final float salary;
    private final transient Course course;
    private final String courseCode;

    // <editor-fold desc="Constructors">

    @SuppressWarnings("WeakerAccess")
    Teacher(String name, String address, Gender gender, Department department, float salary, Course course){
        super(name, address, gender);
        this.department = department;
        this.salary = salary;
        this.course = course;
        this.courseCode = this.course.getCode();
    }

    Teacher(String name, String address, Gender gender, Department department, float salary, String courseCode,
            FunctionWithException<String, Course, NoSuchElementException> courseGetter) {
        this(name, address, gender, department, salary, courseGetter.apply(courseCode));
    }

    Teacher(SupplierWithException<Course, ActionCancelledException> courseSupplier) throws ActionCancelledException {
        this.department = CollegeRegistration.inputDepartment();
        this.salary = Float.valueOf(inputLoop("Enter salary in thousands of pounds: ",
                                              "Must be a real number and at least 0!",
                                              runsCleanly(str -> Float.valueOf(str) >= 0) ));
        this.course = courseSupplier.get();
        this.courseCode = this.course.getCode();
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
