package io.accelerate.solutions.CHK;

import java.util.Map;

/**
 * The type MultiPrice promotion.
 */
public class MultiPricePromotion extends Promotion {
    private final int item;
    private final int quantityNeeded;
    private final int promoPrice;

    /**
     * Instantiates a new Quantity promotion.
     *
     * @param quantityNeeded the quantity needed
     * @param promoPrice     the promo price
     */
    public MultiPricePromotion(int item, int quantityNeeded, int promoPrice) {
        this.item = item;
        this.quantityNeeded = quantityNeeded;
        this.promoPrice = promoPrice;
    }


    /**
     * Apply the promo to the product based on the check out items and the quantity of the item.
     *
     * @param checkOutItems the check out items
     * @return the promo applied
     */
    @Override
    int apply(Map<Character, Integer> checkOutItems) {
        int totalPrice = (checkOutItems.getOrDefault(item, 0) / quantityNeeded) * promoPrice;

        return new int[]{totalPrice, quantity % quantityNeeded};
    }
}

