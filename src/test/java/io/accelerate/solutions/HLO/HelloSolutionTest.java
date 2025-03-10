package io.accelerate.solutions.HLO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Hello solution test.
 */
class HelloSolutionTest {

    /**
     * Hello.
     */
    @Test
    void helloTest() {
        Assertions.assertTrue(HelloSolution.hello("Tiago").contains("Tiago"));
    }
}