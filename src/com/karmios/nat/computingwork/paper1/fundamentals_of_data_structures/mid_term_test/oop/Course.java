package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.mid_term_test.oop;

@SuppressWarnings({"WeakerAccess", "unused"})
public class Course {
    private String name;
    private Teacher teacher;

    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return String.format("Name: %s; Teacher: (%s); ", getName(), getTeacher().toString());
    }

    public void printCourse() {
        System.out.println(this);
    }
}
