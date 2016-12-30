/*
  Skeleton Program code for the AQA A Level Paper 1 2017 examination
  this code should be used In conjunction With the Preliminary Material
  written by the AQA Programmer Team
  developed in the NetBeans IDE 8.1 programming environment

  Additional file AQAConsole2017 is used.

  A package name may be chosen and private and public modifiers added
  Permission to make these changes to the Skeleton Program does not
  need to be obtained from AQA/AQA Programmer

 */

package com.karmios.nat.computingwork.paper1.christmas_holidays.rabbits_and_foxes;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;

@SuppressWarnings("ALL")
public class RabbitsAndFoxes
{
    public static void main(String[] args) {
        Simulation Sim;
        int MenuOption;
        int LandscapeSize;
        int InitialWarrenCount;
        int InitialFoxCount;
        int Variability;
        Boolean FixedInitialLocations;
        do
        {
            Console.println("Predator Prey Simulation Main Menu");
            Console.println();
            Console.println("1. Run simulation with default settings");
            Console.println("2. Run simulation with custom settings");
            Console.println("3. Rabbit Paradise");
            Console.println("4. Exit");
            Console.println();
            MenuOption = Console.readInteger("Select option: ");
            if (MenuOption == 1 || MenuOption == 2 || MenuOption == 3)
            {
                if (MenuOption == 1)
                {
                    LandscapeSize = 15;
                    InitialWarrenCount = 6;
                    InitialFoxCount = 5;
                    Variability = 0;
                    FixedInitialLocations = true;
                }
                else if (MenuOption == 2)
                {
                    LandscapeSize = Console.readInteger("Landscape Size: ");
                    InitialWarrenCount = Console.readInteger("Initial number of warrens: ");
                    InitialFoxCount = Console.readInteger("Initial number of foxes: ");
                    Variability = Console.readInteger("Randomness variability (percent): ");
                    FixedInitialLocations = false;
                }
                else {
                    LandscapeSize = 20;
                    InitialWarrenCount = 20;
                    InitialFoxCount = 0;
                    Variability = 1;
                    FixedInitialLocations = false;
                }
                Sim = new Simulation(LandscapeSize, InitialWarrenCount, InitialFoxCount, Variability, FixedInitialLocations);
            }
        } while (MenuOption != 4);
        Console.readLine();
    }
}

@SuppressWarnings("ALL")
class Location
{
    public Fox Fox;
    public Warren Warren;
    public Den Den;

    public Location()
    {
        Fox = null;
        Warren = null;
        Den = null;
    }
}

@SuppressWarnings("ALL")
class Simulation
{
    private Location[][] Landscape;
    private int TimePeriod = 0;
    private int WarrenCount = 0;
    private int FoxCount  = 0;
    private Boolean ShowDetail = false;
    private int LandscapeSize;
    private int Variability;
    private static Random Rnd = new Random();

    private WarrenGraph warrenGraph = WarrenGraph.getDefault();

