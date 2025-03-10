package io.accelerate.solutions.SUM;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * The Sum solution test.
 */
public class SumSolutionTest {
    private SumSolution sum;

    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {
        sum = new SumSolution();
    }

    /**
     * Compute sum.
     */
    @Test
    public void compute_sumTest() {
        assertThat(sum.compute(1, 1), equalTo(2));
        assertThat(sum.compute(-1, -1), equalTo(-2));
        assertThat(sum.compute(-1, 1), equalTo(0));

    }
}
