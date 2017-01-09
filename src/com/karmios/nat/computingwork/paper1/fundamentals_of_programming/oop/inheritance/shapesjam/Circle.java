package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.oop.inheritance.shapesjam;

public class Circle extends GeometricObject{
    private double radius;

    public Circle() {
        this(1.0);
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius*radius*Math.PI;
    }

    public double getPerimiter() {
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
