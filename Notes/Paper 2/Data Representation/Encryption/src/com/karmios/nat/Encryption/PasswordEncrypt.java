package com.karmios.nat.Encryption;

import org.jasypt.encryption.pbe.PBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.util.Scanner;

public class PasswordEncrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter plain text: ");
        String plainText = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();
        String cipherText = encrypt(plainText, pass);
        System.out.println(cipherText);
        System.out.println(decrypt(cipherText, pass));
    }

    public static String encrypt(String plainText, String pass) {
        PBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(pass);
        return encryptor.encrypt(plainText);
    }

    public static String decrypt(String cipherText, String pass) {
        PBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
        decryptor.setPassword(pass);
        return decryptor.decrypt(cipherText);
    }
}
