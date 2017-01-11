package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.oop.inheritance.shapesjam;

public class ShapesJam {
    public static void main(String[] args) {
        Circle circle = new Circle(1);
        System.out.println(circle);
        System.out.println(circle.getColor());
        System.out.println(circle.getRadius());
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimiter());

        Rectangle rectangle = new Rectangle(2, 4);
        System.out.println(rectangle);
        System.out.println(rectangle.getAres());
        System.out.println(rectangle.getPerimiter());

    }
}