    public Simulation(int LandscapeSize, int InitialWarrenCount,
        int InitialFoxCount, int Variability, Boolean FixedInitialLocations)
    {
        int MenuOption;
        int x;
        int y;
        String ViewRabbits;
        this.LandscapeSize = LandscapeSize;
        this.Variability = Variability;
        Landscape = new Location[LandscapeSize][LandscapeSize];
        CreateLandscapeAndAnimals(InitialWarrenCount, InitialFoxCount, FixedInitialLocations);
        DrawLandscape();
        do
        {
            Console.println();
            Console.println("0. Advance 10 time periods hiding detail");
            Console.println("1. Advance to next time period showing detail");
            Console.println("2. Advance to next time period hiding detail");
            Console.println("3. Inspect fox");
            Console.println("4. Inspect warren");
            Console.println("5. Exit");
            Console.println("6. Find biggest warren");
            Console.println("7. Inspect all rabbits");
            Console.println("8. Display adjacency list");
            Console.println("9. Display adjacency matrix");
            Console.println("10. Check for a route between warrens");
            Console.println();
            MenuOption = Console.readInteger("Select option: ");
            if (MenuOption == 0)
            {
                ShowDetail = false;
                for(int i = TimePeriod+10; TimePeriod<i; TimePeriod++) AdvanceTimePeriod();
            }
            if (MenuOption == 1)
            {
                TimePeriod += 1;
                ShowDetail = true;
                AdvanceTimePeriod();
            }
            if (MenuOption == 2)
            {
                TimePeriod += 1;
                ShowDetail = false;
                AdvanceTimePeriod();
            }
            if (MenuOption == 3)
            {
                x = InputCoordinate('x');
                y = InputCoordinate('y');
                if (Landscape[x][y].Fox != null)
                {
                    Landscape[x][y].Fox.Inspect();
                }
            }
            if (MenuOption == 4)
            {
                x = InputCoordinate('x');
                y = InputCoordinate('y');
                if (Landscape[x][y].Warren != null )
                {
                    Landscape[x][y].Warren.Inspect();
                    ViewRabbits = Console.readLine("View individual rabbits (y/n)?");
                    if ( ViewRabbits.equals("y") )
                    {
                        Landscape[x][y].Warren.ListRabbits();
                    }
                }
            }
            if (MenuOption == 6) findBiggest();
            if (MenuOption == 7) inspectRabbits();
            if (MenuOption == 8) warrenGraph.adjList();
            if (MenuOption == 9) warrenGraph.adjMatrix();
            if (MenuOption == 10) {
                int x1, y1, x2, y2;

                Console.println("\nWarren 1:");
                x1 = InputCoordinate('x');
                y1 = InputCoordinate('y');

                Console.println("\nWarren 2:");
                x2 = InputCoordinate('x');
                y2 = InputCoordinate('y');

                warrenGraph.checkRoute(x1, y1, x2, y2);
            }
        } while ((WarrenCount > 0 || FoxCount > 0) && MenuOption != 5);
        Console.readLine();
    }

    private int InputCoordinate(char CoordinateName)
    {
        int Coordinate;
        Coordinate = Console.readInteger("  Input " + CoordinateName + " coordinate: ");
        return Coordinate;
    }

    private void AdvanceTimePeriod()
    {
        int NewFoxCount = 0;
        if (ShowDetail)
        {
            Console.println();
        }
        for (int x = 0; x < LandscapeSize; x++)
        {
            for (int y = 0; y < LandscapeSize; y++)
            {
                if (Landscape[x][y].Warren != null)
                {
                    if (ShowDetail)
                    {
                        Console.println("Warren at (" + x + "," + y + "):");
                        Console.print("  Period Start: ");
                        Landscape[x][y].Warren.Inspect();
                    }
                    if (FoxCount > 0)
                    {
                        FoxesEatRabbitsInWarren(x, y);
                    }
                    if (Landscape[x][y].Warren.NeedToCreateNewWarren())
                    {
                        CreateNewWarren();
                    }
                    Landscape[x][y].Warren.AdvanceGeneration(ShowDetail);
                    if (ShowDetail)
                    {
                        Console.print("  Period End: ");
                        Landscape[x][y].Warren.Inspect();
                        Console.readLine();
                    }
                    if (Landscape[x][y].Warren.WarrenHasDiedOut())
                    {
                        Landscape[x][y].Warren = null;
                        WarrenCount -= 1;
                    }
                }

                if (Landscape[x][y].Fox != null)
                {
                    if (ShowDetail)
                    {
                        Console.println("Fox at (" + x + "," + y + "): ");
                    }
                    Landscape[x][y].Fox.AdvanceGeneration(ShowDetail);
                    if (Landscape[x][y].Fox.CheckIfDead())
                    {
                        Landscape[x][y].Fox = null;
                        FoxCount -= 1;
                    }
                    else
                    {
                        if (Landscape[x][y].Fox.ReproduceThisPeriod())
                        {
                            if (ShowDetail)
                            {
                                Console.println("  Fox has reproduced. ");
                            }
                            NewFoxCount += 1;
                        }
                        if (ShowDetail)
                        {
                            Landscape[x][y].Fox.Inspect();
                        }
                        Landscape[x][y].Fox.ResetFoodConsumed();
                    }
                }

                if (Landscape[x][y].Den != null) {
                    if (Landscape[x][y].Den.IsReadyForNewFox()) {
                        CreateNewFox();
                    }
                }
            }
        }
        if (NewFoxCount > 0)
        {
            if (ShowDetail)
            {
                Console.println("New foxes born: ");
                for (int f = 0; f < NewFoxCount; f++)
                {
                    CreateNewFox();
                }
            }
        }
        if (ShowDetail)
        {
            Console.readLine();
        }
        DrawLandscape();
        Console.println();
    }

