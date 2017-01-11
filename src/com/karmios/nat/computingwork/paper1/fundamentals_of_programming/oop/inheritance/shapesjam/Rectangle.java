package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.oop.inheritance.shapesjam;

@SuppressWarnings("unused")
public class Rectangle extends GeometricObject {
    private double width, height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    double getAres() {
        return width*height;
    }

    double getPerimiter() {
        return width*2 + height*2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                "} " + super.toString();
    }
}
