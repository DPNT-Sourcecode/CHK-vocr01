package io.accelerate.solutions.CHK.promoTypes;

import io.accelerate.solutions.CHK.PromoConfig;

import java.util.Map;

/**
 * The type Free item promo.
 */
public class FreeItemPromo {
    private final Character item;
    private final int requiredQuantity;
    private final Map<Character, Integer> freeItems;

    /**
     * Instantiates a new Free item promo.
     *
     * @param item             the item
     * @param requiredQuantity the required quantity
     * @param freeItems        the free items
     */
    public FreeItemPromo(Character item, int requiredQuantity, Map<Character, Integer> freeItems) {
        this.item = item;
        this.requiredQuantity = requiredQuantity;
        this.freeItems = freeItems;
    }

    /**
     * Apply free item promo.
     *
     * @param items the items
     */
    public static void applyFreeItemPromo(Map<Character, Integer> items) {
        for (FreeItemPromo freeItemPromo : PromoConfig.getFreeItemPromotionForItem()) {
            freeItemPromo.applyPromo(items);
        }
    }

    private void applyPromo(Map<Character, Integer> checkOutItems) {
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

