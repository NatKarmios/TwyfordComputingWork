// Skeleton Program for the AQA A1 Summer 2017 examination
// this code should be used in conjunction with the Preliminary Material
// written by the AQA AS1 Programmer Team
// developed in the NetBeans IDE 8.1 programming environment

package com.karmios.nat.computingwork.paper1.q4.revision.seedsimulation;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import static java.util.stream.IntStream.range;
import static java.util.Arrays.stream;

public class Main {
    private static char SOIL = '.';
    private static char SEED = 'S';
    private static char PLANT = 'P';
    private static char ROCKS = 'X';
    private static int FIELD_LENGTH = 20;
    private static int FIELD_WIDTH = 35;


    // <editor-fold desc="Nat's helper functions" >

    private static Character[][] field = new Character[FIELD_LENGTH][FIELD_WIDTH];

    enum Seasons {SPRING, SUMMER, AUTUMN, WINTER}
    private static HashMap<Seasons, Runnable> seasonSimulators = new HashMap<>();
    static {
        seasonSimulators.put(Seasons.SPRING, Main::simulateSpring);
        seasonSimulators.put(Seasons.SUMMER, Main::simulateSummer);
        seasonSimulators.put(Seasons.AUTUMN, Main::simulateAutumn);
        seasonSimulators.put(Seasons.WINTER, Main::simulateWinter);
    }

    private static void fillWithSoil() {
        mapFieldCells(cell -> SOIL);
    }

    private static void simulate(Seasons season) {
        seasonSimulators.get(season).run();
    }

    private static void mapFieldRows(UnaryOperator<Character[]> operator) {
        field = Arrays.stream(field).map(operator).toArray(Character[][]::new);
    }

    private static void mapFieldCells(UnaryOperator<Character> operator) {
        mapFieldRows(row -> Arrays.stream(row).map(operator).toArray(Character[]::new));
    }

    private static boolean fieldIsValid(Character[][] newField) {
        return newField.length==FIELD_LENGTH && stream(newField).allMatch(arr -> arr.length==FIELD_WIDTH);
    }

    // </editor-fold>


    private static int getHowLongToRun() {
        Stream.of("Welcome to the Plant Growing simulation", "", "You can step through the simulation a year at a time",
                  "or run the simulation for 0 to 5 years",
                  "How many years do you want the simulation to run?").forEach(System.out::println);
        return Console.readInteger("Enter a number between 0 and 5, or -1 for stepping mode: ");
    }

    private static void createNewField() {
        fillWithSoil();
        field[FIELD_LENGTH / 2][FIELD_WIDTH / 2] = SEED;
    }

    private static void readFile() {
        try {
            fillWithSoil();
            Console.print("Enter file name: ");
            Character[][] newField = Files.lines(Paths.get(Console.readLine())).map(str -> str.chars()
                    .mapToObj(ch -> (char) ch).toArray(Character[]::new)).toArray(Character[][]::new);
            if (fieldIsValid(newField)) field=newField;
            else throw new Exception();
        } catch (Exception e) {
            Console.println("Invalid file!");
            createNewField();
        }
    }

    private static void initialiseField() {
        Console.print("Do you want to load a file with seed positions? (Y/N): ");
        if (Console.readLine().equals("Y")) readFile();
        else createNewField();
    }

    private static void display(Seasons season, int Year) {
        Console.println("\nSeason: " + season.toString().toLowerCase() + "  Year number: " + Year);
        range(0, FIELD_LENGTH).forEach(row -> Console.println(Arrays.stream(field[row])
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString()
                + "|" + String.format("%3d", row)));
    }

    private static void countPlants() {
        int count = (int) Arrays.stream(field).flatMap(Arrays::stream).filter(cell -> cell.equals(PLANT)).count();
        Console.println("There " + (count==1 ? "is 1 plant" : String.format("are %s plants", count)) + " growing");
    }

    private static void simulateSpring() {
        mapFieldCells(cell -> cell.equals(SEED) ? PLANT : cell);
        countPlants();
        if (new Random().nextInt(2) == 1) {
            AtomicInteger plantCount = new AtomicInteger();
            mapFieldCells(cell -> cell==PLANT && plantCount.getAndIncrement()%3==0 ? SOIL : cell);
            Console.println("There has been a frost");
            countPlants();
        }
    }

    private static void simulateSummer() {

        Random RandomInt = new Random();
        if (RandomInt.nextInt(3) == 0) {
            AtomicInteger plantCount = new AtomicInteger();
            mapFieldCells(ch -> plantCount.incrementAndGet()%2==0 ? SOIL : ch);
            Console.println("There has been a drought");
            countPlants();
        }
    }

    private static void seedLands(int row, int col) {
        if ((row >= 0 && row < FIELD_LENGTH && col >= 0 && col < FIELD_WIDTH) && field[row][col] == SOIL)
                field[row][col] = SEED;
    }

    private static void simulateAutumn() {
        range(0, FIELD_LENGTH).forEach(row -> range(0, FIELD_WIDTH).forEach(col ->
                range(-1, 2).forEach(rowOffset -> range(-1, 2).forEach(colOffset -> {
                    if (rowOffset!=0 || colOffset!=0) seedLands(row+rowOffset, col+colOffset);
                }))
        ));
    }

    private static void simulateWinter() {
        mapFieldCells(ch -> ch.equals(PLANT) ? SOIL : ch);
    }

    private static void simulateOneYear(int year) {
        Arrays.stream(Seasons.values()).forEach(season -> {display(season, year); simulate(season);});
    }

    private static void simulation() {
        int yearsToRun = getHowLongToRun();
        if (yearsToRun == 0) return;
        initialiseField();
        if (yearsToRun > 0)  range(1, yearsToRun+1).forEach(Main::simulateOneYear);
        else {
            int year = 0;
            do {
                simulateOneYear(year++);
                Console.print("Press Enter to run simulation for another year, Input X to stop: ");
            } while (!Console.readLine().toUpperCase().equals("X"));
        }
        Console.println("End of simulation");
        Console.readLine();
    }

    public static void main(String[] args) {

        simulation();
    }

}
