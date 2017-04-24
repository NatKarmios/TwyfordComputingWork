package com.karmios.nat.computingwork.ocr_challenges;

import java.time.DateTimeException;
import java.time.LocalDate;

import static com.karmios.nat.computingwork.utils.Utils.inputIntLoop;

class Challenge34_WhatsTheDay {
    public static void main(String[] args) {
        try {
            LocalDate date = LocalDate.of(inputIntLoop("Year: "), inputIntLoop("Month: "),
                    inputIntLoop("Day: "));
            System.out.printf("%s is a %s.\n", date.toString(), date.getDayOfWeek());
        } catch (DateTimeException e) {
            System.out.println("Invalid date!");
        }
    }


}
