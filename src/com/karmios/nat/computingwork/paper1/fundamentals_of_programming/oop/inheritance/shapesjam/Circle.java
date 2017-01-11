package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.oop.inheritance.shapesjam;

@SuppressWarnings("unused")
public class Circle extends GeometricObject{
    private double radius;

    public Circle() {
        this(1.0);
    }

    Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    double getArea() {
        return radius*radius*Math.PI;
    }

    double getPerimiter() {
        return radius*2*Math.PI;
    }

    public double getDiameter() {
        return radius*2;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                "} " + super.toString();
    }

    public void printCircle() {
        System.out.println(this);
    }
}
