package io.accelerate.solutions.CHK;

import java.util.Map;

/**
 * The type MultiPrice promotion.
 */
public class MultiPricePromotion extends Promotion {
    private final int quantityNeeded;
    private final int promoPrice;

    /**
     * Instantiates a new Quantity promotion.
     *
     * @param quantityNeeded the quantity needed
     * @param promoPrice     the promo price
     */
    public MultiPricePromotion(int quantityNeeded, int promoPrice) {
        this.quantityNeeded = quantityNeeded;
        this.promoPrice = promoPrice;
    }


    /**
     * Apply the promo to the product based on the check out items and the quantity of the item.
     *
     * @param quantity      the quantity of the item to apply the promo
     * @param checkOutItems the check out items
     * @return the int [ ] the promos
     */
    @Override
    int[] apply(int quantity, Map<Character, Integer> checkOutItems) {
        int totalPrice = (quantity / quantityNeeded) * promoPrice;

        return new int[]{totalPrice, quantity % quantityNeeded};
    }

    /**
     * Gets promo.
     *
     * @return the promo
     */
    @Override
    int getPromo() {
        return (quantityNeeded / quantityNeeded) * promoPrice;
    }
}
