package com.karmios.nat.computingwork.paper1.fundamentals_of_data_structures.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import static com.karmios.nat.computingwork.utils.Utils.*;

public class ReplaceInFile {
    public static void main(String[] args) {
        System.out.print("Input file - ");
        final File input = getFile(true);
        System.out.print("Output file - ");
        final File output = getFile();
        final String before = inputLoop("Enter text to be replaces: ", "Replacement text cannot contain newlines!",
                str -> !str.contains("\n"));
        final String after = input("Enter replacement text: ");

        try {
            replace(input, output, before, after);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("WeakerAccess")
    public static void replace(File input, File output, String before, String after) throws IOException {
        output.createNewFile();

        FileOutputStream writer = new FileOutputStream(output);

        Files.lines(input.toPath()).forEach(str -> {
            try {
                writer.write((str.replace(before, after) + "\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writer.close();
    }

    private static File getFile(boolean mustExist) {
        String path = inputLoop("Enter file path (use \".\" to get current directory): ", "File must exist!",
                mustExist ? (str -> str.equals(".") || new File(str).isFile()) : STRING_TRUE);

        if (path.equals(".")) {
            final String currentDir = getDir(ReplaceInFile.class);
            path = currentDir + inputLoop(currentDir, "File must exist!",
                    mustExist ? (str -> new File(currentDir+str).isFile()) : STRING_TRUE);
        }

        return new File(path);
    }

    private static File getFile() {
        return getFile(false);
    }
}
