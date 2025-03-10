package io.accelerate.solutions.CHK;

import java.util.Map;

/**
 * The type FreeItem promotion.
 */
public class FreeItemPromotion extends Promotion {
    private final char item;
    private final int quantityNeeded;
    private final char freeItem;

    /**
     * Instantiates a new FreeItem promotion.
     *
     * @param item           the item
     * @param quantityNeeded the quantity needed
     * @param freeItem       the free item
     */
    public FreeItemPromotion(char item, int quantityNeeded, char freeItem) {
        this.item = item;
        this.quantityNeeded = quantityNeeded;
        this.freeItem = freeItem;
    }

    /**
     * Apply the promo to the product based on the check-out items and the quantity of the item.
     *
     * @param checkOutItems the check-out items
     * @return the promo applied, return 0 because the promo is applied directly to the item count.
     */
    @Override
    int apply(Map<Character, Integer> checkOutItems) {
        int count = checkOutItems.getOrDefault(item, 0);
        int freeItems = count / quantityNeeded;
        checkOutItems.put(freeItem, Math.max(0, checkOutItems.getOrDefault(freeItem, 0) - freeItems));
        return 0;
    }
}
