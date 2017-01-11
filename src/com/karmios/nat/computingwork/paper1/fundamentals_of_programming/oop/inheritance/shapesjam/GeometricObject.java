package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.oop.inheritance.shapesjam;

import java.time.LocalDate;

@SuppressWarnings("unused")
public class GeometricObject {
    private String color;
    private boolean filled;
    private LocalDate dateCreated;

    GeometricObject() {
        this("white", false);
    }

    GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        this.dateCreated = LocalDate.now();
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "GeometricObject{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
