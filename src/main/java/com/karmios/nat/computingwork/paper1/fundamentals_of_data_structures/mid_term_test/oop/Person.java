package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.mid_term_test.oop;

@SuppressWarnings("WeakerAccess")
public abstract class Person {
    private String name = "John";
    private int age = 18;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s; Age: %s; ", getName(), getAge());
    }

    public void printPerson() {
        System.out.println(this);
    }
}
