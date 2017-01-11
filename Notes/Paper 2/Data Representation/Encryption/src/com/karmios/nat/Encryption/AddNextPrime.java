package com.karmios.nat.Encryption;

import java.util.Scanner;

public class AddNextPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String plainText = sc.nextLine();
        String cipherText = encrypt(plainText);
        System.out.println("Cipher text: " + cipherText);
        System.out.println("Attempt decrypt: " + decrypt(cipherText));
    }

    public static String encrypt(String plainText) {
        return plainText.chars().mapToObj(x -> String.valueOf((char) (x + nextPrime(x))))
                .reduce("", (str, x) -> str + x);
    }

    public static String decrypt(String cipherText) {
        return cipherText.chars().mapToObj(x -> String.valueOf((char) (x - nextPrime(x/2-1))))
                .reduce("", (str, x) -> str + x);
    }

    private static int nextPrime(int x) {
        int i = x;
        while (!isPrime(++i));
        return i;
    }

    private static boolean isPrime(int x) {
        if (x < 0) return isPrime(x*-1);
        if (x == 1 || x == 0) return false;
        if (x==2 || x==3) return true;

        for (int i = 2; i < Math.sqrt(x)+1; i++) {
            if (((double) x / (double) i) % 1 == 0 ) return false;
        }

        return true;
    }
}
