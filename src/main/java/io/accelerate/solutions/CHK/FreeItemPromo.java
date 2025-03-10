package io.accelerate.solutions.CHK;

import java.util.Map;

public class FreeItemPromo implements CrossPromotion {
    private final Character item;
    private final int requiredQuantity;
    private final Map<Character, Integer> freeitems;

    public FreeItemPromo(Character item, int requiredQuantity, Map<Character, Integer> freeitems) {
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
        if (required <= 0) {
            return;
        }

        for (Map.Entry<Character, Integer> entry : freeitems.entrySet()) {
            Character freeItem = entry.getKey();
            int freeQuantity = entry.getValue();
            int totalFree = required * freeQuantity;
            int currentCount = checkOutItems.getOrDefault(freeItem, 0);

            checkOutItems.put(freeItem, Math.max(currentCount - totalFree, totalFree));
        }
    }
}



