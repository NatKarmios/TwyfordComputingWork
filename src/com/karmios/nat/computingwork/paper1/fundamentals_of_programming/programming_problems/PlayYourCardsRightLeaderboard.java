package com.karmios.nat.computingwork.paper1.fundamentals_of_programming.programming_problems;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static com.codepoetics.protonpack.StreamUtils.zipWithIndex;


import static com.karmios.nat.computingwork.paper1.fundamentals_of_programming.programming_problems.PlayYourCardsRight.*;
import static com.karmios.nat.computingwork.utils.Utils.*;


public class PlayYourCardsRightLeaderboard {
    private static final String FILEPATH = getClassDir(PlayYourCardsRightLeaderboard.class) + "leaderboard.txt";
    private static final File FILE = new File(FILEPATH);

    public static void main(String[] args) {
        int scoreNum = play();
        final Pattern regex = Pattern.compile("^([a-zA-Z0-9]+), ([0-9]+)$");
        ArrayList<Score> scores = new ArrayList<>();
        try {
            Files.lines(FILE.toPath()).forEach(x -> {
                        Matcher matches = regex.matcher(x);
                        if (matches.matches())
                            scores.add(new Score(matches.group(1), Integer.valueOf(matches.group(2))));
                    }
            );
        } catch (IOException e) {
            System.out.println("Unable to open leaderboard file!");
        }

        String name = inputLoop("Enter your name: ", "Your name must be alphanumeric!", IS_ALPHANUMERIC);
        final Score score = new Score(name, scoreNum);
        scores.add(score);
        scores.sort((score1, score2) -> score2.score - score1.score);

        zipWithIndex(scores.stream()).forEach(i -> System.out.println(
                (i.getIndex() == 10 ? "\n-- " : ((i.getIndex()+1) + ". ")) +
                i.getValue().toString() + (score == i.getValue() ? "    <YOU>" : ""))
        );

        try {
            FILE.createNewFile();

            FileOutputStream writer;
            try {
                writer = new FileOutputStream(FILEPATH);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            }

            scores.stream().limit(10).forEach(i -> {
                try {
                    writer.write((i.name + ", " + i.score + "\n").getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.close();
        } catch (IOException e) {
            System.out.println("Unable to create leaderboard.txt!");
        }
    }

    private static class Score {
        final String name;
        final int score;

        @SuppressWarnings("unused")
        public static final Comparator<Score> compareLength =
                Comparator.comparingInt(score1 -> score1.name.length());


        Score(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return name + " - " + score;
        }


    }
}


