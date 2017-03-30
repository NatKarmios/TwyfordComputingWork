package com.karmios.nat.computingwork.ocr_challenges;

import java.util.Arrays;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.Collectors;

import static com.codepoetics.protonpack.StreamUtils.zipWithIndex;
import static com.karmios.nat.computingwork.utils.Utils.*;

public class Challenge06_UnitConverter {
    public static void main(String[] args) {
        int option;
        final String optionPrompt = "\nPick an option, or enter 0 to quit:\n" +
            zipWithIndex(Arrays.stream(conversions)).map(item -> String.format("  %s: %s -> %s\n",
                    item.getIndex() + 1,
                    item.getValue().fromUnit.replace("?", ""),
                    item.getValue().toUnit.replace("?", ""))).collect(Collectors.joining()) + "> ";
        do {
            option = inputIntLoop(
                    optionPrompt,
                    String.format("You must enter a number from 0 to %s!", conversions.length),
                    inBounds(0, conversions.length+1));
            if (option != 0) conversions[option-1].performConversion();
        } while (option != 0);
        System.out.println("\nQuitting...");
    }

    private static final Conversion[] conversions = {
            new Conversion("°C", "°F", c -> (c*1.8)+32, f -> (f-32)/1.8),
            new Conversion("km", "mi", km -> km*0.62137119, mi -> mi/0.62137119),
            new Conversion("£?", "$?",
                    pounds -> Math.round(pounds*124)/100.0, dollars -> Math.round(dollars/0.0124)/100.0)
    };

    private static final class Conversion {
        // ? can be used to denote placement of the value; e.g. "£?" -> "£x", "?kg" -> "xkg", where x is the value.
        final String fromUnit, toUnit;

        final DoubleUnaryOperator converter, reverser;

        Conversion(String fromUnit, String toUnit, DoubleUnaryOperator converter, DoubleUnaryOperator reverser) {
            this.fromUnit = (fromUnit.contains("?") ? "" : "?") + fromUnit;
            this.toUnit = (toUnit.contains("?") ? "" : "?") + toUnit;
            this.converter = converter;
            this.reverser = reverser;
        }

        void performConversion(boolean reversed) {
            double input =
                    inputDoubleLoop("Enter value to convert: ", "You can only enter a number!");
            System.out.printf("%s -> %s\n",
                    (reversed ? toUnit : fromUnit).replace("?", Double.toString(input)),
                    (reversed ? fromUnit : toUnit).replace("?",
                            Double.toString((reversed ? reverser : converter).applyAsDouble(input))));
        }

        void performConversion() {
            performConversion(inputBoolLoop("Reverse conversion? ", "Enter Y or N!", true));
        }
    }
}
