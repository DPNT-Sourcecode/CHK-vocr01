package io.accelerate.solutions.CHK;

import java.util.Map;

public class FreeItemPromo implements Promotion {
    private final Character item;
    private final int requiredQuantity;
    private final Map<Character, Integer> freeItems;

    public FreeItemPromo(Character item, int requiredQuantity, Map<Character, Integer> freeItems) {
        this.item = item;
        this.requiredQuantity = requiredQuantity;
        this.freeItems = freeItems;
    }

    /**
     * Apply.
     *
     * @param checkOutItems the check out items
     * @return the int. Is 0 because de promo is done directly into the checkOutItems
     */
    @Override
    public int apply(Map<Character, Integer> checkOutItems) {
        int promoItemCount = checkOutItems.get(item);
        int required = promoItemCount / requiredQuantity;
        if (required <= 0) {
            return 0;
        }

        for (Map.Entry<Character, Integer> entry : freeItems.entrySet()) {
            Character freeItem = entry.getKey();
            int freeQuantity = entry.getValue();
            int totalFree = required * freeQuantity;
            int currentCount = checkOutItems.getOrDefault(freeItem, 0);

            checkOutItems.put(freeItem, Math.max(currentCount - totalFree, totalFree));
        }

        return 0;
    }
}
