    package com.karmios.nat.computingwork.paper1.q3.exam.question1;

    import java.util.Scanner;

    public class Question1 {
        public static void main(String[] args) {
            // QUICKEST SOLUTION:
            // System.out.println("What player are you looking for?");
            // String playerName = sc.nextLine();
            // System.out.println(Arrays.stream({"Ben", "Thor", "Zoe", "Kate"}).anyMatch(playerName::equals)
            //                    ? "Yes, they have a top score" : "No, they don't have a top score")

            Scanner sc = new Scanner(System.in);

            String[] names = {"Ben", "Thor", "Zoe", "Kate"};
            int max = 3;
            int current = 0;
            boolean found = false;

            System.out.println("What player are you looking for?");
            String playerName = sc.nextLine();

            while (!found && current <= max)
                if (names[current].equals(playerName)) found = true;
                else current++;

            if (found) System.out.println("Yes, they have a top score");
            else System.out.println("No, they don't have a top score");
            // More efficiently:
            // System.out.println(found ? "Yes, they have a top score" : "No, they don't have a top score")
        }
    }

