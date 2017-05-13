// Skeleton Program for the AQA A1 Summer 2017 examination
// this code should be used in conjunction with the Preliminary Material
// written by the AQA AS1 Programmer Team
// developed in the NetBeans IDE 8.1 programming environment

package com.karmios.nat.computingwork.paper1.q4.revision.seedsimulation;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

import static java.util.stream.IntStream.range;

public class Main {
    private static char SOIL = '.';
    private static char SEED = 'S';
    private static char PLANT = 'P';
    private static char ROCKS = 'X';
    private static int FIELD_LENGTH = 20;
    private static int FIELD_WIDTH = 35;

    private static Character[][] field = new Character[FIELD_LENGTH][FIELD_WIDTH];

    private static void fillWithSoil() {
        range(0, FIELD_LENGTH).forEach((row) -> range(0, FIELD_WIDTH).forEach((col) -> field[row][col] = SOIL));
    }

    private static int getHowLongToRun() {
        Console.println("Welcome to the Plant Growing simulation");
        Console.println();
        Console.println("You can step through the simulation a year at a time");
        Console.println("or run the simulation for 0 to 5 years");
        Console.println("How many years do you want the simulation to run?");
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
            field = Files.lines(Paths.get(Console.readLine())).map(str -> str.chars().mapToObj(ch -> (char) ch)
                    .toArray(Character[]::new)).toArray(Character[][]::new);
        } catch (Exception e) {
            createNewField();
        }
    }

    private static void initialiseField() {
        Console.print("Do you want to load a file with seed positions? (Y/N): ");
        if (Console.readLine().equals("Y")) readFile();
        else createNewField();
    }

    private static void display(String season, int Year) {
        Console.println("\nSeason: " + season + "  Year number: " + Year);
        for (int Row = 0; Row < FIELD_LENGTH; Row++) {
            for (int Column = 0; Column < FIELD_WIDTH; Column++) {
                Console.print(field[Row][Column]);
            }
            Console.println("|" + String.format("%3d", Row));
        }
        range(0, FIELD_LENGTH).forEach(row -> Console.println(Arrays.stream(field[row])
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString()
                + "|" + String.format("%3d", row)));
    }

    private static void countPlants() {
        int count = (int) Arrays.stream(field).flatMap(Arrays::stream).filter(cell -> cell.equals(PLANT)).count();
        Console.println("There " + (count==1 ? "is 1 plant" : String.format("are %s plants", count)) + " growing");
    }

    private static void simulateSpring() {
        int PlantCount;
        for (int Row = 0; Row < FIELD_LENGTH; Row++) {
            for (int Column = 0; Column < FIELD_WIDTH; Column++) {
                if (field[Row][Column] == SEED) {
                    field[Row][Column] = PLANT;
                }
            }
        }
        countPlants();
        if (new Random().nextInt(2) == 1) {
            PlantCount = 0;
            for (int Row = 0; Row < FIELD_LENGTH; Row++) {
                for (int Column = 0; Column < FIELD_WIDTH; Column++) {
                    if (field[Row][Column] == PLANT) {
                        PlantCount++;
                        if (PlantCount % 3 == 0) {
                            field[Row][Column] = SOIL;
                        }
                    }
                }
            }
            Console.println("There has been a frost");
            countPlants();
        }
    }

    private static void simulateSummer() {
        Random RandomInt = new Random();
        int RainFall = RandomInt.nextInt(3);
        int PlantCount;
        if (RainFall == 0) {
            PlantCount = 0;
            for (int Row = 0; Row < FIELD_LENGTH; Row++) {
                for (int Column = 0; Column < FIELD_WIDTH; Column++) {
                    if (field[Row][Column] == PLANT) {
                        PlantCount++;
                        if (PlantCount % 2 == 0) {
                            field[Row][Column] = SOIL;
                        }
                    }
                }
            }
            range(0, FIELD_LENGTH).forEach(row -> range(0, FIELD_WIDTH).forEach(col -> {}));
            Console.println("There has been a drought");
            countPlants();
        }
    }

    private static void seedLands(int row, int col) {
        if ((row >= 0 && row < FIELD_LENGTH && col >= 0 && col < FIELD_WIDTH) && field[row][col] == SOIL)
                field[row][col] = SEED;
    }

    private static void simulateAutumn() {
        for (int Row = 0; Row < FIELD_LENGTH; Row++) {
            for (int Column = 0; Column < FIELD_WIDTH; Column++) {
                if (field[Row][Column] == PLANT) {
                    seedLands(Row - 1, Column - 1);
                    seedLands(Row - 1, Column);
                    seedLands(Row - 1, Column + 1);
                    seedLands(Row, Column - 1);
                    seedLands(Row, Column + 1);
                    seedLands(Row + 1, Column - 1);
                    seedLands(Row + 1, Column);
                    seedLands(Row + 1, Column + 1);
                }
            }
        }
    }

    private static void simulateWinter() {
        for (int Row = 0; Row < FIELD_LENGTH; Row++) {
            for (int Column = 0; Column < FIELD_WIDTH; Column++) {
                if (field[Row][Column] == PLANT) {
                    field[Row][Column] = SOIL;
                }
            }
        }
    }

    private static void simulateOneYear(int Year) {
        simulateSpring();
        display("spring", Year);
        simulateSummer();
        display("summer", Year);
        simulateAutumn();
        display("autumn", Year);
        simulateWinter();
        display("winter", Year);
    }

    private static void simulation() {
        int yearsToRun;
        boolean continuing;
        int year;
        yearsToRun = getHowLongToRun();
        if (yearsToRun != 0) {
            initialiseField();
            if (yearsToRun >= 1) {
                for (year = 1; year <= yearsToRun; year++) {
                    simulateOneYear(year);
                }
            } else {
                continuing = true;
                year = 0;
                while (continuing) {
                    year++;
                    simulateOneYear(year);
                    Console.print("Press Enter to run simulation for another year, Input X to stop: ");
                    continuing = !Console.readLine().toUpperCase().equals("X");
                }
            }
            Console.println("End of simulation");
        }
        Console.readLine();
    }

    public static void main(String[] args) {

        simulation();
    }

}
