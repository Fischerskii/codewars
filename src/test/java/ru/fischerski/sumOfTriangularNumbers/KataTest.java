package ru.fischerski.sumOfTriangularNumbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KataTest {

    @Test
    @DisplayName("testSumTriangularNumbers")
    void sumTriangularNumbers() {
        assertEquals(20, Kata.sumTriangularNumbers(4));
        assertEquals(7140, Kata.sumTriangularNumbers(34));
        assertEquals(0, Kata.sumTriangularNumbers(-291));
        assertEquals(140205240, Kata.sumTriangularNumbers(943));
        assertEquals(0, Kata.sumTriangularNumbers(-971));
    }
}