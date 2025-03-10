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
     * @param checkOutItems the check-out items
     * @return the int. Is 0 because de promo is done directly into the checkOutItems
     */
    @Override
    public int apply(Map<Character, Integer> checkOutItems) {
        Integer promoItemCount = checkOutItems.get(item);
        if (promoItemCount != null) {
            int freeItemsMultiplier = promoItemCount / requiredQuantity;
            if (freeItemsMultiplier <= 0) {
                return 0;
            }

            for (Map.Entry<Character, Integer> entry : freeItems.entrySet()) {
                Character freeItem = entry.getKey();
                int numberOfEligibleFreeItems = entry.getValue();
                int totalFree = freeItemsMultiplier * numberOfEligibleFreeItems;
                int checkOutFreeItems = checkOutItems.getOrDefault(freeItem, 0);

                if (checkOutFreeItems > 0) {
                    checkOutItems.put(freeItem, Math.max(checkOutFreeItems - totalFree, totalFree));
                }
            }
        }
        return 0;
    }
}


