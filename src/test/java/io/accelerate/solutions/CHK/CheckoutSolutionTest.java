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
    void checkoutPhaseOneTest() {
        assertEquals(130, checkoutSolution.checkout("AAA"));
        assertEquals(45, checkoutSolution.checkout("BB"));

        assertEquals(95, checkoutSolution.checkout("BDA"));
        assertEquals(245, checkoutSolution.checkout("CCAAABBB"));
        assertEquals(100, checkoutSolution.checkout("AA"));
    }

    @Test
    void checkoutPhaseTwoTest() {
        assertEquals(80, checkoutSolution.checkout("EE"));
        assertEquals(80, checkoutSolution.checkout("EEB"));
        assertEquals(110, checkoutSolution.checkout("EEBB"));
        assertEquals(250, checkoutSolution.checkout("AAAAAA"));
        assertEquals(300, checkoutSolution.checkout("AAAAAAA"));
        assertEquals(330, checkoutSolution.checkout("AAAAAAAA"));
        assertEquals(295, checkoutSolution.checkout("CCAAABBBEE"));
    }

    @Test
    void checkoutPhaseThreeTest() {
        assertEquals(10, checkoutSolution.checkout("F"));
        assertEquals(20, checkoutSolution.checkout("FF"));
        assertEquals(20, checkoutSolution.checkout("FFF"));
        assertEquals(30, checkoutSolution.checkout("FFFF"));
        assertEquals(40, checkoutSolution.checkout("FFFFFF"));
        assertEquals(315, checkoutSolution.checkout("CCAAAFBBBEEF"));
        assertEquals(325, checkoutSolution.checkout("FFCCAAAFBBBEEF"));
    }

    @Test
    void checkoutPhaseFourTest() {
        assertEquals(40, checkoutSolution.checkout("GG"));
        assertEquals(40, checkoutSolution.checkout("HHHH"));
        assertEquals(45, checkoutSolution.checkout("HHHHH"));
        assertEquals(55, checkoutSolution.checkout("HHHHHH"));
        assertEquals(80, checkoutSolution.checkout("HHHHHHHHHH"));


        assertEquals(20, checkoutSolution.checkout("FFF"));
        assertEquals(30, checkoutSolution.checkout("FFFF"));
        assertEquals(40, checkoutSolution.checkout("FFFFFF"));
        assertEquals(315, checkoutSolution.checkout("CCAAAFBBBEEF"));
        assertEquals(325, checkoutSolution.checkout("FFCCAAAFBBBEEF"));
    }

    @Test
    void checkoutInvalidAndZeroTest() {
        assertEquals(-1, checkoutSolution.checkout("&"));
        assertEquals(-1, checkoutSolution.checkout("AB&"));
        assertEquals(-1, checkoutSolution.checkout("&BA"));
        assertEquals(-1, checkoutSolution.checkout("A&B"));
        assertEquals(0, checkoutSolution.checkout(""));
        assertEquals(0, checkoutSolution.checkout("   "));
        assertEquals(-1, checkoutSolution.checkout(null));
    }
}

