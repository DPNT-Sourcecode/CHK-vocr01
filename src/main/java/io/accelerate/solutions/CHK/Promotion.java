package io.accelerate.solutions.CHK;

import java.util.Map;

/**
 * The type Promotion.
 */
public abstract class Promotion {
    /**
     * Apply the promo to the product based on the check-out items and the quantity of the item.
     *
     * @param checkOutItems the check out items
     * @return the promo applied
     */
    abstract int apply(Map<Character, Integer> checkOutItems);
}


