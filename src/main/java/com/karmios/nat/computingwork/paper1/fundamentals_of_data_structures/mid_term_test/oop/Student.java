package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.mid_term_test.oop;

@SuppressWarnings({"WeakerAccess", "unused"})
public class Student extends Person {
    private String form;
    private String favouriteSubject;

    public Student(){}

    public Student(String name, int age, String form, String favouriteSubject) {
        super(name, age);
        this.form = form;
        this.favouriteSubject = favouriteSubject;
    }

    public Student(String form, String favouriteSubject) {
        this.form = form;
        this.favouriteSubject = favouriteSubject;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getFavouriteSubject() {
        return favouriteSubject;
    }

    public void setFavouriteSubject(String favouriteSubject) {
        this.favouriteSubject = favouriteSubject;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Form: %s; Favourite Subject: %s;", getForm(), getFavouriteSubject());
    }

    public void printStudent() {
        System.out.println(this);
    }
}
