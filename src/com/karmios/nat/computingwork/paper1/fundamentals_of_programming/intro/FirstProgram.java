package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.intro;

public class FirstProgram implements Runnable {
    public static void main(String[] args) {
        new FirstProgram().run();
    }

    @Override
    public void run() {
        System.out.println("Programming is fun!");
        System.out.println("Fundamentals First");
        System.out.println("Problem Driven");

        System.out.println((10.5 + 2 * 3) / (45 - 3.5));
    }
}
