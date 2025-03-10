package io.accelerate.solutions.CHK;

import java.util.Map;

/**
 * The interface Cross promotion.
 */
public interface CrossPromotion {

    /**
     * Apply.
     *
     * @param checkOutItems the check out items
     */
    void apply(Map<Character, Integer> checkOutItems);
}
