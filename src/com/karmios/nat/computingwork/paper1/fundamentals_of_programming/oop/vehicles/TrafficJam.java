package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.oop.vehicles;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class TrafficJam {
    private static Random rng = new Random();
    static final String[] MAKES = {
            "Ford", "Honda", "Ferrari", "Porsche", "Mercedes", "BMW", "Mitsubishi", "Peugeot", "Bentley", "Nissan"
    };

    public static void main(String[] args) {
        ArrayList<Car> traffic = new ArrayList<>();
        IntStream.range(0, rng.nextInt(20)).forEach(x -> traffic.add(randomCar()));
    }

    private static Car randomCar() {
        String make = randomMake();
        String model = randomModel();
        int numberOfPassengers = rng.nextInt(5);
        float currentSpeed = rng.nextFloat()*120;
        float amountOfFuel = rng.nextFloat()*12;

        return new Car(make, model, numberOfPassengers, currentSpeed, amountOfFuel);
    }

    private static String randomMake() {
        return MAKES[rng.nextInt(MAKES.length)];
    }

    private static String randomModel() {
        return "'" + (65 + rng.nextInt(35));
    }
}
