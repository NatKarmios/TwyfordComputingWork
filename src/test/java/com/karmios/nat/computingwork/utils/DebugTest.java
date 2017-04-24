package com.karmios.nat.computingwork.utils;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DebugTest {
    @Nested
    class Print {
        // <editor-fold desc="Test Setup">

        private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        @BeforeEach
        void setUpStream() {
            System.setOut(new PrintStream(outContent));
        }

        @AfterEach
        void cleanUpStream() {
            System.setOut(null);
        }

        // </editor-fold>

        @Test
        void BooleanTest() {
            assertTrue(Debug.print(true));
            assertEquals("true\r\n", outContent.toString());
        }

        @Test
        void ByteTest() {
            assertEquals(Debug.print((byte) 1), (byte) 1);
            assertEquals("1\r\n", outContent.toString());
        }

        @Test
        void ShortTest() {
            assertEquals(Debug.print((short) 2), (short) 2);
            assertEquals("2\r\n", outContent.toString());
        }

        @Test
        void IntTest() {
            assertEquals(Debug.print(3), 3);
            assertEquals("3\r\n", outContent.toString());
        }

        @Test
        void LongTest() {
            assertEquals(Debug.print(4L), 4L);
            assertEquals("4\r\n", outContent.toString());
        }

        @Test
        void FloatTest() {
            assertEquals(Debug.print(5.0f), 5.0f);
            assertEquals("5.0\r\n", outContent.toString());
        }

        @Test
        void DoubleTest() {
            assertEquals(Debug.print(6.0), 6.0);
            assertEquals("6.0\r\n", outContent.toString());
        }

        @Test
        void StringTest() {
            assertEquals(Debug.print("Hello, world!"), "Hello, world!");
            assertEquals("Hello, world!\r\n", outContent.toString());
        }
    }
}