    private void CreateLandscapeAndAnimals(int InitialWarrenCount,
                 int InitialFoxCount, Boolean FixedInitialLocations)
    {
        for (int x = 0 ; x < LandscapeSize; x++)
        {
            for (int y = 0; y < LandscapeSize; y++)
            {
                Landscape[x][y] = new Location();
            }
        }
        if (FixedInitialLocations)
        {
            Landscape[1][1].Warren = new Warren(Variability, 38);
            Landscape[2][8].Warren = new Warren(Variability, 80);
            Landscape[9][7].Warren = new Warren(Variability, 20);
            Landscape[10][3].Warren = new Warren(Variability, 52);
            Landscape[11][4].Warren = new GiantWarren(Variability, 115);
            Landscape[13][4].Warren = new Warren(Variability, 67);
            WarrenCount = 6;
            Landscape[2][10].Fox = new Fox(Variability);
            Landscape[6][1].Fox = new Fox(Variability);
            Landscape[8][6].Fox = new Fox(Variability);
            Landscape[11][13].Fox = new Fox(Variability);
            Landscape[12][4].Fox = new Fox(Variability);
            FoxCount = 5;
            Landscape[2][3].Den = new Den();
        }
        else
        {
            for (int w = 0; w < InitialWarrenCount; w++)
            {
                CreateNewWarren();
            }
            for (int f = 0; f < InitialFoxCount; f++)
            {
                CreateNewFox();
            }
        }
    }

    private void CreateNewWarren()
    {
        int x;
        int y;
        do
        {
            x = Rnd.nextInt(LandscapeSize);
            y = Rnd.nextInt(LandscapeSize);
        } while (Landscape[x][y].Warren != null);
        if (ShowDetail)
        {
            Console.println("New Warren at (" + x + "," + y + ")");
        }
        Landscape[x][y].Warren = new Warren(Variability);
        WarrenCount += 1;
    }

    private void CreateNewFox()
    {
        int x;
        int y;
        do
        {
            x = Rnd.nextInt(LandscapeSize);
            y = Rnd.nextInt(LandscapeSize);
        } while (Landscape[x][y].Fox != null);
        if (ShowDetail)
        {
            Console.println("  New Fox at (" + x + "," + y + ")");
        }
        Landscape[x][y].Fox = new Fox(Variability);
        FoxCount += 1;
    }

    private void FoxesEatRabbitsInWarren(int WarrenX, int WarrenY)
    {
        int FoodConsumed;
        int PercentToEat;
        double Dist;
        int RabbitsToEat;
        int RabbitCountAtStartOfPeriod = Landscape[WarrenX][WarrenY].Warren.GetRabbitCount();
        for (int FoxX = 0; FoxX < LandscapeSize; FoxX++)
        {
            for (int FoxY = 0; FoxY < LandscapeSize; FoxY++)
            {
                if (Landscape[FoxX][FoxY].Fox != null)
                {
                    Dist = DistanceBetween(FoxX, FoxY, WarrenX, WarrenY);
                    if (Dist <= 3.5)
                    {
                        PercentToEat = 20;
                    }
                    else if (Dist <= 7)
                    {
                        PercentToEat = 10;
                    }
                    else
                    {
                        PercentToEat = 0;
                    }
                    RabbitsToEat = (int)(Math.round((PercentToEat * RabbitCountAtStartOfPeriod / 100.0)));
                    FoodConsumed = Landscape[WarrenX][WarrenY].Warren.EatRabbits(RabbitsToEat);
                    Landscape[FoxX][FoxY].Fox.GiveFood(FoodConsumed);
                    if (ShowDetail)
                    {
                        Console.println("  " + FoodConsumed + " rabbits eaten by fox at (" + FoxX + "," + FoxY + ").");
                    }
                }
            }
        }
    }

