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
        assertEquals(70, checkoutSolution.checkout("II"));
        assertEquals(120, checkoutSolution.checkout("JJ"));
        assertEquals(120, checkoutSolution.checkout("KK"));
        assertEquals(190, checkoutSolution.checkout("KKK"));
        assertEquals(240, checkoutSolution.checkout("KKKK"));
        assertEquals(180, checkoutSolution.checkout("LL"));
        assertEquals(30, checkoutSolution.checkout("MM"));
        assertEquals(120, checkoutSolution.checkout("NNN"));
        assertEquals(120, checkoutSolution.checkout("NNMN"));
        assertEquals(135, checkoutSolution.checkout("NMNMN"));
        assertEquals(10, checkoutSolution.checkout("O"));
        assertEquals(150, checkoutSolution.checkout("PPP"));
        assertEquals(200, checkoutSolution.checkout("PPPP"));
        assertEquals(200, checkoutSolution.checkout("PPPPP"));
        assertEquals(60, checkoutSolution.checkout("QQ"));
        assertEquals(80, checkoutSolution.checkout("QQQ"));
        assertEquals(160, checkoutSolution.checkout("QQQQQQ"));
        assertEquals(150, checkoutSolution.checkout("RRR"));
        assertEquals(150, checkoutSolution.checkout("RRRQ"));
        assertEquals(180, checkoutSolution.checkout("RQRRQ"));
        assertEquals(120, checkoutSolution.checkout("UUU"));
        assertEquals(120, checkoutSolution.checkout("UUUU"));
        assertEquals(240, checkoutSolution.checkout("UUUUUUUU"));
        assertEquals(50, checkoutSolution.checkout("V"));
        assertEquals(90, checkoutSolution.checkout("VV"));
        assertEquals(130, checkoutSolution.checkout("VVV"));
        assertEquals(180, checkoutSolution.checkout("VVVV"));
        assertEquals(40, checkoutSolution.checkout("WW"));
    }

    @Test
    void checkoutPhaseFiveTest() {
        assertEquals(45, checkoutSolution.checkout("STX"));
        assertEquals(62, checkoutSolution.checkout("STXS"));
        assertEquals(82, checkoutSolution.checkout("STXYZ"));
        assertEquals(90, checkoutSolution.checkout("STXYZZ"));
        assertEquals(90, checkoutSolution.checkout("XXXXXX"));

        assertEquals(342, checkoutSolution.checkout("STXYZVVLBEE"));
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