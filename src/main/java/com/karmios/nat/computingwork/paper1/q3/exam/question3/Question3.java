    package com.karmios.nat.computingwork.paper1.q3.exam.question3;

    import java.util.Scanner;

    public class Question3 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("The new word?");
            String newWord = sc.nextLine();

            System.out.println("Your guess?");
            String userWordGuess = sc.nextLine();
            if (userWordGuess.equals(newWord)) System.out.println("CORRECT");
            else System.out.println("INCORRECT");
        }
    }

