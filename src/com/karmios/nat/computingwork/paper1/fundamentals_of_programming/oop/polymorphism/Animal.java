package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.oop.polymorphism;

@SuppressWarnings("WeakerAccess")
public abstract class Animal {
    int numLegs = 4;

    public void talk() {
        System.out.println("I don't know!");
    }

    public int getNumLegs() {
        return numLegs;
    }

    public static void main(String[] args) {
        Animal animal;

        Dog dog = new Dog();
        animal = dog;

        dog.talk();
        animal.talk();


        Human human = new Human();
        animal = human;
        System.out.println(human.numLegs);
        System.out.println(animal.numLegs);

        System.out.println(human.getNumLegs());
        System.out.println(animal.getNumLegs());

    }
}

class Dog extends Animal {

    public void talk() {
        System.out.println("bork");
    }
}

class Human extends Animal {
    int numLegs = 2;

    public int getNumLegs() {
        return numLegs;
    }
}