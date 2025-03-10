package io.accelerate.solutions.CHK;

import java.util.Map;

public class FreeItemPromo implements CrossPromotion {
    private final Character item;
    private final int requiredQuantity;
    private final Map<String, Integer> freeitems;

    public FreeItemPromo(Character item, int requiredQuantity, Map<String, Integer> freeitems) {
        this.item = item;
        this.requiredQuantity = requiredQuantity;
        this.freeitems = freeitems;
    }

    /**
     * Apply.
     *
     * @param checkOutItems the check out items
     */
    @Override
    public void apply(Map<Character, Integer> checkOutItems) {
        int promoItemCount = checkOutItems.get(item);

        int required = promoItemCount / requiredQuantity;
    }
}


