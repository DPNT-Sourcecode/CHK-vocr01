package io.accelerate.solutions.CHK;

import java.util.Map;

/**
 * The type Promotion.
 */
public abstract class Promotion {
    /**
     * Apply the promo to the product based on the check out items and the quantity of the item.
     *
     * @param quantity      the quantity of the item to apply the promo
     * @param checkOutItems the check out items
     * @return the int [ ] the promos
     */
    abstract int[] apply(int quantity, Map<Character, Integer> checkOutItems);

    /**
     * Gets promo.
     *
     * @return the promo
     */
    abstract int getPromo();
}


