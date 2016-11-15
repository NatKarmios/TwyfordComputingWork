package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.oop.vehicles;


public class Car {
    String make, model;
    int numberOfPassangers;
    float currentSpeed, amountOfPetrol;

    public Car(String make, String model, int numberOfPassangers, float currentSpeed, float amountOfPetrol) {
        this.make = make;
        this.model = model;
        this.numberOfPassangers = numberOfPassangers;
        this.currentSpeed = currentSpeed;
        this.amountOfPetrol = amountOfPetrol;
    }

    public Car(String make, String model) {
        this(make, model, 0, 0.0f, 0.0f);
    }


    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getNumberOfPassangers() {
        return numberOfPassangers;
    }

    public float getCurrentSpeed() {
        return currentSpeed;
    }

    public float getAmountOfPetrol() {
        return amountOfPetrol;
    }

    void accelerate(float amount) {
        currentSpeed += amount;
    }

    void brake(float amount) {
        accelerate(-amount);
    }

    void addPetrol(float amount) {
        amountOfPetrol += amount;
    }
}