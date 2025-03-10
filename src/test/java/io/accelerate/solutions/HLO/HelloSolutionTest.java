package io.accelerate.solutions.HLO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The type Hello solution test.
 */
class HelloSolutionTest {
    private HelloSolution helloSolution;

    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {
        helloSolution = new HelloSolution();
    }

    /**
     * Hello.
     */
    @Test
    void helloTest() {
        Assertions.assertTrue(helloSolution.hello("Tiago").contains("Tiago"));
    }
}