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
        for (FreeItemPromo freeItemPromo : PromoConfig.getFreeItemPromotion()) {
            freeItemPromo.applyPromo(items);
        }
    }

    private void applyPromo(Map<Character, Integer> checkOutItems) {
        Integer promoItemCount = checkOutItems.get(item);
        if (promoItemCount != null) {
            int numberOfBundles = promoItemCount / requiredQuantity;
            if (numberOfBundles <= 0) {
                return;
            }

            for (Map.Entry<Character, Integer> entry : freeItems.entrySet()) {
                Character freeItem = entry.getKey();
                int numberOfEligibleFreeItems = entry.getValue();
                int totalFree = numberOfBundles * numberOfEligibleFreeItems;

                computeFreeItemPromo(checkOutItems, freeItem, totalFree, promoItemCount);
            }
        }
    }

    private void computeFreeItemPromo(Map<Character, Integer> checkOutItems, Character freeItem, int totalFree, Integer promoItemCount) {
        if (!freeItem.equals(item)) {
            computeAnotherFreeItem(checkOutItems, freeItem, totalFree);

        } else {
            computeSameTypeFreeItem(checkOutItems, promoItemCount);
        }
    }

    private void computeSameTypeFreeItem(Map<Character, Integer> checkOutItems, Integer promoItemCount) {

        int groupSize = requiredQuantity + 1;
        if (promoItemCount < groupSize) {
            return;
        }

        int numberOfBundles = promoItemCount / groupSize;
        int itemToAdjustPrice = promoItemCount - numberOfBundles;

        checkOutItems.put(item, Math.max(itemToAdjustPrice, 0));
    }

    private static void computeAnotherFreeItem(Map<Character, Integer> checkOutItems, Character freeItem, int totalFree) {
        int checkOutFreeItems = checkOutItems.getOrDefault(freeItem, 0);

        checkOutItems.put(freeItem, Math.max(checkOutFreeItems - totalFree, 0));
    }
}
