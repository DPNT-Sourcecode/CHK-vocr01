package io.accelerate.solutions.CHK;

import java.util.Map;

/**
 * The interface Promotion.
 */
public interface Promotion {

    /**
     * Apply.
     *
     * @param checkOutItems the check out items
     * @return the int
     */
    int apply(Map<Character, Integer> checkOutItems);
}