    private double DistanceBetween(int x1, int y1, int x2, int y2)
    {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    private void DrawLandscape()
    {
        Console.println();
        Console.println("TIME PERIOD: " + TimePeriod);
        Console.println();
        Console.print("    ");
        for (int x = 0; x < LandscapeSize; x++)
        {
            Console.print("  ");
            if (x < 10)
            {
                Console.print(" ");
            }
            Console.print(x + "   |");
        }
        Console.println();
        for (int x = 0; x < LandscapeSize * 8 + 4; x++)
        {
            Console.print("-");
        }
        Console.println();
        for (int y = 0; y < LandscapeSize; y++)
        {
            if (y < 10)
            {
                Console.print(" ");
            }
            Console.print(" " + y + "|");
            for (int x = 0; x < LandscapeSize; x++)
            {
                if (Landscape[x][y].Warren != null)
                {
                    if (Landscape[x][y].Warren.GetRabbitCount() < 100) Console.print(" ");
                    if (Landscape[x][y].Warren.GetRabbitCount() < 10)
                    {
                        Console.print(" ");
                    }
                    Console.print(Landscape[x][y].Warren.GetRabbitCount());
                }
                else
                {
                    Console.print("   ");
                }
                if (Landscape[x][y].Fox != null)
                {
                    Console.print("F");
                }
                else
                {
                    Console.print(" ");
                }

                if (Landscape[x][y].Den != null) {
                    Console.print("D");
                    Console.print(Landscape[x][y].Den.GetNumFoxesCreated());
                    if (Landscape[x][y].Den.GetNumFoxesCreated() < 10) Console.print(" ");
                }
                else Console.print("   ");
                Console.print("|");
            }
            Console.println();
        }
        Console.println();
        Console.print("    The average life expectancy of a fox stands at ");
        Console.print(Fox.getLifeExpect());
        Console.println();
    }

    private void findBiggest()
    {
        int maxX = -1;
        int maxY = -1;
        int maxCount = -1;
        for (int x = 0; x < LandscapeSize; x++) {
            for (int y = 0; y < LandscapeSize; y++) {
                Location loc = Landscape[x][y];
                Warren warren = loc.Warren;
                if (warren != null && warren.GetRabbitCount() > maxCount) {
                    maxX = x;
                    maxY = y;
                    maxCount = warren.GetRabbitCount();
                }
            }
        }
        System.out.printf("Biggest warren at (%s, %s)%n", maxX, maxY);
    }

    private void inspectRabbits()
    {
        collectRabbits().forEach(Rabbit::Inspect);
    }

    private ArrayList<Rabbit> collectRabbits()
    {
        ArrayList<Rabbit> rabbits = new ArrayList<>();

        for (Location[] arr : Landscape)
            for (Location loc : arr)
                if (loc.Warren != null)
                    for (Rabbit rabbit : loc.Warren.getRabbits())
                        if (rabbit != null)
                            rabbits.add(rabbit);

        rabbits.sort(Comparator.comparing(Rabbit::GetAge));
        return rabbits;
    }
}

@SuppressWarnings("ALL")
class Warren
{
    private static final int DefaultMaxRabbitsInWarren = 99;
    private final int MaxRabbitsInWarren;
    private Rabbit[] Rabbits;
    private int RabbitCount = 0;
    private int PeriodsRun = 0;
    private Boolean AlreadySpread = false;
    private int Variability;
    private static Random Rnd = new Random();

    public Warren(int Variability)
    {
        this(Variability, (int)(CalculateRandomValue(DefaultMaxRabbitsInWarren / 4, Variability)));
    }

    public Warren(int Variability, int RabbitCount)
    {
        this(Variability, RabbitCount, 99);
    }

    public Warren(int Variability, int RabbitCount, int MaxRabbitsInWarren)
    {
        this.Variability = Variability;
        this.RabbitCount = RabbitCount;
        this.MaxRabbitsInWarren = MaxRabbitsInWarren;
        Rabbits = new Rabbit[MaxRabbitsInWarren];
        for (int r = 0; r < RabbitCount; r++)
        {
            Rabbits[r] = new Rabbit(Variability);
        }
    }

