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
        assertEquals(130, checkoutSolution.checkout("AAA"));
        assertEquals(45, checkoutSolution.checkout("BB"));

        assertEquals(95, checkoutSolution.checkout("BDA"));
        assertEquals(245, checkoutSolution.checkout("CCAAABBB"));
        assertEquals(100, checkoutSolution.checkout("AA"));

        assertEquals(80, checkoutSolution.checkout("EE"));
        assertEquals(80, checkoutSolution.checkout("EEB"));
        assertEquals(110, checkoutSolution.checkout("EEBB"));
        assertEquals(250, checkoutSolution.checkout("AAAAAA"));
        assertEquals(300, checkoutSolution.checkout("AAAAAAA"));
        assertEquals(330, checkoutSolution.checkout("AAAAAAAA"));
        assertEquals(295, checkoutSolution.checkout("CCAAABBBEE"));

        assertEquals(20, checkoutSolution.checkout("FF"));

        assertEquals(-1, checkoutSolution.checkout("W"));
        assertEquals(-1, checkoutSolution.checkout("ABW"));
        assertEquals(-1, checkoutSolution.checkout("WBA"));
        assertEquals(-1, checkoutSolution.checkout("AWB"));
        assertEquals(0, checkoutSolution.checkout(""));
        assertEquals(0, checkoutSolution.checkout("   "));
        assertEquals(-1, checkoutSolution.checkout(null));
    }
}

