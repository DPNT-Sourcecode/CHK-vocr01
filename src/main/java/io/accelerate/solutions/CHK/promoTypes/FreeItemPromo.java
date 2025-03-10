package io.accelerate.solutions.CHK.promoTypes;

import java.util.Map;

public class FreeItemPromo {
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
     * @param checkOutItems the check-out items
     */
    public void apply(Map<Character, Integer> checkOutItems) {
        Integer promoItemCount = checkOutItems.get(item);
        if (promoItemCount != null) {
            int freeItemsMultiplier = promoItemCount / requiredQuantity;
            if (freeItemsMultiplier <= 0) {
                return;
            }

            for (Map.Entry<Character, Integer> entry : freeItems.entrySet()) {
                Character freeItem = entry.getKey();
                int numberOfEligibleFreeItems = entry.getValue();
                int totalFree = freeItemsMultiplier * numberOfEligibleFreeItems;
                int checkOutFreeItems = checkOutItems.getOrDefault(freeItem, 0);

                checkOutItems.put(freeItem, Math.max(checkOutFreeItems - totalFree, 0));
            }
        }
    }
}