    private static double CalculateRandomValue(int BaseValue, int Variability)
    {
        return BaseValue - (BaseValue * Variability / 100) + (BaseValue * Rnd.nextInt((Variability * 2) + 1) / 100);
    }

    public int GetRabbitCount()
    {
        return RabbitCount;
    }

    public Boolean NeedToCreateNewWarren()
    {
        if (RabbitCount == MaxRabbitsInWarren && !AlreadySpread)
        {
            AlreadySpread = true;
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean WarrenHasDiedOut()
    {
        if (RabbitCount == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void AdvanceGeneration(Boolean ShowDetail)
    {
        PeriodsRun += 1;
        if (RabbitCount > 0)
        {
            KillByOtherFactors(ShowDetail);
        }
        if (RabbitCount > 0)
        {
            AgeRabbits(ShowDetail);
        }
        if (RabbitCount > 0 && RabbitCount <= MaxRabbitsInWarren)
        {
            if (ContainsMales())
            {
                MateRabbits(ShowDetail);

            }
        }
        if (RabbitCount == 0 && ShowDetail)
        {
            Console.println("  All rabbits in warren are dead");
        }
    }

    public int EatRabbits(int RabbitsToEat)
    {
        int DeathCount = 0;
        int RabbitNumber;
        if (RabbitsToEat > RabbitCount)
        {
            RabbitsToEat = RabbitCount;
        }
        while (DeathCount < RabbitsToEat)
        {
            RabbitNumber = Rnd.nextInt(RabbitCount);
            if (Rabbits[RabbitNumber] != null)
            {
                Rabbits[RabbitNumber] = null;
                DeathCount += 1;
            }
        }
        CompressRabbitList(DeathCount);
        return RabbitsToEat;
    }

    private void KillByOtherFactors(Boolean ShowDetail)
    {
        int DeathCount = 0;
        for (int r = 0; r < RabbitCount; r++)
        {
            if (Rabbits[r].CheckIfKilledByOtherFactor())
            {
                Rabbits[r] = null;
                DeathCount += 1;
            }
        }
        CompressRabbitList(DeathCount);
        if (ShowDetail)
        {
            Console.println("  " + DeathCount + " rabbits killed by other factors.");
        }
    }

    private void AgeRabbits(Boolean ShowDetail)
    {
        int DeathCount = 0;
        for (int r = 0; r < RabbitCount; r++)
        {
            Rabbits[r].CalculateNewAge();
            if (Rabbits[r].CheckIfDead())
            {
                Rabbits[r] = null;
                DeathCount += 1;
            }
        }
        CompressRabbitList(DeathCount);
        if (ShowDetail)
        {
            Console.println("  " + DeathCount + " rabbits die of old age.");
        }
    }

    private void MateRabbits(Boolean ShowDetail)
    {
        int Mate = 0;
        int Babies = 0;
        double CombinedReproductionRate;
        for (int r = 0; r < RabbitCount; r++)
        {
            if (Rabbits[r].IsFemale() && RabbitCount + Babies < MaxRabbitsInWarren)
            {
                do
                {
                    Mate = Rnd.nextInt( RabbitCount);
                } while (Mate == r || Rabbits[Mate].IsFemale());
                CombinedReproductionRate = (Rabbits[r].GetReproductionRate() + Rabbits[Mate].GetReproductionRate()) / 2;
                if (CombinedReproductionRate >= 1)
                {
                    Rabbits[RabbitCount + Babies] = new Rabbit(Variability, CombinedReproductionRate);
                    Babies += 1;
                }
            }
        }
        RabbitCount = RabbitCount + Babies;
        if (ShowDetail)
        {
            Console.println("  " + Babies + " baby rabbits born.");
        }
    }

    private void CompressRabbitList(int DeathCount)
    {
        if (DeathCount > 0)
        {
            int ShiftTo = 0;
            int ShiftFrom = 0;
            while (ShiftTo < RabbitCount - DeathCount)
            {
                while (Rabbits[ShiftFrom] == null)
                {
                    ShiftFrom += 1;
                }
                if (ShiftTo != ShiftFrom)
                {
                    Rabbits[ShiftTo] = Rabbits[ShiftFrom];
                }
                ShiftTo += 1;
                ShiftFrom += 1;
            }
            RabbitCount = RabbitCount - DeathCount;
        }
    }

    private Boolean ContainsMales()
    {
        Boolean Males = false;
        for (int r = 0; r < RabbitCount; r++)
        {
            if (!Rabbits[r].IsFemale())
            {
                Males = true;
            }
        }
        return Males;
    }

    public void Inspect()
    {
        Console.println("Periods Run " + PeriodsRun + " Size " + RabbitCount);
    }

    public void ListRabbits()
    {
        if (RabbitCount > 0)
        {
            for (int r = 0; r < RabbitCount;r++)
            {
                Rabbits[r].Inspect();
            }
        }
    }

    public Rabbit[] getRabbits() {
        return Rabbits;
    }
}

class GiantWarren extends Warren
{

    private static final int MaxRabbitsInWarren = 200;

    @SuppressWarnings("unused")
    public GiantWarren(int Variability) {
        super(Variability, 1);
    }

    GiantWarren(int Variability, int RabbitCount) {
        super(Variability, RabbitCount, MaxRabbitsInWarren);
    }


    @Override
    public Boolean NeedToCreateNewWarren() {
        return GetRabbitCount() == MaxRabbitsInWarren;
    }
}

class Den
{
    private int numFoxesCreated = 0;
    private int timePassed = 0;

    boolean IsReadyForNewFox(){
        if (++timePassed == 3) {
            timePassed = 0;
            numFoxesCreated++;
            return true;
        }
        return false;

    }

    int GetNumFoxesCreated() {
        return numFoxesCreated;
    }
}

@SuppressWarnings("ALL")
class Animal
{
    protected double NaturalLifespan;
    protected int ID;
    protected static int NextID = 1;
    protected int Age = 0;
    protected double ProbabilityOfDeathOtherCauses;
    protected Boolean IsAlive;
    protected static Random Rnd = new Random();
    protected enum Genders {Male, Female}

    public Animal(int AvgLifespan, double AvgProbabilityOfDeathOtherCauses, int Variability)
    {
        NaturalLifespan = AvgLifespan * CalculateRandomValue(100, Variability) / 100;
        ProbabilityOfDeathOtherCauses = AvgProbabilityOfDeathOtherCauses * CalculateRandomValue(100, Variability) / 100;
        IsAlive = true;
        ID = NextID;
        NextID += 1;
    }

    public void CalculateNewAge()
    {
        Age += 1;
        if (Age >= NaturalLifespan)
        {
            IsAlive = false;
        }
    }

    public Boolean CheckIfDead()
    {
        return !IsAlive;
    }

    public void Inspect()
    {
        Console.print("  ID " + ID + " ");
        Console.print("Age " + Age + " ");
        Console.print("LS " + (int)NaturalLifespan + " ");
        Console.print("Pr dth " + Math.round(ProbabilityOfDeathOtherCauses * 100) / 100.0 + " ");
    }

    public Boolean CheckIfKilledByOtherFactor()
    {
        if (Rnd.nextInt(100) < ProbabilityOfDeathOtherCauses * 100)
        {
            IsAlive = false;
            return true;
        }
        else
        {
            return false;
        }
    }

    protected double CalculateRandomValue(int BaseValue, int Variability)
    {
        return BaseValue - (BaseValue * Variability / 100) + (BaseValue * Rnd.nextInt( (Variability * 2) + 1) / 100);
    }
}

@SuppressWarnings("ALL")
class Fox extends Animal
{
    private int FoodUnitsNeeded = 10;
    private int FoodUnitsConsumedThisPeriod = 0;
    private static final int DefaultLifespan = 7;
    private static final double DefaultProbabilityDeathOtherCauses = 0.1;
    private static final int GenderRatio = 67;
    private Genders Gender;

    private static int _TotalDeadFoxes;
    private static int _TotalFoxAge;

    public Fox(int Variability)
    {
        super(DefaultLifespan, DefaultProbabilityDeathOtherCauses, Variability);
        FoodUnitsNeeded = (int)(10 * this.CalculateRandomValue(100, Variability) / 100);
        Gender = Rnd.nextInt(100) < GenderRatio ? Genders.Female : Genders.Male;
    }

    public void AdvanceGeneration(Boolean ShowDetail)
    {
        if (FoodUnitsConsumedThisPeriod == 0)
        {
            IsAlive = false;
            if (ShowDetail){
                Console.println("  Fox dies as has eaten no food this period.");
            }
        }
        else
        {
            if (CheckIfKilledByOtherFactor())
            {
                IsAlive = false;
                if (ShowDetail)
                {
                    Console.println("  Fox killed by other factor.");
                }
            }
            else
            {
                if (FoodUnitsConsumedThisPeriod < FoodUnitsNeeded)
                {
                    CalculateNewAge();
                    if (ShowDetail)
                    {
                        Console.println("  Fox ages further due to lack of food.");
                    }
                }
                CalculateNewAge();
                if (!IsAlive)
                {
                    if (ShowDetail)
                    {
                        Console.println("  Fox has died of old age.");
                    }
                }
            }
        }
        if (!IsAlive) Die();
    }

    public void ResetFoodConsumed()
    {
        FoodUnitsConsumedThisPeriod = 0;
    }

    public Boolean ReproduceThisPeriod()
    {
        final double ReproductionProbability = 0.25;
        if (Gender == Genders.Female && Rnd.nextInt(100) < ReproductionProbability * 100)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void GiveFood(int FoodUnits)
    {
        FoodUnitsConsumedThisPeriod = FoodUnitsConsumedThisPeriod + FoodUnits;
    }

    @Override
    public void Inspect()
    {
        super.Inspect();
        Console.print("Food needed " + FoodUnitsNeeded + " ");
        Console.print("Food eaten " + FoodUnitsConsumedThisPeriod + " ");
        Console.print("Gender " + Gender.toString());
        Console.println();
    }

    public void Die() {
        _TotalDeadFoxes++;
        _TotalFoxAge += Age;
    }

    public static int getLifeExpect() {
        return _TotalDeadFoxes > 0 ? _TotalFoxAge / _TotalDeadFoxes : DefaultLifespan;
    }
}

@SuppressWarnings("ALL")
class Rabbit extends Animal
{
    private double ReproductionRate;
    private static final double DefaultReproductionRate = 1.2;
    private static final int DefaultLifespan = 4;
    private static final double DefaultProbabilityDeathOtherCauses = 0.05;
    private Genders Gender;

    public Rabbit(int Variability)
    {
        this(Variability, DefaultReproductionRate);
    }

    public Rabbit(int Variability, double ParentsReproductionRate)
    {
        this(Variability, ParentsReproductionRate, 50);
    }

    public Rabbit(int Variability, double ParentsReproductionRate, int GenderRatio) {
        super(DefaultLifespan, DefaultProbabilityDeathOtherCauses, Variability);
        ReproductionRate = ParentsReproductionRate * CalculateRandomValue(100, Variability) / 100;
        Gender = Rnd.nextInt(100) < GenderRatio ? Genders.Male : Genders.Female;
    }

    @Override
    public void Inspect()
    {
        super.Inspect();
        Console.print("Rep rate " + Math.round(ReproductionRate * 10) / 10.0 + " ");
        if (Gender == Genders.Female)
        {
            Console.println("Gender Female");
        }
        else
        {
            Console.println("Gender Male");
        }
    }

    public Boolean IsFemale()
    {
        if (Gender == Genders.Female)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public double GetReproductionRate()
    {
        return ReproductionRate;
    }

    @Override
    public void CalculateNewAge()
    {
        super.CalculateNewAge();
        ProbabilityOfDeathOtherCauses += 0.1;
    }

    public int GetAge() {
        return Age;
    }
}

@SuppressWarnings({"unused", "WeakerAccess"})
class WarrenGraph {
    private Node[] nodes;

    static WarrenGraph getDefault() {
        return new WarrenGraph(
                new Node(1, 1, 2, 8, 9, 7),
                new Node(2, 8, 13, 4, 1, 1),
                new Node(9, 7, 1, 1, 13, 4),
                new Node(13, 4, 9, 7, 2, 8),
                new Node(11, 4, -1, -1, -1, -1)
        );
    }

    WarrenGraph(Node... nodes) {
        this.nodes = nodes;
    }
    
    void adjList() {
        Console.println("\n    Displaying adjacency list\n");
        Arrays.stream(nodes).forEach(Node::printAdj);
    }

    void adjMatrix() {
        Console.println();

        // Print top line
        Console.print("        |");
        Arrays.stream(nodes).map(node -> node.getCoord(Ref.SELF)).forEach(coords -> {
            if (coords.x < 10) Console.print(" ");
            if (coords.y < 10) Console.print(" ");
            Console.print(coords);
            Console.print("|");
        });
        Console.println();
        IntStream.range(0, 9*(nodes.length+1)).forEach((n) -> Console.print("-"));
        Console.println();

        // Print each row
        Arrays.stream(nodes).forEach(node -> {
            Node.Coords self = node.getCoord(Ref.SELF);
            if (self.x < 10) Console.print(" ");
            if (self.y < 10) Console.print(" ");
            Console.print(self);
            Console.print("|");

            Arrays.stream(nodes).forEach(col -> {
                Console.print("   ");
                Console.print(node.connectedTo(col) ? node.distanceTo(col) : "----");
                Console.print(" |");
            });

            Console.println();
        });
    }

    void checkRoute(int x1, int y1, int x2, int y2) {
        Node n1 = getNode(x1, y1);
        Node n2 = getNode(x2, y2);
        if (n1 == null || n2 == null) return;

        boolean routeExists = n1.search(Ref.LEFT, n2.getCoord(Ref.SELF), 1, nodes.length, this)
                           || n1.search(Ref.RIGHT, n2.getCoord(Ref.SELF), 1, nodes.length, this);

        System.out.printf("\nThere is %sa route between (%s, %s) and (%s, %s).\n",
                routeExists ? "" : "NOT ", x1, y1, x2, y2);
    }

    Node getNode(int x, int y) {
        return getNode(new Node.Coords(x, y));
    }

    Node getNode(Node.Coords coords) {
        Node found = null;
        for (Node n : nodes) {
            if (n.getCoord(Ref.SELF).equals(coords)) found = n;
        }
        return found;
    }

    enum Ref { SELF, LEFT, RIGHT }

    static class Node {
        private final Coords left, right, self;

        Node(int selfX, int selfY, int leftX, int leftY, int rightX, int rightY) {
            left = new Coords(leftX, leftY);
            right = new Coords(rightX, rightY);
            self = new Coords(selfX, selfY);
        }

        Coords getCoord(@NotNull Ref ref) {
            switch (ref) {
                case LEFT:
                    return left;
                case RIGHT:
                    return right;
                case SELF:
                    return self;
            }
            throw new IllegalArgumentException();
        }

        private static class Coords {
            final int x, y;

            Coords(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public String toString() {
                return String.format("(%s, %s)", x, y);
            }

            @Override
            public boolean equals(Object o) {
                try {
                    Coords c = (Coords) o;
                    return this.x == c.x && this.y == c.y;
                }
                catch (ClassCastException | NullPointerException e) {
                    return false;
                }
            }
        }
        
        private void printAdj() {
            System.out.printf("    (%s, %s) is connected to (%s, %s) and (%s, %s)%n",
                    self.x, self.y,
                    left.x, left.y,
                    right.x, right.y
            );
        }

        boolean connectedTo(Node node) {
            Coords coord = node.getCoord(Ref.SELF);
            return coord.equals(left) || coord.equals(right);
        }

        String distanceTo(Node node) {
            Coords a = self;
            Coords b = node.getCoord(Ref.SELF);

            double length = Math.sqrt(Math.pow(a.x-b.x, 2) + Math.pow(a.y-b.y, 2));

            StringBuilder result = new StringBuilder("");
            if (length < 10) result.append(" ");
            result.append(length);
            return result.toString().substring(0, 4);
        }

        boolean search(Ref ref, Coords target, int steps, int maxSteps, WarrenGraph graph) {
            try {
                return steps <= maxSteps && (self.equals(target) ||
                        graph.getNode(getCoord(ref)).search(ref, target, steps + 1, maxSteps, graph));
            }
            catch (NullPointerException e) {
                return false;
            }
        }
    }
}