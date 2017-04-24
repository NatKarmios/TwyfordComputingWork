package com.karmios.nat.computingwork.ocr_challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static com.karmios.nat.computingwork.ocr_challenges.Challenge15_Pangrams.isPangram;

class Challenge15_PangramsTest {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    @Test
    void isPangramReturnsTrueForAlphabet() {
        assertTrue(isPangram(ALPHABET));
    }

    @Test
    void isPangramReturnsFalseForNonPangram() {
        assertFalse(isPangram("notapangram"));
    }

    @Test
    void isPangramIgnoresNonLetters() {
        assertTrue(isPangram(ALPHABET+"!.?:;<>[]{}@'\""));
    }

    @Test
    void isPangramIgnoresCase() {
        assertTrue(isPangram("AbCdEfGhIjKlMnOpQrStUvWxYz"));
    }


}