package io.accelerate.solutions.CHK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckoutSolutionTest {
    private CheckoutSolution checkoutSolution;

    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {
        checkoutSolution = new CheckoutSolution();
    }

    @Test
    void checkoutTest() {
        assertEquals(130,checkoutSolution.checkout("AAA"));
        assertEquals(45,checkoutSolution.checkout("BB"));

        assertEquals(95,checkoutSolution.checkout("BDA"));
        assertEquals(245,checkoutSolution.checkout("CCAAABBB"));
        assertEquals(100,checkoutSolution.checkout("AA"));

        assertEquals(-1,checkoutSolution.checkout("W"));
        assertEquals(-1,checkoutSolution.checkout("ABW"));
        assertEquals(-1,checkoutSolution.checkout("WBA"));
        assertEquals(-1,checkoutSolution.checkout("AWB"));
        assertEquals(-1,checkoutSolution.checkout(""));
        assertEquals(-1,checkoutSolution.checkout("   "));
        assertEquals(-1,checkoutSolution.checkout(null));
    }
}
